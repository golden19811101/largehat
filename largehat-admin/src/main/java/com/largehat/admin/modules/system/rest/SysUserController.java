package com.largehat.admin.modules.system.rest;

import com.largehat.admin.config.DataScope;
import com.largehat.admin.modules.system.domain.SysUser;
import com.largehat.admin.modules.system.domain.vo.SysUserPassVo;
import com.largehat.admin.modules.system.service.SysDeptService;
import com.largehat.admin.modules.system.service.SysRoleService;
import com.largehat.admin.modules.system.service.SysUserService;
import com.largehat.admin.modules.system.service.dto.SysRoleSmallDTO;
import com.largehat.admin.modules.system.service.dto.SysUserQueryCriteria;
import com.largehat.admin.modules.tools.domain.SysPicture;
import com.largehat.admin.modules.tools.domain.VerificationCode;
import com.largehat.admin.modules.tools.service.SysPictureService;
import com.largehat.admin.modules.tools.service.VerificationCodeService;
import com.largehat.common.core.annotation.Log;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.constant.LargehatConstant;
import com.largehat.common.core.utils.EncryptUtils;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lion
 * @date 2018-11-23
 */
@RestController
@RequestMapping("api")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysPictureService pictureService;

    @Autowired
    private DataScope dataScope;

    @Autowired
    private SysDeptService deptService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Log("查询用户")
    @GetMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT')")
    public ResponseEntity getUsers(SysUserQueryCriteria criteria, Pageable pageable){
        Set<Long> deptSet = new HashSet<>();
        Set<Long> result = new HashSet<>();

        if (!ObjectUtils.isEmpty(criteria.getDeptId())) {
            deptSet.add(criteria.getDeptId());
            deptSet.addAll(dataScope.getDeptChildren(deptService.findByPid(criteria.getDeptId())));
        }

        // 数据权限
        Set<Long> deptIds = dataScope.getDeptIds();

        // 查询条件不为空并且数据权限不为空则取交集
        if (!CollectionUtils.isEmpty(deptIds) && !CollectionUtils.isEmpty(deptSet)){

            // 取交集
            result.addAll(deptSet);
            result.retainAll(deptIds);

            // 若无交集，则代表无数据权限
            criteria.setDeptIds(result);
            if(result.size() == 0){
                return new ResponseEntity(PageUtil.toPage(null,0),HttpStatus.OK);
            } else return new ResponseEntity(userService.queryAll(criteria,pageable),HttpStatus.OK);
        // 否则取并集
        } else {
            result.addAll(deptSet);
            result.addAll(deptIds);
            criteria.setDeptIds(result);
            return new ResponseEntity(userService.queryAll(criteria,pageable),HttpStatus.OK);
        }
    }

    @Log("新增用户")
    @PostMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody SysUser resources){
        checkLevel(resources);
        return new ResponseEntity(userService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改用户")
    @PutMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_EDIT')")
    public ResponseEntity update(@Validated(SysUser.Update.class) @RequestBody SysUser resources){
        checkLevel(resources);
        userService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除用户")
    @DeleteMapping(value = "/users/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        Integer currentLevel =  Collections.min(roleService.findByUsers_Id(SecurityUtils.getUserId()).stream().map(SysRoleSmallDTO::getLevel).collect(Collectors.toList()));
        Integer optLevel =  Collections.min(roleService.findByUsers_Id(id).stream().map(SysRoleSmallDTO::getLevel).collect(Collectors.toList()));

        if (currentLevel > optLevel) {
            throw new BadRequestException("角色权限不足");
        }
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @PostMapping(value = "/users/updatePass")
    public ResponseEntity updatePass(@RequestBody SysUserPassVo user){
        UserDetails userDetails = SecurityUtils.getUserDetails();
        if(!userDetails.getPassword().equals(EncryptUtils.encryptPassword(user.getOldPass()))){
            throw new BadRequestException("修改失败，旧密码错误");
        }
        if(userDetails.getPassword().equals(EncryptUtils.encryptPassword(user.getNewPass()))){
            throw new BadRequestException("新密码不能与旧密码相同");
        }
        userService.updatePass(userDetails.getUsername(),EncryptUtils.encryptPassword(user.getNewPass()));
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改头像
     * @param file
     * @return
     */
    @PostMapping(value = "/users/updateAvatar")
    public ResponseEntity updateAvatar(@RequestParam MultipartFile file){
        SysPicture picture = pictureService.upload(file, SecurityUtils.getUsername());
        userService.updateAvatar(SecurityUtils.getUsername(),picture.getUrl());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改邮箱
     * @param user
     * @param user
     * @return
     */
    @Log("修改邮箱")
    @PostMapping(value = "/users/updateEmail/{code}")
    public ResponseEntity updateEmail(@PathVariable String code,@RequestBody SysUser user){
        UserDetails userDetails = SecurityUtils.getUserDetails();
        if(!userDetails.getPassword().equals(EncryptUtils.encryptPassword(user.getPassword()))){
            throw new BadRequestException("密码错误");
        }
        VerificationCode verificationCode = new VerificationCode(code, LargehatConstant.RESET_MAIL,"email",user.getEmail());
        verificationCodeService.validated(verificationCode);
        userService.updateEmail(userDetails.getUsername(),user.getEmail());
        return new ResponseEntity(HttpStatus.OK);
    }



    /**
     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
     * @param resources
     */
    private void checkLevel(SysUser resources) {
        Integer currentLevel =  Collections.min(roleService.findByUsers_Id(SecurityUtils.getUserId()).stream().map(SysRoleSmallDTO::getLevel).collect(Collectors.toList()));
        Integer optLevel = roleService.findByRoles(resources.getRoles());
        if (currentLevel > optLevel) {
            throw new BadRequestException("角色权限不足");
        }
    }
}

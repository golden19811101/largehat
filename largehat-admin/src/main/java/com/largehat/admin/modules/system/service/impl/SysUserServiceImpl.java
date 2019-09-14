package com.largehat.admin.modules.system.service.impl;

import com.largehat.admin.modules.system.domain.SysUser;
import com.largehat.admin.modules.system.service.dto.SysUserDTO;
import com.largehat.common.core.exception.EntityExistException;
import com.largehat.common.core.exception.EntityNotFoundException;
import com.largehat.admin.modules.monitor.service.RedisService;
import com.largehat.admin.modules.system.service.mapper.SysUserMapper;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import com.largehat.admin.modules.system.repository.SysUserRepository;
import com.largehat.admin.modules.system.service.SysUserService;
import com.largehat.admin.modules.system.service.dto.SysUserQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.Optional;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository userRepository;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public Object queryAll(SysUserQueryCriteria criteria, Pageable pageable) {
        Page<SysUser> page = userRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(userMapper::toDto));
    }

    @Override
    public SysUserDTO findById(long id) {
        Optional<SysUser> user = userRepository.findById(id);
        ValidationUtil.isNull(user,"User","id",id);
        return userMapper.toDto(user.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUserDTO create(SysUser resources) {

        if(userRepository.findByUsername(resources.getUsername())!=null){
            throw new EntityExistException(SysUser.class,"username",resources.getUsername());
        }

        if(userRepository.findByEmail(resources.getEmail())!=null){
            throw new EntityExistException(SysUser.class,"email",resources.getEmail());
        }

        // 默认密码 123456，此密码是加密后的字符
        resources.setPassword("e10adc3949ba59abbe56e057f20f883e");
        resources.setAvatar("https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg");
        return userMapper.toDto(userRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUser resources) {
        Optional<SysUser> userOptional = userRepository.findById(resources.getId());
        ValidationUtil.isNull(userOptional,"User","id",resources.getId());

        SysUser user = userOptional.get();

        SysUser user1 = userRepository.findByUsername(user.getUsername());
        SysUser user2 = userRepository.findByEmail(user.getEmail());

        if(user1 !=null&&!user.getId().equals(user1.getId())){
            throw new EntityExistException(SysUser.class,"username",resources.getUsername());
        }

        if(user2!=null&&!user.getId().equals(user2.getId())){
            throw new EntityExistException(SysUser.class,"email",resources.getEmail());
        }

        // 如果用户的角色改变了，需要手动清理下缓存
        if (!resources.getRoles().equals(user.getRoles())) {
            String key = "role::loadPermissionByUser:" + user.getUsername();
            redisService.delete(key);
            key = "role::findByUsers_Id:" + user.getId();
            redisService.delete(key);
        }

        user.setUsername(resources.getUsername());
        user.setEmail(resources.getEmail());
        user.setEnabled(resources.getEnabled());
        user.setRoles(resources.getRoles());
        user.setDept(resources.getDept());
        user.setJob(resources.getJob());
        user.setPhone(resources.getPhone());
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public SysUserDTO findByName(String userName) {
        SysUser user = null;
        if(ValidationUtil.isEmail(userName)){
            user = userRepository.findByEmail(userName);
        } else {
            user = userRepository.findByUsername(userName);
        }
        if (user == null) {
            throw new EntityNotFoundException(SysUser.class, "name", userName);
        } else {
            return userMapper.toDto(user);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePass(String username, String pass) {
        userRepository.updatePass(username,pass,new Date());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAvatar(String username, String url) {
        userRepository.updateAvatar(username,url);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateEmail(String username, String email) {
        userRepository.updateEmail(username,email);
    }
}

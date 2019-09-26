package com.largehat.admin.modules.system.rest;


import com.largehat.api.modules.system.domain.SysMenu;
import com.largehat.api.modules.system.dto.SysCommonQueryCriteria;
import com.largehat.api.modules.system.dto.SysMenuDTO;
import com.largehat.api.modules.system.dto.SysUserDTO;
import com.largehat.api.modules.system.service.SysMenuService;
import com.largehat.api.modules.system.service.SysRoleService;
import com.largehat.api.modules.system.service.SysUserService;
import com.largehat.common.core.annotation.Log;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Lion
 * @date 2018-12-03
 */
@RestController
@RequestMapping("api")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    private static final String ENTITY_NAME = "menu";

    /**
     * 构建前端路由所需要的菜单
     * @return
     */
    @GetMapping(value = "/menus/build")
    public ResponseEntity buildMenus(){
        SysUserDTO user = userService.findByName(SecurityUtils.getUsername());
        List<SysMenuDTO> menuDTOList = menuService.findByRoles(roleService.findByUsers_Id(user.getId()));
        List<SysMenuDTO> menuDTOTree = (List<SysMenuDTO>)menuService.buildTree(menuDTOList).get("content");
        return new ResponseEntity(menuService.buildMenus(menuDTOTree),HttpStatus.OK);
    }

    /**
     * 返回全部的菜单
     * @return
     */
    @GetMapping(value = "/menus/tree")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_CREATE','MENU_EDIT','ROLES_SELECT','ROLES_ALL')")
    public ResponseEntity getMenuTree(){
        return new ResponseEntity(menuService.getMenuTree(menuService.findByPid(0L)),HttpStatus.OK);
    }

    @Log("查询菜单")
    @GetMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT')")
    public ResponseEntity getMenus(SysCommonQueryCriteria criteria){
        List<SysMenuDTO> menuDTOList = menuService.queryAll(criteria);
        return new ResponseEntity(menuService.buildTree(menuDTOList),HttpStatus.OK);
    }

    @Log("新增菜单")
    @PostMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_CREATE')")
    public ResponseEntity create(@Validated @RequestBody SysMenu resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(menuService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改菜单")
    @PutMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_EDIT')")
    public ResponseEntity update(@Validated(SysMenu.Update.class) @RequestBody SysMenu resources){
        menuService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除菜单")
    @DeleteMapping(value = "/menus/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        List<SysMenu> menuList = menuService.findByPid(id);

        // 特殊情况，对级联删除进行处理
        for (SysMenu menu : menuList) {
            roleService.untiedMenu(menu);
            menuService.delete(menu.getId());
        }
        roleService.untiedMenu(menuService.findOne(id));
        menuService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

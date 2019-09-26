package com.largehat.admin.modules.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.largehat.api.modules.system.domain.SysMenu;
import com.largehat.api.modules.system.dto.SysCommonQueryCriteria;
import com.largehat.api.modules.system.dto.SysMenuDTO;
import com.largehat.api.modules.system.dto.SysRoleSmallDTO;
import com.largehat.api.modules.system.service.SysMenuService;
import com.largehat.api.modules.system.vo.SysMenuMetaVo;
import com.largehat.api.modules.system.vo.SysMenuVo;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.exception.EntityExistException;
import com.largehat.admin.modules.system.service.mapper.SysMenuMapper;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import com.largehat.admin.modules.system.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository menuRepository;

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List queryAll(SysCommonQueryCriteria criteria){
        return menuMapper.toDto(menuRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public SysMenuDTO findById(long id) {
        Optional<SysMenu> menu = menuRepository.findById(id);
        ValidationUtil.isNull(menu,"Menu","id",id);
        return menuMapper.toDto(menu.get());
    }

    @Override
    public List<SysMenuDTO> findByRoles(List<SysRoleSmallDTO> roles) {
        Set<SysMenu> menus = new LinkedHashSet<>();
        for (SysRoleSmallDTO role : roles) {
            List<SysMenu> menus1 = menuRepository.findByRoles_IdOrderBySortAsc(role.getId()).stream().collect(Collectors.toList());
            menus.addAll(menus1);
        }
        return menus.stream().map(menuMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SysMenuDTO create(SysMenu resources) {
        if(menuRepository.findByName(resources.getName()) != null){
            throw new EntityExistException(SysMenu.class,"name",resources.getName());
        }
        if(resources.getIFrame()){
            if (!(resources.getPath().toLowerCase().startsWith("http://")||resources.getPath().toLowerCase().startsWith("https://"))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }
        return menuMapper.toDto(menuRepository.save(resources));
    }

    @Override
    public void update(SysMenu resources) {
        if(resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        Optional<SysMenu> optionalPermission = menuRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalPermission,"Permission","id",resources.getId());

        if(resources.getIFrame()){
            if (!(resources.getPath().toLowerCase().startsWith("http://")||resources.getPath().toLowerCase().startsWith("https://"))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }
        SysMenu menu = optionalPermission.get();
        SysMenu menu1 = menuRepository.findByName(resources.getName());

        if(menu1 != null && !menu1.getId().equals(menu.getId())){
            throw new EntityExistException(SysMenu.class,"name",resources.getName());
        }
        menu.setName(resources.getName());
        menu.setComponent(resources.getComponent());
        menu.setPath(resources.getPath());
        menu.setIcon(resources.getIcon());
        menu.setIFrame(resources.getIFrame());
        menu.setPid(resources.getPid());
        menu.setSort(resources.getSort());
        menuRepository.save(menu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public Object getMenuTree(List<SysMenu> menus) {
        List<Map<String,Object>> list = new LinkedList<>();
        menus.forEach(menu -> {
                    if (menu!=null){
                        List<SysMenu> menuList = menuRepository.findByPid(menu.getId());
                        Map<String,Object> map = new HashMap<>();
                        map.put("id",menu.getId());
                        map.put("label",menu.getName());
                        if(menuList!=null && menuList.size()!=0){
                            map.put("children",getMenuTree(menuList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }

    @Override
    public List<SysMenu> findByPid(long pid) {
        return menuRepository.findByPid(pid);
    }

    @Override
    public Map buildTree(List<SysMenuDTO> menuDTOS) {
        List<SysMenuDTO> trees = new ArrayList<SysMenuDTO>();

        for (SysMenuDTO menuDTO : menuDTOS) {

            if ("0".equals(menuDTO.getPid().toString())) {
                trees.add(menuDTO);
            }

            for (SysMenuDTO it : menuDTOS) {
                if (it.getPid().equals(menuDTO.getId())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<SysMenuDTO>());
                    }
                    menuDTO.getChildren().add(it);
                }
            }
        }
        Map map = new HashMap();
        map.put("content",trees.size() == 0?menuDTOS:trees);
        map.put("totalElements",menuDTOS!=null?menuDTOS.size():0);
        return map;
    }

    @Override
    public List<SysMenuVo> buildMenus(List<SysMenuDTO> menuDTOS) {
        List<SysMenuVo> list = new LinkedList<>();
        menuDTOS.forEach(menuDTO -> {
            if (menuDTO!=null){
                List<SysMenuDTO> menuDTOList = menuDTO.getChildren();
                SysMenuVo menuVo = new SysMenuVo();
                menuVo.setName(menuDTO.getName());
                menuVo.setPath(menuDTO.getPath());

                // 如果不是外链
                if(!menuDTO.getIFrame()){
                    if(menuDTO.getPid().equals(0L)){
                        //一级目录需要加斜杠，不然访问 会跳转404页面
                        menuVo.setPath("/" + menuDTO.getPath());
                        menuVo.setComponent(StrUtil.isEmpty(menuDTO.getComponent())?"Layout":menuDTO.getComponent());
                    }else if(!StrUtil.isEmpty(menuDTO.getComponent())){
                        menuVo.setComponent(menuDTO.getComponent());
                    }
                }
                menuVo.setMeta(new SysMenuMetaVo(menuDTO.getName(),menuDTO.getIcon()));
                if(menuDTOList!=null && menuDTOList.size()!=0){
                    menuVo.setAlwaysShow(true);
                    menuVo.setRedirect("noredirect");
                    menuVo.setChildren(buildMenus(menuDTOList));
                    // 处理是一级菜单并且没有子菜单的情况
                } else if(menuDTO.getPid().equals(0L)){
                    SysMenuVo menuVo1 = new SysMenuVo();
                    menuVo1.setMeta(menuVo.getMeta());
                    // 非外链
                    if(!menuDTO.getIFrame()){
                        menuVo1.setPath("index");
                        menuVo1.setName(menuVo.getName());
                        menuVo1.setComponent(menuVo.getComponent());
                    } else {
                        menuVo1.setPath(menuDTO.getPath());
                    }
                    menuVo.setName(null);
                    menuVo.setMeta(null);
                    menuVo.setComponent("Layout");
                    List<SysMenuVo> list1 = new ArrayList<SysMenuVo>();
                    list1.add(menuVo1);
                    menuVo.setChildren(list1);
                }
                list.add(menuVo);
            }
        }
        );
        return list;
    }

    @Override
    public SysMenu findOne(Long id) {
        Optional<SysMenu> menu = menuRepository.findById(id);
        ValidationUtil.isNull(menu,"Menu","id",id);
        return menu.get();
    }
}

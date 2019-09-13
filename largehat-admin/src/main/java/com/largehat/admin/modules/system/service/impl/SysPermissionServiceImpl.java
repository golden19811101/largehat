package com.largehat.admin.modules.system.service.impl;

import com.largehat.admin.modules.system.domain.SysPermission;
import com.largehat.admin.modules.system.service.dto.SysPermissionDTO;
import com.largehat.admin.modules.system.service.mapper.SysPermissionMapper;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.exception.EntityExistException;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import com.largehat.admin.modules.system.repository.SysPermissionRepository;
import com.largehat.admin.modules.system.service.SysPermissionService;
import com.largehat.admin.modules.system.service.dto.SysCommonQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * @author Lion
 * @date 2018-12-03
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository permissionRepository;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public List<SysPermissionDTO> queryAll(SysCommonQueryCriteria criteria) {
        return permissionMapper.toDto(permissionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public SysPermissionDTO findById(long id) {
        Optional<SysPermission> permission = permissionRepository.findById(id);
        ValidationUtil.isNull(permission,"Permission","id",id);
        return permissionMapper.toDto(permission.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysPermissionDTO create(SysPermission resources) {
        if(permissionRepository.findByName(resources.getName()) != null){
            throw new EntityExistException(SysPermission.class,"name",resources.getName());
        }
        return permissionMapper.toDto(permissionRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysPermission resources) {
        Optional<SysPermission> optionalPermission = permissionRepository.findById(resources.getId());
        if(resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        ValidationUtil.isNull(optionalPermission,"Permission","id",resources.getId());

        SysPermission permission = optionalPermission.get();

        SysPermission permission1 = permissionRepository.findByName(resources.getName());

        if(permission1 != null && !permission1.getId().equals(permission.getId())){
            throw new EntityExistException(SysPermission.class,"name",resources.getName());
        }

        permission.setName(resources.getName());
        permission.setAlias(resources.getAlias());
        permission.setPid(resources.getPid());
        permissionRepository.save(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        List<SysPermission> permissionList = permissionRepository.findByPid(id);
        for (SysPermission permission : permissionList) {
            permissionRepository.delete(permission);
        }
        permissionRepository.deleteById(id);
    }

    @Override
    public Object getPermissionTree(List<SysPermission> permissions) {
        List<Map<String,Object>> list = new LinkedList<>();
        permissions.forEach(permission -> {
                    if (permission!=null){
                        List<SysPermission> permissionList = permissionRepository.findByPid(permission.getId());
                        Map<String,Object> map = new HashMap<>();
                        map.put("id",permission.getId());
                        map.put("label",permission.getAlias());
                        if(permissionList!=null && permissionList.size()!=0){
                            map.put("children",getPermissionTree(permissionList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }

    @Override
    public List<SysPermission> findByPid(long pid) {
        return permissionRepository.findByPid(pid);
    }

    @Override
    public Object buildTree(List<SysPermissionDTO> permissionDTOS) {

        List<SysPermissionDTO> trees = new ArrayList<SysPermissionDTO>();

        for (SysPermissionDTO permissionDTO : permissionDTOS) {

            if ("0".equals(permissionDTO.getPid().toString())) {
                trees.add(permissionDTO);
            }

            for (SysPermissionDTO it : permissionDTOS) {
                if (it.getPid().equals(permissionDTO.getId())) {
                    if (permissionDTO.getChildren() == null) {
                        permissionDTO.setChildren(new ArrayList<SysPermissionDTO>());
                    }
                    permissionDTO.getChildren().add(it);
                }
            }
        }

        Integer totalElements = permissionDTOS!=null?permissionDTOS.size():0;

        Map map = new HashMap();
        map.put("content",trees.size() == 0?permissionDTOS:trees);
        map.put("totalElements",totalElements);
        return map;
    }
}

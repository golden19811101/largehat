package com.largehat.service.modules.system.service;


import com.largehat.service.modules.system.mapper.SysDeptMapper;
import com.largehat.service.modules.system.repository.SysDeptRepository;
import com.largehat.api.modules.system.domain.SysDept;
import com.largehat.api.modules.system.dto.SysDeptDTO;
import com.largehat.api.modules.system.dto.SysDeptQueryCriteria;
import com.largehat.api.modules.system.service.SysDeptService;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
* @author Lion
* @date 2019-03-25
*/
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = SysDeptService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptRepository deptRepository;

    @Autowired
    private SysDeptMapper deptMapper;

    @Override
    public List<SysDeptDTO> queryAll(SysDeptQueryCriteria criteria) {
        return deptMapper.toDto(deptRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public SysDeptDTO findById(Long id) {
        Optional<SysDept> dept = deptRepository.findById(id);
        ValidationUtil.isNull(dept,"Dept","id",id);
        return deptMapper.toDto(dept.get());
    }

    @Override
    public List<SysDept> findByPid(long pid) {
        return deptRepository.findByPid(pid);
    }

    @Override
    public Set<SysDept> findByRoleIds(Long id) {
        return deptRepository.findByRoles_Id(id);
    }

    @Override
    public Object buildTree(List<SysDeptDTO> deptDTOS) {
        Set<SysDeptDTO> trees = new LinkedHashSet<>();
        Set<SysDeptDTO> depts= new LinkedHashSet<>();
        List<String> deptNames = deptDTOS.stream().map(SysDeptDTO::getName).collect(Collectors.toList());
        Boolean isChild;
        for (SysDeptDTO deptDTO : deptDTOS) {
            isChild = false;
            if ("0".equals(deptDTO.getPid().toString())) {
                trees.add(deptDTO);
            }
            for (SysDeptDTO it : deptDTOS) {
                if (it.getPid().equals(deptDTO.getId())) {
                    isChild = true;
                    if (deptDTO.getChildren() == null) {
                        deptDTO.setChildren(new ArrayList<SysDeptDTO>());
                    }
                    deptDTO.getChildren().add(it);
                }
            }
            if(isChild)
                depts.add(deptDTO);
            else if(!deptNames.contains(deptRepository.findNameById(deptDTO.getPid())))
                depts.add(deptDTO);
        }

        if (CollectionUtils.isEmpty(trees)) {
            trees = depts;
        }

        Integer totalElements = deptDTOS!=null?deptDTOS.size():0;

        Map map = new HashMap();
        map.put("totalElements",totalElements);
        map.put("content",CollectionUtils.isEmpty(trees)?deptDTOS:trees);
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysDeptDTO create(SysDept resources) {
        return deptMapper.toDto(deptRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDept resources) {
        if(resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        Optional<SysDept> optionalDept = deptRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalDept,"Dept","id",resources.getId());
        SysDept dept = optionalDept.get();
        resources.setId(dept.getId());
        deptRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        deptRepository.deleteById(id);
    }
}
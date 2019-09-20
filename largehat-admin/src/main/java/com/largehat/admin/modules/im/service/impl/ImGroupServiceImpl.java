package com.largehat.admin.modules.im.service.impl;


import com.largehat.admin.modules.im.domain.ImGroup;
import com.largehat.admin.modules.im.repository.ImGroupRepository;
import com.largehat.admin.modules.im.service.ImGroupService;
import com.largehat.admin.modules.im.service.dto.ImGroupDTO;
import com.largehat.admin.modules.im.service.dto.ImGroupQueryCriteria;
import com.largehat.admin.modules.im.service.mapper.ImGroupMapper;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @author
* @date 2019-09-18
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ImGroupServiceImpl implements ImGroupService {

    @Autowired
    private ImGroupRepository imGroupRepository;

    @Autowired
    private ImGroupMapper imGroupMapper;

    @Override
    public Object queryAll(ImGroupQueryCriteria criteria, Pageable pageable){
        Page<ImGroup> page = imGroupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imGroupMapper::toDto));
    }

    @Override
    public Object queryAll(ImGroupQueryCriteria criteria){
        return imGroupMapper.toDto(imGroupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImGroupDTO findById(Integer groupId) {
        Optional<ImGroup> imGroup = imGroupRepository.findById(groupId);
        ValidationUtil.isNull(imGroup,"ImGroup","groupId",groupId);
        return imGroupMapper.toDto(imGroup.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImGroupDTO create(ImGroup resources) {
        return imGroupMapper.toDto(imGroupRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImGroup resources) {
        Optional<ImGroup> optionalImGroup = imGroupRepository.findById(resources.getGroupId());
        ValidationUtil.isNull( optionalImGroup,"ImGroup","id",resources.getGroupId());
        ImGroup imGroup = optionalImGroup.get();
        imGroup.copy(resources);
        imGroupRepository.save(imGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer groupId) {
        imGroupRepository.deleteById(groupId);
    }
}
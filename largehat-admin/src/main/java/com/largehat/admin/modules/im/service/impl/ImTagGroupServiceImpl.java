package com.largehat.admin.modules.im.service.impl;


import com.largehat.admin.modules.im.repository.ImTagGroupRepository;
import com.largehat.admin.modules.im.service.mapper.ImTagGroupMapper;
import com.largehat.api.modules.im.domain.ImTagGroup;
import com.largehat.api.modules.im.dto.ImTagGroupDTO;
import com.largehat.api.modules.im.dto.ImTagGroupQueryCriteria;
import com.largehat.api.modules.im.service.ImTagGroupService;
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
public class ImTagGroupServiceImpl implements ImTagGroupService {

    @Autowired
    private ImTagGroupRepository imTagGroupRepository;

    @Autowired
    private ImTagGroupMapper imTagGroupMapper;

    @Override
    public Object queryAll(ImTagGroupQueryCriteria criteria, Pageable pageable){
        Page<ImTagGroup> page = imTagGroupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imTagGroupMapper::toDto));
    }

    @Override
    public Object queryAll(ImTagGroupQueryCriteria criteria){
        return imTagGroupMapper.toDto(imTagGroupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImTagGroupDTO findById(Integer id) {
        Optional<ImTagGroup> imTagGroup = imTagGroupRepository.findById(id);
        ValidationUtil.isNull(imTagGroup,"ImTagGroup","id",id);
        return imTagGroupMapper.toDto(imTagGroup.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImTagGroupDTO create(ImTagGroup resources) {
        return imTagGroupMapper.toDto(imTagGroupRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImTagGroup resources) {
        Optional<ImTagGroup> optionalImTagGroup = imTagGroupRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalImTagGroup,"ImTagGroup","id",resources.getId());
        ImTagGroup imTagGroup = optionalImTagGroup.get();
        imTagGroup.copy(resources);
        imTagGroupRepository.save(imTagGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        imTagGroupRepository.deleteById(id);
    }
}
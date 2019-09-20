package com.largehat.admin.modules.im.service.impl;


import com.largehat.admin.modules.im.domain.ImTagRelation;
import com.largehat.admin.modules.im.repository.ImTagRelationRepository;
import com.largehat.admin.modules.im.service.ImTagRelationService;
import com.largehat.admin.modules.im.service.dto.ImTagRelationDTO;
import com.largehat.admin.modules.im.service.dto.ImTagRelationQueryCriteria;
import com.largehat.admin.modules.im.service.mapper.ImTagRelationMapper;
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
public class ImTagRelationServiceImpl implements ImTagRelationService {

    @Autowired
    private ImTagRelationRepository imTagRelationRepository;

    @Autowired
    private ImTagRelationMapper imTagRelationMapper;

    @Override
    public Object queryAll(ImTagRelationQueryCriteria criteria, Pageable pageable){
        Page<ImTagRelation> page = imTagRelationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imTagRelationMapper::toDto));
    }

    @Override
    public Object queryAll(ImTagRelationQueryCriteria criteria){
        return imTagRelationMapper.toDto(imTagRelationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImTagRelationDTO findById(Integer id) {
        Optional<ImTagRelation> imTagRelation = imTagRelationRepository.findById(id);
        ValidationUtil.isNull(imTagRelation,"ImTagRelation","id",id);
        return imTagRelationMapper.toDto(imTagRelation.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImTagRelationDTO create(ImTagRelation resources) {
        return imTagRelationMapper.toDto(imTagRelationRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImTagRelation resources) {
        Optional<ImTagRelation> optionalImTagRelation = imTagRelationRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalImTagRelation,"ImTagRelation","id",resources.getId());
        ImTagRelation imTagRelation = optionalImTagRelation.get();
        imTagRelation.copy(resources);
        imTagRelationRepository.save(imTagRelation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        imTagRelationRepository.deleteById(id);
    }
}
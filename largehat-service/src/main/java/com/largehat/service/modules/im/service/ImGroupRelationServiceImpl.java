package com.largehat.service.modules.im.service;


import com.largehat.service.modules.im.mapper.ImGroupRelationMapper;
import com.largehat.service.modules.im.repository.ImGroupRelationRepository;
import com.largehat.api.modules.im.domain.ImGroupRelation;
import com.largehat.api.modules.im.dto.ImGroupRelationDTO;
import com.largehat.api.modules.im.dto.ImGroupRelationQueryCriteria;
import com.largehat.api.modules.im.service.ImGroupRelationService;
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
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = ImGroupRelationService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ImGroupRelationServiceImpl implements ImGroupRelationService {

    @Autowired
    private ImGroupRelationRepository imGroupRelationRepository;

    @Autowired
    private ImGroupRelationMapper imGroupRelationMapper;

    @Override
    public Object queryAll(ImGroupRelationQueryCriteria criteria, Pageable pageable){
        Page<ImGroupRelation> page = imGroupRelationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imGroupRelationMapper::toDto));
    }

    @Override
    public Object queryAll(ImGroupRelationQueryCriteria criteria){
        return imGroupRelationMapper.toDto(imGroupRelationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImGroupRelationDTO findById(Integer id) {
        Optional<ImGroupRelation> imGroupRelation = imGroupRelationRepository.findById(id);
        ValidationUtil.isNull(imGroupRelation,"ImGroupRelation","id",id);
        return imGroupRelationMapper.toDto(imGroupRelation.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImGroupRelationDTO create(ImGroupRelation resources) {
        return imGroupRelationMapper.toDto(imGroupRelationRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImGroupRelation resources) {
        Optional<ImGroupRelation> optionalImGroupRelation = imGroupRelationRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalImGroupRelation,"ImGroupRelation","id",resources.getId());
        ImGroupRelation imGroupRelation = optionalImGroupRelation.get();
        imGroupRelation.copy(resources);
        imGroupRelationRepository.save(imGroupRelation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        imGroupRelationRepository.deleteById(id);
    }
}
package com.largehat.admin.modules.im.service.impl;


import com.largehat.admin.modules.im.repository.ImMessageRepository;
import com.largehat.admin.modules.im.service.mapper.ImMessageMapper;
import com.largehat.api.modules.im.domain.ImMessage;
import com.largehat.api.modules.im.dto.ImMessageDTO;
import com.largehat.api.modules.im.dto.ImMessageQueryCriteria;
import com.largehat.api.modules.im.service.ImMessageService;
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
public class ImMessageServiceImpl implements ImMessageService {

    @Autowired
    private ImMessageRepository imMessageRepository;

    @Autowired
    private ImMessageMapper imMessageMapper;

    @Override
    public Object queryAll(ImMessageQueryCriteria criteria, Pageable pageable){
        Page<ImMessage> page = imMessageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imMessageMapper::toDto));
    }

    @Override
    public Object queryAll(ImMessageQueryCriteria criteria){
        return imMessageMapper.toDto(imMessageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImMessageDTO findById(Long messageId) {
        Optional<ImMessage> imMessage = imMessageRepository.findById(messageId);
        ValidationUtil.isNull(imMessage,"ImMessage","messageId",messageId);
        return imMessageMapper.toDto(imMessage.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImMessageDTO create(ImMessage resources) {
        return imMessageMapper.toDto(imMessageRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImMessage resources) {
        Optional<ImMessage> optionalImMessage = imMessageRepository.findById(resources.getMessageId());
        ValidationUtil.isNull( optionalImMessage,"ImMessage","id",resources.getMessageId());
        ImMessage imMessage = optionalImMessage.get();
        imMessage.copy(resources);
        imMessageRepository.save(imMessage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long messageId) {
        imMessageRepository.deleteById(messageId);
    }
}
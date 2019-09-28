package com.largehat.service.modules.im.service;



import com.largehat.service.modules.im.repository.ImFileAttachmentRepository;
import com.largehat.service.modules.im.mapper.ImFileAttachmentMapper;
import com.largehat.api.modules.im.domain.ImFileAttachment;
import com.largehat.api.modules.im.dto.ImFileAttachmentDTO;
import com.largehat.api.modules.im.dto.ImFileAttachmentQueryCriteria;
import com.largehat.api.modules.im.service.ImFileAttachmentService;
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
        interfaceClass = ImFileAttachmentService.class,
        timeout = 3000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ImFileAttachmentServiceImpl implements ImFileAttachmentService {

    @Autowired
    private ImFileAttachmentRepository imFileAttachmentRepository;

    @Autowired
    private ImFileAttachmentMapper imFileAttachmentMapper;

    @Override
    public Object queryAll(ImFileAttachmentQueryCriteria criteria, Pageable pageable){
        Page<ImFileAttachment> page = imFileAttachmentRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imFileAttachmentMapper::toDto));
    }

    @Override
    public Object queryAll(ImFileAttachmentQueryCriteria criteria){
        return imFileAttachmentMapper.toDto(imFileAttachmentRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImFileAttachmentDTO findById(Integer fileId) {
        Optional<ImFileAttachment> imFileAttachment = imFileAttachmentRepository.findById(fileId);
        ValidationUtil.isNull(imFileAttachment,"ImFileAttachment","fileId",fileId);
        return imFileAttachmentMapper.toDto(imFileAttachment.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImFileAttachmentDTO create(ImFileAttachment resources) {
        return imFileAttachmentMapper.toDto(imFileAttachmentRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImFileAttachment resources) {
        Optional<ImFileAttachment> optionalImFileAttachment = imFileAttachmentRepository.findById(resources.getFileId());
        ValidationUtil.isNull( optionalImFileAttachment,"ImFileAttachment","id",resources.getFileId());
        ImFileAttachment imFileAttachment = optionalImFileAttachment.get();
        imFileAttachment.copy(resources);
        imFileAttachmentRepository.save(imFileAttachment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer fileId) {
        imFileAttachmentRepository.deleteById(fileId);
    }
}
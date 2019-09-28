package com.largehat.service.modules.im.service;


import com.largehat.service.modules.im.mapper.ImOrgMapper;
import com.largehat.service.modules.im.repository.ImOrgRepository;
import com.largehat.api.modules.im.domain.ImOrg;
import com.largehat.api.modules.im.dto.ImOrgDTO;
import com.largehat.api.modules.im.dto.ImOrgQueryCriteria;
import com.largehat.api.modules.im.service.ImOrgService;
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
        interfaceClass = ImOrgService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ImOrgServiceImpl implements ImOrgService {

    @Autowired
    private ImOrgRepository imOrgRepository;

    @Autowired
    private ImOrgMapper imOrgMapper;

    @Override
    public Object queryAll(ImOrgQueryCriteria criteria, Pageable pageable){
        Page<ImOrg> page = imOrgRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imOrgMapper::toDto));
    }

    @Override
    public Object queryAll(ImOrgQueryCriteria criteria){
        return imOrgMapper.toDto(imOrgRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImOrgDTO findById(Integer orgId) {
        Optional<ImOrg> imOrg = imOrgRepository.findById(orgId);
        ValidationUtil.isNull(imOrg,"ImOrg","orgId",orgId);
        return imOrgMapper.toDto(imOrg.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImOrgDTO create(ImOrg resources) {
        return imOrgMapper.toDto(imOrgRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImOrg resources) {
        Optional<ImOrg> optionalImOrg = imOrgRepository.findById(resources.getOrgId());
        ValidationUtil.isNull( optionalImOrg,"ImOrg","id",resources.getOrgId());
        ImOrg imOrg = optionalImOrg.get();
        imOrg.copy(resources);
        imOrgRepository.save(imOrg);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer orgId) {
        imOrgRepository.deleteById(orgId);
    }
}
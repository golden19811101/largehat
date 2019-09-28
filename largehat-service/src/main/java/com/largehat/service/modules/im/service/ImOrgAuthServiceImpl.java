package com.largehat.service.modules.im.service;


import com.largehat.service.modules.im.mapper.ImOrgAuthMapper;
import com.largehat.service.modules.im.repository.ImOrgAuthRepository;
import com.largehat.api.modules.im.domain.ImOrgAuth;
import com.largehat.api.modules.im.dto.ImOrgAuthDTO;
import com.largehat.api.modules.im.dto.ImOrgAuthQueryCriteria;
import com.largehat.api.modules.im.service.ImOrgAuthService;
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
        interfaceClass = ImOrgAuthService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ImOrgAuthServiceImpl implements ImOrgAuthService {

    @Autowired
    private ImOrgAuthRepository imOrgAuthRepository;

    @Autowired
    private ImOrgAuthMapper imOrgAuthMapper;

    @Override
    public Object queryAll(ImOrgAuthQueryCriteria criteria, Pageable pageable){
        Page<ImOrgAuth> page = imOrgAuthRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imOrgAuthMapper::toDto));
    }

    @Override
    public Object queryAll(ImOrgAuthQueryCriteria criteria){
        return imOrgAuthMapper.toDto(imOrgAuthRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImOrgAuthDTO findById(Integer id) {
        Optional<ImOrgAuth> imOrgAuth = imOrgAuthRepository.findById(id);
        ValidationUtil.isNull(imOrgAuth,"ImOrgAuth","id",id);
        return imOrgAuthMapper.toDto(imOrgAuth.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImOrgAuthDTO create(ImOrgAuth resources) {
        return imOrgAuthMapper.toDto(imOrgAuthRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImOrgAuth resources) {
        Optional<ImOrgAuth> optionalImOrgAuth = imOrgAuthRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalImOrgAuth,"ImOrgAuth","id",resources.getId());
        ImOrgAuth imOrgAuth = optionalImOrgAuth.get();
        imOrgAuth.copy(resources);
        imOrgAuthRepository.save(imOrgAuth);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        imOrgAuthRepository.deleteById(id);
    }
}
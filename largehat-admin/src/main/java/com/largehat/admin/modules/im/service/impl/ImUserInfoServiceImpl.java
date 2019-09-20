package com.largehat.admin.modules.im.service.impl;


import com.largehat.admin.modules.im.domain.ImUserInfo;
import com.largehat.admin.modules.im.repository.ImUserInfoRepository;
import com.largehat.admin.modules.im.service.ImUserInfoService;
import com.largehat.admin.modules.im.service.dto.ImUserInfoDTO;
import com.largehat.admin.modules.im.service.dto.ImUserInfoQueryCriteria;
import com.largehat.admin.modules.im.service.mapper.ImUserInfoMapper;
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
public class ImUserInfoServiceImpl implements ImUserInfoService {

    @Autowired
    private ImUserInfoRepository imUserInfoRepository;

    @Autowired
    private ImUserInfoMapper imUserInfoMapper;

    @Override
    public Object queryAll(ImUserInfoQueryCriteria criteria, Pageable pageable){
        Page<ImUserInfo> page = imUserInfoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imUserInfoMapper::toDto));
    }

    @Override
    public Object queryAll(ImUserInfoQueryCriteria criteria){
        return imUserInfoMapper.toDto(imUserInfoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImUserInfoDTO findById(Integer id) {
        Optional<ImUserInfo> imUserInfo = imUserInfoRepository.findById(id);
        ValidationUtil.isNull(imUserInfo,"ImUserInfo","id",id);
        return imUserInfoMapper.toDto(imUserInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImUserInfoDTO create(ImUserInfo resources) {
        return imUserInfoMapper.toDto(imUserInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImUserInfo resources) {
        Optional<ImUserInfo> optionalImUserInfo = imUserInfoRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalImUserInfo,"ImUserInfo","id",resources.getId());
        ImUserInfo imUserInfo = optionalImUserInfo.get();
        imUserInfo.copy(resources);
        imUserInfoRepository.save(imUserInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        imUserInfoRepository.deleteById(id);
    }
}
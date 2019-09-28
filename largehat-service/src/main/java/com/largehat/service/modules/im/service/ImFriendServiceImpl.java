package com.largehat.service.modules.im.service;


import com.largehat.service.modules.im.mapper.ImFriendMapper;
import com.largehat.service.modules.im.repository.ImFriendRepository;
import com.largehat.api.modules.im.domain.ImFriend;
import com.largehat.api.modules.im.dto.ImFriendDTO;
import com.largehat.api.modules.im.dto.ImFriendQueryCriteria;
import com.largehat.api.modules.im.service.ImFriendService;
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
        interfaceClass = ImFriendService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ImFriendServiceImpl implements ImFriendService {

    @Autowired
    private ImFriendRepository imFriendRepository;

    @Autowired
    private ImFriendMapper imFriendMapper;

    @Override
    public Object queryAll(ImFriendQueryCriteria criteria, Pageable pageable){
        Page<ImFriend> page = imFriendRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(imFriendMapper::toDto));
    }

    @Override
    public Object queryAll(ImFriendQueryCriteria criteria){
        return imFriendMapper.toDto(imFriendRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ImFriendDTO findById(Integer id) {
        Optional<ImFriend> imFriend = imFriendRepository.findById(id);
        ValidationUtil.isNull(imFriend,"ImFriend","id",id);
        return imFriendMapper.toDto(imFriend.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ImFriendDTO create(ImFriend resources) {
        return imFriendMapper.toDto(imFriendRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ImFriend resources) {
        Optional<ImFriend> optionalImFriend = imFriendRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalImFriend,"ImFriend","id",resources.getId());
        ImFriend imFriend = optionalImFriend.get();
        imFriend.copy(resources);
        imFriendRepository.save(imFriend);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        imFriendRepository.deleteById(id);
    }
}
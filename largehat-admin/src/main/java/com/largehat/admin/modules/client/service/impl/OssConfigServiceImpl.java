package com.largehat.admin.modules.client.service.impl;

import com.largehat.admin.modules.client.domain.OssConfig;
import com.largehat.admin.modules.client.repository.OssConfigRepository;
import com.largehat.admin.modules.client.service.OssConfigService;
import com.largehat.admin.modules.client.service.dto.OssConfigDTO;
import com.largehat.admin.modules.client.service.dto.OssConfigQueryCriteria;
import com.largehat.admin.modules.client.service.mapper.OssConfigMapper;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @author kafe
* @date 2019-09-12
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OssConfigServiceImpl implements OssConfigService {

    @Autowired
    private OssConfigRepository ossConfigRepository;

    @Autowired
    private OssConfigMapper ossConfigMapper;


    @Override
    public Object queryAll(OssConfigQueryCriteria criteria, Pageable pageable) {
        Page<OssConfig> page = ossConfigRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(ossConfigMapper::toDto));
    }

    @Override
    public OssConfigDTO findById(Long id) {
        Optional<OssConfig> job = ossConfigRepository.findById(id);
        ValidationUtil.isNull(job,"Oss","id",id);
        return ossConfigMapper.toDto(job.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OssConfigDTO create(OssConfig resources) {
        return ossConfigMapper.toDto(ossConfigRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OssConfig resources) {
        Optional<OssConfig> optionalJob = ossConfigRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalJob,"Oss","id",resources.getId());

        OssConfig job = optionalJob.get();
        resources.setId(job.getId());
        ossConfigRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        ossConfigRepository.deleteById(id);
    }
}
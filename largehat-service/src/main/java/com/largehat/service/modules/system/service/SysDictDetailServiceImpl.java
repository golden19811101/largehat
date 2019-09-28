package com.largehat.service.modules.system.service;

import com.largehat.service.modules.system.mapper.SysDictDetailMapper;
import com.largehat.service.modules.system.repository.SysDictDetailRepository;
import com.largehat.api.modules.system.domain.SysDictDetail;
import com.largehat.api.modules.system.dto.SysDictDetailDTO;
import com.largehat.api.modules.system.dto.SysDictDetailQueryCriteria;
import com.largehat.api.modules.system.service.SysDictDetailService;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

/**
* @author Lion
* @date 2019-04-10
*/
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = SysDictDetailService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysDictDetailServiceImpl implements SysDictDetailService {

    @Autowired
    private SysDictDetailRepository dictDetailRepository;

    @Autowired
    private SysDictDetailMapper dictDetailMapper;

    @Override
    public Map queryAll(SysDictDetailQueryCriteria criteria, Pageable pageable) {
        Page<SysDictDetail> page = dictDetailRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(dictDetailMapper::toDto));
    }

    @Override
    public SysDictDetailDTO findById(Long id) {
        Optional<SysDictDetail> dictDetail = dictDetailRepository.findById(id);
        ValidationUtil.isNull(dictDetail,"DictDetail","id",id);
        return dictDetailMapper.toDto(dictDetail.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysDictDetailDTO create(SysDictDetail resources) {
        return dictDetailMapper.toDto(dictDetailRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictDetail resources) {
        Optional<SysDictDetail> optionalDictDetail = dictDetailRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalDictDetail,"DictDetail","id",resources.getId());
        SysDictDetail dictDetail = optionalDictDetail.get();
        resources.setId(dictDetail.getId());
        dictDetailRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictDetailRepository.deleteById(id);
    }
}
package com.largehat.admin.modules.system.service.impl;

import com.largehat.admin.modules.system.service.mapper.DictMapper;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import com.largehat.admin.modules.system.domain.Dict;
import com.largehat.admin.modules.system.repository.DictRepository;
import com.largehat.admin.modules.system.service.DictService;
import com.largehat.admin.modules.system.service.dto.DictDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author Lion
* @date 2019-04-10
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {

    @Autowired
    private DictRepository dictRepository;

    @Autowired
    private DictMapper dictMapper;

    @Override
    public Object queryAll(DictDTO dict, Pageable pageable){
        Page<Dict> page = dictRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb), pageable);
        return PageUtil.toPage(page.map(dictMapper::toDto));
    }

    @Override
    public DictDTO findById(Long id) {
        Optional<Dict> dict = dictRepository.findById(id);
        ValidationUtil.isNull(dict,"Dict","id",id);
        return dictMapper.toDto(dict.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictDTO create(Dict resources) {
        return dictMapper.toDto(dictRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Dict resources) {
        Optional<Dict> optionalDict = dictRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalDict,"Dict","id",resources.getId());
        Dict dict = optionalDict.get();
        resources.setId(dict.getId());
        dictRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictRepository.deleteById(id);
    }
}
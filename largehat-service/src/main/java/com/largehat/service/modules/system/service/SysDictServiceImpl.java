package com.largehat.service.modules.system.service;

import com.largehat.service.modules.system.mapper.SysDictMapper;
import com.largehat.service.modules.system.repository.SysDictRepository;
import com.largehat.api.modules.system.domain.SysDict;
import com.largehat.api.modules.system.dto.SysDictDTO;
import com.largehat.api.modules.system.service.SysDictService;
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
* @author Lion
* @date 2019-04-10
*/
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = SysDictService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictRepository dictRepository;

    @Autowired
    private SysDictMapper dictMapper;

    @Override
    public Object queryAll(SysDictDTO dict, Pageable pageable){
        Page<SysDict> page = dictRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb), pageable);
        return PageUtil.toPage(page.map(dictMapper::toDto));
    }

    @Override
    public SysDictDTO findById(Long id) {
        Optional<SysDict> dict = dictRepository.findById(id);
        ValidationUtil.isNull(dict,"Dict","id",id);
        return dictMapper.toDto(dict.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysDictDTO create(SysDict resources) {
        return dictMapper.toDto(dictRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDict resources) {
        Optional<SysDict> optionalDict = dictRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalDict,"Dict","id",resources.getId());
        SysDict dict = optionalDict.get();
        resources.setId(dict.getId());
        dictRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictRepository.deleteById(id);
    }
}
package com.largehat.service.modules.system.service;


import com.largehat.service.modules.system.mapper.SysJobMapper;
import com.largehat.service.modules.system.repository.SysDeptRepository;
import com.largehat.service.modules.system.repository.SysJobRepository;
import com.largehat.api.modules.system.domain.SysJob;
import com.largehat.api.modules.system.dto.SysJobDTO;
import com.largehat.api.modules.system.dto.SysJobQueryCriteria;
import com.largehat.api.modules.system.service.SysJobService;
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
* @author Lion
* @date 2019-03-29
*/
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = SysJobService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysJobServiceImpl implements SysJobService {

    @Autowired
    private SysJobRepository jobRepository;

    @Autowired
    private SysJobMapper jobMapper;

    @Autowired
    private SysDeptRepository deptRepository;

    @Override
    public Object queryAll(SysJobQueryCriteria criteria, Pageable pageable) {
        Page<SysJob> page = jobRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        List<SysJobDTO> jobs = new ArrayList<>();
        for (SysJob job : page.getContent()) {
            jobs.add(jobMapper.toDto(job,deptRepository.findNameById(job.getDept().getPid())));
        }
        return PageUtil.toPage(jobs,page.getTotalElements());
    }

    @Override
    public SysJobDTO findById(Long id) {
        Optional<SysJob> job = jobRepository.findById(id);
        ValidationUtil.isNull(job,"Job","id",id);
        return jobMapper.toDto(job.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysJobDTO create(SysJob resources) {
        return jobMapper.toDto(jobRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysJob resources) {
        Optional<SysJob> optionalJob = jobRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalJob,"Job","id",resources.getId());

        SysJob job = optionalJob.get();
        resources.setId(job.getId());
        jobRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
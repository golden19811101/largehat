package com.largehat.admin.modules.quartz.service.impl;

import com.largehat.web.exception.BadRequestException;
import com.largehat.admin.modules.quartz.repository.QuartzJobRepository;
import com.largehat.admin.modules.quartz.repository.QuartzLogRepository;
import com.largehat.admin.modules.quartz.utils.QuartzManage;
import com.largehat.web.utils.PageUtil;
import com.largehat.web.utils.QueryHelp;
import com.largehat.web.utils.ValidationUtil;
import com.largehat.admin.modules.quartz.domain.QuartzJob;
import com.largehat.admin.modules.quartz.service.QuartzJobService;
import com.largehat.admin.modules.quartz.service.dto.JobQueryCriteria;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Zheng Jie
 * @date 2019-01-07
 */
@Service(value = "quartzJobService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private QuartzJobRepository quartzJobRepository;

    @Autowired
    private QuartzLogRepository quartzLogRepository;

    @Autowired
    private QuartzManage quartzManage;

    @Override
    public Object queryAll(JobQueryCriteria criteria, Pageable pageable){
        return PageUtil.toPage(quartzJobRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable));
    }

    @Override
    public Object queryAllLog(JobQueryCriteria criteria, Pageable pageable){
        return PageUtil.toPage(quartzLogRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable));
    }

    @Override
    public QuartzJob findById(Long id) {
        Optional<QuartzJob> quartzJob = quartzJobRepository.findById(id);
        ValidationUtil.isNull(quartzJob,"QuartzJob","id",id);
        return quartzJob.get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public QuartzJob create(QuartzJob resources) {
        if (!CronExpression.isValidExpression(resources.getCronExpression())){
            throw new BadRequestException("cron表达式格式错误");
        }
        resources = quartzJobRepository.save(resources);
        quartzManage.addJob(resources);
        return resources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(QuartzJob resources) {
        if(resources.getId().equals(1L)){
            throw new BadRequestException("该任务不可操作");
        }
        if (!CronExpression.isValidExpression(resources.getCronExpression())){
            throw new BadRequestException("cron表达式格式错误");
        }
        resources = quartzJobRepository.save(resources);
        quartzManage.updateJobCron(resources);
    }

    @Override
    public void updateIsPause(QuartzJob quartzJob) {
        if(quartzJob.getId().equals(1L)){
            throw new BadRequestException("该任务不可操作");
        }
        if (quartzJob.getIsPause()) {
            quartzManage.resumeJob(quartzJob);
            quartzJob.setIsPause(false);
        } else {
            quartzManage.pauseJob(quartzJob);
            quartzJob.setIsPause(true);
        }
        quartzJobRepository.save(quartzJob);
    }

    @Override
    public void execution(QuartzJob quartzJob) {
        if(quartzJob.getId().equals(1L)){
            throw new BadRequestException("该任务不可操作");
        }
        quartzManage.runAJobNow(quartzJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(QuartzJob quartzJob) {
        if(quartzJob.getId().equals(1L)){
            throw new BadRequestException("该任务不可操作");
        }
        quartzManage.deleteJob(quartzJob);
        quartzJobRepository.delete(quartzJob);
    }
}

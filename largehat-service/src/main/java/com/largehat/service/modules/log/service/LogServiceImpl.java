package com.largehat.service.modules.log.service;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONObject;
import com.largehat.service.modules.log.mapper.LogErrorMapper;
import com.largehat.service.modules.log.mapper.LogSmallMapper;
import com.largehat.service.modules.log.repository.LogRepository;
import com.largehat.api.modules.log.domain.SysLog;
import com.largehat.api.modules.log.dto.LogQueryCriteria;
import com.largehat.api.modules.log.service.LogService;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @author Lion
 * @date 2018-11-24
 */
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = LogService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private LogErrorMapper logErrorMapper;

    @Autowired
    private LogSmallMapper logSmallMapper;


    private final String LOGINPATH = "login";

    @Override
    public Object queryAll(LogQueryCriteria criteria, Pageable pageable){
        Page<SysLog> page = logRepository.findAll(((root, criteriaQuery, cb) -> QueryHelp.getPredicate(root, criteria, cb)),pageable);
        if ("ERROR".equals(criteria.getLogType())) {
            return PageUtil.toPage(page.map(logErrorMapper::toDto));
        }
        return page;
    }

    @Override
    public Object queryAllByUser(LogQueryCriteria criteria, Pageable pageable) {
        Page<SysLog> page = logRepository.findAll(((root, criteriaQuery, cb) -> QueryHelp.getPredicate(root, criteria, cb)),pageable);
        return PageUtil.toPage(page.map(logSmallMapper::toDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String username, String ip, ProceedingJoinPoint joinPoint, SysLog log){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.largehat.common.core.annotation.Log aopLog = method.getAnnotation(com.largehat.common.core.annotation.Log.class);

        // 描述
        if (log != null) {
            log.setDescription(aopLog.value());
        }

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";

        String params = "{";
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params += " " + argNames[i] + ": " + argValues[i];
            }
        }

        // 获取IP地址
        log.setRequestIp(ip);

        if(LOGINPATH.equals(signature.getName())){
            try {
                JSONObject jsonObject = new JSONObject(argValues[0]);
                username = jsonObject.get("username").toString();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        log.setMethod(methodName);
        log.setUsername(username);
        log.setParams(params + " }");
        logRepository.save(log);
    }

    @Override
    public Object findByErrDetail(Long id) {
        return Dict.create().set("exception",logRepository.findExceptionById(id));
    }
}

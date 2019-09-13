package com.largehat.admin.modules.monitor.service.impl;

import com.largehat.admin.modules.log.repository.LogRepository;
import com.largehat.admin.modules.monitor.repository.SysVisitsRepository;
import com.largehat.common.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import com.largehat.admin.modules.monitor.domain.SysVisits;
import com.largehat.admin.modules.monitor.service.SysVisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lion
 * @date 2018-12-13
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysVisitsServiceImpl implements SysVisitsService {

    @Autowired
    private SysVisitsRepository visitsRepository;

    @Autowired
    private LogRepository logRepository;

    @Override
    public void save() {
        LocalDate localDate = LocalDate.now();
        SysVisits visits = visitsRepository.findByDate(localDate.toString());
        if(visits == null){
            visits = new SysVisits();
            visits.setWeekDay(StringUtils.getWeekDay());
            visits.setPvCounts(1L);
            visits.setIpCounts(1L);
            visits.setDate(localDate.toString());
            visitsRepository.save(visits);
        }
    }

    @Override
    public void count(HttpServletRequest request) {
        LocalDate localDate = LocalDate.now();
        SysVisits visits = visitsRepository.findByDate(localDate.toString());
        visits.setPvCounts(visits.getPvCounts()+1);
        long ipCounts = logRepository.findIp(localDate.toString(), localDate.plusDays(1).toString());
        visits.setIpCounts(ipCounts);
        visitsRepository.save(visits);
    }

    @Override
    public Object get() {
        Map map = new HashMap();
        LocalDate localDate = LocalDate.now();
        SysVisits visits = visitsRepository.findByDate(localDate.toString());
        List<SysVisits> list = visitsRepository.findAllVisits(localDate.minusDays(6).toString(),localDate.plusDays(1).toString());

        long recentVisits = 0, recentIp = 0;
        for (SysVisits data : list) {
            recentVisits += data.getPvCounts();
            recentIp += data.getIpCounts();
        }
        map.put("newVisits",visits.getPvCounts());
        map.put("newIp",visits.getIpCounts());
        map.put("recentVisits",recentVisits);
        map.put("recentIp",recentIp);
        return map;
    }

    @Override
    public Object getChartData() {
        Map map = new HashMap();
        LocalDate localDate = LocalDate.now();
        List<SysVisits> list = visitsRepository.findAllVisits(localDate.minusDays(6).toString(),localDate.plusDays(1).toString());
        map.put("weekDays",list.stream().map(SysVisits::getWeekDay).collect(Collectors.toList()));
        map.put("visitsData",list.stream().map(SysVisits::getPvCounts).collect(Collectors.toList()));
        map.put("ipData",list.stream().map(SysVisits::getIpCounts).collect(Collectors.toList()));
        return map;
    }
}

package com.largehat.service.modules.monitor.repository;


import com.largehat.api.modules.monitor.domain.SysVisits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lion
 * @date 2018-12-13
 */
@Repository
public interface SysVisitsRepository extends JpaRepository<SysVisits,Long> {

    /**
     * findByDate
     * @param date
     * @return
     */
    SysVisits findByDate(String date);

    /**
     * 获得一个时间段的记录
     * @param date1
     * @param date2
     * @return
     */
    @Query(value = "select * FROM sys_visits where " +
            "create_time between ?1 and ?2",nativeQuery = true)
    List<SysVisits> findAllVisits(String date1, String date2);
}

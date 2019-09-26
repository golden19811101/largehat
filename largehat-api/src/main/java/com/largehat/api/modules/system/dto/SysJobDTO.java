package com.largehat.api.modules.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author Lion
* @date 2019-03-29
*/
@Data
@NoArgsConstructor
public class SysJobDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    private Long sort;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private Boolean enabled;

    private SysDeptDTO dept;

    /**
     * 如果分公司存在相同部门，则显示上级部门名称
     */
    private String deptSuperiorName;

    /**
     * 创建日期
     */
    private Timestamp createTime;

    public SysJobDTO(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}
package com.largehat.admin.modules.im.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author
* @date 2019-09-18
*/
@Entity
@Data
@Table(name="im_org")
public class ImOrg implements Serializable {

    // 组织机构id 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Integer orgId;

    // 组织机构编码
    @Column(name = "org_code",nullable = false)
    private String orgCode;

    // 组织机构名称
    @Column(name = "org_name",nullable = false)
    private String orgName;

    // 0，自有组织  1，社会组织
    @Column(name = "org_type",nullable = false)
    private Integer orgType;

    // 组织图标
    @Column(name = "icon_url")
    private String iconUrl;

    // 0,  正常  1，失效  2，冻结
    @Column(name = "status",nullable = false)
    private Integer status;

    // 创建时间
    @Column(name = "create_time")
    private Timestamp createTime;

    // 创建人
    @Column(name = "create_by")
    private String createBy;

    // 备注
    @Column(name = "note")
    private String note;

    public void copy(ImOrg source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
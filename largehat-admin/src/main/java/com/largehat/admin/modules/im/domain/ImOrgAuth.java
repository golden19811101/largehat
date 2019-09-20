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
@Table(name="im_org_auth")
public class ImOrgAuth implements Serializable {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 组织机构编码
    @Column(name = "org_id")
    private Integer orgId;

    // 鉴权码
    @Column(name = "auth_code")
    private String authCode;

    // 更新时间
    @Column(name = "update_time")
    private Timestamp updateTime;

    // 更新人
    @Column(name = "update_by")
    private String updateBy;

    public void copy(ImOrgAuth source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
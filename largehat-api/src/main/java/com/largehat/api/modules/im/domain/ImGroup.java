package com.largehat.api.modules.im.domain;

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
@Table(name="im_group")
public class ImGroup implements Serializable {

    // 群组ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    // 群组名称
    @Column(name = "group_name",nullable = false)
    private String groupName;

    // 群组头像
    @Column(name = "group_avatar",nullable = false)
    private String groupAvatar;

    // 群组类型 0未知 1固定群 2临时群 3聊天室
    @Column(name = "group_type",nullable = false)
    private Integer groupType;

    // 归属组织机构
    @Column(name = "org_id",nullable = false)
    private String orgId;

    // 最大人数
    @Column(name = "max_num",nullable = false)
    private Integer maxNum;

    // 状态 0 正常  1 失效  2冻结
    @Column(name = "status",nullable = false)
    private Integer status;

    // 创建时间
    @Column(name = "create_time")
    private Timestamp createTime;

    // 创建人
    @Column(name = "create_by",nullable = false)
    private String createBy;

    // 修改时间
    @Column(name = "modify_time")
    private Timestamp modifyTime;

    // 修改人
    @Column(name = "modify_by")
    private String modifyBy;

    // 备注
    @Column(name = "note")
    private String note;

    public void copy(ImGroup source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
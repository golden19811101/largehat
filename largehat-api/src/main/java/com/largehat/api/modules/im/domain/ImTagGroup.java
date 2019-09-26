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
@Table(name="im_tag_group")
public class ImTagGroup implements Serializable {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 群组名称
    @Column(name = "group_name")
    private String groupName;

    // 群组头像
    @Column(name = "group_avatar",nullable = false)
    private String groupAvatar;

    // 归属用户
    @Column(name = "user_id",nullable = false)
    private Integer userId;

    // 归属组织机构
    @Column(name = "org_id",nullable = false)
    private String orgId;

    // 状态 0 正常  1 失效  2冻结
    @Column(name = "status",nullable = false)
    private Integer status;

    // 创建时间
    @Column(name = "create_time",nullable = false)
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

    public void copy(ImTagGroup source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
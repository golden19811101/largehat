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
@Table(name="im_group_relation")
public class ImGroupRelation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 群组id
    @Column(name = "group_id")
    private Integer groupId;

    // 用户id
    @Column(name = "user_id")
    private Integer userId;

    // 加入时间
    @Column(name = "join_time")
    private Timestamp joinTime;

    public void copy(ImGroupRelation source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
package com.largehat.admin.modules.im.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author
* @date 2019-09-18
*/
@Entity
@Data
@Table(name="im_friend")
public class ImFriend implements Serializable {

    // 主键
    @Id
    @Column(name = "id")
    private Integer id;

    // 朋友ID
    @Column(name = "friend_id")
    private Integer friendId;

    // 用户ID
    @Column(name = "user_id")
    private Integer userId;

    // 添加好友时间
    @Column(name = "add_time")
    private Timestamp addTime;

    public void copy(ImFriend source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
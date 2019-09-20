package com.largehat.admin.modules.im.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
* @author
* @date 2019-09-18
*/
@Entity
@Data
@Table(name="im_tag_relation")
public class ImTagRelation implements Serializable {

    // 主键
    @Id
    @Column(name = "id")
    private Integer id;

    // 用户ID
    @Column(name = "user_id")
    private Integer userId;

    // 标签头
    @Column(name = "tag_id")
    private String tagId;

    public void copy(ImTagRelation source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
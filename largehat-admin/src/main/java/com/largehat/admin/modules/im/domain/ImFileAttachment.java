package com.largehat.admin.modules.im.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
* @author
* @date 2019-09-18
*/
@Entity
@Data
@Table(name="im_file_attachment")
public class ImFileAttachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer fileId;

    @Column(name = "file_name",nullable = false)
    private String fileName;

    @Column(name = "message_id",nullable = false)
    private Long messageId;

    // 消息体 gson字符串，不同类型的有不同的展示格式
    @Column(name = "file_body",nullable = false)
    private String fileBody;

    @Column(name = "description")
    private String description;

    public void copy(ImFileAttachment source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
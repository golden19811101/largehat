package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImTagRelationDTO implements Serializable {

    // 主键
    private Integer id;

    // 用户ID
    private Integer userId;

    // 标签头
    private String tagId;
}
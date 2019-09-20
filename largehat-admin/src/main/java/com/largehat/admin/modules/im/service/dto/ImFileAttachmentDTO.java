package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImFileAttachmentDTO implements Serializable {

    private Integer fileId;

    private String fileName;

    private Long messageId;

    // 消息体 gson字符串，不同类型的有不同的展示格式
    private String fileBody;

    private String description;
}
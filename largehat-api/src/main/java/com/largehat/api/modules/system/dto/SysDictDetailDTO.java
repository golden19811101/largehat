package com.largehat.api.modules.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @author Lion
* @date 2019-04-10
*/
@Data
public class SysDictDetailDTO implements Serializable {

    private Long id;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典值
     */
    private String value;

    /**
     * 排序
     */
    private String sort;
}
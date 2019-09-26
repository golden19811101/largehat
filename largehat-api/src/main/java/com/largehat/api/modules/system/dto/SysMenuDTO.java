package com.largehat.api.modules.system.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Lion
 * @date 2018-12-17
 */
@Data
public class SysMenuDTO {

    private Long id;

    private String name;

    private Long sort;

    private String path;

    private String component;

    private Long pid;

    private Boolean iFrame;

    private String icon;

    private List<SysMenuDTO> children;

    private Timestamp createTime;
}

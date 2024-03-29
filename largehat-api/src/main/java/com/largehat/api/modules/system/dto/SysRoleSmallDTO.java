package com.largehat.api.modules.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Data
public class SysRoleSmallDTO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}

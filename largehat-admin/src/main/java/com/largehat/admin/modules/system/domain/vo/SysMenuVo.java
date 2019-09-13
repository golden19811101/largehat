package com.largehat.admin.modules.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 构建前端路由时用到
 * @author Lion
 * @date 2018-12-20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SysMenuVo implements Serializable {

    private String name;

    private String path;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private SysMenuMetaVo meta;

    private List<SysMenuVo> children;
}

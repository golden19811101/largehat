package com.largehat.api.modules.system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Lion
 * @date 2018-12-20
 */
@Data
@AllArgsConstructor
public class SysMenuMetaVo implements Serializable {

    private String title;

    private String icon;
}

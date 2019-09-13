package com.largehat.admin.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
* @author Lion
* @date 2019-6-10 16:32:18
*/
@Data
@NoArgsConstructor
public class SysJobSmallDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;
}
package com.largehat.admin.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Data
public class UserDTO implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String phone;

    private Boolean enabled;

    @JsonIgnore
    private String password;

    private Timestamp createTime;

    private Date lastPasswordResetTime;

    private Set<RoleSmallDTO> roles;

    private JobSmallDTO job;

    private DeptSmallDTO dept;

    private Long deptId;
}

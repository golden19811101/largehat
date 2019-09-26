package com.largehat.api.modules.system.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author kafe
* @date 2019-09-12
*/
@Entity
@Data
@Table(name="oss_config")
public class OssConfig implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    /**
     *  key
     */
    @Column(name = "param_key",nullable = false)
    @NotBlank
    private String paramKey;

    /**
     *  value
     */
    @Column(name = "param_value",nullable = false)
    @NotBlank
    private String paramValue;


    /**
     * 状态
     */
    @Column(name = "status",nullable = false)
    @NotNull
    private Boolean status;

    /**
     * 是否激活
     */
    @NotNull
    @Column(name = "is_activate",nullable = false)
    private Boolean isActivate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    public @interface Update {}
}
package com.largehat.admin.modules.tools.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Lion
 * @date 2018-12-27
 */
@Data
@Entity
@Table(name = "sys_picture")
public class SysPicture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private String url;

    private String size;

    private String height;

    private String width;

    /**
     * delete URl
     */
    @Column(name = "delete_url")
    private String delete;

    private String username;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    @Override
    public String toString() {
        return "Picture{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
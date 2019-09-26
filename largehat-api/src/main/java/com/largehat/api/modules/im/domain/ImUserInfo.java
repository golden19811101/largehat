package com.largehat.api.modules.im.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author
* @date 2019-09-18
*/
@Entity
@Data
@Table(name="im_user_info")
public class ImUserInfo implements Serializable {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 用户ID
    @Column(name = "user_id",nullable = false)
    private String userId;

    // 归属组织机构
    @Column(name = "org_id",nullable = false)
    private String orgId;

    // 是否在线 0,未知 1,下线 2,离线
    @Column(name = "is_online")
    private Integer isOnline;

    // 用户类型  
    @Column(name = "user_type")
    private Integer userType;

    // 用户名称
    @Column(name = "user_name",nullable = false)
    private String userName;

    // 密码
    @Column(name = "password",nullable = false)
    private String password;

    // 用户昵称
    @Column(name = "nickname",nullable = false)
    private String nickname;

    // 性别  0, 男  1,女  2,未知
    @Column(name = "sex")
    private Integer sex;

    // 状态  0,正常  1,失效  2, 冻结
    @Column(name = "status")
    private Integer status;

    // 个性签名
    @Column(name = "sign")
    private String sign;

    // 手机号码
    @Column(name = "phone")
    private String phone;

    // 地址
    @Column(name = "address")
    private String address;

    // 邮箱
    @Column(name = "email")
    private String email;

    // 生日
    @Column(name = "birth_day")
    private String birthDay;

    // 身份证号码
    @Column(name = "card_number")
    private String cardNumber;

    // 毕业院校
    @Column(name = "school")
    private String school;

    // 学历  0，初中 1，高中  2，大专 3，本科  4，研究生  5，博士  6，博士后
    @Column(name = "education")
    private Integer education;

    // 头像
    @Column(name = "user_avatar")
    private String userAvatar;

    // 创建时间
    @Column(name = "create_time")
    private Timestamp createTime;

    // 创建人
    @Column(name = "create_by",nullable = false)
    private String createBy;

    // 修改时间
    @Column(name = "modify_time")
    private Timestamp modifyTime;

    // 修改人
    @Column(name = "modify_by")
    private String modifyBy;

    // 备注
    @Column(name = "note")
    private String note;

    public void copy(ImUserInfo source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
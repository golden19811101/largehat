package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImUserInfoDTO implements Serializable {

    // 主键
    private Integer id;

    // 用户ID
    private String userId;

    // 归属组织机构
    private String orgId;

    // 是否在线 0,未知 1,下线 2,离线
    private Integer isOnline;

    // 用户类型  
    private Integer userType;

    // 用户名称
    private String userName;

    // 密码
    private String password;

    // 用户昵称
    private String nickname;

    // 性别  0, 男  1,女  2,未知
    private Integer sex;

    // 状态  0,正常  1,失效  2, 冻结
    private Integer status;

    // 个性签名
    private String sign;

    // 手机号码
    private String phone;

    // 地址
    private String address;

    // 邮箱
    private String email;

    // 生日
    private String birthDay;

    // 身份证号码
    private String cardNumber;

    // 毕业院校
    private String school;

    // 学历  0，初中 1，高中  2，大专 3，本科  4，研究生  5，博士  6，博士后
    private Integer education;

    // 头像
    private String userAvatar;

    // 创建时间
    private Timestamp createTime;

    // 创建人
    private String createBy;

    // 修改时间
    private Timestamp modifyTime;

    // 修改人
    private String modifyBy;

    // 备注
    private String note;
}
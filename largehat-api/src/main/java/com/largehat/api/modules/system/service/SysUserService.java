package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysUser;
import com.largehat.api.modules.system.dto.SysUserDTO;
import com.largehat.api.modules.system.dto.SysUserQueryCriteria;
import org.springframework.data.domain.Pageable;

/**
 * @author Lion
 * @date 2018-11-23
 */
public interface SysUserService {

    /**
     * get
     * @param id
     * @return
     */
    SysUserDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    SysUserDTO create(SysUser resources);

    /**
     * update
     * @param resources
     */
    void update(SysUser resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);

    /**
     * findByName
     * @param userName
     * @return
     */
    SysUserDTO findByName(String userName);

    /**
     * 修改密码
     * @param username
     * @param encryptPassword
     */
    void updatePass(String username, String encryptPassword);

    /**
     * 修改头像
     * @param username
     * @param url
     */
    void updateAvatar(String username, String url);

    /**
     * 修改邮箱
     * @param username
     * @param email
     */
    void updateEmail(String username, String email);


    Object queryAll(SysUserQueryCriteria criteria, Pageable pageable);
}

package com.largehat.admin.modules.system.service;

import com.largehat.admin.modules.system.domain.SysUser;
import com.largehat.admin.modules.system.service.dto.SysUserDTO;
import com.largehat.admin.modules.system.service.dto.SysUserQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
 * @author Lion
 * @date 2018-11-23
 */
@CacheConfig(cacheNames = "user")
public interface SysUserService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysUserDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysUserDTO create(SysUser resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysUser resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * findByName
     * @param userName
     * @return
     */
    @Cacheable(key = "'loadUserByUsername:'+#p0")
    SysUserDTO findByName(String userName);

    /**
     * 修改密码
     * @param username
     * @param encryptPassword
     */
    @CacheEvict(allEntries = true)
    void updatePass(String username, String encryptPassword);

    /**
     * 修改头像
     * @param username
     * @param url
     */
    @CacheEvict(allEntries = true)
    void updateAvatar(String username, String url);

    /**
     * 修改邮箱
     * @param username
     * @param email
     */
    @CacheEvict(allEntries = true)
    void updateEmail(String username, String email);

    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(SysUserQueryCriteria criteria, Pageable pageable);
}
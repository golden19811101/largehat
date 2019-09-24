package com.largehat.server.base.cache;

import com.largehat.server.base.reids.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Function: 服务器节点缓存
 *
 * @author
 *         Date: 2018/8/19 01:31
 * @since JDK 1.8
 */
//@Component
public class ServerCache {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * <B>获取用户缓存信息</B>
     *
     * @param key "user_" + userId + "_" + orgId
     * @return
     */
    List<Object> getUserCache(String key) {
       //Object obj =  redisUtil.get(key);
       return  null;
    }


    /**
     * <B>获取组织机构缓存</B>
     * @param key "org_" + orgId
     * @return
     */
    List<Object> getOrgCache(String key) {
        return  null;
    }


    /**
     * <B>获取群组缓存</B>
     * @param key "group_" + groupId
     * @return
     */
    List<Object> getGroupCache(String key) {
        return  null;
    }

    /**
     * <B>获取群组用户缓存</B>
     * @param key "groupUser" + groupId + "_" + userId
     * @return
     */
    List<Object> getGroupUserCache(String key) {
        return  null;
    }


    /**
     * <B>获取用户好友信息</B>
     * @param key "userFriend_"  + userId
     * @return
     */
    List<Object> getUserFriend(String key) {
        return  null;
    }


    /**
     * <B>获取用户发送的信息</B>
     * @param key "userSendMessage_"  + userId
     * @return
     */
    List<Object> getUserSendMessage(String key) {
        return  null;
    }



    /**
     * <B>获取用户收到的信息</B>
     * @param key "userReceiveMessage_"  + userId
     * @return
     */
    List<Object> getUserReceiveMessage(String key) {
        return  null;
    }
}

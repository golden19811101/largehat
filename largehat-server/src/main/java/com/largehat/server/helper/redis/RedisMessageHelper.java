package com.largehat.server.helper.redis;

import com.alibaba.fastjson.JSONObject;
import com.largehat.common.cache.redis.JedisTemplate;
import com.largehat.common.cache.redis.RedisCache;
import com.largehat.common.cache.redis.RedisCacheManager;
import com.largehat.common.im.config.Config;
import com.largehat.common.im.entity.message.AbstractMessageHelper;
import com.largehat.common.im.listener.ImBindListener;
import com.largehat.common.im.packets.ChatBody;
import com.largehat.common.im.packets.Group;
import com.largehat.common.im.packets.User;
import com.largehat.common.im.packets.UserMessageData;
import com.largehat.common.im.utils.ChatKit;
import com.largehat.common.im.utils.JsonKit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Redis获取持久化+同步消息助手;
 */
public class RedisMessageHelper extends AbstractMessageHelper {

    private RedisCache groupCache = null;
    private RedisCache pushCache = null;
    private RedisCache storeCache = null;
    private RedisCache userCache = null;

    private final String SUBFIX = ":";
    private Logger log = LoggerFactory.getLogger(RedisMessageHelper.class);

    static {
        RedisCacheManager.register(USER, Integer.MAX_VALUE, Integer.MAX_VALUE);
        RedisCacheManager.register(GROUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
        RedisCacheManager.register(STORE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        RedisCacheManager.register(PUSH, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public RedisMessageHelper() {
        this(null);
    }

    public RedisMessageHelper(Config imConfig) {
        this.groupCache = RedisCacheManager.getCache(GROUP);
        this.pushCache = RedisCacheManager.getCache(PUSH);
        this.storeCache = RedisCacheManager.getCache(STORE);
        this.userCache = RedisCacheManager.getCache(USER);
        this.imConfig = imConfig;
    }

    @Override
    public ImBindListener getBindListener() {
        //return new RedisImBindListener(imConfig);
        return  null;
    }

    @Override
    public boolean isOnline(String userid, String orgid) {
        try {
            Set<String> keys = JedisTemplate.me().keys(ORG + orgid +  USER + SUBFIX + userid + SUBFIX + TERMINAL);
            if (keys != null && keys.size() > 0) {
                Iterator<String> keyitr = keys.iterator();
                while (keyitr.hasNext()) {
                    String key = keyitr.next();
                    key = key.substring(key.indexOf(userid));
                    String isOnline = userCache.get(key, String.class);
                    if (ONLINE.equals(isOnline)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return false;
    }


    @Override
    public Group getGroupUsers(String groupId, String orgId, Integer type) {
        if(groupId == null || type == null) {
            return null;
        }
        Group group = groupCache.get(groupId + SUBFIX + INFO , Group.class);
        if(group == null) {
            return null;
        }
        List<String> userIds = this.getGroupUsers(groupId, orgId);
        if(CollectionUtils.isEmpty(userIds)) {
            return null;
        }
        List<User> users = new ArrayList<User>();
        for(String userId : userIds){
            User user = getUserByType(userId, orgId, type);
            if(user != null){
                String status = user.getStatus();
                if(type == 0 && ONLINE.equals(status)){
                    users.add(user);
                }else if(type == 1 && OFFLINE.equals(status)){
                    users.add(user);
                }else if(type == 2){
                    users.add(user);
                }
            }
        }
        group.setUsers(users);
        return group;
    }

    @Override
    public List<Group> getAllGroupUsers(String userId, String orgId, Integer type) {
        if (userId == null) {
            return null;
        }
        List<String> group_ids = userCache.listGetAll(userId + SUBFIX + GROUP);
        if (CollectionUtils.isEmpty(group_ids)) {
            return null;
        }
        List<Group> groups = new ArrayList<Group>();
        for (String group_id : group_ids) {
            Group group = getGroupUsers(group_id, orgId, type);
            if (group != null) {
                groups.add(group);
            }
        }
        return groups;
    }

    @Override
    public Group getFriendUsers(String userId, String orgId, String friendGroupId, Integer type) {
        if (friendGroupId == null || friendGroupId == null || type == null) {
            return null;
        }
        List<Group> friends = userCache.get(userId + SUBFIX + FRIENDS, List.class);
        if (friends == null || friends.isEmpty()) {
            return null;
        }
        for (Group group : friends) {
            if (friendGroupId.equals(group.getGroup_id())) {
                List<User> users = group.getUsers();
                if (CollectionUtils.isEmpty(users)) {
                    return null;
                }
                List<User> userResults = new ArrayList<User>();
                for (User user : users) {
                    initUserStatus(user, orgId);
                    String status = user.getStatus();
                    if (type == 0 && ONLINE.equals(status)) {
                        userResults.add(user);
                    } else if (type == 1 && OFFLINE.equals(status)) {
                        userResults.add(user);
                    } else {
                        userResults.add(user);
                    }
                }
                group.setUsers(userResults);
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> getAllFriendUsers(String userId, String orgId, Integer type) {
        if (userId == null) {
            return null;
        }
        List<JSONObject> friendJsonArray = userCache.get(userId + SUBFIX + FRIENDS, List.class);
        if (CollectionUtils.isEmpty(friendJsonArray)) {
            return null;
        }
        List<Group> friends = new ArrayList<Group>();
        for (JSONObject groupJson : friendJsonArray) {
            Group group = JSONObject.toJavaObject(groupJson, Group.class);
            List<User> users = group.getUsers();
            if (CollectionUtils.isEmpty(users)) {
                continue;
            }
            List<User> userResults = new ArrayList<User>();
            for (User user : users) {
                initUserStatus(user, orgId);
                String status = user.getStatus();
                if (type == 0 && ONLINE.equals(status)) {
                    userResults.add(user);
                } else if (type == 1 && OFFLINE.equals(status)) {
                    userResults.add(user);
                } else if (type == 2) {
                    userResults.add(user);
                }
            }
            group.setUsers(userResults);
            friends.add(group);
        }
        return friends;
    }

    @Override
    public User getUserByType(String userId, String orgId, Integer type) {
        User user = userCache.get(userId + SUBFIX + INFO, User.class);
        if (user == null) {
            return null;
        }
        boolean isOnline = this.isOnline(userId, orgId);
        String status = isOnline ? ONLINE : OFFLINE;
        if (type == 0 || type == 1) {
            if (type == 0 && isOnline) {
                user.setStatus(status);
            } else if (type == 1 && !isOnline) {
                user.setStatus(status);
            }
        } else if (type == 2) {
            user.setStatus(status);
        }
        return user;
    }

    @Override
    public void addGroupUser(String userId, String orgId, String groupId) {
        List<String> users = groupCache.listGetAll(groupId);
        if (!users.contains(userId)) {
            groupCache.listPushTail(groupId, userId);
        }
    }

    @Override
    public List<String> getGroupUsers(String groupId, String orgId) {
        String group_user_key = orgId + SUBFIX + groupId + SUBFIX + USER;
        List<String> users = groupCache.listGetAll(group_user_key);
        return users;
    }

    @Override
    public List<String> getGroups(String userId, String orgId) {
        List<String> groups = userCache.listGetAll(userId + SUBFIX + ORG + orgId);
        return groups;
    }

    @Override
    public void writeMessage(String timelineTable, String timelineId, ChatBody chatBody) {
        double score = chatBody.getCreateTime();
        RedisCacheManager.getCache(timelineTable).sortSetPush(timelineId, score, chatBody);
    }

    @Override
    public void removeGroupUser(String userId, String groupId) {
        groupCache.listRemove(userId, groupId);
    }

    @Override
    public UserMessageData getFriendsOfflineMessage(String userId, String orgId, String fromUserId) {
        String key = USER + SUBFIX + userId + SUBFIX + fromUserId;
        List<String> messageList = pushCache.sortSetGetAll(key);
        List<ChatBody> datas = JsonKit.toArray(messageList, ChatBody.class);
        pushCache.remove(key);
        return putFriendsMessage(new UserMessageData(userId), datas);
    }

    @Override
    public UserMessageData getFriendsOfflineMessage(String userId, String orgId) {
        try {
            Set<String> keys = JedisTemplate.me().keys(PUSH + SUBFIX + USER + SUBFIX + userId);
            UserMessageData messageData = new UserMessageData(userId);
            if (keys != null && keys.size() > 0) {
                List<ChatBody> results = new ArrayList<ChatBody>();
                Iterator<String> keyitr = keys.iterator();
                //获取好友离线消息;
                while (keyitr.hasNext()) {
                    String key = keyitr.next();
                    key = key.substring(key.indexOf(USER + SUBFIX));
                    List<String> messages = pushCache.sortSetGetAll(key);
                    pushCache.remove(key);
                    results.addAll(JsonKit.toArray(messages, ChatBody.class));
                }
                putFriendsMessage(messageData, results);
            }
            List<String> groups = userCache.listGetAll(userId + SUBFIX + GROUP);
            //获取群组离线消息;
            if (groups != null) {
                for (String groupId : groups) {
                    UserMessageData groupMessageData = getGroupOfflineMessage(userId, orgId, groupId);
                    if (groupMessageData != null) {
                        putGroupMessage(messageData, groupMessageData.getGroups().get(groupId));
                    }
                }
            }
            return messageData;
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return null;
    }

    @Override
    public UserMessageData getGroupOfflineMessage(String userId, String orgId, String groupId) {
        String key = GROUP + SUBFIX + groupId + SUBFIX + userId;
        List<String> messages = pushCache.sortSetGetAll(key);
        if (CollectionUtils.isEmpty(messages)) {
            return null;
        }
        UserMessageData messageData = new UserMessageData(userId);
        putGroupMessage(messageData, JsonKit.toArray(messages, ChatBody.class));
        pushCache.remove(key);
        return messageData;
    }

    @Override
    public UserMessageData getFriendHistoryMessage(String userId, String fromUserId, Double beginTime, Double endTime, Integer offset, Integer count) {
        String sessionId = ChatKit.sessionId(userId, fromUserId);
        List<String> messages = null;
        String key = USER + SUBFIX + sessionId;
        boolean isTimeBetween = (beginTime != null && endTime != null);
        boolean isPage = (offset != null && count != null);
        //消息区间，不分页
        if (isTimeBetween && !isPage) {
            messages = storeCache.sortSetGetAll(key, beginTime, endTime);
            //消息区间，并且分页;
        } else if (isTimeBetween && isPage) {
            messages = storeCache.sortSetGetAll(key, beginTime, endTime, offset, count);
            //所有消息，并且分页;
        } else if (!isTimeBetween && isPage) {
            messages = storeCache.sortSetGetAll(key, 0, Double.MAX_VALUE, offset, count);
            //所有消息，不分页;
        } else {
            messages = storeCache.sortSetGetAll(key);
        }
        if (CollectionUtils.isEmpty(messages)) {
            return null;
        }
        UserMessageData messageData = new UserMessageData(userId);
        putFriendsHistoryMessage(messageData, JsonKit.toArray(messages, ChatBody.class), fromUserId);
        return messageData;
    }

    @Override
    public UserMessageData getGroupHistoryMessage(String userId, String groupid, Double beginTime, Double endTime, Integer offset, Integer count) {
        String key = GROUP + SUBFIX + groupid;
        List<String> messages = null;
        boolean isTimeBetween = (beginTime != null && endTime != null);
        boolean isPage = (offset != null && count != null);
        //消息区间，不分页
        if (isTimeBetween && !isPage) {
            messages = storeCache.sortSetGetAll(key, beginTime, endTime);
            //消息区间，并且分页;
        } else if (isTimeBetween && isPage) {
            messages = storeCache.sortSetGetAll(key, beginTime, endTime, offset, count);
            //所有消息，并且分页;
        } else if (!isTimeBetween && isPage) {
            messages = storeCache.sortSetGetAll(key, 0, Double.MAX_VALUE, offset, count);
            //所有消息，不分页;
        } else {
            messages = storeCache.sortSetGetAll(key);
        }
        if (CollectionUtils.isEmpty(messages)) {
            return null;
        }
        UserMessageData messageData = new UserMessageData(userId);
        putGroupMessage(messageData, JsonKit.toArray(messages, ChatBody.class));
        return messageData;
    }


    /**
     * 放入用户好友消息;
     * @param userMessage
     * @param messages
     */
    public UserMessageData putFriendsMessage(UserMessageData userMessage , List<ChatBody> messages){
        if(userMessage == null || messages == null) {
            return null;
        }
        for(ChatBody chatBody : messages){
            String fromUserId = chatBody.getFrom();
            if(StringUtils.isEmpty(fromUserId)) {
                continue;
            }
            List<ChatBody> friendMessages = userMessage.getFriends().get(fromUserId);
            if(friendMessages == null){
                friendMessages = new ArrayList<ChatBody>();
                userMessage.getFriends().put(fromUserId, friendMessages);
            }
            friendMessages.add(chatBody);
        }
        return userMessage;
    }
    /**
     * 放入用户好友历史消息;
     * @param userMessage
     * @param messages
     */
    public UserMessageData putFriendsHistoryMessage(UserMessageData userMessage , List<ChatBody> messages,String friendId){
        if(userMessage == null || messages == null) {
            return null;
        }
        for(ChatBody chatBody : messages){
            String fromUserId = chatBody.getFrom();
            if(StringUtils.isEmpty(fromUserId)) {
                continue;
            }
            List<ChatBody> friendMessages = userMessage.getFriends().get(friendId);
            if(friendMessages == null){
                friendMessages = new ArrayList<ChatBody>();
                userMessage.getFriends().put(friendId, friendMessages);
            }
            friendMessages.add(chatBody);
        }
        return userMessage;
    }


    public UserMessageData putGroupMessage(UserMessageData userMessage,List<ChatBody> messages){
        if(userMessage == null || messages == null) {
            return null;
        }
        for(ChatBody chatBody : messages){
            String group = chatBody.getGroup_id();
            if(StringUtils.isEmpty(group)) {
                continue;
            }
            List<ChatBody> groupMessages = userMessage.getGroups().get(group);
            if(groupMessages == null){
                groupMessages = new ArrayList<ChatBody>();
                userMessage.getGroups().put(group, groupMessages);
            }
            groupMessages.add(chatBody);
        }
        return userMessage;
    }

    /**
     * 初始化用户在线状态;
     * @param user
     */
    public void initUserStatus(User user, String orgId){
        if(user == null) {
            return;
        }
        String userId = user.getId();
        boolean isOnline = this.isOnline(userId, orgId);
        if(isOnline){
            user.setStatus(ONLINE);
        }else{
            user.setStatus(OFFLINE);
        }
    }
}

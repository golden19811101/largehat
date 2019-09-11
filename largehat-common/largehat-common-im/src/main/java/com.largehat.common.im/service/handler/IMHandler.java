package com.largehat.common.im.service.handler;

import com.google.protobuf.Message;
import com.largehat.common.im.utils.Worker;
import io.netty.channel.ChannelHandlerContext;
import redis.clients.jedis.Jedis;


/**
 */
public abstract class IMHandler {
    protected final String _userid;
    protected final long  _netid;
    protected final Message _msg;
    protected ChannelHandlerContext _ctx;
    protected Jedis _jedis;

    protected IMHandler(String userid, long netid, Message msg, ChannelHandlerContext ctx) {
        _userid = userid;
        _netid = netid;
        _msg = msg;
        _ctx = ctx;
    }

    protected abstract void excute(Worker worker) throws Exception;
}

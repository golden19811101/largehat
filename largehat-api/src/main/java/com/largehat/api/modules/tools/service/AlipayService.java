package com.largehat.api.modules.tools.service;


import com.largehat.api.modules.tools.domain.AlipayConfig;
import com.largehat.api.modules.tools.domain.vo.TradeVo;

/**
 * @author Lion
 * @date 2018-12-31
 */
public interface AlipayService {

    /**
     * 处理来自PC的交易请求
     * @param alipay
     * @param trade
     * @return
     * @throws Exception
     */
    String toPayAsPC(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 处理来自手机网页的交易请求
     * @param alipay
     * @param trade
     * @return
     * @throws Exception
     */
    String toPayAsWeb(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 查询配置
     * @return
     */
    AlipayConfig find();

    /**
     * 更新配置
     * @param alipayConfig
     * @return
     */
    AlipayConfig update(AlipayConfig alipayConfig);
}

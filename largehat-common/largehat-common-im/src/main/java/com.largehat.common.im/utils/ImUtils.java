package com.largehat.common.im.utils;

import com.largehat.common.im.packets.Client;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lion
 */
public class ImUtils {

	/**
	 * 设置Client对象到ImSessionContext中
	 * @param channelContext
	 * @return
	 * @author: Lion
	 */
	public static Client setClient(ChannelHandlerContext channelContext) {
//		ImSessionContext imSessionContext = (ImSessionContext)channelContext.getAttribute();
//		Client client = imSessionContext.getClient();
//		if (client == null) {
//			client = new Client();
//			client.setId(channelContext.getId());
//			client.setIp(channelContext.getClientNode().getIp());
//			client.setPort(channelContext.getClientNode().getPort());
//			imSessionContext.setClient(client);
//		}
//		return client;
		return null;
	}

	public static String formatRegion(String region) {
		if (StringUtils.isBlank(region)) {
			return "";
		}

		String[] arr = StringUtils.split(region, "|");//.split("|");
		List<String> validArr = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			String e = arr[i];
			if (StringUtils.isNotBlank(e) && !"0".equals(e)) {
				validArr.add(e);
			}
		}
		if (validArr.size() == 0) {
			return "";
		} else if (validArr.size() == 1) {
			return validArr.get(0);
		} else {
			return validArr.get(validArr.size() - 2) + validArr.get(validArr.size() - 1);
		}
	}
	
	public static String formatUserAgent(ChannelHandlerContext channelContext) {
	/*	ImSessionContext imSessionContext = (ImSessionContext)channelContext.getAttribute();
		HttpRequestPacket httpHandshakePacket = imSessionContext.getHandshakeRequestPacket();
		
		if (httpHandshakePacket != null) {
			UserAgent userAgent = httpHandshakePacket.getUserAgent();

			String DeviceName = userAgent.getValue(UserAgent.DEVICE_NAME);//StringUtils.leftPad(userAgent.getValue(UserAgent.DEVICE_NAME), 1);
			String DeviceCpu = userAgent.getValue("DeviceCpu"); //StringUtils.leftPad(userAgent.getValue("DeviceCpu"), 1);
			String OperatingSystemNameVersion = userAgent.getValue("OperatingSystemNameVersion"); //StringUtils.leftPad(userAgent.getValue("OperatingSystemNameVersion"), 1);
			String AgentNameVersion = userAgent.getValue("AgentNameVersion");//StringUtils.leftPad(userAgent.getValue("AgentNameVersion"), 1);
			String useragentStr = DeviceName + " " + DeviceCpu + " " + OperatingSystemNameVersion + " " + AgentNameVersion;

			return useragentStr;
		} else {
			return "";
		}*/
		
		return null;
	}
	/**
	 * @param args
	 * @author: Lion
	 */
	public static void main(String[] args) {
		String region = "中国|长沙|电信";
		String xx = formatRegion(region);
		System.out.println(xx);
	}
}

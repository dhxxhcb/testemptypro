package com.xoa.controller.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoa.model.im.ImChatList;
import com.xoa.service.im.ImDataService;
import com.xoa.service.im.wrapper.ImChatListWrappers;
import com.xoa.service.im.wrapper.ImMessageWrappers;
import com.xoa.util.ToJson;
import com.xoa.util.common.wrapper.BaseWrapper;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-24 上午11:42:27
 * @类介绍 IM信息处理类
 * @构造参数 无
 * 
 */
@RestController
@RequestMapping("/im")
public class ImDataController {
	@Autowired
	ImDataService imDataService;

	/**
	 * @作者 韩东堂
	 * @创建日期 2017-4-25 下午5:20:24
	 * @方法介绍 ip:/im/putMessage
	 * @参数说明 @param flag 接口判断
	 * @参数说明 @param from_uid 发送人UID
	 * @参数说明 @param to_uid 接收人UID
	 * @参数说明 @param of_from 发送人openfireID
	 * @参数说明 @param of_to 接收人openfireID
	 * @参数说明 @param content 发送内容
	 * @参数说明 @param type 消息类型（文本/附件/图片/语音）
	 * @参数说明 @param time Openfire端发送消息时间
	 * @参数说明 @param uuid 每条消息唯一标识
	 * @参数说明 @return
	 * @return
	 */
	@RequestMapping("/putMessage")
	public BaseWrapper putMessageInfo(Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String time, String uuid) {

		return imDataService.putMessageInfo(flag, from_uid, to_uid, of_from,
				of_to, content, type, time, uuid);
	}

	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-25 下午5:32:56
	 * @方法介绍 获取会话列表
	 * @参数说明 @param from_uid 发送人Id （这玩意感觉没必要传都）
	 * @参数说明 @return 信息集合
	 * @return
	 */
	@RequestMapping("/getImList")
	public ImChatListWrappers getImList(String from_uid) {
		return imDataService.getImChatList(from_uid);
	}

	@RequestMapping("/rollBackMessage")
	public BaseWrapper rollBackMessage(String from_id, String delete_uuid) {
		return imDataService.rollBackMessage(from_id, delete_uuid);
	}
	
	@RequestMapping("/showMessageList")
	public ImMessageWrappers showMessageList(String from_uid,String to_uid,String last_time,@RequestParam(defaultValue="0",required=false)Integer page){
		return imDataService.showMessageList(from_uid, to_uid, last_time, page);
	}
	
	

}

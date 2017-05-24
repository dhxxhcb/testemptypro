package com.xoa.controller.im;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoa.controller.im.Model.ImMessageModel;
import com.xoa.controller.im.Model.ImRoomModel;
import com.xoa.controller.im.Model.Status;
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
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午9:28:04
	 * 方法介绍:   存储一条信息
	 * 参数说明:   @param request  请求
	 * 参数说明:   @param flag 根据判断
	 * 参数说明:   @param from_uid 发送消息人员id
	 * 参数说明:   @param to_uid   接收消息人员id
	 * 参数说明:   @param of_from  发送消息openfirid者
	 * 参数说明:   @param of_to  接収信息openfirid
	 * 参数说明:   @param content 会话内容
	 * 参数说明:   @param type 消息类型 （text:文本,voice:语音,img:图片,file:附件,local:位置,withdraw:撤回,groupgeneral:群聊提醒类型）
	 * 参数说明:   @param stime 发送时间
	 * 参数说明:   @param uuid  声音的uuid
	 * 参数说明:   @param msg_type  消息类型 （1单聊，2群聊）
	 * 参数说明:   @param voice_time 插入声音    将声音时长记录在THUMBNAIL_URL中
	 * 参数说明:   @return 根据要求一个请求用到多种返回类型 用Object包装 返回多种json方式
	 * @return     Object
	 */
	@RequestMapping("/putMessage")
	@ResponseBody
	public Object putMessageInfo(HttpServletRequest request,Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String stime, String uuid,String msg_type,String voice_time) {
        System.out.println("-------putMessage----------");
       // MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Object status = imDataService.putMessageInfo(request,flag,from_uid, to_uid, of_from,of_to, content, type, stime, uuid,msg_type,voice_time);
        return status;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午9:52:36
	 * 方法介绍:   取得会话消息列表
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param of_from 当前用户的openfireid
	 * 参数说明:   @return
	 * @return     List<ImMessageModel>   
	 */
	@RequestMapping("/getImList")
	@ResponseBody
	public List<ImMessageModel> getImList(HttpServletRequest request,String of_from) {
		System.out.println("-------getImList----------");
		List<ImMessageModel> list=null;
		try {
			list=imDataService.getImChatList(request,of_from);
		} catch (FileNotFoundException e) {
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return list;
			
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return list;
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}
	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午9:53:55
	 * 方法介绍:   撤回一条信息
	 * 参数说明:   @param from_id
	 * 参数说明:   @param delete_uuid
	 * 参数说明:   @return
	 * @return     BaseWrapper
	 */
	@RequestMapping("/rollBackMessage")
	@ResponseBody
	public BaseWrapper rollBackMessage(String from_id, String delete_uuid) {
		return imDataService.rollBackMessage(from_id, delete_uuid);
	}
	/**  
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:43:04
	 * 方法介绍:   获取聊天历史记录
	 * 参数说明:   @param request
	 * 参数说明:   @param of_from
	 * 参数说明:   @param of_to
	 * 参数说明:   @param last_time
	 * 参数说明:   @return
	 * @return     List<ImMessageModel>
	 */
	
	@RequestMapping("/showMessageList")
	@ResponseBody
	public List<ImMessageModel> showMessageList(HttpServletRequest request,String of_from,String of_to,String last_time){
		System.out.println("-------showMessageList----------");
		List<ImMessageModel> list=null;
		try {
			 list=imDataService.showMessageList(request,of_from, of_to, last_time);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		return  list;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午9:55:52
	 * 方法介绍:   获取所有房间信息
	 * 参数说明:   @param of_from 当前用户的openfireid
	 * 参数说明:   @return
	 * @return     List<ImRoomModel>
	 */
	@RequestMapping("/getAllRoom")
	@ResponseBody
	public List<ImRoomModel> getAllRoom(String of_from){
		System.out.println("-------getAllRoom----------");
		return imDataService.getAllRoom(of_from);
	}
	/**  
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:30:10
	 * 方法介绍:   获取单个房间信息
	 * 参数说明:   @param room_id 房间openfireid
	 * 参数说明:   @return 
	 * @return     ImRoomModel 
	 */
	
	@RequestMapping("/getSingleRoom")
	@ResponseBody
	public ImRoomModel getSingleRoom(String room_id){
		System.out.println("-------getSingleRoom----------");
		return imDataService.getSingleRoom(room_id);
	}
	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:42:18
	 * 方法介绍:   开启或关闭成员邀请
	 * 参数说明:   @param room_id  房间openfireid
	 * 参数说明:   @param check  1:开启  0:关闭
	 * 参数说明:   @return
	 * @return     Status
	 */
	@RequestMapping("/openInvite")
	@ResponseBody
	public Status openInvite(String room_id,String check){
		System.out.println("-------openInvite----------");
		return imDataService.openInvite(room_id,check);
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:41:07
	 * 方法介绍:   创建房间
	 * 参数说明:   @param name  房间名称
	 * 参数说明:   @param set_uid   创建人uid
	 * 参数说明:   @param set_of   创建人openfireid
	 * 参数说明:   @param member_uid   房间成员uid串，用逗号分隔
	 * 参数说明:   @param stime  创建时间
	 * 参数说明:   @param room_of  房间openfireid
	 * 参数说明:   @return
	 * @return     Status  返回状态
	 */
	@RequestMapping("/insertRoom")
	@ResponseBody
	public Status insertRoom(String name,String set_uid,String set_of,String member_uid,String stime,String room_of){
		System.out.println("-------openInvite----------");
		return imDataService.insertRoom(name,set_uid,set_of,member_uid,stime,room_of);
	}
	/**
	 *
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:30:46
	 * 方法介绍:    主动退出某个群／踢人/解散某个群
	 * 参数说明:   @param room_id  房间openfireid
	 * 参数说明:   @param delete_uid  要退出／踢的人的uid
	 * 参数说明:   @param opt  1（主动退出某个群／踢人）   2（解散某个群）
	 * 参数说明:   @return
	 * @return     Status 返回状态
	 */
	@RequestMapping("/getOutPerson")
	@ResponseBody
	public Status getOutPerson(String room_id,String delete_uid,String opt){
		return imDataService.getOutPerson(room_id,delete_uid,opt);
	}
	
	/** 
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:31:02
	 * 方法介绍:   删除一条消息
	 * 参数说明:   @param deleteuuid  要删除的消息的uuid
	 * 参数说明:   @return
	 * @return     Status
	 */
	@RequestMapping("/deleteMessage")
	@ResponseBody
	public Status deleteMessage(String deleteuuid){
		return imDataService.deleteMessage(deleteuuid);
	}
	
	/** 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:32:17
	 * 方法介绍:   邀请好友加入某个群
	 * 参数说明:   @param room_id  房间openfireid
	 * 参数说明:   @param invite_uid 邀请的人uid串，用逗号分隔
	 * 参数说明:   @return
	 * @return     Status
	 */
	
	@RequestMapping("/getPersonToRoom")
	@ResponseBody
	public Status getPersonToRoom(String room_id,String invite_uid){
		return imDataService.getPersonToRoom(room_id,invite_uid);
	}
	
	/**
	 *
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-22 上午10:38:23
	 * 方法介绍:   修改房间名称
	 * 参数说明:   @param room_id
	 * 参数说明:   @param room_name
	 * 参数说明:   @return
	 * @return     Status
	 */
	 
	@RequestMapping("/updateRoomName")
	@ResponseBody
	public Status updateRoomName(String room_id,String room_name){
		return imDataService.updateRoomName(room_id,room_name);
	}

}

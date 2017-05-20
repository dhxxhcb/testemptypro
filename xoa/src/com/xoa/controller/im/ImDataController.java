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
	 * 插入一条信息
	 * @param flag
	 * @param from_uid
	 * @param to_uid
	 * @param of_from
	 * @param of_to
	 * @param content
	 * @param type
	 * @param time
	 * @param uuid
	 * @return
	 */
	@RequestMapping("/putMessage")
	@ResponseBody
	public Object putMessageInfo(HttpServletRequest request,Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String stime, String uuid,String msg_type) {
        System.out.println("-------putMessage----------");
       // MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Object bWrapper = imDataService.putMessageInfo(request,flag,from_uid, to_uid, of_from,of_to, content, type, stime, uuid,msg_type);
        return bWrapper;
	}
	
	/*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	String model = TeeStringUtil.getString(multipartRequest.getParameter("model"));
	
	List<TeeAttachmentModel> list = new ArrayList<TeeAttachmentModel>();
	List<TeeAttachment> attachs = baseUpload.manyAttachUpload(multipartRequest, model);
	
	for(TeeAttachment attach:attachs){
		TeeAttachmentModel am = new TeeAttachmentModel();
		BeanUtils.copyProperties(attach, am);
		am.setCreateTimeDesc(TeeDateUtil.format(attach.getCreateTime()));
		am.setSizeDesc(TeeFileUtility.getFileSizeDesc(attach.getSize()));
		
		//新上传的附件设置为所有权限
		am.setPriv(1|2|4|8|16|32|64|128);
		list.add(am);
	}*/
	/**
	 * 取得消息列表
	 * @param of_from
	 * @return
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
	 * 撤回一条消息
	 * @param from_id
	 * @param delete_uuid
	 * @return
	 */
	@RequestMapping("/rollBackMessage")
	@ResponseBody
	public BaseWrapper rollBackMessage(String from_id, String delete_uuid) {
		return imDataService.rollBackMessage(from_id, delete_uuid);
	}
	/**
	 * 获取聊天历史记录
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/showMessageList")
	@ResponseBody
	public List<ImMessageModel> showMessageList(HttpServletRequest request,String of_from,String of_to,String last_time){
		System.out.println("-------showMessageList----------");
		List<ImMessageModel> list=null;
		
		try {
			 list=imDataService.showMessageList(request,of_from, of_to, last_time);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
	 * 获取所有房间信息
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return  roomInfo数组
	 */
	@RequestMapping("/getAllRoom")
	@ResponseBody
	public List<ImRoomModel> getAllRoom(String of_from){
		System.out.println("-------getAllRoom----------");
		return imDataService.getAllRoom(of_from);
	}
	/**
	 * 获取单个房间信息
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/getSingleRoom")
	@ResponseBody
	public ImRoomModel getSingleRoom(String room_id){
		System.out.println("-------getSingleRoom----------");
		return imDataService.getSingleRoom(room_id);
	}
	/**
	 * 开启或关闭成员邀请
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/openInvite")
	@ResponseBody
	public Status openInvite(String room_id,String check){
		System.out.println("-------openInvite----------");
		return imDataService.openInvite(room_id,check);
	}
	/**
	 * 创建房间
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/insertRoom")
	@ResponseBody
	public Status insertRoom(String name,String set_uid,String set_of,String member_uid,String stime,String room_of){
		System.out.println("-------openInvite----------");
		return imDataService.insertRoom(name,set_uid,set_of,member_uid,stime,room_of);
	}
	/**
	 * 主动退出某个群／踢人/解散某个群
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/getOutPerson")
	@ResponseBody
	public Status getOutPerson(String room_id,String delete_uid,String opt){
		return imDataService.getOutPerson(room_id,delete_uid,opt);
	}
	
	/**
	 * 删除一条消息
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/deleteMessage")
	@ResponseBody
	public Status deleteMessage(String deleteuuid){
		return imDataService.deleteMessage(deleteuuid);
	}
	
	/**
	 * 
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/deleteRoom")
	@ResponseBody
	public Status deleteRoom(String room_id,String opt){
		return null;
	}
	
	/**
	 * 邀请好友加入某个群
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/getPersonToRoom")
	@ResponseBody
	public Status getPersonToRoom(String room_id,String invite_uid){
		return imDataService.getPersonToRoom(room_id,invite_uid);
	}
	
	/**
	 * 修改房间名称
	 * @param from_uid
	 * @param to_uid
	 * @param last_time
	 * @param page
	 * @return
	 */
	@RequestMapping("/updateRoomName")
	@ResponseBody
	public Status updateRoomName(String room_id,String room_name){
		return imDataService.updateRoomName(room_id,room_name);
	}

}

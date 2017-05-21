package com.xoa.service.im;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xoa.controller.im.Model.ImMessageModel;
import com.xoa.controller.im.Model.ImRoomModel;
import com.xoa.controller.im.Model.Status;
import com.xoa.dao.im.ImChatListMapper;
import com.xoa.dao.im.ImMessageMapper;
import com.xoa.model.im.ImChatList;
import com.xoa.model.im.ImMessage;
import com.xoa.model.im.ImMessageWithBLOBs;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.controller.im.Model.Files;
/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-24 下午3:43:10
 * @类介绍 Im数据信息服务类
 * @构造参数 无
 * 
 */
@Service
public class ImDataService {
	@Autowired
	ImMessageMapper messageDao;
	@Autowired
	ImChatListMapper chatlistDao;
	@Autowired
	ImMessageMapper ImRoomDao;

    
	@SuppressWarnings("finally")
	@Transactional(readOnly = false)
    public Object putMessageInfo(HttpServletRequest request,Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String time, String uuid,String msg_type) {
		Status s=new Status();
		 Files file1=new Files();
		try {
			String checkResult = StringUtils.checkNullUtils(
					new CheckCallBack() {
						@Override
						public boolean isNull(Object obj) {
							// TODO Auto-generated method stub
							if (obj instanceof String) {
								String a = (String) obj;
								if (a == null || "".equals(a)
										|| a.length() == 0)
									return true;
							}
							if (obj instanceof Integer) {
								Integer a = (Integer) obj;
								if (a == null)
									return true;
							}
							return false;
						}
					}, flag, "flag不能为空", from_uid, "from_uid不能为空", to_uid,
					"to_uid不能为空", of_from, "of_from不能为空", of_to, "of_to不能为空",
					 type, "type不能为空", time, "time不能为空");
			if (checkResult != null) {
				s.setStatus("error");
				return s;
			}
			ImMessageWithBLOBs record = new ImMessageWithBLOBs();
			record.setFromUid(from_uid);
			record.setType(type);
			record.setOfTo(of_to);
			record.setOfFrom(of_from);
			record.setToUid(to_uid);
			record.setUuid(uuid);
			switch (flag){
			case 1:
				record.setContent(content);
				break;
			case 3:
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				String path=request.getRealPath("");
				System.out.println(path);
				/*List<TeeAttachmentModel> list = new ArrayList<TeeAttachmentModel>();
				List<TeeAttachment> attachs = baseUpload.manyAttachUpload(multipartRequest, path);
				
				for(TeeAttachment tee:attachs){
					record.setFileId(String.valueOf(tee.getSid()));
					record.setFileName(tee.getFileName());
				
				String severpath=request.getRealPath("");
				//String from_uid, String to_uid, String of_from,String content, String of_to, String uuid, String type, String file,String time
				 //图片处理
				 if("img".equals(type)){
				 tee.getAttachmentName();
				 String ip=request.getLocalAddr();
				 String port=String.valueOf(request.getServerPort());
				 System.out.println(tee.getAttachmentPath());
				 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
				  File picture = new File(severpath+fileString);  
			       BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture));   
			       System.out.println(sourceImg.getWidth());  
			       System.out.println(sourceImg.getHeight());
			       file1.setFile_url("http://"+ip+":"+port+fileString);
			       file1.setFile_size(String.valueOf(tee.getSize()));
			       file1.setFile_width(String.valueOf(sourceImg.getWidth()));
			       file1.setFile_height(String.valueOf(sourceImg.getHeight()));
			       file1.setThumbnail_url("http://"+ip+":"+port+fileString);
			       file1.setThumbnail_size(String.valueOf(tee.getSize()/1024));
			       file1.setThumbnail_width(String.valueOf(sourceImg.getWidth()));
			       file1.setThumbnail_height(String.valueOf(sourceImg.getHeight()));
				 }
				 //text   voice     img  file
				 if("voice".equals(type)){
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
					 File voice = new File(severpath+fileString); 
					 long total = 0;  
					 AudioFileFormat aff = AudioSystem.getAudioFileFormat(voice);  
				        Map props = aff.properties();  
				        if (props.containsKey("duration")) {  
				            total = (long) Math.round((((Long) props.get("duration")).longValue()) / 1000);  
				        }  
				        System.out.println(total / 1000); 
				        file1.setFile_url("http://"+ip+":"+port+fileString);
				        file1.setVoice_time(total / 1000+"s");
					 
					  
//				        Clip clip = AudioSystem.getClip();
//				        AudioInputStream ais = AudioSystem.getAudioInputStream(voice);
//				        clip.open(ais);
//				        System.out.println( clip.getMicrosecondLength() / 1000000D + " s" );//获取音频文件时长
//				       file1.setFile_url("http://"+ip+":"+port+fileString);
//				       file1.setVoice_time(clip.getMicrosecondLength() / 1000000D + " s");
					 }
				//text file
				 if("file".equals(type)){
					 tee.getAttachmentName();
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
				       
				       file1.setFile_url("http://"+ip+":"+port+fileString);
				       file1.setFile_name(tee.getFileName());
				       file1.setFile_type(tee.getExt());
				       file1.setFile_size(String.valueOf(tee.getSize()/1024));
					 }
				   
				if("img".equals(type)){
				  }
				  }*/
			default:
				break;
			}
			record.setStime(time);
			record.setMsgType(msg_type);
			Long atime = new Date().getTime();
			record.setAtime(String.valueOf(atime));
			// TODO 处理附近信息
			// FIXME 类型不知道按什么区分现在默认文本类型
			ImChatList chatModel=null; 
			//ImChatList chatModel = chatlistDao.loadSingleObject("from ImChatList icl where  icl.fromUid=? and icl.toUid=?",new Object[]{from_uid,to_uid});
			
			//Serializable meResult = messageDao.save(record);
             if(chatModel==null){
            	 chatModel=new ImChatList();
             }
			 chatModel.setFromUid(from_uid);
			 chatModel.setToUid(to_uid);
			 chatModel.setOfFrom(of_from);
			 chatModel.setOfTo(of_to);
			 chatModel.setLastTime(time);
			 chatModel.setLastAtime(String.valueOf(atime));
			 chatModel.setLastContent(content);
			 chatModel.setType(type);
			 chatModel.setUuid(UUID.randomUUID().toString());
			Serializable chResult = 0;
			if (chatModel.getListId() == null||chatModel.getListId()==0) {
				//chResult = chatlistDao.save(chatModel);
			} else {
				//chatlistDao.update(chatModel);
			}
			s.setStatus("ok");
		} catch (Exception e) {
			e.printStackTrace();
			s.setStatus("error");
		}
		if(flag==3){
			file1.setStatus("ok");
		return file1;
		}
			return s;
	}
   
	@Transactional(readOnly = false)
    public List<ImMessageModel> getImChatList(HttpServletRequest request,String ofFrom) throws FileNotFoundException, IOException, LineUnavailableException, UnsupportedAudioFileException {
		List<Object> datas = null;
		
		List<Object> list = new ArrayList<Object>();
		list.add(ofFrom);
		//datas = chatlistDao.findByObject("from ImChatList where ofFrom=?", list);
		List<Object> icm = new ArrayList<Object>();
		List<ImMessageModel> iclmList=new ArrayList<ImMessageModel>();
		for(int i=0;i<datas.size();i++){
			ImChatList icmSingle=(ImChatList)datas.get(i);
			List<ImMessageWithBLOBs> imlist=new  ArrayList<ImMessageWithBLOBs>();
			//List<ImMessageWithBLOBs> imlist=messageDao.pageFind("from ImMessage im where ((im.fromUid=? and im.toUid=?) or (im.fromUid=? and im.toUid=?)) order by im.stime desc",0,2,new Object[]{icmSingle.getFromUid(),icmSingle.getToUid(),icmSingle.getToUid(),icmSingle.getFromUid()});
			ImMessage  im=imlist.get(0);
			ImMessageModel iclm=new ImMessageModel();
			iclm.setContent(icmSingle.getLastContent());
			iclm.setFrom_uid(icmSingle.getFromUid());
			iclm.setTo_uid(icmSingle.getToUid());
			iclm.setOf_from(icmSingle.getOfFrom());
			iclm.setOf_to(icmSingle.getOfTo());
			iclm.setTime(icmSingle.getLastTime());
			iclm.setUuid(im.getUuid());
		    iclm.setType(icmSingle.getType());
		    
		    
		  /*  String severpath=request.getRealPath("");
				//String from_uid, String to_uid, String of_from,String content, String of_to, String uuid, String type, String file,String time
				 Files file1=new Files();
				 //图片处理
				 if("img".equals(im.getType())){
				 TeeAttachment tee=loadAttachById(Integer.parseInt(im.getFileId()));
				 tee.getAttachmentName();
				 String ip=request.getLocalAddr();
				 String port=String.valueOf(request.getServerPort());
				 System.out.println(tee.getAttachmentPath());
				 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
				  File picture = new File(severpath+fileString);  
			       BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture));   
			       System.out.println(sourceImg.getWidth());  
			       System.out.println(sourceImg.getHeight());
			       file1.setFile_url("http://"+ip+":"+port+fileString);
			       file1.setFile_size(String.valueOf(tee.getSize()));
			       file1.setFile_width(String.valueOf(sourceImg.getWidth()));
			       file1.setFile_height(String.valueOf(sourceImg.getHeight()));
			       file1.setThumbnail_url("http://"+ip+":"+port+fileString);
			       file1.setThumbnail_size(String.valueOf(tee.getSize()/1024));
			       file1.setThumbnail_width(String.valueOf(sourceImg.getWidth()));
			       file1.setThumbnail_height(String.valueOf(sourceImg.getHeight()));
				 }
				 //text   voice     img  file
				 if("voice".equals(im.getType())){
					 TeeAttachment tee=loadAttachById(Integer.parseInt(im.getFileId()));
					 tee.getAttachmentName();
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
					  File voice = new File(severpath+fileString);  
				        Clip clip = AudioSystem.getClip();
				        AudioInputStream ais = AudioSystem.getAudioInputStream(voice);
				        clip.open(ais);
				        System.out.println( clip.getMicrosecondLength() / 1000000D + " s" );//获取音频文件时长
				       file1.setFile_url("http://"+ip+":"+port+fileString);
				       file1.setVoice_time(clip.getMicrosecondLength() / 1000000D + " s");
					 }
				//text file
				 if("file".equals(im.getType())){
					 TeeAttachment tee=loadAttachById(Integer.parseInt(im.getFileId()));
					 tee.getAttachmentName();
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
				       
				       file1.setFile_url("http://"+ip+":"+port+fileString);
				       file1.setFile_name(im.getFileName());
				       file1.setFile_type(tee.getExt());
				       file1.setFile_size(String.valueOf(tee.getSize()/1024));
					 }
				 iclm.setFile(file1);*/
			iclmList.add(iclm);
		}
		return iclmList;
	}
    
/*	*//**
	 * 获取 附件信息
	 * 
	 * @return
	 *//*
	@Transactional(readOnly = false)
	protected TeeAttachment loadAttachById(int sid) {
		*//**
		 * 判断获取的附件是否为null 如果为空 则返回空的 stream
		 *//*
		TeeAttachment attachment = attachmentDao.get(sid);

		if (attachment == null) {
			return new TeeAttachment();
		}
		return attachment;
	}
	*/
	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-26 下午1:58:29 
	 * @方法介绍 消息撤回
	 * @参数说明 @param from_id 谁要撤回
	 * @参数说明 @param delete_uuid 要撤回的消息
	 * @参数说明 @return
	 * @return
	 */
	@Transactional(readOnly = false)
    public BaseWrapper rollBackMessage(String from_id, String delete_uuid) {
		// 删除此消息
		BaseWrapper bw = new BaseWrapper();
		if (StringUtils.checkNull(from_id)
				|| StringUtils.checkNull(delete_uuid)) {
			bw.setFlag(false);
			bw.setStatus(false);
			bw.setMsg("缺少必要参数");
			return bw;
		}
        try {
        	ImMessage message=null;
        	//ImMessage message = messageDao.;
    		if (message == null) {
    			bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("无效的撤回信息");
    			return bw;
    		}
    		List<ImMessage> messages=null;
    		//List<ImMessage> messages = messageDao.selectByFromAndTo(from_id, message.getToUid());
    		if (messages == null || messages.size() == 0) {
    			bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("无效的撤回信息");
    			return bw;
    		}
    		// 更新最后一条记录
    		int upRe=0;
    		if (delete_uuid.equals(messages.get(0).getUuid())) {
    			// 撤回的是最后一条信息
    			// 列表更新上一条
    			ImChatList chatList = new ImChatList();
    			chatList.setFromUid(from_id);
    			chatList.setToUid(message.getToUid());
    			chatList.setOfFrom(message.getOfFrom());
    			chatList.setOfTo(message.getOfTo());
    			chatList.setLastTime(message.getStime());
    			chatList.setLastAtime(message.getAtime());
    			if (messages.size() == 2) {
    				//chatList.setLastContent(messages.get(1).getContent());
    			} else {
    				chatList.setLastContent("消息已经撤回");
    			}
    			//upRe=chatlistDao.updateByRollBack(chatList);
    		}
    		// 三分钟内可撤销
    		Long nowL = new Date(System.currentTimeMillis() - 1000 * 3 * 60)
    				.getTime();
    		String now = String.valueOf(nowL);
    		int der=0;
    		//int der = messageDao.;
    		if (der < 1) {
    			bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("撤销失败");
    			return bw;
    		}
    	    if(der<=0||upRe<=0){
    	    	bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("撤销失败");
    			throw new RuntimeException("撤销失败");
    	    }else{
    	    	bw.setFlag(true);
    			bw.setStatus(true);
    			bw.setMsg("撤销成功");
    	    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bw.setFlag(false);
			bw.setStatus(false);
			bw.setMsg("撤销失败");
			throw new RuntimeException("撤销失败"+e.getMessage());
		}
		return bw;
	}
    
	@Transactional(readOnly = false)
    public List<ImMessageModel> showMessageList(HttpServletRequest request,String from_uid,String to_uid,String last_time) throws FileNotFoundException, IOException, LineUnavailableException, UnsupportedAudioFileException{
		List<ImMessageModel> list=new ArrayList<ImMessageModel>();
		String checkResult = StringUtils.checkNullUtils(
				new CheckCallBack() {
					@Override
					public boolean isNull(Object obj) {
						// TODO Auto-generated method stub
						if (obj instanceof String) {
							String a = (String) obj;
							if (a == null || "".equals(a)
									|| a.length() == 0)
								return true;
						}
						if (obj instanceof Integer) {
							Integer a = (Integer) obj;
							if (a == null)
								return true;
						}
						return false;
					}
				},  from_uid, "from_uid不能为空", to_uid,
				"to_uid不能为空",  last_time,"last_time不能为空");
		if (checkResult != null) {
			return null;
		}
		
		List<ImMessage> datas=null;//((FROM_UID=#{fromId} AND TO_UID =#{toId}) OR (FROM_UID=#{toId} AND TO_UID =#{fromId})) AND #{lastTime} >= ATIME  ORDER BY ATIME
		//datas=messageDao.pageFind("from ImMessage im  where ((im.ofFrom=? and im.ofTo=?) or (im.ofFrom=? and im.ofTo=?))  and im.stime<? order by im.stime desc", 0,20,new Object[]{from_uid,to_uid,to_uid,from_uid,last_time});
		
	/*	String severpath=request.getRealPath("");
		for(ImMessage im:datas){
			//String from_uid, String to_uid, String of_from,String content, String of_to, String uuid, String type, String file,String time
			 Files file=new Files();
			 //图片处理
			 if("img".equals(im.getType())){
			 TeeAttachment tee=loadAttachById(Integer.parseInt(im.getFileId()));
			 tee.getAttachmentName();
			 String ip=request.getLocalAddr();
			 String port=String.valueOf(request.getServerPort());
			 System.out.println(tee.getAttachmentPath());
			 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
			  File picture = new File(severpath+fileString);  
		       BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture));   
		       System.out.println(sourceImg.getWidth());  
		       System.out.println(sourceImg.getHeight());
		       file.setFile_url("http://"+ip+":"+port+fileString);
		       file.setFile_size(String.valueOf(tee.getSize()));
		       file.setFile_width(String.valueOf(sourceImg.getWidth()));
		       file.setFile_height(String.valueOf(sourceImg.getHeight()));
		       file.setThumbnail_url("http://"+ip+":"+port+fileString);
		       file.setThumbnail_size(String.valueOf(tee.getSize()/1024));
		       file.setThumbnail_width(String.valueOf(sourceImg.getWidth()));
		       file.setThumbnail_height(String.valueOf(sourceImg.getHeight()));
			 }
			 //text   voice     img  file
			 if("voice".equals(im.getType())){
				 TeeAttachment tee=loadAttachById(Integer.parseInt(im.getFileId()));
				 tee.getAttachmentName();
				 String ip=request.getLocalAddr();
				 String port=String.valueOf(request.getServerPort());
				 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
				  File voice = new File(severpath+fileString);  
			        Clip clip = AudioSystem.getClip();
			        AudioInputStream ais = AudioSystem.getAudioInputStream(voice);
			        clip.open(ais);
			        System.out.println( clip.getMicrosecondLength() / 1000000D + " s" );//获取音频文件时长
			       file.setFile_url("http://"+ip+":"+port+fileString);
			       file.setVoice_time(clip.getMicrosecondLength() / 1000000D + " s");
				 }
			//text file
			 if("file".equals(im.getType())){
				 TeeAttachment tee=loadAttachById(Integer.parseInt(im.getFileId()));
				 tee.getAttachmentName();
				 String ip=request.getLocalAddr();
				 String port=String.valueOf(request.getServerPort());
				 String fileString="/"+"attch"+"/"+tee.getModel()+"/"+tee.getAttachmentPath()+"/"+tee.getAttachmentName();
			       
			       file.setFile_url("http://"+ip+":"+port+fileString);
			       file.setFile_name(im.getFileName());
			       file.setFile_type(tee.getExt());
			       file.setFile_size(String.valueOf(tee.getSize()/1024));
				 }
			 
			 
			ImMessageModel imm=new ImMessageModel(im.getFromUid()
					,im.getToUid()
					,im.getOfFrom()
					,im.getContent()
					,im.getOfTo()
					,im.getUuid()
					,im.getType()
					,file
					,im.getStime());
			list.add(imm);
			}
			*/
		
		return list;
	}
	
	@Transactional(readOnly = false)
    public List<ImRoomModel> getAllRoom(String of_from) {
		List<ImRoomModel> alist=new ArrayList<ImRoomModel>();
		if(of_from==null||"".equals(of_from)){
			return null;
		}
		String[] s=of_from.split("@");
		String uidString=s[0]+",";
		//List<ImRoom> list=ImRoomDao.find("from ImRoom ir where (locate(?,rmemberUid)>0 or locate(?,routUid)>0) and locate(?,roomOf)>0",uidString,uidString,s[1]);
	/*	for(ImRoom ir:list){
			String rNAME, String rOOM_OF, String rMEMBER_UID,
			String rOUT_UID, String rSET_UID, String rSET_OFID, String rTIME,
			String tYPE, String rCHANGE, String rINVITE
			ImRoomModel irm=new ImRoomModel(
					ir.getRnamr()
					,ir.getRsetOfid()
					,ir.getRmemberUid()
					,ir.getRoutUid()
					,ir.getRsetUid()
					,ir.getRsetOfid()
					,ir.getRtime()
					,ir.getRmemberUid().indexOf(uidString)<0?"1":"0"
					,ir.getRchange()
					,ir.getRinvite());
			alist.add(irm);
		}*/
		return alist;
	}
	@Transactional(readOnly = false)
    public ImRoomModel getSingleRoom(String room_id) {
		/*List<ImRoom> irm=ImRoomDao.find("from ImRoom where roomOf=?",room_id);
		ImRoom i=irm.get(0);
		ImRoomModel ir=new ImRoomModel(i.getRnamr(), i.getRoomOf(),i.getRmemberUid(),i.getRoutUid(),i.getRsetUid()
				,i.getRsetOfid(), i.getRtime(), "1", i.getRchange(), i.getRinvite());
		return ir;*/
		return null;
	}
	@Transactional(readOnly = false)
    public Status openInvite(String room_id, String check) {
		Status s=new Status();
		try {
			/*List<ImRoom> irm=ImRoomDao.find("from ImRoom where roomOf=?",room_id);
			ImRoom i=irm.get(0);
			i.setRinvite(check);
			ImRoomDao.update(i);
			s.setStatus("ok");*/
		} catch (Exception e) {
			e.printStackTrace();
			s.setStatus("error");
		}
		return s;
	}
	@Transactional(readOnly = false)
    public Status insertRoom(String name, String set_uid, String set_of,
			String member_uid, String stime, String room_of) {
		Status s=new Status();
		try {
			/*ImRoom ir=new ImRoom();
			ir.setRnamr(name);
			ir.setRsetUid(set_uid);
			ir.setRinvite("1");
			ir.setRsetOfid(set_of);
			ir.setRmemberUid(member_uid);
			ir.setRtime(stime);
			ir.setRoomOf(room_of);
			ir.setRchange("1");
			ImRoomDao.save(ir);*/
			s.setStatus("ok");
		} catch (Exception e) {
			s.setStatus("error");
		}
		return s;
	}
	@Transactional(readOnly = false)
    public Status deleteMessage(String deleteuuid) {
		Status s=new Status();
		try {
			//messageDao.deleteOrUpdateByQuery("delete from  ImMessage im where im.uuid=?",new Object[]{deleteuuid});
		} catch (Exception e) {
			s.setStatus("error");
		}
		return s;
	}
	@Transactional(readOnly = false)
    public Status getOutPerson(String room_id, String delete_uid, String opt) {
		Status s=new Status();
		
		try {
			/*List<ImRoom> irm=ImRoomDao.find("from ImRoom where roomOf=?",room_id);
			if(irm==null&&irm.size()==0){
				s.setStatus("error");
				return s;
			}
			String memberUid;
			String outUid;
			ImRoom i=irm.get(0);
			if("1".equals(opt)){//踢人
				memberUid=i.getRmemberUid().replace(delete_uid+",", "");
				outUid=(i.getRoutUid()==null?"":i.getRoutUid())+delete_uid+",";
			}else{//散群
				memberUid="";
				outUid=(i.getRoutUid()==null?"":i.getRoutUid())+(memberUid==null?"":memberUid);
			}
			i.setRmemberUid(memberUid);
			i.setRoutUid(outUid);
			ImRoomDao.update(i);
			s.setStatus("ok");*/
			return s;
		} catch (Exception e) {
			s.setStatus("error");
			return s;
		}
		
	}
	@Transactional(readOnly = false)
    public Status getPersonToRoom(String room_id, String invite_uid) {
        Status s=new Status();
		
		try {
	/*		List<ImRoom> irm=ImRoomDao.find("from ImRoom where roomOf=?",room_id);
			if(irm==null&&irm.size()==0){
				s.setStatus("error");
				return s;
			}
			ImRoom iRoom=irm.get(0);
			String newString=iRoom.getRmemberUid()+invite_uid+",";
			iRoom.setRmemberUid(newString);
			ImRoomDao.update(iRoom);
			s.setStatus("ok");
			return s;*/
		} catch (Exception e) {
			s.setStatus("error");
			return s;
		}
		return s;
	}
	@Transactional(readOnly = false)
    public Status updateRoomName(String room_id, String room_name) {
		 Status s=new Status();
			
			try {
				/*List<ImRoom> irm=ImRoomDao.find("from ImRoom where roomOf=?",room_id);
				if(irm==null&&irm.size()==0){
					s.setStatus("error");
					return s;
				}
				ImRoom iRoom=irm.get(0);
				iRoom.setRnamr(room_name);
				ImRoomDao.update(iRoom);
				s.setStatus("ok");*/
				return s;
			} catch (Exception e) {
				s.setStatus("error");
				return s;
			}
	}
	
	
}

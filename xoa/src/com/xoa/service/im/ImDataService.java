package com.xoa.service.im;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xoa.controller.im.Model.ImMessageModel;
import com.xoa.controller.im.Model.ImRoomModel;
import com.xoa.controller.im.Model.Status;
import com.xoa.dao.im.ImChatListMapper;
import com.xoa.dao.im.ImMessageMapper;
import com.xoa.dao.im.ImRoomMapper;
import com.xoa.model.enclosure.Attachment;
import com.xoa.model.im.ImChatList;
import com.xoa.model.im.ImMessage;
import com.xoa.model.im.ImRoom;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.page.PageParams;
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
	@Resource
	ImMessageMapper messageDao;
	@Resource
	ImChatListMapper chatlistDao;
	@Resource
	ImRoomMapper  roomDao;
	@Resource 
	ImEnclosureService attachService;

    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-5-23 下午4:55:08
     * 方法介绍:   存一条信息包括附件
     * 参数说明:   @param request
     * 参数说明:   @param flag
     * 参数说明:   @param from_uid
     * 参数说明:   @param to_uid
     * 参数说明:   @param of_from
     * 参数说明:   @param of_to
     * 参数说明:   @param content
     * 参数说明:   @param type
     * 参数说明:   @param time
     * 参数说明:   @param uuid
     * 参数说明:   @param msg_type
     * 参数说明:   @param voice_time
     * 参数说明:   @return
     * @return     Object
     */
	@Transactional(readOnly = false)
	public Object putMessageInfo(MultipartFile files[],HttpServletRequest request,Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String time, String uuid,String msg_type,String voice_time) {
		Status s=new Status();
		Files file1=new Files();
		//全局变量记录在一个聊天中的最后一条信息 然后保存到imchatList表中如果存在则修改
		String fileID="";
		String attachName="";
		String lastThumbnailUrl="";
		//全局变量记录在一个聊天中的最后一条信息
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
			ImMessage record = new ImMessage();
			record.setFromUid(from_uid);
			record.setType(type);
			record.setOfTo(of_to);
			record.setOfFrom(of_from);
			record.setToUid(to_uid);
			record.setUuid(uuid);
			 //text   voice     img  file
			switch (flag){
			case 1:
				 //text
				record.setContent(content);
				break;
			case 3:
//				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//				String path=request.getRealPath("");
//				MultiValueMap<String, MultipartFile> map=multipartRequest.getMultiFileMap();
//				Collection<List<MultipartFile>> MultipartFileList=map.values();
//				MultipartFile[] mf=null;
//				Iterator<List<MultipartFile>> it=MultipartFileList.iterator();
//				while(it.hasNext()){
//					List<MultipartFile> list=it.next();
//					mf=list.toArray(new MultipartFile[map.size()]);
//				}
				List<Attachment> attachs = attachService.upload(files, type,"im","xoa1001");
				
				for(Attachment tee:attachs){
					record.setFileId(String.valueOf(tee.getAid()));
					record.setFileName(tee.getYm());
					 //附件id
					 fileID=String.valueOf(tee.getAid());
                     //上传以后返回值交给ym
				     attachName=tee.getYm();
//
//				    String severpath=request.getRealPath("");
					String fileString=	tee.getUrl();
					 //图片处理
					 if("img".equals(type)){
					 String ip=request.getLocalAddr();

					 String port=String.valueOf(request.getServerPort());
//					 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
					  File picture = new File(fileString);
					  File thmpicture = new File(fileString);
					  FileInputStream fis=new FileInputStream(picture);
					  FileInputStream thmfis=new FileInputStream(thmpicture);
					  //获取图片大小
					   long size=fis.getChannel().size();
					   long thmsize=thmfis.getChannel().size();
				       BufferedImage sourceImg =ImageIO.read(fis);
				       BufferedImage thmsourceImg =ImageIO.read(thmfis);  
				       //返回值file
				       file1.setFile_url("http://"+ip+":"+port+"/xoa/xs?"+tee.getAttUrl());
				       file1.setFile_size(String.valueOf(size/1024));
				       file1.setFile_width(String.valueOf(sourceImg.getWidth()));
				       file1.setFile_height(String.valueOf(sourceImg.getHeight()));
				       file1.setThumbnail_url("http://"+ip+":"+port+"/xoa/xs?"+tee.getAttUrl());
				       file1.setThumbnail_size(String.valueOf(thmsize/1024));
				       file1.setThumbnail_width(String.valueOf(thmsourceImg.getHeight()));
				       file1.setThumbnail_height(String.valueOf(thmsourceImg.getWidth()));
				       
				       //将附件信息保存起来
				       record.setThumbnailUrl(tee.getAttUrl());
				       lastThumbnailUrl=tee.getAttUrl();				      
					 }
					 //voice   上传一条声音信息
					 if("voice".equals(type)){
						 String ip=request.getLocalAddr();
						 String port=String.valueOf(request.getServerPort());
//						 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
						 //返回值file
						 file1.setFile_url("http://"+ip+":"+port+tee.getAttachFile());
					     file1.setVoice_time(voice_time);	
					     
					     //将附件信息保存起来
					     //将声音时间长度放入ThumbnailUrl 和 lastThumbnailUrl 用于记录时长  在app端处理  在获取时长返回时长时直接获取 可减缓服务器端压力  
					     record.setThumbnailUrl(voice_time);
					     lastThumbnailUrl=voice_time;
					 }
					//file 上传一个文档信息
					 if("file".equals(type)){
						 String ip=request.getLocalAddr();
						 String port=String.valueOf(request.getServerPort());
//						 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
						   //返回值file
					       file1.setFile_url("http://"+ip+":"+port+fileString);
					       file1.setFile_name(tee.getYm());
					       file1.setFile_type(tee.getAttachName().substring(tee.getAttachName().lastIndexOf(".")+1));
					       file1.setFile_size(String.valueOf(tee.getAttachSign()));
					       
					       //将附件信息保存起来
					}
				   
				}
			default:
				break;
			}
			record.setStime(time);
			record.setMsgType(msg_type);
			Long atime = new Date().getTime();
			record.setAtime(String.valueOf(atime));
			
			ImChatList chatModel=null; 
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("fromUid", from_uid);
			map.put("toUid", to_uid);
			chatModel = chatlistDao.getSingleObject(map);
			
			int meResult = messageDao.save(record);
             if(chatModel==null){
            	 chatModel=new ImChatList();
             }
			 chatModel.setFromUid(from_uid);
			 chatModel.setToUid(to_uid);
			 chatModel.setOfFrom(of_from);
			 chatModel.setOfTo(of_to);
			 chatModel.setLastTime(time);
			 chatModel.setLastAtime(String.valueOf(atime));
			 if("text".equals(type)){
				 chatModel.setLastContent(content);
				 //如果最后一条信息为文字    上一条信息为附件 则将其他字段改为空值  在声明时已经初始化为空值
				 chatModel.setLastFileId(fileID);
				 chatModel.setLastFileName(attachName);
				 chatModel.setLastThumbnailUrl(lastThumbnailUrl);
			 }else if("img".equals(type)){
				 //反之将内容置为空值
				 chatModel.setLastContent("");
				 
				 chatModel.setLastFileId(fileID);
				 chatModel.setLastFileName(attachName);
				 chatModel.setLastThumbnailUrl(lastThumbnailUrl);
			 }else if("voice".equals(type)){
				//反之将内容置为空值
				 chatModel.setLastContent("");
				 
				 chatModel.setLastFileId(fileID);
				 chatModel.setLastFileName(attachName);
				 chatModel.setLastThumbnailUrl(lastThumbnailUrl);
			 }else if("file".equals(type)){
				//反之将内容置为空值
				 chatModel.setLastContent("");
				 
				 chatModel.setLastFileId(fileID);
				 chatModel.setLastFileName(attachName);
				 chatModel.setLastThumbnailUrl(lastThumbnailUrl);
			 }
			 chatModel.setType(type);
			 chatModel.setUuid(uuid);
			int chResult = 0;
			if (chatModel.getListId() == null) {
				chResult = chatlistDao.saveChat(chatModel);
			} else {
				chResult=chatlistDao.updateChatlist(chatModel);
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
     /**
      * 
      * 创建作者:   杨 胜
      * 创建日期:   2017-5-23 下午4:56:29
      * 方法介绍:   取得信息列表
      * 参数说明:   @param request
      * 参数说明:   @param ofFrom
      * 参数说明:   @return
      * 参数说明:   @throws FileNotFoundException
      * 参数说明:   @throws IOException
      * 参数说明:   @throws LineUnavailableException
      * 参数说明:   @throws UnsupportedAudioFileException
      * @return     List<ImMessageModel>
      */
	@Transactional(readOnly = false)
	public List<ImMessageModel> getImChatList(HttpServletRequest request,String ofFrom) throws FileNotFoundException, IOException, LineUnavailableException, UnsupportedAudioFileException {
		List<Object> datas = null;
		
		List<Object> list = new ArrayList<Object>();
		list.add(ofFrom);
		//findByObject("from ImChatList where ofFrom=?", list)
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("ofFrom",ofFrom);
		datas = chatlistDao.getChatList(map);
		List<Object> icm = new ArrayList<Object>();
		List<ImMessageModel> iclmList=new ArrayList<ImMessageModel>();
		for(int i=0;i<datas.size();i++){
			ImChatList icmSingle=(ImChatList)datas.get(i);
			List<ImMessage> imlist=new  ArrayList<ImMessage>();
			//"from ImMessage im where ((im.fromUid=? and im.toUid=?) or (im.fromUid=? and im.toUid=?)) order by im.stime desc",0,2,new Object[]{icmSingle.getFromUid(),icmSingle.getToUid(),icmSingle.getToUid(),icmSingle.getFromUid()}
			Map<String,Object> mapLastMessage=new HashMap<String,Object>();
			mapLastMessage.put("uuid", icmSingle.getUuid());
			ImMessage im=messageDao.getLastMessage(map);
		    
			ImMessageModel iclm=new ImMessageModel();
			iclm.setContent(icmSingle.getLastContent());
			iclm.setFrom_uid(icmSingle.getFromUid());
			iclm.setTo_uid(icmSingle.getToUid());
			iclm.setOf_from(icmSingle.getOfFrom());
			iclm.setOf_to(icmSingle.getOfTo());
			iclm.setTime(icmSingle.getLastTime());
			iclm.setUuid(im.getUuid());
		    iclm.setType(icmSingle.getType());
		    
		    
		    String severpath=request.getRealPath("");
				//String from_uid, String to_uid, String of_from,String content, String of_to, String uuid, String type, String file,String time
				 Files file1=new Files();
				 //图片处理
				 if("img".equals(im.getType())){
				 Attachment tee=attachService.findByAttachId(Integer.parseInt(im.getFileId()));
				 String ip=request.getLocalAddr();
				 String port=String.valueOf(request.getServerPort());
				 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
				  File picture = new File(severpath+fileString); 
				  File thmpicture = new File(severpath+tee.getAttUrl()); 
				  FileInputStream fis=new FileInputStream(picture);
				  FileInputStream thmfis=new FileInputStream(thmpicture);
				  //获取图片大小
				   long size=fis.getChannel().size();
				   long thmsize=thmfis.getChannel().size();
			       BufferedImage sourceImg =ImageIO.read(fis);
			       BufferedImage thmsourceImg =ImageIO.read(thmfis);   
			       file1.setFile_url("http://"+ip+":"+port+tee.getAttachFile());
			       file1.setFile_size(String.valueOf(size/1024));
			       file1.setFile_width(String.valueOf(sourceImg.getWidth()));
			       file1.setFile_height(String.valueOf(sourceImg.getHeight()));
			       file1.setThumbnail_url("http://"+ip+":"+port+tee.getAttUrl());
			       file1.setThumbnail_size(String.valueOf(thmsize/1024));
			       file1.setThumbnail_width(String.valueOf(thmsourceImg.getHeight()));
			       file1.setThumbnail_height(String.valueOf(thmsourceImg.getWidth()));
				 }
				 //text   voice     img  file
				 if("voice".equals(im.getType())){
					 Attachment tee=attachService.findByAttachId(Integer.parseInt(im.getFileId()));
					 
				
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
					 file1.setFile_url("http://"+ip+":"+port+fileString);
				     file1.setVoice_time(im.getThumbnailUrl());	 
				 }
				//text file
				 if("file".equals(im.getType())){
					 Attachment tee=attachService.findByAttachId(Integer.parseInt(im.getFileId()));
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
				       file1.setFile_url("http://"+ip+":"+port+fileString);
				       file1.setFile_name(im.getFileName());
				       file1.setFile_type(tee.getAttachName().substring(tee.getAttachName().lastIndexOf(".")+1));
				       file1.setFile_size(im.getThumbnailUrl());
					 }
				 iclm.setFile(file1);
			iclmList.add(iclm);
		}
		return iclmList;
	}
    

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
      /**
       * 
       * 创建作者:   杨 胜
       * 创建日期:   2017-5-23 下午4:58:17
       * 方法介绍:   取得历史消息
       * 参数说明:   @param request
       * 参数说明:   @param from_uid
       * 参数说明:   @param to_uid
       * 参数说明:   @param last_time
       * 参数说明:   @return
       * 参数说明:   @throws FileNotFoundException
       * 参数说明:   @throws IOException
       * 参数说明:   @throws LineUnavailableException
       * 参数说明:   @throws UnsupportedAudioFileException
       * @return     List<ImMessageModel>
       */
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
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fromId", from_uid);
		map.put("lastTime", last_time);
		map.put("toId",to_uid);
		 PageParams pageParams = new PageParams();  
	        pageParams.setUseFlag(true);  
	        pageParams.setPage(1);  
	        pageParams.setPageSize(20);
	     map.put("pageParams", pageParams);
		datas=messageDao.getMessageList(map);
	String severpath=request.getRealPath("");
		for(ImMessage im:datas){
			//String from_uid, String to_uid, String of_from,String content, String of_to, String uuid, String type, String file,String time
			 //图片处理
				//String from_uid, String to_uid, String of_from,String content, String of_to, String uuid, String type, String file,String time
				 Files file1=new Files();
				 //图片处理
				 if("img".equals(im.getType())){
				 Attachment tee=attachService.findByAttachId(Integer.parseInt(im.getFileId()));
				 String ip=request.getLocalAddr();
				 String port=String.valueOf(request.getServerPort());
				 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
				  File picture = new File(severpath+fileString); 
				  File thmpicture = new File(severpath+tee.getAttUrl()); 
				  FileInputStream fis=new FileInputStream(picture);
				  FileInputStream thmfis=new FileInputStream(thmpicture);
				  //获取图片大小
				   long size=fis.getChannel().size();
				   long thmsize=thmfis.getChannel().size();
			       BufferedImage sourceImg =ImageIO.read(fis);
			       BufferedImage thmsourceImg =ImageIO.read(thmfis);   
			       file1.setFile_url("http://"+ip+":"+port+tee.getAttachFile());
			       file1.setFile_size(String.valueOf(size/1024));
			       file1.setFile_width(String.valueOf(sourceImg.getWidth()));
			       file1.setFile_height(String.valueOf(sourceImg.getHeight()));
			       file1.setThumbnail_url("http://"+ip+":"+port+tee.getAttUrl());
			       file1.setThumbnail_size(String.valueOf(thmsize/1024));
			       file1.setThumbnail_width(String.valueOf(thmsourceImg.getHeight()));
			       file1.setThumbnail_height(String.valueOf(thmsourceImg.getWidth()));
				 }
				 //text   voice     img  file
				 if("voice".equals(im.getType())){
					 Attachment tee=attachService.findByAttachId(Integer.parseInt(im.getFileId()));
					 
				
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
					 file1.setFile_url("http://"+ip+":"+port+fileString);
				     file1.setVoice_time(im.getThumbnailUrl());	 
				 }
				//text file
				 if("file".equals(im.getType())){
					 Attachment tee=attachService.findByAttachId(Integer.parseInt(im.getFileId()));
					 String ip=request.getLocalAddr();
					 String port=String.valueOf(request.getServerPort());
					 String fileString="/"+"imAttach"+"/"+tee.getAttachFile().replace("\\", "/");
				       file1.setFile_url("http://"+ip+":"+port+fileString);
				       file1.setFile_name(im.getFileName());
				       file1.setFile_type(tee.getAttachName().substring(tee.getAttachName().lastIndexOf(".")+1));
				       file1.setFile_size(im.getThumbnailUrl());
					 }
			 
			ImMessageModel imm=new ImMessageModel(im.getFromUid()
					,im.getToUid()
					,im.getOfFrom()
					,im.getContent()
					,im.getOfTo()
					,im.getUuid()
					,im.getType()
					,file1
					,im.getStime());
			list.add(imm);
			}
	
		
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
		Map<String, String> map=new HashMap<String, String>();
		map.put("roomOf", s[1]);
		List<ImRoom> list=roomDao.getAllRoom(map);
		//find("from ImRoom ir where (locate(?,rmemberUid)>0 or locate(?,routUid)>0) and locate(?,roomOf)>0",uidString,uidString,s[1])
		 Iterator<ImRoom> itlist=list.iterator();
		 while(itlist.hasNext()){
			 ImRoom ir=itlist.next();
			 String[] rmemberUid=ir.getRmemberUid().split(",");
			 String[] routUid=ir.getRoutUid().split(",");
			  List<String> rmemberUidString=Arrays.asList(rmemberUid);
			  List<String> routUidString=Arrays.asList(routUid);
			  if(!rmemberUidString.contains(uidString)&&!routUidString.contains(uidString)){
				  itlist.remove();
			  }
		 }
		 
	for(ImRoom ir:list){
			/*String rNAME, String rOOM_OF, String rMEMBER_UID,
			String rOUT_UID, String rSET_UID, String rSET_OFID, String rTIME,
			String tYPE, String rCHANGE, String rINVITE*/
		    String[] rmemberUid=ir.getRmemberUid().split(",");
		    List<String> rmemberUidString=Arrays.asList(rmemberUid);
			ImRoomModel irm=new ImRoomModel(
					ir.getRnamr()
					,ir.getRsetOfid()
					,ir.getRmemberUid()
					,ir.getRoutUid()
					,ir.getRsetUid()
					,ir.getRsetOfid()
					,ir.getRtime()
					,rmemberUidString.contains(uidString)?"1":"0"
					,ir.getRchange()
					,ir.getRinvite());
			alist.add(irm);
		}
		return alist;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-23 下午4:59:46
	 * 方法介绍:   取得单个房间信息
	 * 参数说明:   @param room_id
	 * 参数说明:   @return
	 * @return     ImRoomModel
	 */
	@Transactional(readOnly = false)
	public ImRoomModel getSingleRoom(String room_id) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("roomOf", room_id);
		ImRoom irm=roomDao.getRoomByRoomOf(map);
		ImRoomModel ir=new ImRoomModel(irm.getRnamr(), irm.getRoomOf(),irm.getRmemberUid(),irm.getRoutUid(),irm.getRsetUid()
				,irm.getRsetOfid(), irm.getRtime(), "1", irm.getRchange(), irm.getRinvite());
		return ir;
	}
	@Transactional(readOnly = false)
	public Status openInvite(String room_id, String check) {
		Status s=new Status();
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("roomOf", room_id);
			map.put("check", check);
			 int i=roomDao.roomUpdateInvite(map);
			if(i==1){
			s.setStatus("ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
			s.setStatus("error");
		}
		return s;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-23 下午5:00:18
	 * 方法介绍:   创建一个房间
	 * 参数说明:   @param name
	 * 参数说明:   @param set_uid
	 * 参数说明:   @param set_of
	 * 参数说明:   @param member_uid
	 * 参数说明:   @param stime
	 * 参数说明:   @param room_of
	 * 参数说明:   @return
	 * @return     Status
	 */
	@Transactional(readOnly = false)
	public Status insertRoom(String name, String set_uid, String set_of,
			String member_uid, String stime, String room_of) {
		Status s=new Status();
		try {
			ImRoom ir=new ImRoom();
			ir.setRnamr(name);
			ir.setRsetUid(set_uid);
			ir.setRinvite("1");
			ir.setRsetOfid(set_of);
			ir.setRmemberUid(member_uid);
			ir.setRtime(stime);
			ir.setRoomOf(room_of);
			ir.setRchange("1");
			int i=roomDao.saveRoom(ir);
			if(i==1){
			s.setStatus("ok");
			}
		} catch (Exception e) {
			s.setStatus("error");
		}
		return s;
	}
	@Transactional(readOnly = false)
	public Status deleteMessage(String deleteuuid) {
		Status s=new Status();
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("uuid", deleteuuid);
			int i=messageDao.deleteByUuid(map);
			if(i==1){
			s.setStatus("ok");
			}
		} catch (Exception e) {
			s.setStatus("error");
		}
		return s;
	}
	@Transactional(readOnly = false)
	public Status getOutPerson(String room_id, String delete_uid, String opt) {
		Status s=new Status();
		
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("roomOf", room_id);
			ImRoom irm=roomDao.getRoomByRoomOf(map);
			if(irm==null){
				s.setStatus("error");
				return s;
			}
			String memberUid;
			String outUid;
			if("1".equals(opt)&&delete_uid!=null){//踢人
				memberUid=irm.getRmemberUid().replace(delete_uid+",", "");
				outUid=(irm.getRoutUid()==null?"":irm.getRoutUid())+delete_uid+",";
			}else{//散群
				memberUid="";
				outUid=(irm.getRoutUid()==null?"":irm.getRoutUid())+(irm.getRmemberUid()==null?"":irm.getRmemberUid());
			}
			irm.setRmemberUid(memberUid);
			irm.setRoutUid(outUid);
			 int i=roomDao.roomUpdateByroomOf(irm);
			if(i==1){
				s.setStatus("ok");
			}
		} catch (Exception e) {
			s.setStatus("error");
		}
		return s;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-23 下午5:01:18
	 * 方法介绍:   邀请人员进房间
	 * 参数说明:   @param room_id
	 * 参数说明:   @param invite_uid
	 * 参数说明:   @return
	 * @return     Status
	 */
	@Transactional(readOnly = false)
	public Status getPersonToRoom(String room_id, String invite_uid) {
        Status s=new Status();
		
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("roomOf", room_id);
			ImRoom irm=roomDao.getRoomByRoomOf(map);
			if(irm==null){
				s.setStatus("error");
				return s;
			}
			String newString=irm.getRmemberUid()+invite_uid+",";
			irm.setRmemberUid(newString);
			int i=roomDao.updatePersonToRoom(irm);
			s.setStatus("ok");
		} catch (Exception e) {
			s.setStatus("error");
		}
		return s;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-23 下午5:01:52
	 * 方法介绍:   修改房间名称
	 * 参数说明:   @param room_id
	 * 参数说明:   @param room_name
	 * 参数说明:   @return
	 * @return     Status
	 */
	@Transactional(readOnly = false)
	public Status updateRoomName(String room_id, String room_name) {
		 Status s=new Status();
			
			try {
				Map<String, String> map=new HashMap<String, String>();
				map.put("roomOf", room_id);
				ImRoom irm=roomDao.getRoomByRoomOf(map);
				if(irm==null){
					s.setStatus("error");
					return s;
				}
				irm.setRnamr(room_name);
				int i=roomDao.updateRoomName(irm);
				if(i==1){
				s.setStatus("ok");
				}
			} catch (Exception e) {
				s.setStatus("error");
			}
			return s;
	}
	
	
}

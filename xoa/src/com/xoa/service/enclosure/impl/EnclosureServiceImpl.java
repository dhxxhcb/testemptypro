package com.xoa.service.enclosure.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xoa.dao.enclosure.AttachmentMapper;
import com.xoa.model.enclosure.Attachment;
import com.xoa.service.enclosure.EnclosureService;
@Service
public class EnclosureServiceImpl implements EnclosureService {
	@Resource
	AttachmentMapper attachmentMapper;

	@Override
	public void saveAttachment(Attachment attachment) {
		attachmentMapper.insertSelective(attachment);

	}

	@Override
	public Attachment findByAttachId(int attachId) {
		Attachment a=attachmentMapper.findByAttachId(attachId);
		return a;
	}

	
	@Override
	public Attachment findByLast() {
		Attachment att = attachmentMapper.findByLast();
		return att;
	}

	@Override
	public Attachment upload(MultipartFile[] files,String company,String module) {
		 List<Attachment> list = new ArrayList<Attachment>();
		  //当前年月
	     String ym = new SimpleDateFormat("yyMM").format(new Date());
	     String basePath="D://upload";
	     String path=basePath+"/"+company+"/"+module+"/"+ym;
	 	 Map<String, String> fileNameMap = new HashMap<String, String>(); 
	 	Attachment attachment=new Attachment();
	 	 for (int i = 0; i < files.length; i++) {  
	        	MultipartFile file = files[i];
	        	if(!file.isEmpty()){
	            // 获得原始文件名  
	        	String fileName=file.getOriginalFilename();	
	            //String fileName = files[i].getOriginalFilename();  
	            System.out.println("原始文件名:" + fileName); 
	            //后缀名
	        	String Suffix = fileName.substring(
	        			fileName.indexOf(".") + 1);
	            //当前时间戳
	           // System.currentTimeMillis();
	    		int attachID=Math.abs((int) System.currentTimeMillis()); 
		    	 // String attachDate = new SimpleDateFormat("MMddHHmmss").format(new Date());
		    	  //int attachID=Integer.parseInt(attachDate);
		    	String newFileName=Integer.toString(attachID)+"."+fileName; 
	            if (!file.isEmpty()) {  
	            	try{
	            	  if(!new File(path, newFileName).exists()){  
	    	    		  new File(path, newFileName).mkdirs();  
                    }  
	    	        // 转存文件 
	            file.transferTo(new File(path,newFileName));
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            byte a=0;
	            byte b=2;
	          //获得模块名
		        int moduleID=com.xoa.util.ModuleEnum.EMAIL.getIndex();
	            byte mid=(byte)moduleID;
	            
	            attachment.setAttachId(attachID);
	            attachment.setModule(mid);
	            attachment.setAttachFile(fileName);
	            attachment.setAttachName(fileName);
	            attachment.setYm(ym);
	            attachment.setAttachSign(new Long(0));
	            attachment.setDelFlag(a);
	            attachment.setPosition(b);
	            list.add(attachment);
	            saveAttachment(attachment);
	            attachment=findByLast();
		
	  }
    }
	 	return attachment;
     }
	}	

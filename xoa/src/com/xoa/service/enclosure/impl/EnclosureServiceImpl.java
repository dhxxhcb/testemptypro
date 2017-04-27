package com.xoa.service.enclosure.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午6:57:35
	 * 方法介绍:   查找最后的附件信息
	 * 参数说明:   @return
	 * @return     Attachment 附件信息
	 */
	@Override
	public Attachment findByLast() {
		Attachment att = attachmentMapper.findByLast();
		return att;
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午6:56:58
	 * 方法介绍:   上传接口
	 * 参数说明:   @param files 上传文件
	 * 参数说明:   @param company 公司名
	 * 参数说明:   @param module 模块名
	 * 参数说明:   @return
	 * @return     List<Attachment>  附件信息集合
	 */
	@Override
	public List<Attachment> upload(MultipartFile[] files,String company,String module) {
		
		List<Attachment> list = new ArrayList<Attachment>();
		  //当前年月
	     String ym = new SimpleDateFormat("yyMM").format(new Date());
	     String basePath="D://upload";
	     String path=basePath+"/"+company+"/"+module+"/"+ym;	 	 
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
	            attachment=new Attachment();
	            attachment.setAttachId(attachID);
	            attachment.setModule(mid);
	            attachment.setAttachFile(fileName);
	            attachment.setAttachName(fileName);
	            attachment.setYm(ym);
	            attachment.setAttachSign(new Long(0));
	            attachment.setDelFlag(a);
	            attachment.setPosition(b);            
	            saveAttachment(attachment);
	            attachment=findByLast();
	            list.add(attachment);
	  }
    }
	 	return list;
  }
	
	
	public String attachmenturl(Attachment att,String company,String module){
		String attUrl="AID="+att.getAid()+"&"+"MODULE="+att.getModule()+"&"+"YM="+att.getYm()+"&"+"ATTACHMENT_ID="+att.getAttachId()+"&"+"ATTACHMENT_NAME="+att.getAttachName();
		String basePath="D://upload";
	    String path=basePath+"/"+company+"/"+module+"/"+att.getYm();
	    String fileName=att.getAttachName();
		String url=path+"/"+fileName;
		return attUrl;
	}
}	

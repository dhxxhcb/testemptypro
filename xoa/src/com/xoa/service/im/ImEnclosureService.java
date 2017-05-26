package com.xoa.service.im;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xoa.dao.enclosure.AttachmentMapper;
import com.xoa.model.enclosure.Attachment;
import com.xoa.service.enclosure.EnclosureService;
import com.xoa.util.GetUUID;
@Service
public class ImEnclosureService{
	@Resource
	AttachmentMapper attachmentMapper;


	public void saveAttachment(Attachment attachment) {
		attachmentMapper.insertSelective(attachment);

	}

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
	 * @throws IOException 
	 */
	public List<Attachment> upload(MultipartFile[] files,String types,String module,String company) throws IOException {
		if(files.length==0){
			return null;
		}
		ResourceBundle rb =  ResourceBundle.getBundle("upload");
		String os = System.getProperty("os.name");
		StringBuffer sb=new StringBuffer();
		if(os.toLowerCase().startsWith("win")){
			sb=sb.append(rb.getString("upload.win"));
		}else{
			sb=sb.append(rb.getString("upload.linux"));
		}
		List<Attachment> list = new ArrayList<Attachment>();
		//当前年月
		String ym = new SimpleDateFormat("yyMM").format(new Date());
		//存储路径
		String path=sb.toString()+System.getProperty("file.separator")+"attach"+System.getProperty("file.separator")+
				company+System.getProperty("file.separator") +module+ System.getProperty("file.separator") +ym;

		Attachment attachment=new Attachment();
	 	 for (int i = 0; i < files.length; i++) {
             MultipartFile file = files[i];
             if(!file.isEmpty()){
                 // 获得原始文件名
                 String fileName=file.getOriginalFilename().trim();
                 //String fileName = new String(file.getOriginalFilename().getBytes("gbk"),"utf-8");
                 int attachID=Math.abs((int) System.currentTimeMillis());
                 StringBuffer s=new StringBuffer();
                 if(os.toLowerCase().startsWith("win")){
                     s.append(fileName);
                 }else{
                     s.append(new String(fileName.getBytes(),"UTF-8"));
                 }
                 String sf=Integer.toString(attachID)+"."+s.toString();
                 String newFileName=new String(sf.getBytes(),"UTF-8");
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

                 File f=new File(path+newFileName);
                 f.renameTo(new File(newFileName));
                 byte isImg=3;
                 //获取后缀名
                 String type=fileName.substring(fileName.indexOf(".") + 1);
                 String[] imagType={"jpg","png","bmp","gif","JPG","PNG","BMP","GIF"};
                 List<String> imageTyepLists=Arrays.asList(imagType);
                 if(imageTyepLists.contains(type)){
                     isImg=0;
                 }else{
                     isImg=1;
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
                 String attUrl="AID="+attachment.getAid()+"&"+"MODULE="+module+"&"+"COMPANY="+company+"&"+"YM="+attachment.getYm()+"&"+"ATTACHMENT_ID="+attachment.getAttachId()+"&"+"ATTACHMENT_NAME="+attachment.getAttachName();
                 attachment.setAttUrl(attUrl);
                 String url=path+System.getProperty("file.separator")+newFileName;
                 attachment.setUrl(url);
                 attachment.setIsImage(isImg);
                 list.add(attachment);
             }

//	        	MultipartFile file = files[i];
//
//	    		byte[] filesize=file.getBytes();
//					if(!file.isEmpty()){
//						// 获得原始文件名
//						String fileName=file.getOriginalFilename().trim();
//						//String fileName = new String(file.getOriginalFilename().getBytes("gbk"),"utf-8");
//						int attachID=Math.abs((int) System.currentTimeMillis());
//						StringBuffer s=new StringBuffer();
//						if(os.toLowerCase().startsWith("win")){
//							s=s.append(fileName);
//						}else{
//							s=s.append(new String(fileName.getBytes(),"UTF-8"));
//						}
//						String sf=Integer.toString(attachID)+"."+s.toString();
//						String newFileName=new String(sf.getBytes(),"UTF-8");
//						if (!file.isEmpty()){
//	            	try{
//	            	  if(!new File(path, newFileName).exists()){
//	    	    		  new File(path, newFileName).mkdirs();
//                    }
//	    	        // 转存文件
//	            file.transferTo(new File(path,newFileName));
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	            File f=null;
//	            String thamPath="";
//	            String size="";
//	            f=new File(path+newFileName);
//	            if("img".equals(types)){
//	            	thamPath=GetUUID.getUuid()+newFileName.substring(newFileName.lastIndexOf("."));
//	            	File newf=new File(path+thamPath);
//	            	CompressImg.compressImg(f, newf);
//	            }
//	            f.renameTo(new File(newFileName));
//	            byte isImg=3;
//	            byte a=0;
//	            byte b=2;
//	            //获得模块名
//		        int moduleID=com.xoa.util.ModuleEnum.IM.getIndex();
//	            byte mid=(byte)moduleID;
//	            attachment=new Attachment();
//	            attachment.setAttachId(attachID);
//	            attachment.setModule(mid);
//	            if("img".equals(types)){
//	            attachment.setAttachFile(thamPath);
//	            attachment.setAttachName(file.getOriginalFilename().trim());
//	            }else{
//	            attachment.setAttachFile(path+newFileName);
//	            attachment.setAttachName(path+newFileName);
//	            }
//	            attachment.setYm("");
//	            attachment.setAttachSign((long)filesize.length/1024);
//	            attachment.setDelFlag(a);
//	            attachment.setPosition(b);
//	            saveAttachment(attachment);
//	            //attachID
//	            attachment=findByAttachId(attachID);
//	        	String attUrl="AID="+attachment.getAid()+"&"+"MODULE="+module+"&"+"COMPANY="+company+"&"+"YM="+attachment.getYm()+"&"+"ATTACHMENT_ID="+attachment.getAttachId()+"&"+"ATTACHMENT_NAME="+attachment.getAttachName();
//	            attachment.setAttUrl(attUrl);
//	            //图片格式的压缩图    将压缩图地址存入
////	            if("img".equals(types)){
////	            	attachment.setAttUrl(thamPath);
////	            }
//					String url=path+System.getProperty("file.separator")+newFileName;
//					attachment.setUrl(url);
//	            //将文件名字 放入ym属性 返回时传给表中的filename字段
//	            attachment.setYm(fileName);
//	            list.add(attachment);
//	  }
    }
	 	return list;
  }
	public String attachmenturl(Attachment att,String company,String module){
		String attUrl="AID="+att.getAid()+"&"+"MODULE="+module+"&"+"YM="+att.getYm()+"&"+"ATTACHMENT_ID="+att.getAttachId()+"&"+"ATTACHMENT_NAME="+att.getAttachName();
		return attUrl;
	}
}	

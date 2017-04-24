package com.xoa.controller.enclosure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xoa.model.enclosure.Attachment;
import com.xoa.service.enclosure.EnclosureService;

 
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 下午12:56:00
 * 类介绍  :    附件
 * 构造参数:   
 *
 */
@Controller
@Scope(value="prototype")
public class EnclosureController {
	private Logger loger = Logger.getLogger(EnclosureController.class);
	
	@Resource
	private EnclosureService enclosureService;
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午11:48:09
	 * 方法介绍:   上传
	 * 参数说明:   @param file
	 * 参数说明:   @param request
	 * 参数说明:   @param model
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/upload")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
		String module=com.xoa.util.ModuleEnum.EMAIL.getName();
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename(); 
        boolean b=enclosureService.saveUpload(path, fileName,module, file); 
        if(b==true){
        loger.info(request.getContextPath()+"/upload/"+fileName);
        }
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
        return "login/logins";  
    }  
	/*@RequestMapping(value = "/uploadbatch")  
    public String upload(HttpServletRequest request,
			HttpServletResponse response, ModelMap mmMap) {  
		
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//获得模块ID
		String module=com.xoa.util.ModuleEnum.EMAIL.getName();
		//判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
               
                //对上传文件进行处理
                if(!file.isEmpty()){  
                	String path = request.getSession().getServletContext()
        					.getRealPath("upload");
        			String fileName = file.getOriginalFilename();
        			
        			 boolean b=enclosureService.saveUpload(path, fileName,module, file); 
        		        if(b==true){
        		        loger.info(request.getContextPath()+"/upload/"+fileName);
        		        }        
                }  
            }  
              
        }
        return "login/logins";  
	}*/
	
	
	    @RequestMapping("/uploadbatch")  
	    public String threeFileUpload(  
	            @RequestParam("file") MultipartFile[] files,HttpServletRequest request) {  
	      
	        List<Attachment> list = new ArrayList<Attachment>();
	        //获得公司名
	        String company="xoa111";
	        //获得模块名
	        String module=com.xoa.util.ModuleEnum.EMAIL.getName();
	        //当前年月
	        String ym = new SimpleDateFormat("yyMM").format(new Date());
	        // 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	        String basePath = sc.getRealPath("/upload"); // 设定文件保存的目录  
	        
	    	String path=basePath+"/"+company+"/"+module+"/"+ym;	
	        //File f = new File(path);  
	       /* if (!f.exists())  
	            f.mkdirs();*/  	     	      
	        for (int i = 0; i < files.length; i++) {  
	        	MultipartFile file = files[i];
	            // 获得原始文件名  
	        	String fileName=file.getOriginalFilename();	
	            //String fileName = files[i].getOriginalFilename();  
	            System.out.println("原始文件名:" + fileName);  
	            //当前时间戳
		    	  String attachDate = new SimpleDateFormat("MMddHHmmss").format(new Date());
		    	  int attachID=Integer.parseInt(attachDate);
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
	            Attachment attachment=new Attachment();
	            attachment.setAttachId(attachID);
	            attachment.setModule(mid);
	            attachment.setAttachFile(fileName);
	            attachment.setAttachName(fileName);
	            attachment.setYm(ym);
	            attachment.setAttachSign(new Long(0));
	            attachment.setDelFlag(a);
	            attachment.setPosition(b);
	            list.add(attachment);
	            enclosureService.saveAttachment(attachment);
	            //attachmentMapper.insertSelective(attachment);
	            
	            //System.out.println("上传文件到:" + path + newFileName);  
	            //list.add(path + newFileName);  
	            
	      
	        } 

	        // 保存文件地址，用于JSP页面回显  
	        //model.addAttribute("fileList", list);  
	        return "";  
	      
	    } 
	
	
	
	
	
	/**
	 * @Title: download
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param filename
	 * @param: @param response
	 * @param: @param request
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value={"/download"},method={RequestMethod.GET})
	public String download(String filename,HttpServletResponse response,
	 HttpServletRequest request) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ filename);
				try {
					String path = Thread.currentThread().getContextClassLoader()
							.getResource("").getPath()
							+ "download";//这个download目录为啥建立在classes下的
					InputStream inputStream = new FileInputStream(new File(path
							+ File.separator + filename));

					OutputStream os = response.getOutputStream();
					byte[] b = new byte[2048];
					int length;
					while ((length = inputStream.read(b)) > 0) {
						os.write(b, 0, length);
					}

					 // 这里主要关闭。
					os.close();

					inputStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		            //  返回值要注意，要不然就出现下面这句错误！
		            //java+getOutputStream() has already been called for this response
				return null;
	}
	
	
	
	
   }
	

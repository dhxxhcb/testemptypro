package com.xoa.controller.enclosure;

import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xoa.service.enclosure.EnclosureService;

@Controller
@Scope(value="prototype")
public class EnclosureController {
	private Logger loger = Logger.getLogger(EnclosureController.class);
	
	@Resource
	private EnclosureService enclosureService;
	
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
  
	@RequestMapping(value = "/uploadbatch")  
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
    }  
	
	
	
	
}
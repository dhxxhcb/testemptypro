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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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
 * 构造参数:   无
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
	     * 创建日期:   2017年4月24日 下午8:20:58
	     * 方法介绍:   上传
	     * 参数说明:   @param files 上传的文件
	     * 参数说明:   @param request 请求
	     * 参数说明:   @return
	     * @return     String  返回页面
	     */
	  @RequestMapping("/upload")  
	    public String FileUpload(  
	            @RequestParam("file") MultipartFile[] files,HttpServletRequest request) {  
			if(files.length==0){
				return null;
			}
			ResourceBundle rb =  ResourceBundle.getBundle("upload");
			//String name = rb.getString("mysql.driverClassName");
			String os = System.getProperty("os.name");
			StringBuffer sb=new StringBuffer();
			if(os.toLowerCase().startsWith("win")){  
			  sb=sb.append(rb.getString("upload.win"));  
			}else{
			  sb=sb.append(rb.getString("upload.linux"));
			}
			
			
	        List<Attachment> list = new ArrayList<Attachment>();
	        //获得公司名
	        String company="xoa111";
	        //获得模块名
	        String module=com.xoa.util.ModuleEnum.EMAIL.getName();
	        //当前年月
	        String ym = new SimpleDateFormat("yyMM").format(new Date());
	        // 获得项目的路径  
	       // ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	       // String basePath = sc.getRealPath("/upload"); // 设定文件保存的目录  
	        String basePath="D://upload";
	    	String path=basePath+"/"+company+"/"+module+"/"+ym;	
	    	
	    	Map<String, String> fileNameMap = new HashMap<String, String>(); 
	        //File f = new File(path);  
	       /* if (!f.exists())  
	            f.mkdirs();*/  	     	      
	        for (int i = 0; i < files.length; i++) {  
	        	MultipartFile file = files[i];
	        	if(!file.isEmpty()){
	            // 获得原始文件名  
	        	String fileName=file.getOriginalFilename();	
	            //String fileName = files[i].getOriginalFilename();  
	            System.out.println("原始文件名:" + fileName);  
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
	           Attachment att=enclosureService.findByLast();
	            
	           //String attUrl="AID="+att.getAid()+"&"+"Module="+att.getModule()+"&"+"YM="+att.getYm()+"&"+"ATTACHMENT_ID="+att.getAttachId()+"&"+"ATTACHMENT_NAME="+att.getAttachName();
	           //fileNameMap.put(attUrl,fileName);
	           fileNameMap.put(path+"/"+newFileName,fileName);String attUrl="AID="+att.getAid()+"&"+"Module="+att.getModule()+"&"+"YM="+att.getYm()+"&"+"ATTACHMENT_ID="+att.getAttachId()+"&"+"ATTACHMENT_NAME="+att.getAttachName();
	           //attachmentMapper.insertSelective(attachment);	            
	            //System.out.println("上传文件到:" + path + newFileName);  
	            //list.add(path + newFileName);  
	        	}
	        } 
	        //String url=
	        // 存储要下载的文件名  
	       //Map<String, String> fileNameMap = new HashMap<String, String>();  
	        // 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中  
	        //listfile(new File(path), fileNameMap,path);// File既可以代表一个文件也可以代表一个目录  
	       // File allfile=new File(path);
	    	//File allfiles[] = allfile.listFiles();
	    	//for (File f : allfiles) {
	    	//	String realName = f.getName().substring(
			//			f.getName().indexOf(".") + 1);
			//	// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复	
	    	//	fileNameMap.put(path+"//"+f.getName(),realName);
	    //	}
	        // 将Map集合发送到listfile.jsp页面进行显示  
    
	        request.setAttribute("fileNameMap", fileNameMap); 
	        // 保存文件地址，用于JSP页面回显  
	        //model.addAttribute("fileList", list);  
	        return "app/upload/listFile";  
	      
	    } 
	
	
	    /** 
	     * 列出所有的图片 
	     */  
	    /*@RequestMapping("/listFile")  
	    public String listFile(HttpServletRequest request,  
	            HttpServletResponse response) {  
	        // 获取上传文件的目录  
	        ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	        String uploadFilePath = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
	        // 存储要下载的文件名  
	        Map<String, String> fileNameMap = new HashMap<String, String>();  
	        // 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中  
	        listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录  
	        // 将Map集合发送到listfile.jsp页面进行显示  
	        request.setAttribute("fileNameMap", fileNameMap);  
	        return "listFile";  
	    }  */
	    
		public void listfile(File file, Map<String, String> map,String path) {
			// 如果file代表的不是一个文件，而是一个目录
			if (!file.isFile()) {
				// 列出该目录下的所有文件和目录
				File files[] = file.listFiles();
				// 遍历files[]数组
				for (File f : files) {
					// 递归
					listfile(f, map,path);
				}
			} else {
				/**
				 * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的时间戳部分
				 * file.getName().indexOf
				 * (".")检索字符串中第一次出现"."字符的位置，如果文件名类似于：9349249849.afanda.avi
				 * 那么file.getName().substring(file.getName().indexOf(".")+1)
				 * 处理之后就可以得到
				 */
				String realName = file.getName().substring(
						file.getName().indexOf(".") + 1);
				// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
				
				map.put(path+"/"+realName,file.getName());
			}
		}
	
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月24日 上午10:19:22
	 * 方法介绍:   下载
	 * 参数说明:   @param filename 文件名
	 * 参数说明:   @param response 响应
	 * 参数说明:   @param request 请求
	 * 参数说明:   @return
	 * @return     String 返回是否成功
	 */
	@RequestMapping(value={"/download"},method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public String download(@RequestParam("AID") String aid ,
						@RequestParam("MODULE") String module ,
						@RequestParam("YM") String ym ,
						@RequestParam("ATTACHMENT_ID") String attachmentId ,
						@RequestParam("ATTACHMENT_NAME") String attachmenrName ,
						@RequestParam("company") String company ,
						HttpServletResponse response,
						HttpServletRequest request) {
		
		ResourceBundle rb =  ResourceBundle.getBundle("upload");
		//String name = rb.getString("mysql.driverClassName");
		String osName = System.getProperty("os.name");
		StringBuffer sb=new StringBuffer();
		if(osName.toLowerCase().startsWith("win")){  
		  sb=sb.append(rb.getString("upload.win"));  
		}else{
		  sb=sb.append(rb.getString("upload.linux"));
		}
		String basePath=sb.toString();
	
		String path=basePath+"/"+company+"/"+module+"/"+ym+"/"+attachmentId+"."+attachmenrName;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ attachmenrName);
				try {
				/*	String path = Thread.currentThread().getContextClassLoader()
							.getResource("").getPath()
							+ "download";//
*/					
					InputStream inputStream = new FileInputStream(new File(path));

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
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月24日 下午8:18:47
	 * 方法介绍:   下载
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param response 相应
	 * @return     void 无
	 */
	@RequestMapping(value={"/downFile"} ,method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public void downFile(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("1");
		// 得到要下载的文件名
		String fileName = request.getParameter("fileName");
		
		//String company="xoa111";
		
		//String Module="email";
		
		//String YM=request.getParameter("YM");
		
		//String AttachmentId= request.getParameter("ATTACHMENT_ID");
		
		//String AttachmentName =request.getParameter("ATTACHMENT_NAME");
		
		//String path="D://"+"upload"+company+"/"+Module+"/"+YM;
		
	//	String fName=AttachmentId+"."+AttachmentName;
		
		System.out.println("2");
		try {
			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
			System.out.println("3");
			// 获取上传文件的目录
			//ServletContext sc = request.getSession().getServletContext();
			System.out.println("4");
			// 上传位置
			//String fileSaveRootPath = sc.getRealPath("/img"); 
			
			//System.out.println(fileSaveRootPath + "//" + fileName);
			// 得到要下载的文件
			//File file = new File(fileSaveRootPath + "\\" + fileName);
			
			String bath = fileName.substring(fileName.indexOf("//") + 1);
			File file = new File(fileName);

			// 如果文件不存在
			if (!file.exists()) {
				request.setAttribute("message", "您要下载的资源已被删除！！");
				System.out.println("您要下载的资源已被删除！！");
				return;
			}
			// 清空response
			response.reset();
			// 处理文件名
			String realname = fileName.substring(fileName.indexOf(".") + 1);
			  
			// 设置响应头，控制浏览器下载该文件
			response.setCharacterEncoding("UTF-8");
			response.setContentType("multipart/form-data");  
			// 设置响应头，控制浏览器下载该文件
			response.setHeader("content-disposition", "attachment;filename="
								+new String(realname.getBytes("UTF-8"), "ISO8859-1"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(fileName);			
			// 创建输出流	
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			//创建带有自动行刷新的PW
			//PrintWriter pw = new PrintWriter(out,true);
			//pw.wait();
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();
		} catch (Exception e) {

		}
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月24日 下午6:18:16
	 * 方法介绍:   上传测试入口
	 * 参数说明:   @return
	 * @return     String 返回上传页面
	 */
	@RequestMapping("/up") 
	public String cont() {
		return "app/upload/updwj";
	}
	
	
	
	
   }
	

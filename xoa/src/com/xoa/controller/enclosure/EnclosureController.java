package com.xoa.controller.enclosure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xoa.model.enclosure.Attachment;
import com.xoa.service.enclosure.EnclosureService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

 
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 下午12:56:00
 * 类介绍  :    附件
 * 构造参数:   无
 *
 */
@Controller
@Scope(value = "prototype")
@SuppressWarnings("all")
public class EnclosureController {
	private Logger loger = Logger.getLogger(EnclosureController.class);
	
	@Resource
	private EnclosureService enclosureService;

	   
	  /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月2日 上午11:12:17
	 * 方法介绍:   附件上传
	 * 参数说明:   @param files 文件
	 * 参数说明:   @param module 模块名
	 * 参数说明:   @param isAttach 是否直接显示上传路径
	 * 参数说明:   @param request 请求
	 * 参数说明:   @return
	 * @return     ToJson<Attachment> 返回附件信息
	 */
	@RequestMapping(value ="/upload",produces = {"application/json;charset=UTF-8"}) 
	public @ResponseBody ToJson<Attachment> upload( @RequestParam("file") MultipartFile[] files,String module,
			  HttpServletRequest request) {	
//		L.w("0=||==============》"+request.getSession().getId());
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		String pd=(String) request.getSession().getAttribute(
				"loginDateSouse");
		StringBuffer sb=new StringBuffer();
			if(pd==null){
			sb.append("xoa1001");
			}else{
			sb.append("xoa"+pd.toString());
			}
			String company=sb.toString();
			ToJson<Attachment> json=new ToJson<Attachment>(0, null);
			try {	
				List<Attachment> list=enclosureService.upload(files, company, module);  
				json.setObj(list);
	            json.setMsg("OK");
	            json.setFlag(0);
	            System.out.println(json.toString());
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
	        return json;
	    }

	
	  /**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月23日 上午11:12:17
		 * 方法介绍:   附件上传适配手机端
		 * 参数说明:   @param files 文件
		 * 参数说明:   @param module 模块名
		 * 参数说明:   @param isAttach 是否直接显示上传路径
		 * 参数说明:   @param request 请求
		 * 参数说明:   @return
		 * @return     ToJson<Attachment> 返回附件信息
		 */
		@RequestMapping(value ="/uploadApp",produces = {"application/json;charset=UTF-8"}) 
		public @ResponseBody ToJson<Attachment> uploadApp( @RequestParam("file") MultipartFile[] files,String module,
				String company,  
				HttpServletRequest request) {	
//			L.w("0=||==============》"+request.getSession().getId());
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
				ToJson<Attachment> json=new ToJson<Attachment>(0, null);
				try {	
					List<Attachment> list=enclosureService.upload(files, company, module);  
					json.setObj(list);
		            json.setMsg("OK");
		            json.setFlag(0);
		            System.out.println(json.toString());
				} catch (Exception e) {
					json.setMsg(e.getMessage());
				}
		        return json;
		    }

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
	 * 创建日期:   2017年4月30日 上午9:52:41
	 * 方法介绍:   下载
	 * 参数说明:   @param aid 附件信息主键
	 * 参数说明:   @param module 模块名
	 * 参数说明:   @param ym 年月
	 * 参数说明:   @param attachmentId 附件id
	 * 参数说明:   @param attachmenrName 附件名字
	 * 参数说明:   @param company 公司
	 * 参数说明:   @param response 响应
	 * 参数说明:   @param request 请求
	 * 参数说明:   @return
	 * @return     String 返回
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value={"/download"},method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public String download(@RequestParam("AID") String aid ,
						@RequestParam("MODULE") String module ,
						@RequestParam("YM") String ym ,
						@RequestParam("ATTACHMENT_ID") String attachmentId ,
						@RequestParam("ATTACHMENT_NAME") String attachmentName ,
						@RequestParam("COMPANY") String company ,
						HttpServletResponse response,
						HttpServletRequest request) throws UnsupportedEncodingException {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		//读取配置文件
		ResourceBundle rb =  ResourceBundle.getBundle("upload");
		//String name = rb.getString("mysql.driverClassName");
		String osName = System.getProperty("os.name");
		StringBuffer sb=new StringBuffer();
		if(osName.toLowerCase().startsWith("win")){  
		  sb=sb.append(rb.getString("upload.win"));  
		}else{
		  sb=sb.append(rb.getString("upload.linux"));
		}
		//String basePath="D:"+System.getProperty("file.separator");
	  	
		 String path=sb.toString()+System.getProperty("file.separator")+"attach"+System.getProperty("file.separator")+company+
	    		 System.getProperty("file.separator") +module+ System.getProperty("file.separator") +ym+ System.getProperty("file.separator")+attachmentId+"."+attachmentName;	 	  	 
		System.out.println(path.toString());
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		 byte[] bytes = attachmentName.getBytes("UTF-8"); 
		 attachmentName = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码
		    response.setHeader("Content-disposition",
		            String.format("attachment; filename=\"%s\"", attachmentName));
	
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
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
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
	 * 创建日期:   2017年4月30日 上午9:52:22
	 * 方法介绍:   删除
	 * 参数说明:   @param aid 附件主键
	 * 参数说明:   @param module 模块
	 * 参数说明:   @param ym 年月
 	 * 参数说明:   @param attachmentId 附件id
	 * 参数说明:   @param attachmenrName 附件名字
	 * 参数说明:   @param company 公司
	 * 参数说明:   @param response 响应
	 * 参数说明:   @param request 请求
	 * 参数说明:   @return 
	 * @return     boolean 是否成功
	 */
	@RequestMapping(value={"/delete"} ,method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public boolean delete(@RequestParam("AID") String aid ,
			@RequestParam("MODULE") String module ,
			@RequestParam("YM") String ym ,
			@RequestParam("ATTACHMENT_ID") String attachmentId ,
			@RequestParam("ATTACHMENT_NAME") String attachmentName ,
			@RequestParam("COMPANY") String company ,
			HttpServletResponse response,
			HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ResourceBundle rb =  ResourceBundle.getBundle("upload");
		//String name = rb.getString("mysql.driverClassName");
		String osName = System.getProperty("os.name");
		StringBuffer sb=new StringBuffer();
		if(osName.toLowerCase().startsWith("win")){  
		  sb=sb.append(rb.getString("upload.win"));  
		}else{
		  sb=sb.append(rb.getString("upload.linux"));
		}
		//String basePath="D:"+System.getProperty("file.separator");
	  	
		 String path=sb.toString()+System.getProperty("file.separator")+"attach"+System.getProperty("file.separator")+company+
	    		 System.getProperty("file.separator") +module+ System.getProperty("file.separator") +ym+ System.getProperty("file.separator")+attachmentId+"."+attachmentName;	 	  	 
		boolean flag = false;
		File file =new File(path);
		if (file.exists()) {// 路径为文件且不为空则进行删除
			file.delete();// 文件删除	
			flag=true;
		}
		return flag;
	
	
	}
	
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月24日 下午6:18:16
	 * 方法介绍:   上传测试入口
	 * 参数说明:   @return
	 * @return     String 返回上传页面
	 */
	@RequestMapping("/up") 
	public String cont(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/upload/updwj";
	}
	
    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    @RequestMapping(value={"/xs"},method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    public void loadImage(@RequestParam("AID") String aid ,
			@RequestParam("MODULE") String module ,
			@RequestParam("YM") String ym ,
			@RequestParam("ATTACHMENT_ID") String attachmentId ,
			@RequestParam("ATTACHMENT_NAME") String attachmentName ,
			@RequestParam("COMPANY") String company ,
			HttpServletResponse response,
			HttpServletRequest request) throws Exception { 
    	
    	ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
	ResourceBundle rb =  ResourceBundle.getBundle("upload");
	String osName = System.getProperty("os.name");
	StringBuffer sb=new StringBuffer();
	if(osName.toLowerCase().startsWith("win")){  
	  sb=sb.append(rb.getString("upload.win"));  
	}else{
	  sb=sb.append(rb.getString("upload.linux"));
	}
	//String basePath="D:"+System.getProperty("file.separator");
    String path=sb.toString()+System.getProperty("file.separator")+"attach"+System.getProperty("file.separator")+company+
   		 System.getProperty("file.separator") +module+ System.getProperty("file.separator") +ym+ System.getProperty("file.separator")+attachmentId+"."+attachmentName;	 	  	 
    	
    try {
			
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
    	
     
    }  
    

	
	
   }
	

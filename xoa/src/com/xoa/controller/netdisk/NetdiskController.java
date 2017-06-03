package com.xoa.controller.netdisk;

import com.xoa.model.netdisk.Catalog;
import com.xoa.model.netdisk.MyNetdisk;
import com.xoa.model.netdisk.Netdisk;
import com.xoa.model.users.Users;
import com.xoa.service.netdisk.NetdiskService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.netdisk.*;
import org.apache.http.HttpRequest;
import org.apache.poi.util.SystemOutLogger;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by gsb on 2017/6/1.
 */

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/netdisk")
public class NetdiskController {
    @Resource
    private NetdiskService netdiskService;

    /**
     * 查找目录文件
     * @param request
     * @param path
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/selectNetdisk",produces = {"application/json;charset=UTF-8"})
    public  ToJson<Catalog> selectNetdisk(HttpServletRequest request,String path) throws Exception {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Users users = SessionUtils.getSessionInfo(request.getSession(), Users.class,new Users());
        Map<String,Object> map=new Hashtable<String, Object>();
        ToJson<Catalog> toJson = new ToJson<Catalog>();
        map.put("userId", users.getUid());
        map.put("userPriv", users.getUserPriv());
        map.put("deptId", users.getDeptId());
        Catalog  catalog=null;
        List<Netdisk>  neList= netdiskService.selectNetdisk();
        for (Netdisk netdisk:neList){
            if (CheckAll.checkAll(netdisk.getUserId(),map)){
                if (!StringUtils.checkNull(path)){
                    catalog=ReadFile.getFiles(path);
                }
            }else {
                toJson.setFlag(1);
                toJson.setMsg("err");

            }
        }



        if (catalog!=null){
            toJson.setFlag(0);
            toJson.setMsg("ok");
            toJson.setObject(catalog);
        }




        return toJson;
    }

    /**
     * 新增文件目录
     * @param request
     * @param path
     * @param directoryName
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/mkDirectory",produces = {"application/json;charset=UTF-8"})
    public ToJson<String> mkDirectory(HttpServletRequest request,String path,String directoryName ){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        String mkDirectoryPath =path+"/"+directoryName;

        ToJson<String> json=new ToJson<String>();
        if (ReadFile.mkDirectory(mkDirectoryPath)) {
            json.setFlag(0);
            json.setMsg("ok");

        }
        else{
            json.setFlag(1);
            json.setMsg("err");

        }

        return  json;
    }

    /**
     * 修改文件夹和文件名字
     * @param request
     * @param path
     * @param newsName
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/changeName ",produces = {"application/json;charset=UTF-8"})
    public String  changeName(HttpServletRequest request,String path,String newsName ){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        File   file=new   File(path);   //指定文件名及路径
        String name=newsName;
        String   filename=file.getAbsolutePath();
        String  filename1 = null;
        String prefix=filename.substring(filename.lastIndexOf(".")+1,filename.length());
        if(filename.indexOf(".")>=0)
        {
            filename   =   filename.substring(0,filename.lastIndexOf("."));
            filename1= filename.substring(0,filename.lastIndexOf("\\"));
            File newfile=new File(filename1+"/"+name+prefix);
           file.renameTo(newfile);   //改名

        }else {
            filename1= filename.substring(0,filename.lastIndexOf("\\"));
            File newfile=new File(filename1+"/"+name);
            file.renameTo(newfile);
        }
        return  null;
    }

    /**
     * 上传
     * @param request
     * @param response
     * @param path
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value="/uploadFile",method={RequestMethod.POST},produces = {"application/json;charset=UTF-8"})
    public ToJson<String>  uploadFile(HttpServletRequest request, HttpServletResponse response,String path) throws IOException {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        ToJson<String>  json=new ToJson<String>();
    //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
        	 List<MultipartFile> files =multiRequest.getFiles("file");
        	 for (MultipartFile multipartFile : files) {
				if (multipartFile!=null) {
					 //取得当前上传文件的文件名称
					String myFileName=multipartFile.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (!StringUtils.checkNull(myFileName)) {
						String fileName =  multipartFile.getOriginalFilename();
						 String path1 = path +"/"+ fileName;
	                        System.out.println(path1);
	                        File localFile = new File(path1);
	                        multipartFile.transferTo(localFile);
	                        json.setFlag(0);
	                        json.setMsg("ok");
	                    }else {
	                        json.setFlag(1);
	                        json.setMsg("err");
	                    }

				}
			}

         // Iterator<String> iter = multiRequest.getFileNames();
         /*   while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件

                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName =  file.getOriginalFilename();
                        //定义上传路径
                        String path1 = path +"/"+ fileName;
                        System.out.println(path1);
                        File localFile = new File(path1);
                        file.transferTo(localFile);
                        json.setFlag(0);
                        json.setMsg("ok");
                    }else {
                        json.setFlag(1);
                        json.setMsg("err");
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }*/

        }


        return  json;
    }

    /**
     * 下载
     * @param fileName
     * @param request
     * @param response
     * @param path
     * @return
     */
    @RequestMapping(value="/download",method={RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    public String download(String fileName, HttpServletRequest request,
                           HttpServletResponse response,String path) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        try {

            InputStream inputStream = new FileInputStream(new File(path
                    + File.separator + fileName));

            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException
                e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

    /**
     * 复制文件
     * @param path
     * @return
     */
    @RequestMapping(value="/copyFile",produces = {"application/json;charset=UTF-8"})
    public  ToJson<String>  copyFiles(String path){
        ToJson<String>  json=new ToJson<String>();
           if (!StringUtils.checkNull(path)){
               String  read= CopyFile.readByBufferedReader(path);
               json.setFlag(0);
               json.setMsg("ok");
               json.setObject(read);
           }else {
               json.setFlag(1);
               json.setMsg("err");

           }

        return json;
    }

    /**
     * 写文件
     * @param content
     * @param path
     * @return
     */
    @RequestMapping(value="/writeFile",produces = {"application/json;charset=UTF-8"})
   public ToJson<String>  writeFile(String content,String path ){
        ToJson<String>  json=new ToJson<String>();
         if(!StringUtils.checkNull(path)){
             File file =new File(path);
             CopyFile.writeFile(content,file);
             json.setFlag(0);
             json.setMsg("ok");
         }else {
             json.setFlag(1);
             json.setMsg("err");
         }


        return  json;
    }

    /**
     * 文件内容搜索
     * @param content
     * @param path
     * @return
     */
    @RequestMapping(value="/globalFile",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ToJson<String>  globalFile(String content,String path ){
        ToJson<String>  json=new ToJson<String>();
        if(!StringUtils.checkNull(path)){
            String filename = path;
            //创建一个 File 实例，表示路径名是指定路径参数的文件
            File file = new File(filename);
            String[]    args=new String[]{content};//
            for (int i = 0; i < args.length; i++) {
                GlobalSearch.findFile(file, args[i]);

                for (String string : GlobalSearch.path) {
                    System.out.println(string
                    );

                }
            }
            json.setFlag(0);
            json.setMsg("ok");
            json.setObj(GlobalSearch.path);
        }else {
            json.setFlag(1);
            json.setMsg("err");
        }


        return  json;
    }
    /**
     * 文件内容搜索
     * @param content
     * @param path
     * @return
     */
    @RequestMapping(value="/searchFile",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ToJson<String>  searchFile(String content,String path ) {
        ToJson<String> json = new ToJson<String>();
        if (!StringUtils.checkNull(path)) {
            path = path.replaceAll("\\\\", "\\\\\\\\");
          String fileName = content;
            List<String> destpath = SearchFile.searchFile(path, fileName);
            if (destpath != null && destpath.size() > 0) {
                System.out.println("你要找的文件的目录如下：");
                for (String s : destpath) {
                    System.out.println(s);
                }
                json.setFlag(0);
                json.setMsg("ok");
                json.setObj(destpath);
            } else {
                System.out.println("没有找到或您输入有误");

                json.setFlag(1);
                json.setMsg("err");

            }



        }
        return json;
    }
    @RequestMapping(value="/deleteFile",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  ToJson<String>  deleteFile(String path,String filename){
        ToJson<String> json = new ToJson<String>();
        File file=new File(path+"/"+filename);
        if(file.exists()&&file.isFile()){
            file.delete();
            json.setMsg("ok");
            json.setFlag(0);
        }else {
            json.setMsg("err");
            json.setFlag(1);

        }
        return  json;
    }

    @RequestMapping(value="/deleteFolder",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  ToJson<String>  deleteFolder(String path){
        ToJson<String> json = new ToJson<String>();
  if(!StringUtils.checkNull(path)){
            DeleteFile.refreshFileList(path);
            json.setMsg("ok");
            json.setFlag(0);
        }else {
            json.setMsg("err");
            json.setFlag(1);

        }
        return  json;
    }





























    @RequestMapping("/up1")
    public String cont(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/upload/updwj1";
    }




}

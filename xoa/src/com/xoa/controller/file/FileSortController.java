package com.xoa.controller.file;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xoa.model.enclosure.Attachment;
import com.xoa.model.file.File_Content;
import com.xoa.model.file.File_Sort;
import com.xoa.service.enclosure.EnclosureService;
import com.xoa.service.file.File_ContentService;
import com.xoa.service.file.File_SortService;
import com.xoa.util.ToJson;
import com.xoa.util.treeUtil.FileSortTreeUtil;
import com.xoa.util.treeUtil.HtmlUtil;
import com.xoa.util.treeUtil.TreeNode;


@Controller
public class FileSortController {
	private Logger loger = Logger.getLogger(FileSortController.class);
	
    @Resource
	File_SortService file_SortService;
    @Resource
    File_ContentService file_ContentService;
    @Resource
    EnclosureService enclosureService;
    
    /**
	 *文件柜跳转页面
	 * @author 杨  胜
	 * @return 
	 */
	@RequestMapping(value="/fileHome")
	public String fileHome() {
		loger.info("--------fileHome-------");
		return "app/file/fileHome";
	}
    
	 /**
		 *文件柜跳转页面
		 * @author 杨  胜
		 * @return 
		 */
		@RequestMapping(value="/topFrame")
		public String topFrame() {
			loger.info("--------topFrame-------");
			return "app/file/fileTop";
		}
	
    /**
     *将目录树转换成json数据通过HtmlUtil.writerJson(response, treeList)写到前台页面
     *@author 杨  胜
     * @param file
     * @param response
     */
	@RequestMapping(value="/showFile")
	@ResponseBody
	public void showFile(File_Sort file,HttpServletResponse response) {
		loger.info("--------showFile-------");
		List<TreeNode> treeList=treeMenu(file.getSort_id());
		HtmlUtil.writerJson(response, treeList);
	}
	/**
	 *目录树跳转页面
	 * @author 杨  胜
	 * @return 
	 */
	@RequestMapping(value="/fileIndex")
	public String fileIndex() {
		loger.info("--------fileIndex-------");
		return "app/file/showFile";
	}
	/**
	 * 进入文件柜主页面
	 * @author 杨  胜
	 * @return
	 */
	@RequestMapping(value="/fileHomeOne")
	public String fileHomeOne() {
		loger.info("--------fileHomeOne-------");
		return "app/file/fileHomeOne";
	}
	/**
	 * 构建树形目录信息
	 * @author 杨  胜
	 * @param sortid 传入父节点获取
	 * @return
	 */
	public List<TreeNode> treeMenu(int sortid) {
		List<File_Sort> rootTree = file_SortService.getRootTree(sortid);// 根节点
		List<File_Sort> childTree=null;
		//取子节点
		childTree= file_SortService.getChildTree(sortid);// 子节点
		//构造方法传值
		FileSortTreeUtil util = new FileSortTreeUtil(rootTree, childTree);
		return util.getTreeNode();
	}
	/**
	 * 输出到页面File_Sort集合输出跳转并展示到页面
	 * @author 杨  胜
	 * @param file 
	 * @return ("app/file/showFile",model)
	 */
	@RequestMapping("/showFiles")
	public ModelAndView showFiles(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		List<File_Sort> list=file_SortService.getFile_Sorts(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("json", list);
		ModelAndView modelAndView=new ModelAndView("app/file/showFile",model);
		return modelAndView;
	}
	/**
	 * 获取根文件夹
	 * @author 杨  胜
	 * @param file
	 * @return ("app/file/fileSet",model)
	 */
	@RequestMapping("/showFileBySort_id")
	public ModelAndView showFileBySort_id(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		System.out.println("parent:"+file.getSort_parent());
		List<File_Sort> list=file_SortService.getFile_Sorts(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("parentList", list);
		ModelAndView modelAndView=new ModelAndView("app/file/fileSet",model);
		return modelAndView;
	}
	/**
	 * 添加文件夹，通过判断字段，重复使用
	 * @param file 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/fileAdd")
	public ModelAndView fileAdd(File_Sort file) throws UnsupportedEncodingException{
		//"redirect:/showFile"   "file/showFile"
		Map<String, Object> model =null;
		ModelAndView modelAndView=null;
		if(file.getSort_no()==null||file.getSort_no().equals("")){
			model = new HashMap<String, Object>();
			modelAndView=new ModelAndView("app/file/addFile",model);
			return modelAndView;
		}
		System.out.println("--前--------------"+file.getSort_name());
			String sname=new String(file.getSort_name().getBytes("ISO-8859-1"),"utf-8");
		System.out.println("--中--------------"+sname);
			file.setSort_name(sname);
		System.out.println("--后--------------"+file.getSort_name());
		int resultAdd=file_SortService.addFile_Sorts(file);
		System.out.println("添加文件影响行--------"+resultAdd);
		modelAndView=new ModelAndView("redirect:/showFiles",model);
		return modelAndView;
	}
	/**
	 * 文件夹克隆
	 * @param file
	 * @return
	 */
	@RequestMapping("/fileClone")
	public ModelAndView fileClone(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView=null;
		modelAndView=new ModelAndView("app/file/",model);
		
		return modelAndView;
	}
	/**
	 * 编辑文件夹信息传值跳转
	 * @param file
	 * @return
	 */
	@RequestMapping("/fileEdit")
	public ModelAndView fileEdit(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		Map<String, Object> fileEdit = new HashMap<String, Object>();
		List<File_Sort> fileslist=file_SortService.getFile_Sorts(file);
		File_Sort files=fileslist.get(0);
		fileEdit.put("sortid", files.getSort_id());
		fileEdit.put("sortno", files.getSort_no());
		fileEdit.put("sortname", files.getSort_name());
		ModelAndView modelAndView=new ModelAndView("app/file/fileEdit",fileEdit);
		return modelAndView;
	}
	/**
	 * 修改文件夹信息
	 * @param file
	 * @return
	 */
	@RequestMapping("/fileUpdate")
	public ModelAndView  fileUpdate(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		int resultUpdate=file_SortService.updateFile(file);
		System.out.println("修改文件影响行--------"+resultUpdate);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("app/file/fileEdit");
		return modelAndView;
	}
	
	/**
	 * 删除目录
	 * @author 杨  胜
	 * @param file
	 * @return modelAndView
	 */
	@RequestMapping("/fileDelete")
	public ModelAndView fileDelete(HttpServletRequest request,File_Sort file){
		
		//所有删除文件夹
		List<File_Sort> childrenList=getfilesDelete(file);
		//将父节点加入，父节点下可能也有文件
		childrenList.add(file);
		//文件集合
		List<File_Content> fileContentList=new ArrayList<File_Content>();
		//
	   for(File_Sort f : childrenList){
		  int tempNo=f.getSort_id();
		  List<File_Content>  fileContent=file_ContentService.getFileConBySortid(tempNo);
		  fileContentList.addAll(fileContent);
		  int deleConNo=file_ContentService.fileContentDeleBySort_id(tempNo);
		  System.out.println("删除文件影响行----deleConNo----"+deleConNo);
		}
	   //删除附件  
		//boolean flag=deleteAttachment(fileContentList,request);
		//删除父节点，子节点
		for(File_Sort f:childrenList){
		Map<String, Object> fileSortidMap=new HashMap<String, Object>();
		fileSortidMap.put("sortid", f.getSort_id());
		int deleSortNo=file_SortService.fileDeleteBySort_id(fileSortidMap);
		    System.out.println("删除文件影响行----deleSortNo----"+deleSortNo);
		}
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView=new ModelAndView("redirect:/showFileBySort_id",model);
		return modelAndView;
	}
	/**
	 * @author 杨  胜
	 * @category 递归循环获取文件夹对象
	 * @param file
	 * @return parentList
	 */
	public List<File_Sort> getfilesDelete(File_Sort file){
	    //传值查询子节点数据
		List<File_Sort> parentList=new ArrayList<File_Sort>();
	   int tempNo=file.getSort_id();
	   List<File_Sort> childrenList=new ArrayList<File_Sort>();
	   childrenList=file_SortService.getSortChrildren(tempNo);
	   //将父节点数据加入
	    if(childrenList.size()>0){
	    for(File_Sort fs:childrenList){
	    	parentList.addAll(getfilesDelete(fs));
	      }
	      parentList.addAll(childrenList);
	    }
		return parentList;
	}
	/**
	 *删除附件
	 * @author 杨  胜
	 * @param fileContentList
	 * @return
	 */
	private boolean deleteAttachment(List<File_Content> fileContentList,HttpServletRequest request) {
		List<Attachment> attachmentList=new ArrayList<Attachment>();
		//遍历处理附件字段进行查询附件操作
		for(File_Content fc:fileContentList){
			String[] Att_idArray=fc.getAttachment_id().split(",");
			for(int i=0;i<Att_idArray.length;i++){
				String[] Att_idArrayAid=Att_idArray[i].split("@");
				Attachment att=new Attachment();
				att.setAid(Integer.parseInt(Att_idArrayAid[0]));
				String[] ymAndAttachId=Att_idArrayAid[1].split("_");
				att.setYm(ymAndAttachId[0]);
				att.setAttachId(Integer.parseInt(ymAndAttachId[1]));
				attachmentList.add(att);
			}
		}
		for(Attachment at:attachmentList){
			//定义"条件map集合"确定一条删除的记录
			Map<String,Object> atMap=new HashMap<String, Object>();
			atMap.put("aidString", at.getAid());
			atMap.put("ymString", at.getYm());
			atMap.put("attachIdString", at.getAttachId());
            //删除的记录attachment
			//Attachment attachment=enclosureService.getByatMap(atMap);
			String path=request.getSession().getServletContext().getRealPath("/");
		} 
		return false;
	}
}

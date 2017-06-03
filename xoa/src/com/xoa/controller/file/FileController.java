package com.xoa.controller.file;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;

import com.alibaba.fastjson.JSONArray;
import com.xoa.util.common.L;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.apache.log4j.Logger;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xoa.model.diary.DiaryModel;
import com.xoa.model.enclosure.Attachment;
import com.xoa.model.file.FileContentModel;
import com.xoa.model.file.FileSortModel;
import com.xoa.service.enclosure.EnclosureService;
import com.xoa.service.file.FileContentService;
import com.xoa.service.file.FileSortService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.treeUtil.FileSortTreeUtil;
import com.xoa.util.treeUtil.HtmlUtil;
import com.xoa.util.treeUtil.TreeNode;


/**
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-18 下午4:06:47
 * 类介绍  :   文件柜模块控制层
 * 构造参数:   默认(由Spring容器托管)
 */
@Controller
@RequestMapping("/file")
public class FileController {
	private Logger loger = Logger.getLogger(FileController.class);
     
	@Resource
	FileSortService fileSortService;
	@Resource
	FileContentService fileContentService;

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:07:17
	 * 方法介绍:   文件柜跳转首页面
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/home")
	public String fileHome(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------home-------");
		return "app/file/fileHome";
	}
	@RequestMapping(value = "/persionBox")
	public String persionBox(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------home-------");
		return "app/file/fileHomePerson";
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:07:17
	 * 方法介绍:   文件柜跳转首页面
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/temp")
	public String temp(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------home-------");
		return "app/file/temp";
	}


	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:07:34
	 * 方法介绍:   文件柜顶层页面跳转
	 * 参数说明:   @return
	 * @return   String
	 */
	@RequestMapping(value = "/homePerson")
	public String topFrame(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------homePerson-------");
		return "app/file/fileHomePerson";
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:09:20
	 * 方法介绍:   将目录树转换成json数据通过HtmlUtil.writerJson(response, treeList)写到前台页面
	 * 参数说明:   @param file
	 * 参数说明:   @param response
	 * @return     void
	 */
	@RequestMapping(value = "/writeTree", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void showFile(FileSortModel file, HttpServletResponse response,HttpSession session,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------writeTree-------");
		List<TreeNode> treeList = treeFile(file.getSortId(),session);
		HtmlUtil.writerJson(response, treeList);
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:12:07
	 * 方法介绍:   构建树形目录信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return     List<TreeNode>
	 */
	public List<TreeNode> treeFile(int sortid,HttpSession session) {
		//Session 获取用户信息
		String userId=session.getAttribute("userId").toString();
		String userPriv=session.getAttribute("userPriv").toString();
		String deptId=session.getAttribute("deptId").toString();
		Map<String,Object> map=new Hashtable<String, Object>();
		map.put("userId", userId);
		map.put("userPriv", userPriv);
		map.put("deptId", deptId);
		//采用 LinkedList 双向列表实现类 操作 在链表中操作对象集合效率高
		List<FileSortModel> rootTree=new LinkedList<FileSortModel>();
		rootTree = fileSortService.getRootTree(sortid);// 根节点
		//利用迭代器删除集合中元素
		List<FileSortModel> childTree = new LinkedList<FileSortModel>();
		if(rootTree.size()>0){
		Iterator<FileSortModel> iterator=rootTree.iterator();
		while(iterator.hasNext()){
			FileSortModel fsm=iterator.next();
			//将权限字符串传到checkAll 返回为true时 有权限 为false时无权限
			if(!this.checkAll(fsm.getUserId(),map)){
				iterator.remove();
			}
		}
		}
		for(FileSortModel fsm:rootTree){
			childTree.addAll(getchildTrees(fsm,map));
		}
		// 构造方法传值
		FileSortTreeUtil util = new FileSortTreeUtil(rootTree, childTree);
		return util.getTreeNode();
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:15:03
	 * 方法介绍:   根据权限递归循环获取文件夹对象
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	public List<FileSortModel> getchildTrees(FileSortModel file,Map<String,Object> map) {
		// 传值查询子节点数据
		List<FileSortModel> parentList = new ArrayList<FileSortModel>();
		int tempNo = file.getSortId();
		List<FileSortModel> childrenList = new ArrayList<FileSortModel>();
		childrenList = fileSortService.getSortChrildren(tempNo);
		if(childrenList.size()>0){
		Iterator<FileSortModel> iteratorChr=childrenList.iterator();
		while(iteratorChr.hasNext()){
					FileSortModel fsm=iteratorChr.next();
					//将权限字符串传到checkAll 返回为true时 有权限 为false时无权限
					if(!this.checkAll(fsm.getUserId(),map)){
						iteratorChr.remove();
			}
		}
		for (FileSortModel fs : childrenList){
			parentList.addAll(getchildTrees(fs,map));
		}
		parentList.addAll(childrenList);
		}
		return parentList;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:09:20
	 * 方法介绍:   将目录树转换成json数据通过HtmlUtil.writerJson(response, treeList)写到前台页面
	 * 参数说明:   @param file
	 * 参数说明:   @param response
	 * @return     void
	 */
	@RequestMapping(value = "/writeTreePerson", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void showFilePerson(FileSortModel file, HttpServletResponse response,HttpSession session,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------writeTreePerson-------");
		List<TreeNode> treeList = treeFilePerson(file.getSortId(),session);
		HtmlUtil.writerJson(response, treeList);
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:12:07
	 * 方法介绍:   构建个人树形目录信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return     List<TreeNode>
	 */
	public List<TreeNode> treeFilePerson(int sortid,HttpSession session) {
		//Session 获取用户信息
		String userId=SessionUtils.getSessionInfo(session, "userId", String.class);
//		String userId=session.getAttribute("userId")==null?"":session.getAttribute("userId").toString();
		
	
		//采用 LinkedList 双向列表实现类 操作 在链表中操作对象集合效率高
		List<FileSortModel> rootTree=new LinkedList<FileSortModel>();
		if(!"".equals(userId)&&userId!=null){
		FileSortModel fsm=new FileSortModel();
		fsm.setUserId(userId);
		fsm.setSortType("4");
		fsm.setSortParent(0);
		rootTree = fileSortService.getFileSortList(fsm);// 根节点
		}
		List<FileSortModel> childTree = new LinkedList<FileSortModel>();
		
		// 取子节点
		for(FileSortModel fsm:rootTree){
			childTree.addAll(getchildTreePerson(fsm));
		}
		// 构造方法传值
		FileSortTreeUtil util = new FileSortTreeUtil(rootTree, childTree);
		return util.getTreeNode();
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-8 下午3:45:58
	 * 方法介绍:   递归个人文件柜
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	public List<FileSortModel> getchildTreePerson(FileSortModel file) {
		// 传值查询子节点数据
		List<FileSortModel> parentList = new ArrayList<FileSortModel>();
		int tempNo = file.getSortId();
		List<FileSortModel> childrenList = new ArrayList<FileSortModel>();
		childrenList = fileSortService.getSortChrildren(tempNo);
		if(childrenList.size()>0){
		for (FileSortModel fs : childrenList){
			parentList.addAll(getchildTreePerson(fs));
		}
		parentList.addAll(childrenList);
		}
		return parentList;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:10:52
	 * 方法介绍:    目录树跳转页面
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/tree")
	public String fileIndex(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------tree-------");
		return "app/file/fileTree";
	}

	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:11:14
	 * 方法介绍:   进入文件柜主页面
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/contentAdd")
	public ModelAndView fileHomeOne(HttpServletRequest request,String sortId,String text) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute("loginDateSouse"));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("sortId", sortId);
		model.put("text",text);
		ModelAndView modelAndView = new ModelAndView("app/file/fileContentAdd", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "/getContentById")
	@ResponseBody
	public FileContentModel file(HttpServletRequest request,String contentId) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute("loginDateSouse"));
		FileContentModel fcm=fileContentService.getFileConByContentId(contentId);
		return fcm;
	}
	
	
	@RequestMapping(value = "/updateContent")
	@ResponseBody
	public ToJson updateContent(HttpServletRequest request,FileContentModel fcm) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute("loginDateSouse"));
		int i=fileContentService.updateFileCon(fcm);
		ToJson to=new ToJson();
		to.setFlag(0);
		to.setMsg(i+"");
		return to;
	}
 
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:11:45
	 * 方法介绍:   文件展示页面跳转
	 * 参数说明:   @return
	 * @return     String
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/content")
	public ModelAndView fileContent(String sortType,String sortId,String text,String postType,HttpServletRequest request) throws UnsupportedEncodingException {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		loger.info("--------home-------");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("sortId", sortId);
		model.put("sortType", sortType);
//		String sname = new String(text.getBytes("ISO-8859-1"),"utf-8");
		model.put("text", text);
		model.put("postType", postType);
		ModelAndView modelAndView = new ModelAndView("app/file/fileContent", model);
		return modelAndView;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-26 上午9:06:06
	 * 方法介绍:   添加子文件夹
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "saveContent")
	@ResponseBody
	public ToJson<DiaryModel> addContent(FileContentModel fileContentModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		 ToJson diaryListToJson=new ToJson(0,"");
		 fileContentModel.setSendTime(DateFormat.getStrDate(new Date()));
		 fileContentModel.setCreater(request.getSession().getAttribute("userId").toString());
		   int i=fileContentService.saveContent(fileContentModel);
		   diaryListToJson.setFlag(0);
		   diaryListToJson.setMsg(""+i);
		  return diaryListToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-26 上午9:06:53
	 * 方法介绍:   查看文件内容
	 * 参数说明:   @param contentId
	 * 参数说明:   @return
	 * @return     ModelAndView
	 */
	@RequestMapping(value = "/catContent")
	public ModelAndView catContent(String contentId,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		loger.info("--------catContent-------");
		Map<String, Object> model = new HashMap<String, Object>();
		FileContentModel fcm=fileContentService.getFileConByContentId(contentId);
		model.put("fcm", fcm);
		ModelAndView modelAndView = new ModelAndView("app/file/fileContentDetail", model);
		return modelAndView;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:12:25
	 * 方法介绍:   通过循环获取条判断返回不同类型数据 从而一个请求接口处理多种业务
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   void  通过HtmlUtil.writerJson() 方法中out对象写到response中返回json数据
	 */
	@RequestMapping(value="/catalog")
	public void showFiles(FileSortModel file,HttpServletResponse response,String postType,HttpServletRequest request,String deptId,String userPriv) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute("loginDateSouse"));
		// "redirect:/showFile" "file/showFile"
		List<FileSortModel> fileList =new LinkedList<FileSortModel>();
		List<Object>  tatalList=new LinkedList<Object>();
		List<FileContentModel>  fileConList=null;
		Map<String,Object> map=new Hashtable<String, Object>();
		map.put("userId", file.getUserId()==null?"":file.getUserId());
		map.put("userPriv", userPriv==null?"":userPriv);
		map.put("deptId", deptId==null?"":deptId);
		int tempNo=file.getSortId();
		//获取文件
		if(tempNo!=0){
		fileConList=fileContentService.getFileConBySortid(tempNo);
		}
		if("1".equals(postType)||"2".equals(postType)){
			for(FileContentModel fcm:fileConList){
				fcm.setContent("");
			}
		}
		//通过判断获取父文件夹或子文件夹
		if(file.getSortId()==0){
			FileSortModel fileChr=new FileSortModel();
			fileChr.setSortParent(file.getSortId());
			fileChr.setSortType(file.getSortType());
		if(fileChr.getSortType()=="5"||"5".equals(fileChr.getSortType()))
			{
			fileList = fileSortService.getFileSortList(fileChr);
			//利用迭代器删除集合中元素
			Iterator<FileSortModel> iteratorChr=fileList.iterator();
			 while(iteratorChr.hasNext()){
						 FileSortModel fsm=iteratorChr.next();
						//将权限字符串传到checkAll 返回为true时 有权限 为false时无权限
						if(!this.checkAll(fsm.getUserId(),map)){
							iteratorChr.remove();
				      }
			   }
			}
			 if(fileChr.getSortType()=="4"||"4".equals(fileChr.getSortType()))
				{
				fileChr.setUserId(file.getUserId());
				fileList = fileSortService.getFileSortList(fileChr);
			}
		}else{
			FileSortModel filePar=new FileSortModel();
			filePar.setSortParent(file.getSortId());
			filePar.setSortType(file.getSortType());
			fileList = fileSortService.getFileSortList(filePar);
			if(!"2".equals(postType)){
			Iterator<FileSortModel> iteratorChr=fileList.iterator();
			 while(iteratorChr.hasNext()){
						 FileSortModel fsm=iteratorChr.next();
						//将权限字符串传到checkAll 返回为true时 有权限 为false时无权限
						if(!this.checkAll(fsm.getUserId(),map)){
							iteratorChr.remove();
				      }
			   }
			}
		}
		if(fileConList!=null){
		tatalList.addAll(fileConList);
		}
		if(fileList!=null){
		tatalList.addAll(fileList);
		}
		HtmlUtil.writerJson(response,tatalList);
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:12:47
	 * 方法介绍:   获取根文件夹
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     ModelAndView
	 */
	@RequestMapping("/setIndex")
	public ModelAndView showFileBySort_id(FileSortModel file,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		// "redirect:/showFile" "file/showFile"
		HttpSession session=request.getSession();
		String userId=session.getAttribute("userId").toString();
		String userPriv=session.getAttribute("userPriv").toString();
		String deptId=session.getAttribute("deptId").toString();
		Map<String,Object> map=new Hashtable<String, Object>();
		map.put("userId", userId);
		map.put("userPriv", userPriv);
		map.put("deptId", deptId);
		file.setSortType("5");
		List<FileSortModel> list = fileSortService.getFileSortList(file);
		Iterator<FileSortModel> iteratorChr=list.iterator();
		 while(iteratorChr.hasNext()){
					 FileSortModel fsm=iteratorChr.next();
					//将权限字符串传到checkAll 返回为true时 有权限 为false时无权限
					if(!this.checkAll(fsm.getUserId(),map)){
						iteratorChr.remove();
			      }
		   }
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("parentList", list);
		ModelAndView modelAndView = new ModelAndView("app/file/fileSet", model);
		return modelAndView;
	}

	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:13:10
	 * 方法介绍:   添加文件夹，通过判断字段，重复使用
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * 参数说明:   @throws UnsupportedEncodingException
	 * @return     ModelAndView
	 */
	@RequestMapping("/add")
	public ModelAndView fileAdd(FileSortModel file,HttpServletRequest request,HttpServletResponse response)
			throws UnsupportedEncodingException {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			HttpSession session=request.getSession();
			String userId=session.getAttribute("userId").toString();
		Map<String, Object> model = null;
		ModelAndView modelAndView = null;
		if("".equals(file.getSortNo())||file.getSortNo()==null){
			
		if ("".equals(file.getSortName())||file.getSortName()==null) {
			modelAndView = new ModelAndView("app/file/fileAdd", null);
			return modelAndView;
		}
		
		if (!"".equals(file.getSortName())||file.getSortName()!=null) {
			modelAndView = new ModelAndView("app/file/addFile", null);
			return modelAndView;
		}
		}
		// 乱码处理-----开始
		System.out.println("--before--------------" + file.getSortName());
		String sname = new String(file.getSortName().getBytes("ISO-8859-1"),"utf-8");
		System.out.println("--into--------------" + sname);
		file.setSortName(sname);
		System.out.println("--behand--------------" + file.getSortName());
		// 乱码处理-----结束
		//新建子文件夹
		if(file.getSortId()!=0){
			file.setSortParent(file.getSortId());
			file.setSortId(0);
			int resultSaveChr=fileSortService.saveFileSortChr(file);
			System.out.println("----------新建sortId:"+file.getSortId()+"子文件夹---------------");
			return null;
		}
		//添加文件影响行
		file.setUserId("||"+userId+",");
		int resultSave = fileSortService.saveFileSort(file);
		HtmlUtil.writerJson(response, resultSave);
		return null;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:13:36
	 * 方法介绍:   文件夹克隆
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     ModelAndView
	 */
	@RequestMapping("/clone")
	public ModelAndView fileClone(FileSortModel file,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute("loginDateSouse"));
		// "redirect:/showFile" "file/showFile"
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("app/file/", model);

		return modelAndView;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:14:01
	 * 方法介绍:   编辑文件夹信息传值跳转
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     ModelAndView
	 */
	@RequestMapping("/edit")
	public ModelAndView fileEdit(FileSortModel file,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		// "redirect:/showFile" "file/showFile"
		Map<String, Object> fileEditMap = new HashMap<String, Object>();
		List<FileSortModel> fileslist = fileSortService.getFileSortList(file);
		System.out.println("------"+fileslist.size()+"-------");
		FileSortModel files=null;
		if(fileslist.size()>0){
		files = fileslist.get(0);
		}
		fileEditMap.put("sortid", files.getSortId());
		fileEditMap.put("sortno", files.getSortNo());
		fileEditMap.put("sortname", files.getSortName());
		ModelAndView modelAndView = new ModelAndView("app/file/fileEdit",fileEditMap);
		return modelAndView;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:14:19
	 * 方法介绍:   修改文件夹信息
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   ModelAndView
	 */
	@RequestMapping("/update")
	public void fileUpdate(FileSortModel file,HttpServletRequest request ,HttpServletResponse response) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		//修改文件影响行
		int resultUpdate = fileSortService.updateFileSort(file);
		HtmlUtil.writerJson(response,resultUpdate);
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:14:39
	 * 方法介绍:   删除目录
	 * 参数说明:   @param request
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   ModelAndView
	 */
	@RequestMapping("/deleteAll")
	public ModelAndView fileDelete(HttpServletRequest request, FileSortModel file) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		// 所有删除文件夹
		List<FileSortModel> childrenList = getfilesDeleteList(file);
		// 将父节点加入，父节点下可能也有文件
		childrenList.add(file);
		// 文件集合
		List<FileContentModel> fileContentList = new ArrayList<FileContentModel>();
		//
		for (FileSortModel f : childrenList) {
			int tempNo = f.getSortId();
			List<FileContentModel> fileContent = fileContentService
					.getFileConBySortid(tempNo);
			fileContentList.addAll(fileContent);
			//删除文件影响行
			int deleConNo = fileContentService
					.deleteBySortId(tempNo);
		}
		// 删除附件
		// boolean flag=deleteAttachment(fileContentList,request);
		// 删除父节点，子节点
		for (FileSortModel f : childrenList) {
			Map<String, Object> fileSortidMap = new HashMap<String, Object>();
			fileSortidMap.put("sortid", f.getSortId());
			//删除文件影响行
			int deleSortNo = fileSortService
					.deleteBySortId(fileSortidMap);
		}
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/file/setIndex", model);
		return modelAndView;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:14:39
	 * 方法介绍:   删除文件
	 * 参数说明:   @param request
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   ModelAndView
	 */
	@RequestMapping("/deletefileAndCon")
	@ResponseBody
	public ToJson conDelete(HttpServletRequest request, FileSortModel file,String contentId) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			int deleSortNo = 0;
			ToJson tj=new ToJson();
		// 所有删除文件夹
		if(contentId==null){
		List<FileSortModel> childrenList = getfilesDeleteList(file);
		// 将父节点加入，父节点下可能也有文件
		childrenList.add(file);
		// 文件集合
		//
		for (FileSortModel f : childrenList) {
			int tempNo = f.getSortId();
			int deleConNo = fileContentService
					.deleteBySortId(tempNo);
		}
			
		// 删除附件
		// boolean flag=deleteAttachment(fileContentList,request);
		// 删除父节点，子节点
		for (FileSortModel f : childrenList) {
			Map<String, Object> fileSortidMap = new HashMap<String, Object>();
			fileSortidMap.put("sortid", f.getSortId());
			//删除文件影响行
			deleSortNo+=fileSortService
					.deleteBySortId(fileSortidMap);
		}
		tj.setFlag(0);
		tj.setMsg(deleSortNo+"");
	    }else{
				Map<String, Object> fileConMap = new HashMap<String, Object>();
				fileConMap.put("contentId", contentId);
				deleSortNo = fileContentService.deleteByConId(fileConMap);
				tj.setFlag(0);
				tj.setMsg(deleSortNo+"");
			}
		return tj;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:15:03
	 * 方法介绍:   递归循环获取文件夹对象
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	public List<FileSortModel> getfilesDeleteList(FileSortModel file) {
		// 传值查询子节点数据
		List<FileSortModel> parentList = new ArrayList<FileSortModel>();
		int tempNo = file.getSortId();
		List<FileSortModel> childrenList = new ArrayList<FileSortModel>();
		childrenList = fileSortService.getSortChrildren(tempNo);
		if (childrenList.size() > 0) {
			for (FileSortModel fs : childrenList) {
				parentList.addAll(getfilesDeleteList(fs));
			}
			parentList.addAll(childrenList);
		}
		return parentList;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:15:18
	 * 方法介绍:   删除附件
	 * 参数说明:   @param fileContentList
	 * 参数说明:   @param request
	 * 参数说明:   @return
	 * @return     boolean
	 */
	private boolean deleteAttachment(List<FileContentModel> fileContentList,HttpServletRequest request) {
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		// 遍历处理附件字段进行查询附件操作
		for (FileContentModel fc : fileContentList) {
			String[] Att_idArray = fc.getAttachmentId().split(",");
			for (int i = 0; i < Att_idArray.length; i++) {
				String[] Att_idArrayAid = Att_idArray[i].split("@");
				Attachment att = new Attachment();
				att.setAid(Integer.parseInt(Att_idArrayAid[0]));
				String[] ymAndAttachId = Att_idArrayAid[1].split("_");
				att.setYm(ymAndAttachId[0]);
				att.setAttachId(Integer.parseInt(ymAndAttachId[1]));
				attachmentList.add(att);
			}
		}
		for (Attachment at : attachmentList) {
			// 定义"条件map集合"确定一条删除的记录
			Map<String, Object> atMap = new HashMap<String, Object>();
			atMap.put("aidString", at.getAid());
			atMap.put("ymString", at.getYm());
			atMap.put("attachIdString", at.getAttachId());
			// 删除的记录attachment
			// Attachment attachment=enclosureService.getByatMap(atMap);
			String path = request.getSession().getServletContext()
					.getRealPath("/");
		}
		return false;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-26 上午10:01:17
	 * 方法介绍:   验证目录树权限公共方法
	 * 参数说明:   @param checkString
	 * 参数说明:   @param map
	 * 参数说明:   @return
	 * @return     boolean
	 */
	public boolean checkAll(String checkString,Map<String,Object> map){
		//"|"转义字符串  所以必须用\\进行转义 因为 而且取出数组长度不确定
	   String[] checkStrings=checkString.split("\\|");
	   if(checkStrings.length==0){
		   return false;
	   }
	     //数组长度为1时 说明此时角色和用户Id权限为空
	   if(checkStrings.length==1){
		   String[]  checkDept=checkStrings[0].split(",");
		   for(int i=0;i<checkDept.length;i++){
			   //调用校验部门方法  传值为部门id
			   if(checkDeptPriv(checkDept[i],map.get("deptId").toString())){
				   return true;
			   }
		   }
	   }
	     //数组长度为2时 说明此时角色和用户Id权限为空
	   if(checkStrings.length==2){
		   String[]  checkDept=checkStrings[0].split(",");
		   for(int i=0;i<checkDept.length;i++){
			   //调用校验部门范围方法  传值为部门id
			   if(checkDeptPriv(checkDept[i],map.get("deptId").toString())){
				   return true;
			   }
		   }
		   String[]  checkUserPriv=checkStrings[1].split(",");
		   for(int i=0;i<checkUserPriv.length;i++){
			   //调用校验角色范围方法  传值为角色id
			   if(checkUserPriv(checkUserPriv[i],map.get("userPriv").toString())){
				   return true;
			   }
		   }
	   }
	     //数组长度为3时 说明此时部门、角色和用户Id权限都不为空
	   if(checkStrings.length==3){
		   String[]  checkDept=checkStrings[0].split(",");
		   for(int i=0;i<checkDept.length;i++){
			   //调用校验部门范围方法  传值为部门id
			   if(checkDeptPriv(checkDept[i],map.get("deptId").toString())){
				   return true;
			   }
		   }
		   String[]  checkUserPriv=checkStrings[1].split(",");
		   for(int i=0;i<checkUserPriv.length;i++){
			   //调用校验角色范围方法  传值为角色id
			   if(checkUserPriv(checkUserPriv[i],map.get("userPriv").toString())){
				   return true;
			   }
		   }
		   String[]  checkUserId=checkStrings[2].split(",");
		   for(int i=0;i<checkUserId.length;i++){
			   //调用校验用户范围方法  传值为用户id
			   if(checkUserId(checkUserId[i],map.get("userId").toString())){
				   return true; 
			   }
		   }
	   }
        //
		return false;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-26 上午9:21:36
	 * 方法介绍:   检查部门权限Id
	 * 参数说明:   @param DeptId 
	 * 参数说明:   @param deptIdOfuser_Id
	 * 参数说明:   @return
	 * @return     boolean
	 */
	public boolean checkDeptPriv(String DeptId,String deptIdOfuser_Id){
		//如果部门部分权限为“ALL_DEPT" 则部门范围有访问权限。将直返回return true；停止执行程序
		if("ALL_DEPT".equals(DeptId)||"ALL_DEPT"==DeptId){
			return true;
		}
		//如果部门部分权限为拼接字符串则将字符串拆开验证 ，如果登录人员匹配得所属部门则将直返回return true；停止执行程序
		if(DeptId!=null&&!"".equals(DeptId)){
		    String[] deptIds=DeptId.split(",");
		    for(int i=0;i<deptIds.length;i++){
		    	if(deptIdOfuser_Id.equals(deptIds)){
		    		return true;
		    	}
		    }
		}
		//如果部门字符串为其他类型 证明其无权限访问return false;
		return false;
	}
	/**
	 * 
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-26 上午9:54:36
	 * 方法介绍:   检查角色权限Id
	 * 参数说明:   @param userPriv 角色id
	 * 参数说明:   @param userPrivOfuser_Id 角色字符串
	 * 参数说明:   @return
	 * @return     boolean
	 */
	public boolean checkUserPriv(String userPriv,String userPrivOfuser_Id){
		//角色部分权限为拼接字符串，将字符串拆开验证 ，如果登录人员匹配得所属部门则将直接返回return true；停止执行程序
		if(userPriv!=null&&!"".equals(userPriv)){
		    String[] deptIds=userPriv.split(",");
		    for(int i=0;i<deptIds.length;i++){
		    	if(deptIds.equals(userPrivOfuser_Id)){
		    		return true;
		    	}
		    }
		}
		//如果角色部分字符串为其他类型  证明其无权限访问return false;
		return false;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-26 上午9:57:41
	 * 方法介绍:   人员权限验证
	 * 参数说明:   @param userId 人员userId
	 * 参数说明:   @param userIdOfuser_Id
	 * 参数说明:   @return boolean
	 * @return     boolean
	 */
	public boolean checkUserId(String userId,String userIdOfuser_Id){
		//如果部门部分权限为拼接字符串则将字符串拆开验证 ，如果登录人员匹配得所属部门则将直返回return true；停止执行程序
		if(userId!=null&&!"".equals(userId)){
		    String[] deptIds=userId.split(",");
		    for(int i=0;i<deptIds.length;i++){
		    	if(deptIds[i].equals(userIdOfuser_Id)){
		    		return true;
		    	}
		    }
		}
		//如果部门字符串为其他类型 证明其无权限访问return false;
		return false;
	}
	@RequestMapping("/batchDeleteConId")
	@ResponseBody
	public BaseWrapper deleteByList(@RequestParam(name = "fileId[]") Integer fileId[]){

       return fileContentService.batchDeleteConId(fileId);
	}



	@RequestMapping("/setFileSortAuth")
	@ResponseBody
	public BaseWrapper setFileAuth(@RequestParam(name = "auth") String auth
//								   @RequestParam(name ="userId",required = false) Map<String,Object> userId,
//								   @RequestParam(name ="manageUser",required = false) Map<String,Object> manageUser,
//								   @RequestParam(name ="delUser",required = false) Map<String,Object> delUser,
//								   @RequestParam(name ="downUser",required = false) Map<String,Object> downUser,
//								   @RequestParam(name ="shareUser",required = false) Map<String,Object> shareUser,
//								   @RequestParam(name ="owner",required = false) Map<String,Object> owner,
//								   @RequestParam(name ="signUser",required = false) Map<String,Object> signUser,
//								   @RequestParam(name ="review",required = false) Map<String,Object> review,
//								   @RequestParam(name ="description",required = false) Map<String,Object> description
								   ){
		Map<String,Object> mmp=JSONArray.parseObject(auth,Map.class);
		L.w(mmp);
		BaseWrapper	wrapper =fileSortService.setFileSortAuth(mmp);
		return wrapper;
	}

}

package com.xoa.controller.file;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xoa.model.enclosure.Attachment;
import com.xoa.model.file.FileContentModel;
import com.xoa.model.file.FileSortModel;
import com.xoa.service.enclosure.EnclosureService;
import com.xoa.service.file.FileContentService;
import com.xoa.service.file.FileSortService;
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
	public String fileHome() {
		loger.info("--------home-------");
		return "app/file/fileHome";
	}

	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:07:34
	 * 方法介绍:   文件柜顶层页面跳转
	 * 参数说明:   @return
	 * @return   String
	 */
	@RequestMapping(value = "/topFrame")
	public String topFrame() {
		loger.info("--------topFrame-------");
		return "app/file/fileTop";
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
	public void showFile(FileSortModel file, HttpServletResponse response) {
		loger.info("--------showFile-------");
		List<TreeNode> treeList = treeMenu(file.getSortId());
		HtmlUtil.writerJson(response, treeList);
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
	public String fileIndex() {
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
	@RequestMapping(value = "/main")
	public String fileHomeOne() {
		loger.info("--------main-------");
		return "app/file/fileHomeMain";
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
	@ResponseBody
	public ModelAndView fileContent(String sortType,String sortId,String text) throws UnsupportedEncodingException {
		loger.info("--------home-------");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("sortId", sortId);
		model.put("sortType", sortType);
		String sname = new String(text.getBytes("ISO-8859-1"),"utf-8");
		model.put("text", sname);
		ModelAndView modelAndView = new ModelAndView("app/file/fileContent", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "addContent")
	public String addContent() {
		loger.info("--------home-------");
		return "app/file/";
	}
	@RequestMapping(value = "/catContent")
	public ModelAndView catContent(String contentId) {
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
	 * 创建日期:   2017-4-18 下午4:12:07
	 * 方法介绍:   构建树形目录信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return     List<TreeNode>
	 */
	public List<TreeNode> treeMenu(int sortid) {
		List<FileSortModel> rootTree = fileSortService.getRootTree(sortid);// 根节点
		List<FileSortModel> childTree = null;
		// 取子节点
		childTree = fileSortService.getChildTree(sortid);// 子节点
		// 构造方法传值
		FileSortTreeUtil util = new FileSortTreeUtil(rootTree, childTree);
		return util.getTreeNode();
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午4:12:25
	 * 方法介绍:   输出到页面File_Sort：json类型
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   void
	 */
	@RequestMapping(value="/catalog")
	public void showFiles(FileSortModel file,HttpServletResponse response,String postType) {
		// "redirect:/showFile" "file/showFile"
		List<FileSortModel> fileList =null;
		List<Object>  tatalList=new ArrayList<Object>();
		int tempNo=file.getSortId();
		//获取文件
		List<FileContentModel>  fileConList=fileContentService.getFileConBySortid(tempNo);
		if("1".equals(postType)){
			for(FileContentModel fcm:fileConList){
				fcm.setContent("");
			}
		}
		System.out.println("----------fileConList------------"+fileConList.size());
		//通过判断获取父文件夹或子文件夹
		if(file.getSortId()==0){
			System.out.println("----------getFileSortList------------");
			FileSortModel fileChr=new FileSortModel();
			fileChr.setSortParent(file.getSortId());
			fileChr.setSortType(file.getSortType());
			fileList = fileSortService.getFileSortList(fileChr);
		}else{
			FileSortModel filePar=new FileSortModel();
			filePar.setSortParent(file.getSortId());
			filePar.setSortType(file.getSortType());
			fileList = fileSortService.getFileSortList(filePar);
		}
		tatalList.addAll(fileConList);
		tatalList.addAll(fileList);
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
	public ModelAndView showFileBySort_id(FileSortModel file) {
		// "redirect:/showFile" "file/showFile"
		System.out.println("parent:" + file.getSortParent());
		List<FileSortModel> list = fileSortService.getFileSortList(file);
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
	public ModelAndView fileAdd(FileSortModel file)
			throws UnsupportedEncodingException {
		Map<String, Object> model = null;
		ModelAndView modelAndView = null;
		if (file.getSortNo() == null || "".equals(file.getSortNo())) {
			modelAndView = new ModelAndView("app/file/fileAdd", null);
			return modelAndView;
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
		int resultSave = fileSortService.saveFileSort(file);
		modelAndView = new ModelAndView("redirect:/shows", model);
		return modelAndView;
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
	public ModelAndView fileClone(FileSortModel file) {
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
	public ModelAndView fileEdit(FileSortModel file) {
		// "redirect:/showFile" "file/showFile"
		Map<String, Object> fileEditMap = new HashMap<String, Object>();
		List<FileSortModel> fileslist = fileSortService.getFileSortList(file);
		FileSortModel files = fileslist.get(0);
		fileEditMap.put("sortid", files.getSortId());
		fileEditMap.put("sortno", files.getSortNo());
		fileEditMap.put("sortname", files.getSortName());
		ModelAndView modelAndView = new ModelAndView("app/file/fileEdit",
				fileEditMap);
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
	public ModelAndView fileUpdate(FileSortModel file) {
		// "redirect:/showFile" "file/showFile"
		//修改文件影响行
		int resultUpdate = fileSortService.updateFileSort(file);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app/file/fileEdit");
		return modelAndView;
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
		// 将父节点数据加入
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
}

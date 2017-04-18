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
 * 
 * 
 * @ClassName (类名):  FileController
 * @Description(简述): 文件柜模块控制层
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午3:46:24
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {
	private Logger loger = Logger.getLogger(FileController.class);
     
	@Resource
	FileSortService fileSortService;
	@Resource
	FileContentService fileContentService;
	@Resource
	EnclosureService enclosureService;

	
	/**
	 * 
	 * @Title: fileHome
	 * @Description: 文件柜跳转首页面
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/home")
	public String fileHome() {
		loger.info("--------home-------");
		return "app/file/fileHome";
	}

	
	/**
	 * 
	 * @Title: topFrame
	 * @Description: 文件柜顶层
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/topFrame")
	public String topFrame() {
		loger.info("--------topFrame-------");
		return "app/file/fileTop";
	}

	
	/**
	 * 
	 * @Title: showFile
	 * @Description: 将目录树转换成json数据通过HtmlUtil.writerJson(response, treeList)写到前台页面
	 * @author(作者):      ys
	 * @param: @param file
	 * @param: @param response   
	 * @return: void   
	 * @throws
	 */
	@RequestMapping(value = "/writeTree")
	@ResponseBody
	public void showFile(FileSortModel file, HttpServletResponse response) {
		loger.info("--------showFile-------");
		List<TreeNode> treeList = treeMenu(file.getSortId());
		HtmlUtil.writerJson(response, treeList);
	}

	
	/**
	 * 
	 * @Title: fileIndex
	 * @Description:  目录树跳转页面
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/tree")
	public String fileIndex() {
		loger.info("--------tree-------");
		return "app/file/fileTree";
	}

	
	/**
	 * 
	 * @Title: fileHomeOne
	 * @Description: 进入文件柜主页面
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/main")
	public String fileHomeOne() {
		loger.info("--------main-------");
		return "app/file/fileHomeMain";
	}
 
	/**
	 * 
	 * @Title: fileContent
	 * @Description: 文件展示页面跳转
	 * @author(作者):    ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/fileContent")
	public String fileContent() {
		loger.info("--------home-------");
		return "app/file/fileContent";
	}

	/**
	 * 
	 * @Title: treeMenu
	 * @Description: 构建树形目录信息
	 * @author(作者):   杨胜
	 * @param: @param sortid  传入父节点获取
	 * @param: @return   
	 * @return: List<TreeNode>   
	 * @throws
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
	 * 输出到页面File_Sort集合输出跳转并展示到页面
	 * 
	 * @author 杨 胜
	 * @param file
	 * @return ("app/file/showFile",model)
	 
	@RequestMapping("/showFile")
	public ModelAndView showFiles(File_Sort file) {
		// "redirect:/showFile" "file/showFile"
		List<File_Sort> list = fileSortService.getFile_Sorts(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("json", list);
		ModelAndView modelAndView = new ModelAndView("app/file/", model);
		return modelAndView;
	}
     */
	
	/**
	 * 获取根文件夹
	 * 
	 * @author 杨 胜
	 * @param file
	 * @return ("app/file/fileSet",model)
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
	 * 添加文件夹，通过判断字段，重复使用
	 * @param file
	 * @return "app/file/addFile"
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/add")
	public ModelAndView fileAdd(FileSortModel file)
			throws UnsupportedEncodingException {
		// "redirect:/showFile" "file/showFile"
		Map<String, Object> model = null;
		ModelAndView modelAndView = null;
		if (file.getSortNo() == null || file.getSortNo().equals("")) {
			model = new HashMap<String, Object>();
			modelAndView = new ModelAndView("app/file/fileAdd", model);
			return modelAndView;
		}
		// 乱码处理-----开始
		System.out.println("--前--------------" + file.getSortName());
		String sname = new String(file.getSortName().getBytes("ISO-8859-1"),"utf-8");
		System.out.println("--中--------------" + sname);
		file.setSortName(sname);
		System.out.println("--后--------------" + file.getSortName());
		// 乱码处理-----结束
		int resultAdd = fileSortService.saveFileSort(file);
		System.out.println("添加文件影响行--------" + resultAdd);
		modelAndView = new ModelAndView("redirect:/shows", model);
		return modelAndView;
	}

	/**
	 * 文件夹克隆
	 * 
	 * @param file
	 * @return
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
	 * 编辑文件夹信息传值跳转
	 * 
	 * @param file
	 * @return
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
	 * 修改文件夹信息
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView fileUpdate(FileSortModel file) {
		// "redirect:/showFile" "file/showFile"
		int resultUpdate = fileSortService.updateFileSort(file);
		System.out.println("--修改文件影响行--------" + resultUpdate);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app/file/fileEdit");
		return modelAndView;
	}

	/**
	 * 删除目录
	 * 
	 * @author 杨 胜
	 * @param file
	 * @return modelAndView
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
			int deleConNo = fileContentService
					.fileContentDeleBySort_id(tempNo);
			System.out.println("删除文件影响行----deleConNo----" + deleConNo);
		}
		// 删除附件
		// boolean flag=deleteAttachment(fileContentList,request);
		// 删除父节点，子节点
		for (FileSortModel f : childrenList) {
			Map<String, Object> fileSortidMap = new HashMap<String, Object>();
			fileSortidMap.put("sortid", f.getSortId());
			int deleSortNo = fileSortService
					.deleteBySortId(fileSortidMap);
			System.out.println("删除文件影响行----deleSortNo----" + deleSortNo);
		}
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/file/setIndex", model);
		return modelAndView;
	}

	/**
	 * @author 杨 胜
	 * @category 递归循环获取文件夹对象
	 * @param file
	 * @return parentList
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
	 * 删除附件
	 * 
	 * @author 杨 胜
	 * @param fileContentList
	 * @return
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

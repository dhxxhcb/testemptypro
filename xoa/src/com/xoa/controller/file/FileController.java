package com.xoa.controller.file;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xoa.model.file.File_Sort;
import com.xoa.service.file.File_ContentService;
import com.xoa.service.file.File_SortService;
import com.xoa.util.ToJson;


@Controller
public class FileController {
	private Logger loger = Logger.getLogger(FileController.class);
	
    @Resource
	File_SortService file_SortService;
    @Resource
    File_ContentService file_ContentService;
    
	@RequestMapping(value="/showFile",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String showFile(File_Sort file) {
		loger.info("加载文件柜");
		ToJson<File_Sort> toJson=file_SortService.getFile_Sort(file);
		//Map<String, String> map = new HashMap<String, String>();
		
		//map.put("showFile", jsons);
		return JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss");
	}
	@RequestMapping("/showFiles")
	public ModelAndView showFiles(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		List<File_Sort> list=file_SortService.getFile_Sorts(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("json", list);
		ModelAndView modelAndView=new ModelAndView("app/file/showFile",model);
		return modelAndView;
	}
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
	@RequestMapping("/fileAdd")
	public ModelAndView fileAdd(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		Map<String, Object> model =null;
		ModelAndView modelAndView=null;
		if(file.getSort_no()==null||file.getSort_no().equals("")){
			model = new HashMap<String, Object>();
			modelAndView=new ModelAndView("app/file/addFile",model);
			return modelAndView;
		}
		int resultAdd=file_SortService.addFile_Sorts(file);
		System.out.println("添加文件影响行--------"+resultAdd);
		modelAndView=new ModelAndView("redirect:/showFiles",model);
		return modelAndView;
	}
	
	@RequestMapping("/fileClone")
	public ModelAndView fileClone(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView=null;
		modelAndView=new ModelAndView("app/file/",model);
		
		return modelAndView;
	}
	
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
	 * @param file
	 * @return
	 */
	@RequestMapping("/fileDelete")
	public ModelAndView fileDelete(File_Sort file){
		//map对象 传值查询子节点数据
		Map<String, Object> fileParent = new HashMap<String, Object>();
		fileParent.put("fileParent", file.getSort_id());
		//子节点数据
		List<File_Sort> childrenList=file_SortService.getSortChrildren(fileParent);
		//将父节点数据加入
		childrenList.add(file);
		//删除附件
		for(File_Sort f : childrenList){
			int tempNo=f.getSort_id();
			int deleConNo=file_ContentService.fileContentDeleBySort_id(tempNo);
			System.out.println("删除文件影响行----deleConNo----"+deleConNo);
		}
		//删除父节点，子节点
		for(File_Sort f:childrenList){
		Map<String, Object> fileSortidMap= new HashMap<String, Object>();
		fileSortidMap.put("sortid", f.getSort_id());
		int deleSortNo=file_SortService.fileDeleteBySort_id(fileSortidMap);
		System.out.println("删除文件影响行----deleSortNo----"+deleSortNo);
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView=new ModelAndView("redirect:/showFileBySort_id",model);
		return modelAndView;
	}
}

package com.xoa.controller.file;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xoa.model.file.File_Sort;
import com.xoa.service.file.File_SortService;
import com.xoa.util.ToJson;
import net.sf.json.JSONObject;


@Controller
public class FileController {
	private Logger loger = Logger.getLogger(FileController.class);
	
    @Resource
	File_SortService file_SortService;
    
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
		modelAndView=new ModelAndView("redirect:/fileAdd",model);
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
//	@RequestMapping("/checkfileNoid")
//	public String checkFileNoid(String id){
//		//"redirect:/showFile"   "file/showFile"
//		Map<String, Object> model =new HashMap<String, Object>() ;
//		
//		int i=file_SortService.checkSort_No();
//		model.put("flag", i);
//	     JSONObject jsonObject = JSONObject.fromObject(model);
//		return JSON.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd HH:mm:ss");
//	}
	@RequestMapping("/fileUpdate")
	public ModelAndView fileUpdate(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		int resultAdd=file_SortService.updateFile(file);
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView modelAndView=new ModelAndView("redirect:/showFile",model);
		return modelAndView;
	}
	@RequestMapping("/fileDelete")
	public ModelAndView fileDelete(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		Map<String, Object> model = new HashMap<String, Object>();
		int  i=file_SortService.fileDeleteBySort_id(file.getSort_id());
		ModelAndView modelAndView=new ModelAndView("redirect:/showFile",model);
		return modelAndView;
	}
}

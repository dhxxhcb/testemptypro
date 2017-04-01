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
		ModelAndView modelAndView=new ModelAndView("file/showFile",model);
		return modelAndView;
	}
	@RequestMapping("/showFileBySort_id")
	public ModelAndView showFileBySort_id(File_Sort file){
		//"redirect:/showFile"   "file/showFile"
		List<File_Sort> list=file_SortService.getFile_Sorts(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("json", list);
		ModelAndView modelAndView=new ModelAndView("file/fileSet",model);
		return modelAndView;
	}
}

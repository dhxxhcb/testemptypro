package com.xoa.controller.file;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xoa.service.file.File_ContentService;
import com.xoa.service.file.File_SortService;

@Controller
public class FileContentController {
	private Logger loger = Logger.getLogger(FileContentController.class);
	@Resource
	File_SortService file_SortService;
	@Resource
    File_ContentService file_ContentService;
	
	 /**
       *文件夹跳转展示页面
	   * @author 杨  胜
	   * @return 
	   */
		@RequestMapping(value="/fileContent")
		public String fileHome() {
			loger.info("--------fileContent-------");
			return "app/file/fileContent";
		}
	    
}

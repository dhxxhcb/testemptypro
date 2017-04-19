package com.xoa.controller.diary;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xoa.service.diary.DiaryService;

@Controller
@RequestMapping("/diary_")
public class DiaryController {
	@Resource
	DiaryService diaryService;
	
	@RequestMapping("/diary_")
	public void diaryAdd(){
		
	}
	
}

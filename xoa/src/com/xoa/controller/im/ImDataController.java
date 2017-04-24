package com.xoa.controller.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoa.service.im.ImDataService;
import com.xoa.util.ToJson;
import com.xoa.util.common.wrapper.BaseWrapper;


/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-24 上午11:42:27 
 * @类介绍 IM信息处理类
 * @构造参数 无
 *
 */
@RestController
@RequestMapping("/im")
public class ImDataController {
    @Autowired
    ImDataService imDataService;
    @RequestMapping("/putMessage")
	public BaseWrapper putMessageInfo(Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String time, String uuid){
		return imDataService.putMessageInfo(flag, from_uid, to_uid, of_from, of_to, content, type, time, uuid);
	}
	
}

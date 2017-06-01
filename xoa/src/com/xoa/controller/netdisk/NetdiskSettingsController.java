package com.xoa.controller.netdisk;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.netdisk.Netdisk;

import com.xoa.service.netdisk.NetdiskService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

/**
 * 
 * @ClassName (类名):  NetdiskController
 * @Description(简述): 网络硬盘控制层
 * @author(作者):      张丽军
 * @date(日期):        2017-5-8 下午1:35:18
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/netdiskSettings")
public class NetdiskSettingsController {
  
	private Logger loger= Logger.getLogger(NetdiskSettingsController.class);
	@Resource
	private NetdiskService netdiskService;
	
	/**
	 * 
	 * @Title: selectNetdisk
	 * @Description: 网路硬盘设置查询接口
	 * @author(作者): 张丽军
	 * @param: @param request
	 * @param: @return   
	 * @return: ToJson<Netdisk>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/selectNetdiskSettings",produces = {"application/json;charset=UTF-8"})
	public ToJson<Netdisk> selectNetdiskSettings(HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Netdisk> tojson=new ToJson<Netdisk>(0,"");
		try {
			List<Netdisk> list=netdiskService.selectNetdisk();
			tojson.setObject(list);
			tojson.setMsg("ok");
			tojson.setFlag(0);
		} catch (Exception e) {
			tojson.setMsg(e.getMessage());		
		}
		return tojson;
	}
	/**
	 * 
	 * @Title: addNetdisk
	 * @Description: 网盘设置新建
	 * @author(作者): 张丽军
	 * @param: @param diskNo
	 * @param: @param diskName
	 * @param: @param diskPath
	 * @param: @param spaceLimit
	 * @param: @param orderBy
	 * @param: @param request
	 * @param: @return   
	 * @return: ToJson<Netdisk>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/addNetdiskSettings",produces = {"application/json;charset=UTF-8"})
	public ToJson<Netdisk> addNetdisk(
			Netdisk netdisk,
			HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Netdisk> json=new ToJson<Netdisk>();
		try {
			int a=netdiskService.addNetdisk(netdisk);
			if (a>0){
				json.setFlag(0);
				json.setMsg("ok");
			}else {
				json.setFlag(1);
				json.setMsg("err");
			}

			
		} catch (Exception e) {
			json.setMsg(e.getMessage());

		}
		return  json;
	}
	
	/**
	 * 
	 * @Title: editNetdisk
	 * @Description: 网盘编辑设置
	 * @author(作者): 张丽军
	 * @param: @param diskNo
	 * @param: @param diskName
	 * @param: @param diskPath
	 * @param: @param spaceLimit
	 * @param: @param orderBy
	 * @param: @param remark
	 * @param: @param request
	 * @param: @return   
	 * @return: ToJson<Netdisk>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/editNetdiskSettings",produces = {"application/json;charset=UTF-8"})
	public ToJson<Netdisk> editNetdisk(
			Netdisk netdisk,
			HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Netdisk> json=new ToJson<Netdisk>();
		try {
			int a=netdiskService.editNetdisk(netdisk);
			if (a>0){
				json.setFlag(0);
				json.setMsg("ok");
			}else {
				json.setFlag(1);
				json.setMsg("err");
			}

			
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
		return json;
		
	}
	
	
	
	
	/**
	 * 
	 * @Title: deleteByDiskId
	 * @Description: 网盘删除设置
	 * @author(作者): 张丽军
	 * @param: @param diskId
	 * @param: @param request
	 * @param: @return   
	 * @return: ToJson<Netdisk>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteByDiskId", produces = { "application/json;charset=UTF-8" })
	public ToJson<Netdisk> deleteByDiskId(@RequestParam("diskId") Integer diskId,HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Netdisk> tojson=new ToJson<Netdisk>(0,"");
		loger.debug("message"+diskId);
		try {
			netdiskService.delete(diskId);
			tojson.setMsg("ok");
			return tojson;
		} catch (Exception e) {
			tojson.setMsg(e.getMessage());
			return tojson;
		}
		
	}
	
	
	
	/*public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}*/
}


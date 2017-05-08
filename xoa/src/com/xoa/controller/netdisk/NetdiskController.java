package com.xoa.controller.netdisk;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.junit.runners.Parameterized.Parameters;
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
@RequestMapping(value="/netdisk")
public class NetdiskController {
  
	private Logger loger= Logger.getLogger(NetdiskController.class);
	@Resource
	private NetdiskService netdiskService;
	
	/**
	 * 
	 * @Title: selectNetdisk
	 * @Description: 网路硬盘查询接口
	 * @author(作者): 张丽军
	 * @param: @param request
	 * @param: @return   
	 * @return: ToJson<Netdisk>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/selectNetdisk",produces = {"application/json;charset=UTF-8"})
	public ToJson<Netdisk> selectNetdisk(HttpServletRequest request){
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
	 * @Description: 网盘新建
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
	@RequestMapping(value="/addNetdisk",produces = {"application/json;charset=UTF-8"})
	public ToJson<Netdisk> addNetdisk(
			@RequestParam(value="diskNo",required=false)String diskNo,
			@RequestParam(value="diskName",required=false)String diskName,
			@RequestParam(value="diskPath",required=false)String diskPath,
			@RequestParam(value="spaceLimit",required=false)String spaceLimit,
			@RequestParam(value="orderBy",required=false)String orderBy,
			HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		Netdisk netdisk=new Netdisk();
		netdisk.setDiskId(0);
		netdisk.setDiskNo(Integer.valueOf(diskNo));
		netdisk.setDiskName(this.returnValue(diskName));
		netdisk.setDiskPath(this.returnValue(diskPath));
		netdisk.setSpaceLimit(Integer.valueOf(spaceLimit));
		netdisk.setOrderBy(this.returnValue(orderBy));
		try {
			netdiskService.addNetdisk(netdisk);
			return new ToJson<Netdisk>(0,"");
			
		} catch (Exception e) {
			loger.debug("addNetdisk:"+e);
			return new ToJson<Netdisk>(1, "");
		}
		
	}
	
	/**
	 * 
	 * @Title: editNetdisk
	 * @Description: 网盘编辑
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
	@RequestMapping(value="/editNetdisk",produces = {"application/json;charset=UTF-8"})
	public ToJson<Netdisk> editNetdisk(
			@RequestParam(value="diskNo",required=false)String diskNo,
			@RequestParam(value="diskName",required=false)String diskName,
			@RequestParam(value="diskPath",required=false)String diskPath,
			@RequestParam(value="spaceLimit",required=false)String spaceLimit,
			@RequestParam(value="orderBy",required=false)String orderBy,
			@RequestParam(value="remark",required=false)String remark,
			HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		Netdisk netdisk=new Netdisk();
		netdisk.setDiskId(0);
		netdisk.setDiskNo(Integer.valueOf(diskNo));
		netdisk.setDiskName(this.returnValue(diskName));
		netdisk.setDiskPath(this.returnValue(diskPath));
		netdisk.setSpaceLimit(Integer.valueOf(spaceLimit));
		netdisk.setOrderBy(this.returnValue(orderBy));
		netdisk.setRemark(this.returnValue(remark));
		try {
			netdiskService.editNetdisk(netdisk);
			return new ToJson<Netdisk>(0,"");
			
		} catch (Exception e) {
			loger.debug("editNetdisk:"+e);
			return new ToJson<Netdisk>(1, "");
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @Title: deleteByDiskId
	 * @Description: 网盘删除
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
	
	
	
	public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}
}


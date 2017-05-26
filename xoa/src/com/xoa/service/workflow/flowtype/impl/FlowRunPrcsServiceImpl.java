package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import com.xoa.dao.workflow.FlowTypeModelMapper;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;
import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowRunPrcsMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FlowRunPrcsServiceImpl implements FlowRunPrcsService {
	
	@Resource
	private FlowRunPrcsMapper flowRunPrcsMapper;

	@Resource
	private UsersService usersService;

	@Resource
	private FlowTypeModelMapper flowTypeModelMapper;

	@Override
	public void save(FlowRunPrcs flowRunPrcs) {
		flowRunPrcsMapper.insertSelective(flowRunPrcs);
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:29
	 * 方法介绍:   查询代办工作
	 * 参数说明:
	 * @return
	 */
	@SuppressWarnings("all")
	@Override
	public ToJson<FlowRunPrcs> selectObject(Map<String, Object> maps,Integer page,
											Integer pageSize, boolean useFlag) {
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		List<FlowRunPrcs> list = flowRunPrcsMapper.selectObjcet(maps);
		List<FlowRunPrcs> returnList = new ArrayList<FlowRunPrcs>();
		int len = list.size();
		if(len>0){
			long start =  System.currentTimeMillis();
			for (FlowRunPrcs flowRunPrcs : list) {
				flowRunPrcs.setUserName(usersService.getUserNameById(flowRunPrcs.getUserId()));
				maps.put("flowId",flowRunPrcs.getFlowRun().getFlowId());
				flowRunPrcs.setFlowType(flowTypeModelMapper.queryOne(maps));
				returnList.add(flowRunPrcs);
			}
			long end = System.currentTimeMillis();
			toJson.setFlag(0);
			toJson.setMsg("ok");
			toJson.setTotleNum(pageParams.getTotal());
			toJson.setObj(returnList);
			System.out.println("查询时长："+(end-start));

		}else{
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:30
	 * 方法介绍:   查询办结工作
	 * 参数说明:
	 * @return
	 */
	@SuppressWarnings("all")
	@Override
	public ToJson<FlowRunPrcs> selectEnd(Map<String, Object> maps,Integer page,
										 Integer pageSize, boolean useFlag) {
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		List<FlowRunPrcs> list = flowRunPrcsMapper.selectEnd(maps);
		List<FlowRunPrcs> returnList = new ArrayList<FlowRunPrcs>();
		int len = list.size();
		if(len>0){
			for (FlowRunPrcs flowRunPrcs : list) {
				flowRunPrcs.setUserName(usersService.getUserNameById(flowRunPrcs.getUserId()));
				maps.put("flowId",flowRunPrcs.getFlowRun().getFlowId());
				flowRunPrcs.setFlowType(flowTypeModelMapper.queryOne(maps));
				returnList.add(flowRunPrcs);
			}
			toJson.setFlag(0);
			toJson.setMsg("ok");
			toJson.setTotleNum(pageParams.getTotal());
			toJson.setObj(returnList);
		}else{
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/25 15:47
	 * 方法介绍:   查询挂起工作
	 * 参数说明:
	 * @return
	 */
	@SuppressWarnings("all")
	@Override
	public ToJson<FlowRunPrcs> selectHang(Map<String,Object> maps,Integer page,
										  Integer pageSize, boolean useFlag){
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		List<FlowRunPrcs> list = flowRunPrcsMapper.selectHang(maps);
		List<FlowRunPrcs> returnList = new ArrayList<FlowRunPrcs>();
		int len = list.size();
		if(len>0){
			for (FlowRunPrcs flowRunPrcs : list) {
				flowRunPrcs.setUserName(usersService.getUserNameById(flowRunPrcs.getUserId()));
				maps.put("flowId",flowRunPrcs.getFlowRun().getFlowId());
				flowRunPrcs.setFlowType(flowTypeModelMapper.queryOne(maps));
				returnList.add(flowRunPrcs);
			}
			toJson.setFlag(0);
			toJson.setMsg("ok");
			toJson.setTotleNum(pageParams.getTotal());
			toJson.setObj(returnList);
		}else{
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/25 15:47
	 * 方法介绍:   查询所有工作
	 * 参数说明:
	 * @return
	 */
	@SuppressWarnings("all")
	@Override
	public ToJson<FlowRunPrcs> selectAll(Map<String,Object> maps,Integer page,Integer pageSize, boolean useFlag){
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		PageParams pages = new PageParams();
		pages.setPage(page);
		pages.setPageSize(pageSize);
		pages.setUseFlag(useFlag);
		maps.put("page",pages);
		List<FlowRunPrcs> list = flowRunPrcsMapper.selectAll(maps);
		List<FlowRunPrcs> returnList = new ArrayList<FlowRunPrcs>();
		int len = list.size();
		if(len>0){
			for (FlowRunPrcs flowRunPrcs : list) {
				flowRunPrcs.setUserName(usersService.getUserNameById(flowRunPrcs.getUserId()));
				maps.put("flowId",flowRunPrcs.getFlowRun().getFlowId());
				flowRunPrcs.setFlowType(flowTypeModelMapper.queryOne(maps));
				returnList.add(flowRunPrcs);
			}
			toJson.setFlag(0);
			toJson.setMsg("ok");
			toJson.setTotleNum(pages.getTotal());
			toJson.setObj(returnList);
		}else{
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}


}

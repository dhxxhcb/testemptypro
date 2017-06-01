package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import com.xoa.dao.workflow.FlowTypeModelMapper;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.page.PageParams;
import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowRunPrcsMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;
import org.springframework.transaction.annotation.Transactional;

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
			toJson.setTotleNum(pageParams.getTotal());
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
			toJson.setTotleNum(pageParams.getTotal());
			for (FlowRunPrcs flowRunPrcs : list) {
				flowRunPrcs.setUserName(usersService.getUserNameById(flowRunPrcs.getUserId()));
				maps.put("flowId",flowRunPrcs.getFlowRun().getFlowId());
				flowRunPrcs.setFlowType(flowTypeModelMapper.queryOne(maps));
				returnList.add(flowRunPrcs);
			}
			toJson.setFlag(0);
			toJson.setMsg("ok");
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
			toJson.setTotleNum(pageParams.getTotal());
			for (FlowRunPrcs flowRunPrcs : list) {
				flowRunPrcs.setUserName(usersService.getUserNameById(flowRunPrcs.getUserId()));
				maps.put("flowId",flowRunPrcs.getFlowRun().getFlowId());
				flowRunPrcs.setFlowType(flowTypeModelMapper.queryOne(maps));
				returnList.add(flowRunPrcs);
			}
			toJson.setFlag(0);
			toJson.setMsg("ok");
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

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/6/1 10:47
	 * 方法介绍:   根据runId查询关联办理人的步骤和所在部门
	 * 参数说明:
	 * @return
	 */
	@Override
	public  ToJson<FlowRunPrcs> findAllNode (Integer runId){
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		try {
			List<FlowRunPrcs> list = flowRunPrcsMapper.findAllNode(runId);
			List<FlowRunPrcs> list1 = new ArrayList<FlowRunPrcs>();
			int leng = list.size();
			for (int i = 0; i < leng; i++) {
				String flag = list.get(i).getPrcsFlag();
				if ("3".equals(flag) || "4".equals(flag)) {
					list1.add(list.get(i));
				} else {
					list1.add(list.get(i));
					break;
				}
			}
			toJson.setObj(list1);
			toJson.setFlag(0);
			toJson.setMsg("ok");
		}catch (Exception e){
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}

	public List<FlowRunPrcs> findByRunId(Integer runId){
        List<FlowRunPrcs> l=flowRunPrcsMapper.findByRunId(runId);
	    return l;
    }

    @Override
    @Transactional
    public void update(FlowRunPrcs flowRunPrcs) {
        flowRunPrcsMapper.updateByPrimaryKeySelective(flowRunPrcs);
    }


//	public  String returnNode (Integer runId){
//		String returnNodes = "";
//		try {
//			List<FlowRunPrcs> list = flowRunPrcsMapper.findAllNode(runId);
//			int leng = list.size();
//			for (int i = 0; i < leng; i++) {
//				String flag = list.get(i).getPrcsFlag();
//				if (!"3".equals(flag) || !"4".equals(flag)) {
//					list1.add(list.get(i));
//					break;
//				}
//			}
//		}catch (Exception e){
//			L.e("ReturnNode Error:"+e);
//		}
//		return toJson;
//	}


}

package com.xoa.service.workflow.flowtype;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.util.ToJson;

import java.util.Map;

public interface FlowRunPrcsService {

	public void save(FlowRunPrcs flowRunPrcs);

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:29
	 * 方法介绍:   查询代办工作
	 * 参数说明:   
	 * @return     
	 */
	public ToJson<FlowRunPrcs> selectObject(Map<String,Object> maps,Integer page,
											Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:30
	 * 方法介绍:   查询办结工作
	 * 参数说明:   
	 * @return     
	 */
	public ToJson<FlowRunPrcs> selectEnd(Map<String,Object> maps,Integer page,
										 Integer pageSize, boolean useFlag);


	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/25 15:47
	 * 方法介绍:   查询挂起工作
	 * 参数说明:
	 * @return
	 */
	public ToJson<FlowRunPrcs> selectHang(Map<String,Object> maps,Integer page,
										 Integer pageSize, boolean useFlag);

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/25 15:47
	 * 方法介绍:   查询所有工作
	 * 参数说明:
	 * @return
	 */
	public ToJson<FlowRunPrcs> selectAll(Map<String,Object> maps,Integer page,
										 Integer pageSize, boolean useFlag);

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/6/1 10:47
	 * 方法介绍:   根据runId查询关联办理人的步骤和所在部门
	 * 参数说明:
	 * @return
	 */
	public  ToJson<FlowRunPrcs> findAllNode (Integer runId);




}

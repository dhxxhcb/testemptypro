package com.xoa.service.workflow.flowtype;

import java.util.List;

import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowProcessList;
import com.xoa.util.ToJson;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月9日 下午4:24:07
 * 类介绍  :    流程设计
 * 构造参数:   无
 *
 */
public interface FlowProcessService {
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 上午9:42:23
	 * 方法介绍:   根据id查找流程
	 * 参数说明:   @param id 编号
	 * 参数说明:   @return
	 * @return     FlowProcess 流程
	 */
	public FlowProcess find(int id);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 上午9:43:03
	 * 方法介绍:   修改流程
	 * 参数说明:   @param record 流程信息
	 * 参数说明:   @return
	 * @return     ToJson<FlowProcess> 返回流程信息
	 */
	public ToJson<FlowProcess> updateByPrimaryKeySelective(FlowProcess record);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 上午9:43:58
	 * 方法介绍:   根据流程id查找流程
	 * 参数说明:   @param flowId  流程id
	 * 参数说明:   @return
	 * @return     List<FlowProcess> 返回流程信息
	 */
	public List<FlowProcess> findFlowId(int flowId);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 上午9:44:40
	 * 方法介绍:   删除流程
	 * 参数说明:   @param id 
	 * @return     void
	 */
	public void delete(int id);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 上午9:45:01
	 * 方法介绍:   根据流程id查找流程
	 * 参数说明:   @param flowId 流程id
	 * 参数说明:   @return
	 * @return     FlowProcess 流程信息
	 */
	public FlowProcessList flowView(int flowId);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 上午9:45:24
	 * 方法介绍:   新增流程
	 * 参数说明:   @param record
	 * 参数说明:   @return
	 * @return     int
	 */
	public ToJson<FlowProcess> insertSelective(FlowProcess record);
	
	
}

package com.xoa.model.workflow;

import java.util.List;
import java.util.Map;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月22日 下午1:57:38
 * 类介绍  :    用于接收流程信息
 * 构造参数:   无
 *
 */
public class FlowProcessList {
	
	 /**  
	 * 定义连接
	 */ 
	private List<Map<String, String>> connections;
	    
	 /**  
	 * 流程信息
	 */ 
	private List<FlowProcess> designdata;
	    
	 /**  
	 * 数量
	 */ 
	private Integer max;
	 
	 /**  
	 * 流程名字
	 */ 
	private String flowName;
	    
	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public List<Map<String, String>> getConnections() {
		return connections;
	}

	public void setConnections(List<Map<String, String>> connections) {
		this.connections = connections;
	}

	public List<FlowProcess> getDesigndata() {
		return designdata;
	}

	public void setDesigndata(List<FlowProcess> designdata) {
		this.designdata = designdata;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
	 
	 
	    
	
	
}
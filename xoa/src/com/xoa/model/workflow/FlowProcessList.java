package com.xoa.model.workflow;

import java.util.List;
import java.util.Map;

public class FlowProcessList {
	
	 private List<Map<String, String>> connections;
	    
	 private List<FlowProcess> designdata;
	    
	 private Integer max;
	 
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
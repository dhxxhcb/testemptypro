package com.xoa.model.workflow;

import java.util.List;

public class FlowFast {
	
	private FlowProcess flowProcesses;
	
	private FlowTypeModel flowTypeModel;
	
	private FlowFormType flowFormType;
	
	private FlowRun flowRun;
	
	private FlowRunPrcs flowRunPrcs;
	
	private List<FlowProcess> listFp;
	
	

	public List<FlowProcess> getListFp() {
		return listFp;
	}

	public void setListFp(List<FlowProcess> listFp) {
		this.listFp = listFp;
	}

	public FlowRunPrcs getFlowRunPrcs() {
		return flowRunPrcs;
	}

	public void setFlowRunPrcs(FlowRunPrcs flowRunPrcs) {
		this.flowRunPrcs = flowRunPrcs;
	}

	public FlowRun getFlowRun() {
		return flowRun;
	}

	public void setFlowRun(FlowRun flowRun) {
		this.flowRun = flowRun;
	}

	public FlowFormType getFlowFormType() {
		return flowFormType;
	}

	public void setFlowFormType(FlowFormType flowFormType) {
		this.flowFormType = flowFormType;
	}

	public FlowProcess getFlowProcesses() {
		return flowProcesses;
	}

	public void setFlowProcesses(FlowProcess flowProcesses) {
		this.flowProcesses = flowProcesses;
	}

	public FlowTypeModel getFlowTypeModel() {
		return flowTypeModel;
	}

	public void setFlowTypeModel(FlowTypeModel flowTypeModel) {
		this.flowTypeModel = flowTypeModel;
	}

	

}

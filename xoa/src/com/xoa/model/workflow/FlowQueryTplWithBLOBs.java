package com.xoa.model.workflow;

public class FlowQueryTplWithBLOBs extends FlowQueryTpl {
    private String viewExtFields;

	private String groupByFields;

	private String dataConditions;

	private String flowConditions;

	private String dataXml;

	public String getViewExtFields() {
		return viewExtFields;
	}

	public void setViewExtFields(String viewExtFields) {
		this.viewExtFields = viewExtFields == null ? null : viewExtFields
				.trim();
	}

	public String getGroupByFields() {
		return groupByFields;
	}

	public void setGroupByFields(String groupByFields) {
		this.groupByFields = groupByFields == null ? null : groupByFields
				.trim();
	}

	public String getDataConditions() {
		return dataConditions;
	}

	public void setDataConditions(String dataConditions) {
		this.dataConditions = dataConditions == null ? null : dataConditions
				.trim();
	}

	public String getFlowConditions() {
		return flowConditions;
	}

	public void setFlowConditions(String flowConditions) {
		this.flowConditions = flowConditions == null ? null : flowConditions
				.trim();
	}

	public String getDataXml() {
		return dataXml;
	}

	public void setDataXml(String dataXml) {
		this.dataXml = dataXml == null ? null : dataXml.trim();
	}


}
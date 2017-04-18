package com.xoa.model.common;

/**
 * 
 * @ClassName (类名): SysPara
 * @Description(简述): TODO
 * @author(作者): wyq
 * @date(日期): 2017-4-17 下午3:08:06
 * 
 */
public class SysParaModel {
	/**
	 * 参数名称
	 */
	private String paraName;
	/**
	 * 参数值
	 */
	private String paraValue;

	/**
	 * 
	 * @Title: getParaName
	 * @Description: 参数名称
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getParaName() {
		return paraName;
	}

	/**
	 * 
	 * @Title: setParaName
	 * @Description: 参数名称
	 * @author(作者): wyq
	 * @param: @param paraName
	 * @return: void
	 * @throws
	 */
	public void setParaName(String paraName) {
		this.paraName = paraName == null ? null : paraName.trim();
	}

	/**
	 * 
	 * @Title: getParaValue
	 * @Description: 参数值
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getParaValue() {
		return paraValue;
	}

	/**
	 * 
	 * @Title: setParaValue
	 * @Description: 参数值
	 * @author(作者): wyq
	 * @param: @param paraValue
	 * @return: void
	 * @throws
	 */
	public void setParaValue(String paraValue) {
		this.paraValue = paraValue == null ? null : paraValue.trim();
	}
}
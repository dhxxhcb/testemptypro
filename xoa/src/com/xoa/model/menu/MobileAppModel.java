package com.xoa.model.menu;

import java.util.List;

/**
 * @ClassName (类名): MobileApp
 * @Description(简述): TODO
 * @author(作者): wyq
 * @date(日期): 2017-4-17 下午3:11:10
 * 
 */
public class MobileAppModel {
	/**
	 * 桌面应用的ID
	 */
	private Integer appId;
	/**
	 * 应用的名称
	 */
	private String appName;
	/**
	 * 应用的类型 system是系统内置不允许改变，vip组件为需要购买，custom是用户可以自己定制的
	 */
	private String appType;
	/**
	 * 应用所代表的模块
	 */
	private String appModule;
	/**
	 * 应用的图标
	 */
	private String appIcon;
	/**
	 * 如果应用是打开连接地址的，则不为空
	 */
	private String appUrl;
	/**
	 * 应用的描述
	 */
	private String appDesc;
	/**
	 * 应用权限
	 */
	private String appPriv;

	private List<MobileAppModel> arrOne;

	private List<MobileAppModel> arrTwo;

	public List<MobileAppModel> getArrOne() {
		return arrOne;
	}

	public void setArrOne(List<MobileAppModel> arrOne) {
		this.arrOne = arrOne;
	}

	public List<MobileAppModel> getArrTwo() {
		return arrTwo;
	}

	public void setArrTwo(List<MobileAppModel> arrTwo) {
		this.arrTwo = arrTwo;
	}

	/**
	 * 
	 * @Title: getAppId
	 * @Description: 桌面应用的ID
	 * @author(作者): wyq
	 * @param: @return
	 * @return: Integer
	 * @throws
	 */
	public Integer getAppId() {
		return appId;
	}

	/**
	 * 
	 * @Title: setAppId
	 * @Description: 桌面应用的ID
	 * @author(作者): wyq
	 * @param: @param appId
	 * @return: void
	 * @throws
	 */
	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	/**
	 * 
	 * @Title: getAppName
	 * @Description: 应用的名称
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * 
	 * @Title: setAppName
	 * @Description: 应用的名称
	 * @author(作者): wyq
	 * @param: @param appName
	 * @return: void
	 * @throws
	 */
	public void setAppName(String appName) {
		this.appName = appName == null ? null : appName.trim();
	}

	/**
	 * 
	 * @Title: getAppType
	 * @Description: 应用的类型 system是系统内置不允许改变，vip组件为需要购买，custom是用户可以自己定制的
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * 
	 * @Title: setAppType
	 * @Description: 应用的类型 system是系统内置不允许改变，vip组件为需要购买，custom是用户可以自己定制的
	 * @author(作者): wyq
	 * @param: @param appType
	 * @return: void
	 * @throws
	 */
	public void setAppType(String appType) {
		this.appType = appType == null ? null : appType.trim();
	}

	/**
	 * 
	 * @Title: getAppModule
	 * @Description: 应用所代表的模块
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppModule() {
		return appModule;
	}

	/**
	 * 
	 * @Title: setAppModule
	 * @Description: 应用所代表的模块
	 * @author(作者): wyq
	 * @param: @param appModule
	 * @return: void
	 * @throws
	 */
	public void setAppModule(String appModule) {
		this.appModule = appModule == null ? null : appModule.trim();
	}

	/**
	 * 
	 * @Title: getAppIcon
	 * @Description: 应用的图标
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppIcon() {
		return appIcon;
	}

	/**
	 * 
	 * @Title: setAppIcon
	 * @Description: 应用的图标
	 * @author(作者): wyq
	 * @param: @param appIcon
	 * @return: void
	 * @throws
	 */
	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon == null ? null : appIcon.trim();
	}

	/**
	 * 
	 * @Title: getAppUrl
	 * @Description: 如果应用是打开连接地址的，则不为空
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppUrl() {
		return appUrl;
	}

	/**
	 * 
	 * @Title: setAppUrl
	 * @Description: 如果应用是打开连接地址的，则不为空
	 * @author(作者): wyq
	 * @param: @param appUrl
	 * @return: void
	 * @throws
	 */
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl == null ? null : appUrl.trim();
	}

	/**
	 * 
	 * @Title: getAppDesc
	 * @Description: 应用的描述
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppDesc() {
		return appDesc;
	}

	/**
	 * 
	 * @Title: setAppDesc
	 * @Description: 应用的描述
	 * @author(作者): wyq
	 * @param: @param appDesc
	 * @return: void
	 * @throws
	 */
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc == null ? null : appDesc.trim();
	}

	/**
	 * 
	 * @Title: getAppPriv
	 * @Description: TODO
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getAppPriv() {
		return appPriv;
	}

	/**
	 * 
	 * @Title: setAppPriv
	 * @Description: TODO
	 * @author(作者): wyq
	 * @param: @param appPriv
	 * @return: void
	 * @throws
	 */
	public void setAppPriv(String appPriv) {
		this.appPriv = appPriv == null ? null : appPriv.trim();
	}
}
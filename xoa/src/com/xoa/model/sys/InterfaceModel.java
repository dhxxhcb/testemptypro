package com.xoa.model.sys;


import java.io.Serializable;

public class InterfaceModel implements Serializable {
    /**
     * IE浏览器窗口标题
     */
    private String ieTitle;

    /**
     * 状态栏文字
     */
    private String statusText;

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    /**
     * 主界面顶部大标题文字
     */
    private String bannerText;

    /**
     * 字体
     */
    private String bannerFont;

    /**
     * 主界面顶部图标ID
     */
    private String attachmentId;

    /**
     * 主界面顶部图标NAME
     */
    private String attachmentName;

    /**
     * 主界面顶部图标宽度
     */
    private Integer imgWidth;

    /**
     * 主界面顶部图标高度
     */
    private Integer imgHeight;

    /**
     * 登录界面图片ID
     */
    private String attachmentId1;

    /**
     * 登录界面图片NAME
     */
    private String attachmentName1;

    /**
     * 允许用户上传头像(1-允许,0-不允许)
     */
    private String avatarUpload;

    /**
     * 用户上传头像最大宽度
     */
    private Integer avatarWidth;

    /**
     * 用户上传头像最大高度
     */
    private Integer avatarHeight;

    /**
     * 选择界面布局
     */
    private String loginInterface;

    /**
     * 默认界面布局
     */
    private String ui;

    /**
     * 是否允许用户选择界面主题(1-允许,0-不允许)
     */
    private String themeSelect;

    /**
     * 默认界面主题
     */
    private String theme;

    /**
     * 登录界面模板
     */
    private String template;

    private String weatherCity;

    /**
     * 允许用户使用今日资讯
     */
    private String showRss;

    /**
     * 在设置顶部图标时增加是否应用到tos
     */
    private Boolean imgTos;

    private static final long serialVersionUID = 1L;

    public String getIeTitle() {
        return ieTitle;
    }

    public void setIeTitle(String ieTitle) {
        this.ieTitle = ieTitle == null ? null : ieTitle.trim();
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText == null ? null : bannerText.trim();
    }

    public String getBannerFont() {
        return bannerFont;
    }

    public void setBannerFont(String bannerFont) {
        this.bannerFont = bannerFont == null ? null : bannerFont.trim();
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    public String getAttachmentId1() {
        return attachmentId1;
    }

    public void setAttachmentId1(String attachmentId1) {
        this.attachmentId1 = attachmentId1 == null ? null : attachmentId1.trim();
    }

    public String getAttachmentName1() {
        return attachmentName1;
    }

    public void setAttachmentName1(String attachmentName1) {
        this.attachmentName1 = attachmentName1 == null ? null : attachmentName1.trim();
    }

    public String getAvatarUpload() {
        return avatarUpload;
    }

    public void setAvatarUpload(String avatarUpload) {
        this.avatarUpload = avatarUpload == null ? null : avatarUpload.trim();
    }

    public Integer getAvatarWidth() {
        return avatarWidth;
    }

    public void setAvatarWidth(Integer avatarWidth) {
        this.avatarWidth = avatarWidth;
    }

    public Integer getAvatarHeight() {
        return avatarHeight;
    }

    public void setAvatarHeight(Integer avatarHeight) {
        this.avatarHeight = avatarHeight;
    }

    public String getLoginInterface() {
        return loginInterface;
    }

    public void setLoginInterface(String loginInterface) {
        this.loginInterface = loginInterface == null ? null : loginInterface.trim();
    }

    public String getUi() {
        return ui;
    }

    public void setUi(String ui) {
        this.ui = ui == null ? null : ui.trim();
    }

    public String getThemeSelect() {
        return themeSelect;
    }

    public void setThemeSelect(String themeSelect) {
        this.themeSelect = themeSelect == null ? null : themeSelect.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    public String getWeatherCity() {
        return weatherCity;
    }

    public void setWeatherCity(String weatherCity) {
        this.weatherCity = weatherCity == null ? null : weatherCity.trim();
    }

    public String getShowRss() {
        return showRss;
    }

    public void setShowRss(String showRss) {
        this.showRss = showRss == null ? null : showRss.trim();
    }

    public Boolean getImgTos() {
        return imgTos;
    }

    public void setImgTos(Boolean imgTos) {
        this.imgTos = imgTos;
    }


}
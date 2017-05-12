package com.xoa.util;

import java.util.ArrayList;
import java.util.List;

import com.xoa.model.enclosure.Attachment;
import com.xoa.util.common.StringUtils;

public class GetAttachmentListUtil {

	public static final String MODULE_EMAIL="email"; //电子邮件
	public static final String MODULE_WORKFLOW="workflow"; //工作流
	public static final String MODULE_FILE_FOLDER="file_folder"; //文件柜
	public static final String MODULE_NOTIFY="notify"; //公告通知
	public static final String MODULE_NEWS="news"; //新闻
	public static final String MODULE_DIARY="diary"; //工作日志
	public static final String MODULE_BBS="bbs"; //讨论区
	public static final String MODULE_BOOK="book"; //图书管理
	public static final String MODULE_CRM="crm"; //CRM
	public static final String MODULE_DOCUMENT="document"; //公文管理
	public static final String MODULE_FAX="fax"; //电子传真
	public static final String MODULE_HR="hr"; //人力资源
	public static final String MODULE_MEETING="meeting"; //会议管理
	public static final String MODULE_OFFICE_PRODUCT="office_product"; //办公用品
	public static final String MODULE_PROJECT="project"; //项目管理
	public static final String MODULE_REPORTSHOP="reportshop"; //报表管理
	public static final String MODULE_ROLL_MANAGE="roll_manage"; //档案管理
	public static final String MODULE_SALE_MANAGE="sale_manage"; //销售管理
	public static final String MODULE_TRAINING="training"; //培训管理
	public static final String MODULE_VEHICLE="vehicle"; //车辆管理
	public static final String MODULE_VOTE="vote"; //投票
	public static final String MODULE_WORK_PLAN="work_plan"; //工作计划
	public static final String MODULE_ZHIDAO="zhidao"; //OA知道
	public static final String MODULE_UNIT="unit"; //单位管理
	public static final String MODULE_MODEL="model"; //Word模板
	public static final String MODULE_IM="im"; //即时通讯
	public static final String MODULE_EXT_DATA="ext_data"; //数据交互平台
	public static final String MODULE_ASSET="asset"; //固定资产
	public static final String MODULE_UNKNOWN="unknown"; //其它
	public static final String MODULE_ADDRESS="address"; //通讯簿
	public static final String MODULE_VOICEMSG="voicemsg"; //语音微讯
	public static final String MODULE_PORTAL="portal"; //门户
	public static final String MODULE_WEIXUNSHARE="weixunshare"; //微讯分享
	public static final String MODULE_SAFEDOC="safedoc"; //安全文档中心
	public static final String MODULE_UPLOAD_TEMP="upload_temp"; //临时文件夹
	public static final String MODULE_ITASK="itask"; //智协同

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-27 下午1:56:05
	 * 方法介绍:   返回附件集合
	 * 参数说明:   @param attachmentName
	 * 参数说明:   @param attachmentId
	 * 参数说明:   @return
	 * @return     List<Attachment>
	 */
	public static List<Attachment> returnAttachment(String attachmentName,String attachmentId,String sqlType,String module){
		List<Attachment> list = new ArrayList<Attachment>();
		if(StringUtils.checkNull(attachmentId) && StringUtils.checkNull(attachmentName)){
			return list;
		}else{
			String[] attachmentIds = attachmentId.split(",");
			String[] attachmentNames = attachmentName.split("\\*");
			int attachmentidLength = attachmentIds.length;
			for(int i = 0 ; i <attachmentidLength ; i++){
				Attachment att = new Attachment();
				att.setAttachName(attachmentNames[i]);
				att.setAid(Integer.valueOf(attachmentIds[i].substring(0, attachmentIds[i].lastIndexOf("@"))));
				att.setYm(attachmentIds[i].substring(attachmentIds[i].indexOf("@")+1,attachmentIds[i].lastIndexOf("_")));
				att.setAttachId(Integer.valueOf(attachmentIds[i].substring(attachmentIds[i].indexOf("_")+1,attachmentIds[i].length())));
				att.setAttUrl("AID="+att.getAid()+"&COMPANY="+sqlType+"&YM="+att.getYm()+"&ATTACHMENT_ID="+att.getAttachId()+"&ATTACHMENT_NAME="+att.getAttachName()+"&MODULE="+module);
				list.add(att);
			}
			return list;
		}
		
		
	}
}

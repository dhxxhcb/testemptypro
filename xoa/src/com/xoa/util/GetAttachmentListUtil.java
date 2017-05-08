package com.xoa.util;

import java.util.ArrayList;
import java.util.List;

import com.xoa.model.enclosure.Attachment;
import com.xoa.util.common.StringUtils;

public class GetAttachmentListUtil {
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
	public static List<Attachment> returnAttachment(String attachmentName,String attachmentId,String sqlType){
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
				att.setAttUrl("AID="+att.getAid()+"&COMPANY="+sqlType+"&YM="+att.getYm()+"&ATTACHMENT_ID="+att.getAttachId()+"&ATTACHMENT_NAME="+att.getAttachName());
				list.add(att);
			}
			return list;
		}
		
		
	}
}

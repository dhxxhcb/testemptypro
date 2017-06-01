package com.xoa.dao.im;

import java.util.List;
import java.util.Map;

import com.xoa.model.im.ImMessage;
import com.xoa.model.im.ImRoom;

public interface ImMessageMapper {

	int deleteByUuid(Map<String, String> map);

	List<ImMessage> getMessageList(Map<String, Object> map);

	int save(ImMessage record);

	ImMessage getLastMessage(Map<String, Object> map);

	List<ImMessage> selectMessageByPage(Map<String, Object> map);
	
}
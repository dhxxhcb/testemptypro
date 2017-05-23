package com.xoa.dao.im;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.xoa.model.im.ImChatList;


public interface ImChatListMapper {

	int saveChat(ImChatList chatModel);

	ImChatList getSingleObject(Map<String, Object> map);

	int updateChatlist(ImChatList chatModel);

	List<Object> getChatList(Map<String, Object> map);
   
}
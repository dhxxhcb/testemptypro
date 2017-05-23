package com.xoa.dao.im;

import java.util.List;
import java.util.Map;

import com.xoa.model.im.ImRoom;



public interface ImRoomMapper {
	List<ImRoom> getAllRoom(Map<String, String> map);

	ImRoom getRoomByRoomOf(Map<String, String> map);

	int roomUpdateInvite(Map<String, String> map);

	int saveRoom(ImRoom ir);

	int roomUpdateByroomOf(ImRoom irm);

	int updateRoomName(ImRoom irm);

	int updatePersonToRoom(ImRoom irm);
}
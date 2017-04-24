package com.xoa.dao.im;

import com.xoa.model.im.ImChatList;
import com.xoa.model.im.ImChatListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImChatListMapper {
    int countByExample(ImChatListExample example);

    int deleteByExample(ImChatListExample example);

    int deleteByPrimaryKey(Integer listId);

    int insert(ImChatList record);

    int insertSelective(ImChatList record);

    List<ImChatList> selectByExampleWithBLOBs(ImChatListExample example);

    List<ImChatList> selectByExample(ImChatListExample example);

    ImChatList selectByPrimaryKey(Integer listId);

    int updateByExampleSelective(@Param("record") ImChatList record, @Param("example") ImChatListExample example);

    int updateByExampleWithBLOBs(@Param("record") ImChatList record, @Param("example") ImChatListExample example);

    int updateByExample(@Param("record") ImChatList record, @Param("example") ImChatListExample example);

    int updateByPrimaryKeySelective(ImChatList record);

    int updateByPrimaryKeyWithBLOBs(ImChatList record);

    int updateByPrimaryKey(ImChatList record);
}
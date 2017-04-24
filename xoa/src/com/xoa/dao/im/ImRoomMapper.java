package com.xoa.dao.im;

import com.xoa.model.im.ImRoom;
import com.xoa.model.im.ImRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImRoomMapper {
    int countByExample(ImRoomExample example);

    int deleteByExample(ImRoomExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(ImRoom record);

    int insertSelective(ImRoom record);

    List<ImRoom> selectByExample(ImRoomExample example);

    ImRoom selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") ImRoom record, @Param("example") ImRoomExample example);

    int updateByExample(@Param("record") ImRoom record, @Param("example") ImRoomExample example);

    int updateByPrimaryKeySelective(ImRoom record);

    int updateByPrimaryKey(ImRoom record);
}
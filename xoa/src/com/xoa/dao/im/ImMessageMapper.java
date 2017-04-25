package com.xoa.dao.im;

import com.xoa.model.im.ImMessage;
import com.xoa.model.im.ImMessageExample;
import com.xoa.model.im.ImMessageWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImMessageMapper {
	
	int deleteByUUID(@Param("fromId")String fromId,@Param("uuid")String uuid);
	
    int countByExample(ImMessageExample example);
 
    int deleteByExample(ImMessageExample example);

    int deleteByPrimaryKey(Integer imid);

    int insert(ImMessageWithBLOBs record);

    int insertSelective(ImMessageWithBLOBs record);

    List<ImMessageWithBLOBs> selectByExampleWithBLOBs(ImMessageExample example);

    List<ImMessage> selectByExample(ImMessageExample example);

    ImMessageWithBLOBs selectByPrimaryKey(Integer imid);

    int updateByExampleSelective(@Param("record") ImMessageWithBLOBs record, @Param("example") ImMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") ImMessageWithBLOBs record, @Param("example") ImMessageExample example);

    int updateByExample(@Param("record") ImMessage record, @Param("example") ImMessageExample example);

    int updateByPrimaryKeySelective(ImMessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ImMessageWithBLOBs record);

    int updateByPrimaryKey(ImMessage record);
}
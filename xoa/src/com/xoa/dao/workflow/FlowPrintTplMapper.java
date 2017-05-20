package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowPrintTpl;
import com.xoa.model.workflow.FlowPrintTplExample;
import com.xoa.model.workflow.FlowPrintTplWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowPrintTplMapper {
    int countByExample(FlowPrintTplExample example);

    int deleteByExample(FlowPrintTplExample example);

    int deleteByPrimaryKey(Integer tId);

    int insert(FlowPrintTplWithBLOBs record);

    int insertSelective(FlowPrintTplWithBLOBs record);

    List<FlowPrintTplWithBLOBs> selectByExampleWithBLOBs(FlowPrintTplExample example);

    List<FlowPrintTpl> selectByExample(FlowPrintTplExample example);

    FlowPrintTplWithBLOBs selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") FlowPrintTplWithBLOBs record, @Param("example") FlowPrintTplExample example);

    int updateByExampleWithBLOBs(@Param("record") FlowPrintTplWithBLOBs record, @Param("example") FlowPrintTplExample example);

    int updateByExample(@Param("record") FlowPrintTpl record, @Param("example") FlowPrintTplExample example);

    int updateByPrimaryKeySelective(FlowPrintTplWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FlowPrintTplWithBLOBs record);

    int updateByPrimaryKey(FlowPrintTpl record);
}
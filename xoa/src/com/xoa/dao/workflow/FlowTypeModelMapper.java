package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowTypeModel;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface FlowTypeModelMapper extends BaseMapper<FlowTypeModel>{

   List<FlowTypeModel> selectBySortid(@Param("flowId") Integer flowId);

    List<FlowTypeModel> selectBySearch(@Param("searchValue")String searchValue, @Param("sortId")Integer sortId);

    List<FlowTypeModel> selectFlowAuthOrSearch(Map<String,Object> map);
//    int deleteByPrimaryKey(Integer flowId);

//    int insert(FlowTypeModelWithBLOBs record);
//
//    int insertSelective(FlowTypeModelWithBLOBs record);
//
//    FlowTypeModelWithBLOBs selectByPrimaryKey(Integer flowId);
//
//    int updateByPrimaryKeySelective(FlowTypeModelWithBLOBs record);
//
//    int updateByPrimaryKeyWithBLOBs(FlowTypeModelWithBLOBs record);
//
//    int updateByPrimaryKey(FlowTypeModel record);
}
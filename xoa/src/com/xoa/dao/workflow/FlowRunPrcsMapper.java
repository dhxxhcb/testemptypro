package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.model.workflow.FlowRunPrcsExcted;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FlowRunPrcsMapper extends BaseMapper<FlowRunPrcs>{

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:16
     * 方法介绍:   查询完结工作
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs>  selectEnd(Map<String,Object> maps);

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/25 15:46
     * 方法介绍:   查询挂起工作
     * 参数说明:   
     * @return     
     */
    public List<FlowRunPrcs> selectHang(Map<String,Object> maps);

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/25 17:04
     * 方法介绍:   查询所有工作
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs> selectAll(Map<String,Object> maps);

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/1 10:45
     * 方法介绍:   查询上一步办结时间
     * 参数说明:
     * @return
     */
    public String findTime(@Param("prcsId") Integer prcsId, @Param("runId")Integer runId);

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017/6/1 17:03
     * 方法介绍:   根据runId查询流程实例步骤信息
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs> findByRunId(Integer runId);
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017/6/2 11:44
     * 方法介绍:   根据流程实例Id和流程实例步骤id查询
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs> selectfrp(Map<String,Object> maps);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowRunPrcs record);

    int insertSelective(FlowRunPrcs record);

    FlowRunPrcs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowRunPrcsExcted record);

    int updateByPrimaryKey(FlowRunPrcs record);

    int updateSql(Map<String,Object> map);
}
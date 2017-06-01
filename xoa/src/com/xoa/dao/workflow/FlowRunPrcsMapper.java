package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowRunPrcs;

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
     * 方法介绍:   根据runId查询关联办理人的步骤和所在部门
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs> findAllNode(Integer runId);

    /**
     * 创建作者:   zlf
     * 创建日期:   2017/6/1 17:03
     * 方法介绍:   根据runId查询流程实例步骤信息
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs> findByRunId(Integer runId);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowRunPrcs record);

    int insertSelective(FlowRunPrcs record);

    FlowRunPrcs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowRunPrcs record);

    int updateByPrimaryKey(FlowRunPrcs record);
}
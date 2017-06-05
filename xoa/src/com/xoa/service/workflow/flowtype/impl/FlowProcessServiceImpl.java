package com.xoa.service.workflow.flowtype.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.workflow.FlowTiggerMapper;
import com.xoa.model.department.Department;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.model.workflow.FlowTiggerModel;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.util.common.L;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xoa.dao.workflow.FlowProcessMapper;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowProcessList;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;

@Service
public class FlowProcessServiceImpl implements FlowProcessService {

    @Resource
    private FlowProcessMapper flowProcessMapper;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private UsersPrivService usersPrivService;

    @Resource
    private UsersService usersService;

    @Resource
    private FlowTiggerMapper flowTiggerMapper;


    @Override
    public FlowProcess find(int id) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("id", id);
        FlowProcess flowProcess = flowProcessMapper.find(maps);
        return flowProcess;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:  2017年5月10日 上午11:18:20
     * 方法介绍:   （修改后保存）在6/3修改补充json解析，并完善已知bug(张勇)
     * 参数说明:
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<FlowProcess> updateByPrimaryKeySelective(FlowProcess record) {
        ToJson<FlowProcess> tojson = new ToJson<FlowProcess>();
        try {
            L.a("itemId：" + record.getITEM_ID());
            L.a("autoPrcsUser：" + record.getAUTO_PRCS_USER());

            // 解析页面json串
            if (!StringUtils.checkNull(record.getSettlementOfCondition())) {
                String tlement = record.getSettlementOfCondition();
                String intoTheCondition = JSONArray.parseObject(tlement).getString("intoTheCondition");
                String transferConditions = JSONArray.parseObject(tlement).getString("transferConditions");
                if (!StringUtils.checkNull(JSONArray.parseObject(intoTheCondition).getString("list")) && !StringUtils.checkNull(JSONArray.parseObject(transferConditions).getString("list"))) {
                    record.setPrcsIn(JSONArray.parseObject(intoTheCondition).getString("list") + "\n" + JSONArray.parseObject(transferConditions).getString("list"));
                } else if (!StringUtils.checkNull(JSONArray.parseObject(intoTheCondition).getString("list"))) {
                    record.setPrcsIn(JSONArray.parseObject(intoTheCondition).getString("list"));
                } else if (!StringUtils.checkNull(JSONArray.parseObject(transferConditions).getString("list"))) {
                    record.setPrcsOut(JSONArray.parseObject(transferConditions).getString("list"));
                }

                if (!StringUtils.checkNull(JSONArray.parseObject(intoTheCondition).getString("prcsInSet"))) {
                    record.setPrcsInSet(JSONArray.parseObject(intoTheCondition).getString("prcsInSet"));
                }
                if (!StringUtils.checkNull(JSONArray.parseObject(intoTheCondition).getString("conditionDesc"))) {
                    record.setConditionDesc(JSONArray.parseObject(intoTheCondition).getString("conditionDesc"));
                }

                if (!StringUtils.checkNull(JSONArray.parseObject(transferConditions).getString("prcsOutSet"))) {
                    record.setPrcsOutSet(JSONArray.parseObject(transferConditions).getString("prcsOutSet"));
                }

                if (!StringUtils.checkNull(JSONArray.parseObject(transferConditions).getString("conditionDesc"))) {
                    record.setConditionDesc(JSONArray.parseObject(transferConditions).getString("conditionDesc"));
                }
            }
            // 解析页面json串
            if (!StringUtils.checkNull(record.getPrcsItemTwo())) {
                String prcsItem = record.getPrcsItemTwo();
                if (!StringUtils.checkNull(JSONArray.parseObject(prcsItem).getString("prcsItem"))) {
                    record.setPrcsItem(JSONArray.parseObject(prcsItem).getString("prcsItem"));
                }
                if (!StringUtils.checkNull(JSONArray.parseObject(prcsItem).getString("attachPriv"))) {
                    record.setAttachPriv(JSONArray.parseObject(prcsItem).getString("attachPriv"));
                }
                if (!StringUtils.checkNull(JSONArray.parseObject(prcsItem).getString("attachEditPriv"))) {
                    record.setAttachEditPriv(JSONArray.parseObject(prcsItem).getString("attachEditPriv"));
                }
                if (!StringUtils.checkNull(JSONArray.parseObject(prcsItem).getString("attachEditPrivOnline"))) {
                    record.setAttachEditPrivOnline(JSONArray.parseObject(prcsItem).getString("attachEditPrivOnline"));
                }
                if (!StringUtils.checkNull(JSONArray.parseObject(prcsItem).getString("attachMacroMark"))) {
                    record.setAttachMacroMark(JSONArray.parseObject(prcsItem).getString("attachMacroMark"));
                }
            }
            if (!StringUtils.checkNull(record.getITEM_ID())) {
                record.setAutoUser(record.getITEM_ID());
            }
            if (!StringUtils.checkNull(record.getITEM_ID())) {
                record.setAutoUser(record.getITEM_ID());
            }
            flowProcessMapper.updateByPrimaryKeySelective(record);
            tojson.setFlag(0);
            tojson.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;
    }

    @Override
    public List<FlowProcess> findFlowId(int flowId) {
        List<FlowProcess> list = flowProcessMapper.findFlowId(flowId);
        return list;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月22日 上午9:44:40
     * 方法介绍:   删除流程
     * 参数说明:   @param id
     *
     * @return void
     */
    @Override
    @Transactional
    public ToJson<FlowProcess> delete(int id) {
        ToJson<FlowProcess> toJson = new ToJson<FlowProcess>();
        try {
            flowProcessMapper.deleteByPrimaryKey(id);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }


    @Override
    public FlowProcessList flowView(int flowId) {
        //定义用于返回的流程信息
        FlowProcessList f = new FlowProcessList();
        Map<String, String> map = null;
        //定义
        List<Map<String, String>> lm = new ArrayList<Map<String, String>>();
        //根据flowId获取流程信息
        List<FlowProcess> list = flowProcessMapper.findF(flowId);
        int len = list.size();
        //f.setFlowName(list.get(0).getFlowName());
        list.get(len - 1).setSetType("end round");
        list.get(0).setSetType("start");
        for (int i = 0; i < len; i++) {
            Integer prId = list.get(i).getPrcsId();
            String prceTo = list.get(i).getPrcsTo();
            if (StringUtils.checkNull(prceTo)) {
                map = new HashMap<String, String>();
                map.put("from", Integer.toString(prId));
                if (i < len - 1) {
                    if (list.get(i + 1).getPrcsId() == prId + 1) {
                        map.put("to", Integer.toString(list.get(i + 1).getPrcsId()));
                    }
                } else {
                    map.put("to", "end");
                }
                lm.add(map);
            } else {
                String[] p = prceTo.split(",");
                for (String a : p) {
                    if(!"0".equals(a)) {
                        map = new HashMap<String, String>();
                        map.put("from", Integer.toString(prId));
                        map.put("to", a.toString());
                        lm.add(map);
                    }else {
                        map = new HashMap<String, String>();
                        map.put("from", Integer.toString(prId));
                        map.put("to", "end");
                        list.get(i).setSetType("end round");
                        lm.add(map);
                    }
                }
            }
        }
        List<FlowProcess> listp = new ArrayList<>();
        //添加汉字转换方法
        for (FlowProcess flowProcess : list) {
            if (!StringUtils.checkNull(flowProcess.getPrcsDept())) {
                flowProcess.setPrcsDeptName(departmentService.getDeptNameByDeptId(flowProcess.getPrcsDept(), ","));
            }
            if (!StringUtils.checkNull(flowProcess.getPrcsPriv())) {
                flowProcess.setPrcsPrivName(usersPrivService.getPrivNameByPrivId(flowProcess.getPrcsPriv(), ","));
            }
            if (!StringUtils.checkNull(flowProcess.getPrcsUser())) {
                flowProcess.setPrcsUserName(usersService.getUserNameById(flowProcess.getPrcsUser()));
            }
//            FlowTiggerModel flowTiggerModel = flowTiggerMapper.selectFlowTigger(flowProcess.getFlowId(),flowProcess.getPrcsId());



            listp.add(flowProcess);
        }
        f.setConnections(lm);
        f.setDesigndata(listp);
        f.setMax(listp.size());
        return f;
    }

    @Override
    @Transactional
    public ToJson<FlowProcess> insertSelective(FlowProcess record) {
        ToJson<FlowProcess> toJson = new ToJson<FlowProcess>();
        try {
            flowProcessMapper.insert(record);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    @Override
    public FlowProcess findbyprcsId(int flowId, int prcsId) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("folwId", flowId);
        maps.put("prcsId", prcsId);
        FlowProcess flowProcess = flowProcessMapper.find(maps);
        return flowProcess;
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/3 11:24
     * 方法介绍:   修改流程节点坐标
     * 参数说明:
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<FlowProcess> updateTopAndLeft(FlowProcess flowProcess) {
        ToJson<FlowProcess> toJson = new ToJson<FlowProcess>();
        try {
            flowProcessMapper.updateTopAndLeft(flowProcess);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setTotleNum(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    /**
     * 部门id转换为部门名字
     *
     * @param name
     * @return
     */
    public String deptName(String name) {
        String deptName = null;
//        getDeptNameById
        return deptName;
    }


}

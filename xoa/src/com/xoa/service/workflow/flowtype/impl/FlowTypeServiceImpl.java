package com.xoa.service.workflow.flowtype.impl;

import com.xoa.dao.workflow.FlowSortMapper;
import com.xoa.dao.workflow.FlowTypeModelMapper;
import com.xoa.model.users.Users;
import com.xoa.model.workflow.FlowSort;
import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.JobClassifyService;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.page.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/5/8 16:43
 * 类介绍  :
 * 构造参数:
 */
@Service
public class FlowTypeServiceImpl implements FlowTypeService {

    @Resource
    private FlowTypeModelMapper flowTypeModelMapper;
    @Autowired
    JobClassifyService classifyService;


    @Override
    @Transactional
    public ToJson<FlowTypeModel> saveFlow(FlowTypeModel flowTypeModel) {
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
        try {
            flowTypeModelMapper.save(flowTypeModel);
            toJson.setMsg("ok");
            toJson.setFlag(0);
        } catch (Exception e) {
            L.e("保存异常："+e);
            toJson.setMsg("error");
            toJson.setFlag(1);
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/23 17:31
     * 方法介绍:   自定义属性所有查询，根据flowId
     * 参数说明:
     *
     * @return
     */
    @Override
    public ToJson<FlowTypeModel> selectAllFlow(Map<String, Object> maps) {
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(false);
        pageParams.setPage(1);
        pageParams.setPageSize(5);
        maps.put("page", pageParams);
        try {
            toJson.setObject(flowTypeModelMapper.queryOne(maps));
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    @Override
    public ToJson<FlowTypeModel> quertBySortId(Integer flowId) {
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();

        List<FlowTypeModel> datas = flowTypeModelMapper.selectBySortid(flowId);
        if (datas != null && datas.size() > 0) {
            toJson.setObj(datas);
            toJson.setFlag(0);
            toJson.setMsg("success");
        } else {
            toJson.setFlag(1);
            toJson.setMsg("no data");
        }

        return toJson;
    }

    @Override
    public ToJson<FlowTypeModel> flowBySearch(String searchValue, Integer flowId) {

        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
        if (StringUtils.checkNull(searchValue)) {
            toJson.setFlag(1);
            toJson.setMsg("搜索字段不能为空");
            return toJson;
        }

        List<FlowTypeModel> datas = flowTypeModelMapper.selectBySearch(searchValue, flowId);
        if (datas != null && datas.size() > 0) {
            toJson.setObj(datas);
            toJson.setFlag(0);
            toJson.setMsg("success");
        } else {
            toJson.setFlag(1);
            toJson.setMsg("no data");
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/23 19:35
     * 方法介绍:   自定义属性根据flowId修改
     * 参数说明:
     * @return
     */
    @SuppressWarnings("all")
    @Override
    @Transactional
    public ToJson<FlowTypeModel> updateFlow(FlowTypeModel flowTypeModel){
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
        try{
            flowTypeModelMapper.update(flowTypeModel);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        }catch (Exception e){
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    @Override
    public ToJson<FlowTypeModel> selectFlowAuthOrSearch(HttpServletRequest request, String searchValue, Integer sortId){
        Map<String,Object> param =new HashMap<String,Object>();
        ToJson<FlowTypeModel> toJson =new ToJson<FlowTypeModel>();
        Users user= SessionUtils.getSessionInfo(request.getSession(),Users.class,new Users());
        if(user.getUid()==null){
            toJson.setFlag(1);
            toJson.setMsg("无法获取用户信息");
            return toJson;
        }

        List<Integer> sirtIds = classifyService.getSortChildId(sortId,new ArrayList<>());
        StringBuffer sirtIdsTr =new StringBuffer();
        int i=0;
        for(Integer integer:sirtIds){
            sirtIdsTr.append(integer);
            if(i!=sirtIds.size()){
                sirtIdsTr.append(",");
            }
                i++;
        }
        Integer[] arry=new Integer[]{};
        arry=sirtIds.toArray(arry);
        String privOther= user.getUserPrivOther()==null?"":user.getUserPrivOther();//辅助角色
        String privIds[] =privOther.split(",");
        String deptOther = user.getDeptIdOther()==null?"":user.getDeptIdOther();//辅助部门
        String deptIds[] =deptOther.split(",");
        param.put("user", user.getUserId()==null?"":user.getUserId());
        param.put("deptId",user.getDeptId()==null?"":user.getDeptId());
        param.put("privId", user.getUserPriv()==null?"":user.getUserPriv());
        if(privIds!=null&&privIds.length>0){
            param.put("privIds",privIds);
        }
        if(deptIds!=null&&deptIds.length>0){
            param.put("deptIds",deptIds);
        }
        param.put("searchValue",searchValue);
        L.w(arry);
        if(sortId!=null){
            param.put("sortId",sirtIdsTr.toString());
        }

        List<FlowTypeModel> datas = flowTypeModelMapper.selectFlowAuthOrSearch(param);

        if(datas!=null&&datas.size()>0){
            toJson.setFlag(0);
            toJson.setMsg("成功");
            toJson.setObj(datas);
        }else{
            toJson.setFlag(1);
            toJson.setMsg("失败");
        }
        return toJson;
    }



}

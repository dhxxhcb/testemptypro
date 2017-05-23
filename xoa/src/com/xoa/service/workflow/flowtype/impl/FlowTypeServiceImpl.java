package com.xoa.service.workflow.flowtype.impl;

import com.xoa.dao.workflow.FlowTypeModelMapper;
import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.page.PageParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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


    @Override
    @Transactional
    public ToJson<FlowTypeModel> saveFlow(FlowTypeModel flowTypeModel) {
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
        try {
            flowTypeModelMapper.save(flowTypeModel);
            toJson.setMsg("ok");
            toJson.setFlag(0);
        } catch (Exception e) {
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
}

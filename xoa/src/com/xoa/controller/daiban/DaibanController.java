package com.xoa.controller.daiban;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.daiban.Daiban;
import com.xoa.model.department.Department;
import com.xoa.model.users.Users;
import com.xoa.service.daiban.DaibanService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value="prototype")
public class DaibanController {
	
	private Logger loger = Logger.getLogger(DaibanController.class);
	
	@Resource
	private DaibanService daibanService;
	
	@ResponseBody
	@RequestMapping(value = "/daiban/list",produces = {"application/json;charset=UTF-8"})
    public ToJson<Daiban> list(HttpServletRequest request,String userId) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Daiban> json=new ToJson<Daiban>(0, null);
		try {
			
			
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("fromId", userId);
			Daiban d=daibanService.list(maps);
            json.setObject(d);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }

}

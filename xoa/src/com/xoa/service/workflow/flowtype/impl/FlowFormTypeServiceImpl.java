package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xoa.model.department.Department;
import com.xoa.model.users.UserPriv;
import com.xoa.model.users.Users;
import com.xoa.model.workflow.TMacroCtrl;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.util.DateFormat;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import org.springframework.messaging.simp.user.UserSessionRegistry;
import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowFormTypeMapper;
import com.xoa.model.workflow.FlowFormType;
import com.xoa.service.workflow.flowtype.FlowFormTypeService;
import com.xoa.util.ToJson;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gsb on 2017/5/9.
 */
@Service
public class FlowFormTypeServiceImpl implements FlowFormTypeService {
	 @Resource
	 private FlowFormTypeMapper  flowFormTypeMapper;
    @Resource
    private UsersService usersService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private UsersPrivService usersPrivService;




	@Override
	public ToJson<FlowFormType> qureyItemMax(Integer formId) {
		ToJson<FlowFormType>  toJson=new ToJson<FlowFormType>(0, "");
		if (formId!=null) {
		FlowFormType folw = flowFormTypeMapper.qureyItemMax(formId);
		if(folw!=null){
			toJson.setMsg("ok");
			toJson.setObject(folw);
           }
		/*if (folw!=null) {
		folw.setItemMax(folw.getItemMax()+1);
		int a= flowFormTypeMapper.updateItemMax(folw);
		if(a>0) {
		toJson.setMsg("ok");
		toJson.setObject(folw);
		}else{
			toJson.setMsg("err");
		}
		
		}*/
		
		}else {
			toJson.setMsg("err");
		}
		 
		
		 return toJson;
	}

	@Override
	public ToJson<TMacroCtrl> qureyCtrl(String controlId,String option,HttpServletRequest request) {
        Users  users= SessionUtils.getSessionInfo(request.getSession(), Users.class,new Users());
        String[] strArray = null;
		ToJson<TMacroCtrl>  json=new ToJson<TMacroCtrl>();
		TMacroCtrl   tM=new TMacroCtrl();
        Date  curDate   =   new   Date();//获取当前时间
        Map<String, Object> maps=new HashMap<>();
        if (tM.getControlId().equals(controlId)){
            tM.setSYS_USERID(users.getUserId());
            tM.setSYS_USERNAME(users.getUserName());
            tM.setSYS_DEPTNAME(users.getDep().getDeptName());
            tM.setSYS_DEPTNAME_SHORT(users.getDep().getDeptName());
            tM.setSYS_USERPRIV(users.getUserPrivName());
            tM.setSYS_USERPRIVOTHER(users.getUserPrivName());
            tM.setSYS_USERNAME_DATE(users.getUserName()+ DateFormat.getStrDate(curDate));
            strArray= option.split(",");
            for(int j = 0; j < strArray.length; j++){
                L.a("ASASASASASA"+strArray[j]);
                if ("SYS_LIST_DEPT".equals(strArray[j])) {
                    List<Department> deptList = departmentService.getDatagrid();
                    tM.setSYS_LIST_DEPT(deptList);
                }
                if("SYS_LIST_USER".equals(strArray[j])){
                    List<Users> list=usersService.getAlluser(maps,1,5,false);
                    tM.setSYS_LIST_USER(list);
                }
                if ("SYS_LIST_PRIV".equals(strArray[j])){
                    List<UserPriv> list=usersPrivService.getAllPriv(maps,1,5,false);
                    tM.setSYS_LIST_PRIV(list);
                }

            }

            json.setFlag(0);
            json.setMsg("ok");
            json.setObject(tM);
        }else {
            json.setFlag(1);
            json.setMsg("err");

        }




		return json;
	}


}

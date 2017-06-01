package com.xoa.controller.netdisk;

import com.xoa.model.netdisk.Catalog;
import com.xoa.model.netdisk.MyNetdisk;
import com.xoa.model.netdisk.Netdisk;
import com.xoa.model.users.Users;
import com.xoa.service.netdisk.NetdiskService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.netdisk.CheckAll;
import com.xoa.util.netdisk.ReadFile;
import org.apache.http.HttpRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by gsb on 2017/6/1.
 */

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/netdisk")
public class NetdiskController {
    @Resource
    private NetdiskService netdiskService;
    @Resource
    private UsersService usersService;
    @Resource
    private UsersPrivService usersPrivService;

    @ResponseBody
    @RequestMapping(value="/selectNetdisk",produces = {"application/json;charset=UTF-8"})
    public  ToJson<Catalog> selectNetdisk(HttpServletRequest request,String path) throws Exception {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Users users = SessionUtils.getSessionInfo(request.getSession(), Users.class,new Users());
        Map<String,Object> map=new Hashtable<String, Object>();
        map.put("userId", users.getUid());
        map.put("userPriv", users.getUserPriv());
        map.put("deptId", users.getDeptId());
        Catalog  catalog=null;
        List<Netdisk>  neList= netdiskService.selectNetdisk();
   for (Netdisk netdisk:neList){
       if (CheckAll.checkAll(netdisk.getUserId(),map)){
      if (!StringUtils.checkNull(path)){
               catalog=ReadFile.getFiles(path);
           }
       }
   }


          ToJson<Catalog> toJson = new ToJson<Catalog>();
       if (catalog!=null){
           toJson.setFlag(0);
           toJson.setMsg("ok");
           toJson.setObject(catalog);
       }else{
           toJson.setFlag(1);
           toJson.setMsg("err");
       }




        return toJson;
    }






}

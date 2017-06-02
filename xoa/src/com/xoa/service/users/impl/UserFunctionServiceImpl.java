package com.xoa.service.users.impl;

import com.xoa.dao.department.DepartmentMapper;
import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.users.UserExtMapper;
import com.xoa.dao.users.UserFunctionMapper;
import com.xoa.dao.users.UsersMapper;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.users.UserFunction;
import com.xoa.service.users.UserFunctionService;
import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFunctionServiceImpl implements UserFunctionService {
    @Resource
    private UserFunctionMapper userFunctionMapper;
    @Resource
    private SysFunctionMapper sysFunctionMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private UsersMapper usersMapper;

    @Resource
    private UserExtMapper userExtMapper;

    @Override
    public ToJson<SysFunction> getMenu(int uid) {
        ToJson<SysFunction> toJson = new ToJson<SysFunction>(0, "显示结果");
        String[] strArray = null;
        List<SysFunction> sFunList = sysFunctionMapper.getAll();
        UserFunction uFun = userFunctionMapper.getMenuByUserId(uid);
        strArray = uFun.getUserFunCidStr().split(",");
        List<SysFunction> list1 = new ArrayList<SysFunction>();
        System.out.println(strArray.length);
        for (int j = 0; j < strArray.length; j++) {
            for (int i = j; i < sFunList.size(); i++) {
                System.out.println(sFunList.get(j).getId());
                if (sFunList.get(i).getId().toString().equals(strArray[j])) {
                    //	System.out.println("相等"+sFunList.get(i).getId());
                    list1.add(sFunList.get(i));
                    break;
                }
            }

        }
        toJson.setObj(list1);
        return toJson;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/1 16:50
     * @函数介绍: 根据function功能id查询有此功能的用户（名）
     * @参数说明: @param String fid
     * @return: List<Users></Users>
     */
    @Override
    public List<String> getUserNameByFuncId(String fid) {

        List<String> userNameList = null;
        List<String> uidList = usersMapper.getUserByFuncId(fid);
        if (uidList != null && uidList.size() > 0) {

            List<String> list = new ArrayList<String>();
            for (String uid : uidList) {
                list.add(uid);

            }
            Map<String, List> map = new HashMap<String, List>();
            map.put("ids", list);
            userNameList = usersMapper.findUsersByIds(map);
        }

        return userNameList;


    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/2 14:09
     * @函数介绍: 增加用户的某个菜单权限，user_ext, user_function两张表都要修改
     * @参数说明: String fid ,对应sys_function表的id
     * @参数说明: String uids , 对应user表的user_id，多个用逗号分隔
     * @return: void
     **/
    @Override
    public void updateAuthUser(String fid, String uids) {
        String[] uidArr = null;
        if (uids != null) {
            uidArr = uids.split(",");
        }

        if (uidArr != null && fid != null) {
            for (String userId : uidArr) {
                String userFuncIdStr = userExtMapper.getUserFuncIdStr(userId);
                if (userFuncIdStr != null && "".equals(userFuncIdStr)) {
                    userFuncIdStr = fid.concat(",");

                } else if (userFuncIdStr != null) {
                    if (!userFuncIdStr.contains(",".concat(fid).concat(",")) && !userFuncIdStr.contains("".concat(fid).concat(","))) {
                        userFuncIdStr = userFuncIdStr.concat(fid).concat(",");
                    }
                }


                if (userFuncIdStr != null) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("userId", userId);
                    map.put("userFuncIdStr", userFuncIdStr);
                    userExtMapper.updateUserFuncIdStr(map);

                }


            }
        }

        if (uidArr != null && fid != null) {
            for (String userId : uidArr) {
                String userFuncIdStr = userFunctionMapper.getUserFuncIdStr(userId);
                if (userFuncIdStr != null && "".equals(userFuncIdStr)) {
                    userFuncIdStr = fid.concat(",");

                } else if (userFuncIdStr != null) {
                    userFuncIdStr = userFuncIdStr.concat(fid).concat(",");
                }
                if (userFuncIdStr != null) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("userId", userId);
                    map.put("userFuncIdStr", userFuncIdStr);
                    userFunctionMapper.updateUserFuncIdStr(map);

                }

            }
        }


    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/2 15:26
     * @函数介绍: 删除用户的某项菜单权限（对应user_ext和user_function表）
     * @参数说明: fid 某个某个功能的id, 对应sys_function的id
     * @参数说明: uids 用户的userId多个用逗号分隔。
     * @return: void
     **/
    @Override
    public void deleteAuthUser(String fid, String uids) {
        String[] uidArr = null;
        if (uids != null) {
            uidArr = uids.split(",");
        }

        if (uidArr != null && fid != null) {
            for (String userId : uidArr) {
                String userFuncIdStr = userFunctionMapper.getUserFuncIdStr(userId);
                if (userFuncIdStr != null && (userFuncIdStr.contains(",".concat(fid).concat(",")) || (userFuncIdStr.contains(fid.concat(","))))) {
                    userFuncIdStr = userFuncIdStr.replace(fid.concat(","), "");
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("userId", userId);
                    map.put("userFuncIdStr", userFuncIdStr);
                    userFunctionMapper.updateUserFuncIdStr(map);
                }
            }

            for (String userId : uidArr) {

                String userFuncIdStr = userExtMapper.getUserFuncIdStr(userId);
                if (userFuncIdStr != null && (userFuncIdStr.contains(",".concat(fid).concat(",")) || (userFuncIdStr.contains(fid.concat(","))))) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("userId", userId);
                    userFuncIdStr = userFuncIdStr.replace(fid.concat(","), "");
                    map.put("userFuncIdStr", userFuncIdStr);
                    userExtMapper.updateUserFuncIdStr(map);
                }
            }
        }


    }


}


    /*@Override
    public ToJson<Department> getDep() {
		ToJson<Department> toJson=new ToJson<Department>(0,"显示结果");
		List<Department> dep=departmentMapper.getDatagrid();
		toJson.setObj(dep);
		return toJson;
	}*/
    /*@Override
    public ToJson<Users> getUser(int uid) {
		ToJson<Users> toJson=new ToJson<Users>(0,"显示结果");
		List<Users> userList=departmentMapper.getUserAll(uid);
		toJson.setObj(userList);
		return toJson;
	}}*/

package com.xoa.service.users.impl;

import com.xoa.dao.users.UserPrivMapper;
import com.xoa.model.users.UserPriv;
import com.xoa.service.users.UsersPrivService;
import com.xoa.util.page.PageParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:32:17
 * 类介绍  :    角色权限
 * 构造参数:    无
 */
@Service
public class UsersPrivServiceImpl implements UsersPrivService {
    @Resource
    private UserPrivMapper userPrivMapper;

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:32:42
     * 方法介绍:   格局privid串获取privName
     * 参数说明:   @param privId  角色id串
     * 参数说明:   @return
     *
     * @return String   角色名称串
     */
    @Override
    public String getPrivNameById(int... privId) {
        if (privId == null) {
            return null;
        }
        //定义用于拼接角色名称的字符串
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < privId.length; i++) {
            if (privId.length == 1) {
                String privName = userPrivMapper.getPrivNameById(privId[i]);
                return privName;
            } else {
                String privName = userPrivMapper.getPrivNameById(privId[i]);
                if (i < privId.length - 1) {
                    sb.append(privName).append(",");
                } else {
                    sb.append(privName);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:32:47
     * 方法介绍:   格局userpriv获取用户权限
     * 参数说明:   @param up 角色主键
     * 参数说明:   @return
     *
     * @return UserPriv    返回角色信息
     */
    @Override
    public UserPriv selectByPrimaryKey(int up) {
        UserPriv userPriv = userPrivMapper.selectByPrimaryKey(up);
        return userPriv;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:32:51
     * 方法介绍:   格局userpriv删除用户
     * 参数说明:   @param userPriv  角色主键
     *
     * @return void   无
     */
    @Override
    public void deleteByPrimaryKey(int userPriv) {
        userPrivMapper.deleteByPrimaryKey(userPriv);

    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:32:58
     * 方法介绍:   userpriv保存
     * 参数说明:   @param record 角色信息
     *
     * @return void   无
     */
    @Override
    public void insertSelective(UserPriv record) {
        userPrivMapper.insertSelective(record);

    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:33:03
     * 方法介绍:   获取所有userPriv
     * 参数说明:   @param maps  集合
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag  是否开启分页
     * 参数说明:   @return
     *
     * @return List<UserPriv>   返回角色
     */
    @Override
    public List<UserPriv> getAllPriv(Map<String, Object> maps, Integer page,
                                     Integer pageSize, boolean useFlag) {
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        pageParams.setUseFlag(useFlag);
        maps.put("page", pageParams);
        List<UserPriv> list = userPrivMapper.getAlluserPriv(maps);
        return list;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:33:07
     * 方法介绍:   多条件查询userPriv
     * 参数说明:   @param priv 角色
     * 参数说明:   @return
     *
     * @return List<UserPriv>   返回角色信息
     */
    @Override
    public List<UserPriv> getPrivByMany(UserPriv priv) {
        List<UserPriv> list = userPrivMapper.getPrivByMany(priv);
        return list;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 10:45
     * @函数介绍: 查询所有用户Priv
     * @return: List<UserPriv></UserPriv>
     **/
    @Override
    public List<UserPriv> getAllUserPriv() {
        Map<String, Object> map = new HashMap<String, Object>();
        return userPrivMapper.getAlluserPriv(map);
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/1 13:54
     * @函数介绍: 根据funcIdStr查询角色名称
     * @参数说明: @param fid, 某个功能的id,对应sys_function表中的FUNC_ID
     * @return: XXType(value introduce)
     */
    @Override
    public List<UserPriv> getUserPrivNameByFuncId(String fid) {

        List<UserPriv> userPrivList = userPrivMapper.getUserPrivNameByFuncId(fid);

        return userPrivList;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/1 19:43
     * @函数介绍: 修改角色权限（serPriv 的funcIdStr）,数据库原有字段基础上如果存在就不在拼接，否则
     * @参数说明: String privids
     * @参数说明: String funcId
     * @return: XXType(value introduce)
     */
    @Override
    public void updateUserPrivfuncIdStr(String privids, String funcId) {

        String[] prividArr = null;
        if (privids != null && privids != "") {
            prividArr = privids.split(",");
        }

        if (prividArr != null && prividArr.length > 0) {

            for (String id : prividArr) {
                String funcIdStr = userPrivMapper.getUserPrivfuncIdStr(id);

                if (funcIdStr != null && !"".equals(funcIdStr) && funcId != null) {

                    //已结添加
                    if (funcIdStr.contains("".concat(funcId).concat(",")) || funcIdStr.startsWith(funcId.concat(","))) {
                        //do nothing
                        //未添加添加
                    } else {

                        funcIdStr = funcIdStr.concat(funcId).concat(",");
                        Map<String, Object> hashMap = new HashMap<String, Object>();
                        hashMap.put("id", id);
                        hashMap.put("funcIdStr", funcIdStr);
                        userPrivMapper.updateUserPrivFuncIdStr(hashMap);
                    }
                } else {
                    if (funcId != null && "".equals(funcIdStr)) {
                        funcIdStr = ",";
                        funcIdStr = funcIdStr.concat(funcId).concat(",");
                        Map<String, Object> hashMap = new HashMap<String, Object>();
                        hashMap.put("id", id);
                        hashMap.put("funcIdStr", funcIdStr);
                        userPrivMapper.updateUserPrivFuncIdStr(hashMap);
                    }else if(funcId != null) {
                        funcIdStr = "";
                        Map<String, Object> hashMap = new HashMap<String, Object>();
                        hashMap.put("id", id);
                        funcIdStr = funcIdStr.concat(funcId).concat(",");
                        hashMap.put("funcIdStr", funcIdStr);
                        userPrivMapper.updateUserPrivFuncIdStr(hashMap);
                    }

                }

            }
        }
    }

    /**
     * @param privids
     * @param funcIds
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/1 19:43
     * @函数介绍: 修改角色权限（serPriv 的funcIdStr）
     * @参数说明: String privids
     * @参数说明: String funcId
     * @return: void
     */
    @Override
    public void deleteUserPriv(String privids, String funcIds) {

        String[] prividArr = null;
        if (privids != null && privids != "") {
            prividArr = privids.split(",");
        }

        if (prividArr != null && prividArr.length > 0) {

            for (String id : prividArr) {
                String funcIdStr = userPrivMapper.getUserPrivfuncIdStr(id);

                if (funcIdStr != null && !"".equals(funcIdStr) && funcIds != null) {

                    //包含
                    if (funcIdStr.contains("".concat(funcIds).concat(",")) || funcIdStr.startsWith(funcIds.concat(","))) {
                        funcIdStr = funcIdStr.replace(funcIds.concat(","), "");
                        Map<String, Object> hashMap = new HashMap<String, Object>();
                        hashMap.put("id", id);
                        hashMap.put("funcIdStr", funcIdStr);

                        userPrivMapper.updateUserPrivFuncIdStr(hashMap);


                    }
                }
            }

        }
    }


}



package com.xoa.service.users.impl;

import com.xoa.dao.common.SyslogMapper;
import com.xoa.dao.users.UsersMapper;
import com.xoa.model.common.Syslog;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.util.CusAccessObjectUtil;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.encrypt.EncryptSalt;
import com.xoa.util.page.PageParams;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:29:38
 * 类介绍  :    用户service接口实现类
 * 构造参数:
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;
    @Resource
    private SyslogMapper syslogMapper;
    @Resource
    private UsersPrivService usersPrivService;

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午4:44:24
     * 方法介绍:   添加用户
     * 参数说明:   @param user  用户信息
     *
     * @return void   无
     */
    @Override
    @Transactional
    public ToJson<Users> addUser(Users user) {
        ToJson<Users> tojson = new ToJson<Users>();
        try {
            usersMapper.insert(user);
            //user=usersMapper.findUserByuid(user.getUid());
            tojson.setObject(user);
            tojson.setFlag(0);
            tojson.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月23日 下午1:39:34
     * 方法介绍:   修改用户
     * 参数说明:   @param user 用户
     * 参数说明:   @return
     *
     * @return ToJson<Users>  用户
     */
    @Override
    @Transactional
    public ToJson<Users> editUser(Users user) {
        ToJson<Users> tojson = new ToJson<Users>();
        try {
            usersMapper.editUser(user);
            user = usersMapper.findUserByuid(user.getUid());
            tojson.setObject(user);
            tojson.setFlag(0);
            tojson.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;

    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午5:44:51
     * 方法介绍:   删除用户
     * 参数说明:   @param uid 用户uid
     *
     * @return void   无
     */
    @Override
    public void deleteUser(int uid) {
        usersMapper.deleteUser(uid);
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午4:46:36
     * 方法介绍:   获取所有用户
     * 参数说明:   @param maps  集合
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag  是否开启分页
     * 参数说明:   @return
     *
     * @return List<Users>  返回用户信息集合
     */
    @Override
    public List<Users> getAlluser(Map<String, Object> maps, Integer page,
                                  Integer pageSize, boolean useFlag) {
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        pageParams.setUseFlag(useFlag);
        maps.put("page", pageParams);
        return usersMapper.getAlluser(maps);
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午4:46:52
     * 方法介绍:   多条件查询
     * 参数说明:   @param user  用户信息
     * 参数说明:   @return
     *
     * @return List<Users>  返回用户信息
     */
    @Override
    public List<Users> getUserByMany(Users user) {
        List<Users> list = usersMapper.getUserByMany(user);
        return list;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午4:18:08
     * 方法介绍:   获取用户信息和部门信息
     * 参数说明:   @param maps  集合
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag   是否开启分页
     * 参数说明:   @return
     *
     * @return List<Users>   返回用户信息
     */
    @Override
    public List<Users> getUserAndDept(Map<String, Object> maps, Integer page,
                                      Integer pageSize, boolean useFlag) {
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        pageParams.setUseFlag(useFlag);
        maps.put("page", pageParams);
        return usersMapper.getUserAndDept(maps);
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午5:01:06
     * 方法介绍:   格局uid获取用户信息
     * 参数说明:   @param uid  用户uid
     * 参数说明:   @return
     *
     * @return Users   返回用户信息
     */
    @Override
    public Users findUserByuid(int uid) {
        Users user = usersMapper.findUserByuid(uid);
        return user;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月19日 上午9:48:51
     * 方法介绍:   根据别名获取用户信息
     * 参数说明:   @param byname  用户别名
     * 参数说明:   @return
     *
     * @return Users  返回用户
     */
    @Override
    public Users findUserByName(String byname, HttpServletRequest req) {
        Users user = usersMapper.findUserByName(byname);
        user.setDeptName(user.getDep().getDeptName());
        user.setCompanyName("北京高速波软件有限公司");
        Syslog sysLog = new Syslog();
        sysLog.setLogId(0);
        sysLog.setUserId(user.getUserId());
        sysLog.setTime(new Date());
        String ip = CusAccessObjectUtil.getIpAddress(req);
        sysLog.setIp(ip);
        sysLog.setType(1);
        sysLog.setRemark("");
        syslogMapper.save(sysLog);

        return user;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月21日 上午10:27:07
     * 方法介绍:   根据输入条件进行查询
     * 参数说明:   @param maps 集合
     * 参数说明:   @param page 当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag  是否开启分页
     * 参数说明:   @return
     *
     * @return List<Users>   返回用户信息
     */
    @Override
    public List<Users> getBySearch(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        pageParams.setUseFlag(useFlag);
        maps.put("page", pageParams);
        return usersMapper.getBySearch(maps);
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月21日 上午11:00:05
     * 方法介绍:   根据部门id查询用户信息
     * 参数说明:   @param maps  集合
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag  是否开启分页
     * 参数说明:   @return
     *
     * @return List<Users>  返回用户信息
     */
    @Override
    public List<Users> getByDeptId(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        pageParams.setUseFlag(useFlag);
        maps.put("page", pageParams);
        return usersMapper.getByDeptId(maps);
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月21日 上午11:00:05
     * 方法介绍:   根据uid查询用户姓名、部门、角色信息
     * 参数说明:   @param uid  用户uid
     * 参数说明:   @return
     *
     * @return Users  返回用户信息
     */
    @Override
    public Users getByUid(int uid) {
        Users users = usersMapper.getByUid(uid);
        return users;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月26日 下午5:20:05
     * 方法介绍:   根据userId串获取用户姓名
     * 参数说明:   @param uids  用户uid串
     * 参数说明:   @return
     *
     * @return List<String>  返回用户姓名串
     */
    @Override
    public String getUserNameById(String userIds) {
        if (StringUtils.checkNull(userIds)) {
            return null;
        }
        //定义用于拼接角色名称的字符串
        StringBuffer sb = new StringBuffer();
        String[] temp = userIds.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (!StringUtils.checkNull(temp[i])) {
                String userName = usersMapper.getUsernameByUserId(temp[i]);
                if (userName != "") {
                    if (i < temp.length - 1) {
                        sb.append(userName).append(",");
                    } else {
                        sb.append(userName);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月26日 下午5:20:05
     * 方法介绍:   根据uId串获取用户姓名
     * 参数说明:   @param uids  用户uid串
     * 参数说明:   @return
     *
     * @return String  返回用户姓名串
     */
    @Override
    public String findUsersByuid(int... uid) {
        if (uid == null) {
            return null;
        }
        //定义用于拼接用户姓名的字符串
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < uid.length; i++) {
            if (uid.length == 1) {
                String userName = usersMapper.getUsernameById(uid[i]);
                return userName;
            } else {
                String userName = usersMapper.getUsernameById(uid[i]);
                if (i < uid.length - 1) {
                    sb.append(userName).append(",");
                } else {
                    sb.append(userName);
                }
            }
        }
        return sb.toString();
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 9:40
     * @函数介绍: 根据User的角色或部门id, 查询用户，其他条件可在serverce层扩展
     * @参数说明: @param Users
     * @return: List<Users></Users>
     */
    @Override
    public List<Users> getUsersByCondition(Users users) {
        List<Users> usersList = new ArrayList<Users>();

        //根据用户部门id查询
        if (users != null && users.getDeptId() != null) {
            usersList = usersMapper.getUserByDeptId(users);
        } else if (users != null && users.getUserPriv() != null) {
            usersList = usersMapper.getUserByRoleId(users);
        }

        return usersList;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 11:10
     * @函数介绍: 查询在线用户
     * @参数说明: @param paramname paramintroduce
     * @return: List<User></User>
     **/
    @Override
    public List<Users> getUsersOnline() {

        return usersMapper.getUserOnline();
    }

    @Override
    public List<Users> getUserbyCondition(Map<String, Object> maps) {
        List<Users> usersList = usersMapper.getUserbyCondition(maps);
        StringBuffer s2 = new StringBuffer();
        for (Users users : usersList) {
            users.setDepartmentPhone(users.getDep().getTelNo());
            if (users.getUserPrivOther() != null && !users.getUserPrivOther().equals("")) {
                String userOther = users.getUserPrivOther();
                String[] strArray2 = userOther.split(",");
                for (int i = 0; i < strArray2.length; i++) {
                    String name3 = usersPrivService.getPrivNameById(Integer.parseInt(strArray2[i]));
                    if (name3 != null) {
                        s2.append(name3);
                        s2.append(",");
                        users.setRoleAuxiliaryName(s2.toString());
                    }
                }

            }

        }
        return usersList;
    }

    @Override
    @Transactional
    public ToJson<Users> edit(Integer uid, String userName, String sex, String birthday, String email, String oicqNo,
                              String mobilNo, String telNoDept, String avatar) {
        ToJson<Users> tojson = new ToJson<Users>();
        Users u = new Users();
        u.setUid(uid);
        u.setUserName(userName);
        u.setSex(sex);
        u.setBirthday(birthday);
        u.setEmail(email);
        u.setOicqNo(oicqNo);
        u.setMobilNo(mobilNo);
        u.setTelNoDept(telNoDept);
        u.setAvatar(avatar);
        try {
            usersMapper.editUser(u);
            tojson.setFlag(0);
            tojson.setMsg("ok");
        } catch (Exception e) {
            e.printStackTrace();
            tojson.setFlag(1);
            tojson.setMsg("false");
        }
        return tojson;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/6 21:15
     * @函数介绍: 验证密码是否正确, 为了保证兼容php的加密，发现php项目的MD5加密,加的盐是密文。
     * 比如，密码123，在数据库里的加密是XX,那么加的盐就是XX
     * @参数说明: @param userName 用户名
     * @参数说明: @param password 密码
     * @return: Boolean 密码是否正确
     */
    @Override
    public Boolean checkPassWord(String userName, String password) {

        if (userName != null && password != null) {

            List<Users> usersList = usersMapper.checkPassWord(userName);

            if (usersList != null && usersList.size() > 0) {

                for (Users users : usersList) {
                    String truePassword1 = users.getPassword();

                    String md5Password = Md5Crypt.md5Crypt(password.getBytes(), truePassword1);
                    if (md5Password != null && md5Password.equals(truePassword1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/7 10:47
     * @函数介绍: 加密一个字符串，MD5加密，EncryptSalt类产生一个字符串作为加盐加密。
     * @参数说明: @param String 要加密的字符串
     * @return: String 加密过后的字符串
     */
    @Override
    public String getEncryptString(String password) {

        String md5WithSalt = null;
        if (password != null) {
            md5WithSalt = Md5Crypt.md5Crypt(password.trim().getBytes(), "$1$".concat(EncryptSalt.getRandomSalt(12)));
        }
        return md5WithSalt;
    }

}

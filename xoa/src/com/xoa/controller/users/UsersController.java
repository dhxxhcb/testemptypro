package com.xoa.controller.users;

import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.FileUploadUtil;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.dataSource.ContextHolder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:42:39
 * 类介绍  :    用户
 * 构造参数:    无
 */
@Controller
@Scope(value = "prototype")
public class UsersController {
    private Logger loger = Logger.getLogger(UsersController.class);
    @Resource
    private UsersService usersService;

    @RequestMapping("/addUsers")
    public String addUser(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/sys/addUser";
    }
    @RequestMapping("/userInfor")
    public String userInfor(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/sys/userInfor";
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:43:04
     * 方法介绍:   添加用户
     * 参数说明:   @param user  用户信息
     * 参数说明:   @return
     *
     * @return ToJson<Users>  返回显示信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public ToJson<Users> addUser(Users user, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return usersService.addUser(user);
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:53:11
     * 方法介绍:   修改用户
     * 参数说明:   @param user  用户信息
     * 参数说明:   @return
     *
     * @return ToJson<Users>  返回显示信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/editUser", method = RequestMethod.GET)
    public ToJson<Users> editUser(Users user, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        loger.debug("ID" + user.getUid());
        try {
            usersService.editUser(user);
            user = usersService.findUserByuid(user.getUid());
            json.setObject(user);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月22日 下午5:08:37
     * 方法介绍:   修改用户信息
     * 参数说明:   @param user 用户信息
     * 参数说明:   @param imageFile 头像
     * 参数说明:   @param request 请求
     * 参数说明:   @return
     * 参数说明:   @throws IllegalStateException
     * 参数说明:   @throws IOException
     *
     * @return ToJson<Users>
     */
    @ResponseBody
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public ToJson<Users> edit(
            Users user,
            @RequestParam(value = "imgFile", required = false) MultipartFile imageFile
            , HttpServletRequest request) throws IllegalStateException, IOException {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String resourcePath = "ui/img/user";
        if (imageFile != null) {
            if (FileUploadUtil.allowUpload(imageFile.getContentType())) {
                String fileName = FileUploadUtil.rename(imageFile.getOriginalFilename());
                File dir = new File(realPath + resourcePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, fileName);
                imageFile.transferTo(file);
                user.setAvatar(fileName);
            }
        }
        return usersService.editUser(user);
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:53:19
     * 方法介绍:   删除用户
     * 参数说明:   @param user  用户信息
     * 参数说明:   @return
     *
     * @return ToJson<Users> 返回显示信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST)
    public ToJson<Users> deletesUser(Users user, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        loger.debug("ID" + user.getUid());
        try {
            usersService.deleteUser(user.getUid());
            json.setObject(user);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:53:27
     * 方法介绍:   根据uid查询用户
     * 参数说明:   @param uid  用户uid号
     * 参数说明:   @return
     *
     * @return ToJson<Users>  返回用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/findUserByuid", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ToJson<Users> findUserByuid(int uid, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            Users users = usersService.findUserByuid(uid);
            if (StringUtils.checkNull(users.getBirthday())) {
                users.setBirthday("");
            }
            json.setObject(users);
            ;
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:53:36
     * 方法介绍:   获取所有用户
     * 参数说明:   @param maps  封装集合对象
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面数据大小
     * 参数说明:   @param useFlag  是否开启分页
     * 参数说明:   @return
     *
     * @return String  返回所有用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/getAlluser", produces = {"application/json;charset=UTF-8"})
    public ToJson<Users> getAllUser(Map<String, Object> maps, Integer page,
                                    Integer pageSize, boolean useFlag) {
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            List<Users> list = usersService.getAlluser(maps, page, pageSize, useFlag);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:53:43
     * 方法介绍:   根据多条件查询部门
     * 参数说明:   @param users  用户信息
     * 参数说明:   @return
     *
     * @return ToJson<Users>  返回用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/getDeptByMany", method = RequestMethod.POST)
    public ToJson<Users> getDeptByMany(Users users, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            List<Users> list = usersService.getUserByMany(users);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月20日 下午7:16:57
     * 方法介绍:   获取用户信息以及部门名称信息
     * 参数说明:   @param maps  集合
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag  是否开启分页
     * 参数说明:   @return
     *
     * @return ToJson<Users>  返回用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/getUserAndDept", produces = {"application/json;charset=UTF-8"})
    public ToJson<Users> getUserAndDept(Map<String, Object> maps, Integer page,
                                        Integer pageSize, boolean useFlag, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            List<Users> list = usersService.getUserAndDept(maps, page, pageSize, useFlag);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月20日 下午2:28:22
     * 方法介绍:   根据（用户姓名、角色、部门）查询用户信息接口
     * 参数说明:   @param request 请求
     * 参数说明:   @param maps  集合
     * 参数说明:   @param page  当前页面
     * 参数说明:   @param pageSize  页面大小
     * 参数说明:   @param useFlag   是否开启分页
     * 参数说明:   @return
     *
     * @return String  返回用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/getBySearch", produces = {"application/json;charset=UTF-8"})
    public ToJson<Users> getBySearch(HttpServletRequest request, Map<String, Object> maps, Integer page,
                                     Integer pageSize, boolean useFlag) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            request.setCharacterEncoding("UTF-8");
            String search = request.getParameter("search");
            System.out.println(search);
            //String search=URLEncoder.encode(request.getParameter("search"),"utf-8");
            maps = new HashMap<String, Object>();
            maps.put("userName", search);
            maps.put("userPrivName", search);
            maps.put("deptName", search);
            List<Users> list = usersService.getBySearch(maps, page, pageSize, useFlag);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月21日 上午11:49:11
     * 方法介绍:   根据部门id获取所有用户
     * 参数说明:   @param request 请求
     * 参数说明:   @param maps 集合
     * 参数说明:   @param page 当前页面
     * 参数说明:   @param pageSize 页面大小
     * 参数说明:   @param useFlag 是否开启分页
     * 参数说明:   @return
     *
     * @return String  返回部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/getByDeptId", produces = {"application/json;charset=UTF-8"})
    public ToJson<Users> getByDeptId(HttpServletRequest request, Map<String, Object> maps, Integer page,
                                     Integer pageSize, boolean useFlag) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            request.setCharacterEncoding("UTF-8");
            int deptId = Integer.parseInt(new String(request.getParameter("deptId").getBytes("ISO-8859-1"), "UTF-8"));
            maps = new HashMap<String, Object>();
            maps.put("deptId", deptId);
            List<Users> list = usersService.getByDeptId(maps, page, pageSize, useFlag);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月25日 上午10:17:54
     * 方法介绍:   根据uid查询用户姓名、部门、角色信息
     * 参数说明:   @param uid  用户uid
     * 参数说明:   @return
     *
     * @return String 返回用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/getByUid", produces = {"application/json;charset=UTF-8"})
    public ToJson<Users> getByUid(int uid, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        try {
            Users user = usersService.getByUid(uid);
            json.setObject(user);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/user/getUserNameById", method = RequestMethod.GET)
    public ToJson<Users> getUserNameById(String userIds, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Users> json = new ToJson<Users>(0, null);
        //loger.debug("ID"+user.getUid());
        try {
            String userName = usersService.getUserNameById(userIds);
            json.setObject(userName);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @RequestMapping(value = "/user/xsu", method = RequestMethod.GET)
    public String xs(HttpServletRequest request) {


        return "app/test/xs";

    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 9:37
     * @函数介绍: 根据User的角色或部门id, 查询用户，其他条件可在serverce层扩展
     * @参数说明: @param Users
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/getUserByCondition")
    public ToJson<Users> getUserByCondition(HttpServletRequest request, Users users) {


        ToJson<Users> json = new ToJson<Users>(0, null);
        try {

            List<Users> userList = usersService.getUsersByCondition(users);
            json.setObject(userList);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 11:07
     * @函数介绍: 查询在线用户
     * @参数说明: HttpServletRequest
     * @return: json
     **/
    @ResponseBody
    @RequestMapping("/getUserOnline")
    public ToJson<Users> getUserOnline(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<Users> json = new ToJson<Users>(0, null);
        try {

            List<Users> userList = usersService.getUsersOnline();
            json.setObject(userList);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;

    }



}

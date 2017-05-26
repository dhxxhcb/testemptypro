package com.xoa.controller.menu;

import com.alibaba.fastjson.JSON;
import com.xoa.model.menu.MobileApp;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;
import com.xoa.service.menu.MobileAppService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-18 下午6:34:34
 * 类介绍   :    菜单控制器
 * 构造参数:    无
 */
@Controller
@Scope(value = "prototype")
public class MenuController {
    @Resource
    private MenuService menuService;
    @Resource
    private MobileAppService mobileAppService;
    private int flag;
    private String err = "err";
    private String ok = "ok";


    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午6:35:04
     * 方法介绍:   获取菜单和下面的子菜单
     * 参数说明:   @return
     *
     * @return String 返回JSON类型的菜单
     */
    @RequestMapping(value = "/showMenu", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    ToJson<SysMenu> showNew(HttpServletRequest request, HttpServletResponse response) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        String LOCALE_SESSION_ATTRIBUTE_NAME = SessionLocaleResolver.class.getName() + ".LOCALE";
        Object locale = request.getSession().getAttribute(LOCALE_SESSION_ATTRIBUTE_NAME);
        List<SysMenu> munuList;
        try {

            munuList = menuService.getAll(locale.toString());
            String msg;
            if (munuList.size() > 0) {
                flag = 0;
                msg = ok;
            } else {
                flag = 1;
                msg = err;
            }

            ToJson<SysMenu> menuJson = new ToJson<SysMenu>(flag, msg);
            menuJson.setObj(munuList);

            Map<String, String> map = new HashMap<String, String>();
            map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
                    "yyyy-MM-dd HH:mm:ss"));
            return menuJson;
        } catch (Exception e) {

            munuList = menuService.getAll("zh_CN");
            String msg;
            if (munuList.size() > 0) {
                flag = 0;
                msg = ok;
            } else {
                flag = 1;
                msg = err;
            }

            ToJson<SysMenu> menuJson = new ToJson<SysMenu>(flag, msg);
            menuJson.setObj(munuList);

            Map<String, String> map = new HashMap<String, String>();
            map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
                    "yyyy-MM-dd HH:mm:ss"));
            return menuJson;
        }


    }


    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:57:41
     * 方法介绍:   获取一级菜单下面的子类菜单
     * 参数说明:   @param request
     * 参数说明:   @param response
     * 参数说明:   @return
     *
     * @return String
     */
    @RequestMapping(value = "/showSubclassesMenu", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    String showDadMenu(HttpServletRequest request, HttpServletResponse response) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        String menuId = request.getParameter("menuId");
        List<SysFunction> list = menuService.getDadMenu(menuId);
        String msg;
        if (list.size() > 0) {
            flag = 0;
            msg = ok;
        } else {
            flag = 1;
            msg = err;
        }
        ToJson<SysFunction> menuJson = new ToJson<SysFunction>(flag, msg);
        menuJson.setObj(list);
        Map<String, String> map = new HashMap<String, String>();
        map.put("showSubclassesMenu", JSON.toJSONStringWithDateFormat(menuJson,
                "yyyy-MM-dd HH:mm:ss"));

        return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:59:56
     * 方法介绍:   移动对应菜单
     * 参数说明:   @return
     *
     * @return String
     */
    @RequestMapping(value = "/getMenu", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    ToJson<MobileApp> getMenu(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        List<MobileApp> munuList = mobileAppService.getMobileAppList();
        String msg;
        if (munuList.size() > 0) {
            flag = 0;
            msg = ok;
        } else {
            flag = 1;
            msg = err;

        }

        ToJson<MobileApp> menuJson = new ToJson<MobileApp>(flag, msg);
        menuJson.setObj(munuList);
        return menuJson;


    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/23 19:28
     * @函数介绍: 对一级菜单(SysMenu)修改,
     * @参数说明: @param sysMenu
     * @参数说明: @param request
     * @return: String (转发到查询所有菜单)
     **/
    @RequestMapping(value = "/updateFirstMenu", produces = {"application/json;charset=UTF-8"})
    public String updateSysMenu(SysMenu sysMenu, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        String LOCALE_SESSION_ATTRIBUTE_NAME = SessionLocaleResolver.class.getName() + ".LOCALE";
        Object locale = request.getSession().getAttribute(LOCALE_SESSION_ATTRIBUTE_NAME);
        //部分属性不为null.
        if (sysMenu != null && sysMenu.getId() != null && sysMenu.getName() != null &&
                sysMenu.getName1() != null && sysMenu.getName2() != null && sysMenu.getImg() != null) {
            try {
                menuService.updateSysMenu(sysMenu);
                return "forward:showMenu";
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }


    /**
    *@创建作者:  韩成冰
    *@创建日期:  2017/5/26 13:01
    *@函数介绍:  添加主菜单(由于主菜单和其它子菜单对应不同的表，所以添加时分开)
    *@参数说明:  @param sysMenu
    *@return:   String
    **/
    @RequestMapping(value = "/addSysMenu", produces = {"application/json;charset=UTF-8"})
    public String addSysMenu(SysMenu sysMenu, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        //菜单代码，菜单的中、英、繁体名不能为null才可以修改。
        if (sysMenu != null && sysMenu.getId() != null && sysMenu.getName() != null
                && sysMenu.getName1() != null && sysMenu.getName2() != null && sysMenu.getImg() != null) {

            //数据库要求字段不为空，但是前端没传入，这里设置为“”
            sysMenu.setName3("");
            sysMenu.setName4("");
            sysMenu.setName5("");
            sysMenu.setExt("");

            //菜单id长度为2
            if (sysMenu.getId().length() == 2) {
                try {
                    menuService.addSysMenu(sysMenu);
                    return "redirect:showMenu";
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    /**
    *@创建作者:  韩成冰
    *@创建日期:  2017/5/26 13:15
    *@函数介绍:  删除菜单
    *@参数说明:  @param id（对应数据库MENU_ID）
    *@return:   String
    **/
    @RequestMapping(value = "/deleteSysMenu", produces = {"application/json;charset=UTF-8"})
    public String deleteSysMenu(String id, HttpServletRequest request) {
      /*  ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/
        //id不为空，去除空格，id长度大于等于2
        if (id != null && id.trim().length() >= 2) {
            try {
                menuService.deleteSysMenu(id);
                return "redirect:showMenu";
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }
}

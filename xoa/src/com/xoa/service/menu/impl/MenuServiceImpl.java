package com.xoa.service.menu.impl;

import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:44:26 类介绍 : 菜单ServiceImpl 构造参数:
 */
@Transactional
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;// 父类菜单DAO

    @Resource
    private SysFunctionMapper sysFunctionMapper;// 子类菜单DAO

    /**
     * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:43:57 方法介绍: 获取全部菜单 参数说明: @return
     *
     * @return List<SysMenu>
     */
    @Override
    public List<SysMenu> getAll(String locale) {
        List<SysMenu> list = sysMenuMapper.getDatagrid();
        for (SysMenu sysMenu : list) {
            if (locale.equals("zh_CN")) {
                sysMenu.setName(sysMenu.getName());
            } else if (locale.equals("en_US")) {
                sysMenu.setName(sysMenu.getName1());
            } else if (locale.equals("zh_TW")) {
                sysMenu.setName(sysMenu.getName2());
            }
            List<SysFunction> list1 = sysFunctionMapper.getDatagrid(sysMenu
                    .getId());
            for (SysFunction sysFunction : list1) {
                if (locale.equals("zh_CN")) {
                    sysFunction.setName(sysFunction.getName());
                } else if (locale.equals("en_US")) {
                    sysFunction.setName(sysFunction.getName1());
                } else if (locale.equals("zh_TW")) {
                    sysFunction.setName(sysFunction.getName2());
                }
                List<SysFunction> list2 = sysFunctionMapper
                        .childMenu(sysFunction.getId());
                for (SysFunction sysFunction2 : list2) {
                    if (locale.equals("zh_CN")) {
                        sysFunction2.setName(sysFunction2.getName());
                    } else if (locale.equals("en_US")) {
                        sysFunction2.setName(sysFunction2.getName1());
                    } else if (locale.equals("zh_TW")) {
                        sysFunction2.setName(sysFunction2.getName2());
                    }

                }
                sysFunction.setChild(list2);

            }
            sysMenu.setChild(list1);
        }
        return list;
    }

    /**
     * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:44:08 方法介绍: 获取子类菜单 参数说明: @param menuId
     * 参数说明: @return
     *
     * @return List<SysFunction>
     */
    @Override
    public List<SysFunction> getDadMenu(String menuId) {
        List<SysFunction> list = sysFunctionMapper.getDatagrid(menuId);
        for (SysFunction sysFunction : list) {
            List<SysFunction> list1 = sysFunctionMapper.childMenu(sysFunction
                    .getId());
            sysFunction.setChild(list1);
        }
        return list;
    }

    /**
     * @param sysMenu
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 12:50
     * @函数介绍: 修改一级菜单
     * @参数说明: @param SysMenu
     * @return: void
     */
    @Override
    public void updateSysMenu(SysMenu sysMenu) {
        sysMenuMapper.updateSysMenu(sysMenu);
    }

    /**
     * @param sysMenu
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 13:03
     * @函数介绍: 添加一级菜单
     * @参数说明: @param paramname paramintroduce
     * @return: void
     */
    @Override
    public void addSysMenu(SysMenu sysMenu) {
        sysMenuMapper.addSysMenu(sysMenu);
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 13:16
     * @函数介绍: 删除菜单
     * @参数说明: @param paramname paramintroduce
     * @return: void
     */
    @Override
    public void deleteSysMenu(String id) {
        //根据id长度,判断删除是一级菜单，还是其他菜单
        //一级
        if (id != null && id.trim().length() == 2) {
            sysMenuMapper.deleteSysMenu(id);
            sysFunctionMapper.deleteFunction(id);
        } else {
            sysFunctionMapper.deleteFunction(id);
        }


    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 13:59
     * @函数介绍: 添加二级菜单
     * @参数说明: @param SysFunctioni
     * @return: void
     */
    @Override
    public void addFunctionMenu(SysFunction sysFunction) {

        sysFunctionMapper.addFunctionMenu(sysFunction);
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 14:14
     * @函数介绍: 修改二级菜单
     * @参数说明: @param sysFunction
     * @return: void
     **/
    @Override
    public void editSysFunction(SysFunction sysFunction) {
        sysFunctionMapper.editSysFunction(sysFunction);
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 19:37
     * @函数介绍: 查询子菜单
     * @参数说明: @param id
     * @return: List<SysFunction></SysFunction>
     **/
    @Override
    public List<SysFunction> findChildMenu(String id) {
        List<SysFunction> list = null;

        //查出所以的2级3级菜单
        if (id != null) {
            list = sysFunctionMapper.findChildMenu(id);
        }

        //是否查询的是2级菜单，如果是，把三级菜单放到对应的二级菜单。
        // 如果不是就直接返回多个三级
        boolean isFindSecond = false;

        //把三级菜单放到对应的二级菜单。
        List<SysFunction> secondMenuList = new ArrayList<SysFunction>();
        List<SysFunction> thirdList = new ArrayList<SysFunction>();


        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                SysFunction sysFunction = list.get(i);
                if (sysFunction.getId().length() == 4) {
                    //查询的是2级
                    isFindSecond = true;
                    secondMenuList.add(sysFunction);
                } else if (sysFunction.getId().length() == 6) {
                    thirdList.add(sysFunction);
                }
            }
        }


        if (secondMenuList.size() > 0) {
            for (int i = 0; i < secondMenuList.size(); i++) {
                secondMenuList.get(i).setChild(new ArrayList<SysFunction>());
                for (int j = 0; j < thirdList.size(); j++) {
                    String thirdMenuId = thirdList.get(j).getId().substring(0, 4);
                    String theSecondMenuId = secondMenuList.get(i).getId();
                    if (theSecondMenuId != null && theSecondMenuId.equals(thirdMenuId)) {
                        secondMenuList.get(i).getChild().add(thirdList.get(j));
                    }
                }
            }
        }

        if (isFindSecond) {
            return secondMenuList;
        } else {
            return list;
        }

    }
    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 19:37
     * @函数介绍: 根据id查一级菜单
     * @参数说明: @param Stirng
     * @return: List<SysMenu></SysMenu>
     **/
    @Override
    public List<SysMenu> getTheFirstMenu(String id) {

        if (id != null) {
            List<SysMenu> list = sysMenuMapper.getTheFirstMenu(id);
            return list;
        }
        return null;
    }
}

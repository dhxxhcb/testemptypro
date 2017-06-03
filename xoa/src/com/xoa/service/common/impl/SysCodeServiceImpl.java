package com.xoa.service.common.impl;

import com.xoa.dao.common.SysCodeMapper;
import com.xoa.model.common.SysCode;
import com.xoa.service.common.SysCodeService;
import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建作者:   王曰岐
 * 创建日期:   2017-5-2 下午2:40:05
 * 类介绍  :    系统代码日志表
 * 构造参数:
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {
    @Resource
    private SysCodeMapper sysCodeMapper;

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-2 下午2:40:40
     * 方法介绍:   根据代码主分类查找信息
     * 参数说明:   @param parentNo
     * 参数说明:   @return
     *
     * @return SysCode
     */
    @Override
    public ToJson<SysCode> getSysCode(String parentNo) {
        List<SysCode> code = sysCodeMapper.getSysCode(parentNo);
        ToJson<SysCode> codeJson = new ToJson<SysCode>();
        if (code.size() > 0) {
            codeJson.setObj(code);
            codeJson.setFlag(0);
            codeJson.setMsg("ok");
        } else {
            codeJson.setFlag(1);
            codeJson.setMsg("err");
        }
        return codeJson;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月3日 下午4:50:09
     * 方法介绍:   获取所有系统代码
     * 参数说明:   @return
     *
     * @return List<SysCode>
     */
    @Override
    public List<SysCode> getAllSysCode() {
        List<SysCode> list = sysCodeMapper.getAllSysCode();
        return list;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 上午10:06:41
     * 方法介绍:   更新系统代码设置表
     * 参数说明:   @param sysCode 系统代码设置表
     *
     * @return void 无
     */
    @Override
    public void update(SysCode sysCode) {


        Boolean codeNoExits = isCodeNoExits(sysCode);
        Boolean codeOrderExits = isCodeOrderExits(sysCode);
        if (!codeNoExits && codeOrderExits) {
            sysCodeMapper.update(sysCode);
        }


    }

    @Override
    public List<SysCode> getLogType() {

        List<SysCode> sysCodeList = sysCodeMapper.getLogType("PARENT_NO");
        return sysCodeList;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 16:49
     * @函数介绍: 根据日志的NO, 查询日志TYPENa
     * @参数说明: @param String
     * @参数说明:param codeNo
     * @return: String
     */
    @Override
    public String getLogNameByNo(String codeNo) {
        String logTypeName = sysCodeMapper.getLogNameByNo(codeNo);

        return logTypeName;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 13:25
     * @函数介绍: 删除日志
     * @参数说明: @param SysCode sysCode
     * @return: void
     */
    @Override
    public void deleteSysCode(SysCode sysCode) {
        sysCodeMapper.delete(sysCode);
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 13:41
     * @函数介绍: 增加代码主分类
     * @参数说明: @param SysCode
     * @return: void
     */
    @Override
    public void addSysMainCode(SysCode sysCode) {


        Boolean codeNoExits = isCodeNoExits(sysCode);
        Boolean codeOrderExits = isCodeOrderExits(sysCode);

        //sysCode的ext属性不为空
        if (sysCode != null && !codeNoExits && !codeOrderExits) {
            //这个多语言字段不用，数据库不能为空，所以赋值为“”
            sysCode.setCodeExt("");
            sysCodeMapper.addSysMainCode(sysCode);
        }
    }

    /**
     * @param sysCode
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:16
     * @函数介绍: 判断系统代码排序是否存在
     * @参数说明: @param SysCOde
     * @return: Boolean
     */
    @Override
    public Boolean isCodeOrderExits(SysCode sysCode) {
        List<SysCode> sysCodesList;
        //一级二级分开考虑,因为二级的两个字段都重复才重复，一级有一个字段重复就重复
        if (sysCode != null && ("".equals(sysCode.getParentNo()) || sysCode.getParentNo() == null)) {
            sysCodesList = sysCodeMapper.isSysCodeOrderExits(sysCode);
        } else {
            sysCodesList = sysCodeMapper.isChildCodeOrderExits(sysCode);

        }

        //该排序号已经被用了
        if (sysCodesList != null && sysCodesList.size() > 0) {
            return true;

        }
        return false;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:31
     * @函数介绍: 判断系统代码CODE_NO是否存在
     * @参数说明: @param SysCode
     * @return: boolean
     */
    @Override
    public Boolean isCodeNoExits(SysCode sysCode) {
        List<SysCode> sysCodesList;

        //一级二级分开考虑,因为二级的两个字段都重复才重复，一级有一个字段重复就重复
        if (sysCode != null && ("".equals(sysCode.getParentNo()) || sysCode.getParentNo() == null)) {
            sysCodesList = sysCodeMapper.isSysCodeNoExits(sysCode);
        } else {
            sysCodesList = sysCodeMapper.isChildCodeNoExits(sysCode);

        }
        //该CODE_NO号已经被用了
        if (sysCodesList != null && sysCodesList.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:41
     * @函数介绍: 增加子代码
     * @参数说明: @param SysCode
     * @return: void
     */
    @Override
    public void addChildSysCode(SysCode sysCode) {


        Boolean codeNoExits = isCodeNoExits(sysCode);
        Boolean codeOrderExits = isCodeOrderExits(sysCode);


        //sysCode的ext属性不为空
        if (sysCode != null && sysCode.getParentNo() != null && !codeNoExits && !codeOrderExits) {
            //这个多语言字段不用，数据库不能为空，所以赋值为“”
            sysCode.setCodeExt("");
            sysCodeMapper.addSysChildCode(sysCode);
        }
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:45
     * @函数介绍: 查询子代码
     * @参数说明: @param SysCode
     * @return: List<SysCode></SysCode>
     */
    @Override
    public List<SysCode> getChildSysCode(SysCode sysCode) {

        if (sysCode != null && sysCode.getParentNo() != null) {
            return sysCodeMapper.getSysCode(sysCode.getParentNo());
        }

        return null;
    }


}

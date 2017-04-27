package com.xoa.service.menu.impl;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.common.SysParaMapper;
import com.xoa.dao.menu.MobileAppMapper;
import com.xoa.model.menu.MobileApp;
import com.xoa.service.menu.MobileAppService;

    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午6:24:33
     * 类介绍  :    APP端菜单Service实现类
     * 构造参数:   无
     *
     */
@SuppressWarnings("all")
@Service
public class MobileAppServiceImpl implements MobileAppService {

	@Resource 
	private MobileAppMapper mobileAppMapper;//APP菜单DAO
	
	@Resource 
	private SysParaMapper sysParaMapper;//APP权限DAO
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-18 下午6:25:43
	 * 方法介绍:   得到APP端菜单集合
	 * 参数说明:   @return
	 * @return     List  返回菜单集合List
	 */
	@Override
	public List getMobileAppList() {
		String  ids=sysParaMapper.getSysPara();
		String[] firstIds = ids.substring(0,ids.lastIndexOf("|")).split(",");
		String[] twoIds = ids.substring(ids.indexOf("|")+1, ids.length()).split(",");
		List<MobileApp> mList=mobileAppMapper.getMobileAppList();
		List<List> mList1=new ArrayList<List>();
		List<MobileApp> list1 = new ArrayList<MobileApp>();
		List<MobileApp> list2 = new ArrayList<MobileApp>();
		for (int j = 0; j < firstIds.length; j++) {
			for (int i=j; i<mList.size(); i++) {  
				System.out.println(mList.get(j).getAppId());
				if (mList.get(i).getAppId().toString().equals(firstIds[j])) {
					list1.add(mList.get(i));
					break; 
				}
			}
		}
		for (int j = 0; j < twoIds.length; j++) {
			for (int i=j; i<mList.size(); i++) {  
				System.out.println(mList.get(j).getAppId());
				if (mList.get(i).getAppId().toString().equals(twoIds[j])) {
					list2.add(mList.get(i));
					break; 
				}
			}
			
		}
		mList1.add(list1);
		if (list2.size()>0) {
			mList1.add(list2);
		}
		return mList1;
	}

}

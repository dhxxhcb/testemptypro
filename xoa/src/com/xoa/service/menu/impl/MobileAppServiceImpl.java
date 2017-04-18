package com.xoa.service.menu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.common.SysParaMapper;
import com.xoa.dao.menu.MobileAppMapper;
import com.xoa.model.menu.MobileAppModel;
import com.xoa.service.menu.MobileAppService;
@SuppressWarnings("all")
@Service
/**
 * 
 * @ClassName (类名):  MobileAppServiceImpl
 * @Description(简述): 移动端菜单
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午6:02:34
 *
 */
public class MobileAppServiceImpl implements MobileAppService {

	@Resource 
	private MobileAppMapper mobileAppMapper;//菜单DAO
	
	@Resource 
	private SysParaMapper sysParaMapper;
	/**
	 * 
	 * <p>Title: getMobileAppList</p>
	 * <p>Description: </p>
	 * @return
	 * @author(作者):  wyq
	 * @see com.xoa.service.menu.MobileAppService#getMobileAppList()
	 */
	@Override
	public List getMobileAppList() {
		String  ids=sysParaMapper.getSysPara();
		String[] firstIds = ids.substring(0,ids.lastIndexOf("|")).split(",");
		String[] twoIds = ids.substring(ids.indexOf("|")+1, ids.length()).split(",");
		List<MobileAppModel> mList=mobileAppMapper.getMobileAppList();
		List<List> mList1=new ArrayList<List>();
		List<MobileAppModel> list1 = new ArrayList<MobileAppModel>();
		List<MobileAppModel> list2 = new ArrayList<MobileAppModel>();
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
		mList1.add(list2);
		return mList1;
	}

}

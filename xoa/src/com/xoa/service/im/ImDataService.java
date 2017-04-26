package com.xoa.service.im;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.alibaba.fastjson.JSONArray;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.TODO;
import com.xoa.dao.im.ImChatListMapper;
import com.xoa.dao.im.ImMessageMapper;
import com.xoa.model.im.ImChatList;
import com.xoa.model.im.ImChatListExample;
import com.xoa.model.im.ImMessage;
import com.xoa.model.im.ImMessageWithBLOBs;
import com.xoa.service.im.wrapper.ImChatListWrappers;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.dataSource.DynDatasource;
import com.xoa.util.page.PageParams;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-24 下午3:43:10
 * @类介绍 Im数据信息服务类
 * @构造参数 无
 * 
 */
@Service
public class ImDataService {
	@Autowired
	ImMessageMapper messageMapper;
	@Autowired
	ImChatListMapper chatlistMapper;

	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-24 下午3:54:20
	 * @方法介绍 添加IM消息到数据库
	 * @参数说明 @param flag
	 * @参数说明 @param from_uid 从那个Id
	 * @参数说明 @param to_uid 给那个Id
	 * @参数说明 @param of_from of的从Id
	 * @参数说明 @param of_to of的给Id
	 * @参数说明 @param content 消息内容
	 * @参数说明 @param type 附件类型
	 * @参数说明 @param time 发送时间
	 * @参数说明 @param uuid uuid
	 * @参数说明 @return
	 * @return
	 */
	@DynDatasource
	@Transactional(rollbackFor=ImDataException.class)
	public BaseWrapper putMessageInfo(Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String time, String uuid) {
		BaseWrapper bWrapper = new BaseWrapper();
		try {
			String checkResult = StringUtils.checkNullUtils(new CheckCallBack() {
				@Override
				public boolean isNull(Object obj) {
					// TODO Auto-generated method stub
					if (obj instanceof String) {
						String a = (String) obj;
						if (a == null || "".equals(a) || a.length() == 0)
							return true;
					}
					if (obj instanceof Integer) {
						Integer a = (Integer) obj;
						if (a == null)
							return true;
					}
					return false;
				}
			}, flag, "flag不能为空", from_uid, "from_uid不能为空", to_uid, "to_uid不能为空",
					of_from, "of_from不能为空", of_to, "of_to不能为空", content,
					"content不能为空", type, "type不能为空", time, "time不能为空", uuid,
					"uuid不能为空");
			if (checkResult != null) {
				bWrapper.setMsg(checkResult);
				bWrapper.setStatus(false);
				bWrapper.setFlag(false);
				return bWrapper;
			}
			ImMessageWithBLOBs record = new ImMessageWithBLOBs();
			record.setFromUid(from_uid);
			record.setType(type);
			record.setOfTo(of_to);
			record.setOfFrom(of_from);
			record.setToUid(to_uid);
			record.setUuid(uuid);
			record.setContent(content);
			record.setStime(time);
			Long atime = new Date().getTime();
			record.setAtime(String.valueOf(atime));
			record.setUseFlag(false);
			// TODO 处理附近信息
			// FIXME 类型不知道按什么区分现在默认文本类型
			switch (flag) {
			case 1:

				break;
			default:
				break;
			}
			L.w("meResult is run ");
			PageParams pageParams =new PageParams();
			pageParams.setUseFlag(false);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("fromUid", from_uid);
			paramsMap.put("toUid", to_uid);
			paramsMap.put("page", pageParams);
			ImChatList chatModel = chatlistMapper.selectChatListByParams(paramsMap);
			if(chatModel==null){
				L.a("chatModel is  null");
			}else{
				L.a("chatModel is not null:",JSONArray.toJSON(chatModel));
			}
			int meResult = messageMapper.insertSelective(record);
		
			L.w("meResult is ok ",String.valueOf(meResult));
			// TODO 检查消息列表更新或添加

			ImChatList putDateChatList= new ImChatList();
			putDateChatList.setFromUid(from_uid);
			putDateChatList.setToUid(to_uid);
			putDateChatList.setOfFrom(of_from);
			putDateChatList.setOfTo(of_to);
			putDateChatList.setLastTime(time);
			putDateChatList.setLastAtime(String.valueOf(atime));
			putDateChatList.setLastContent(content);
			putDateChatList.setType(type);
			putDateChatList.setUuid(uuid);
			int chResult=0;
			if(chatModel==null){
//				TODO insert
				chResult=chatlistMapper.insertSelective(putDateChatList);
			}else{
//				TODO update;
				putDateChatList.setListId(chatModel.getListId());
				chResult=chatlistMapper.updateByPrimaryKeySelective(putDateChatList);
			}
			if(meResult<1||chResult<1){
				throw new ImDataException("Im存入出现异常，进入catch块。");
			}else{ 
				bWrapper.setFlag(true);
				bWrapper.setMsg("操作成功");
				bWrapper.setStatus(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bWrapper.setFlag(false);
			bWrapper.setMsg("操作失败");
			bWrapper.setStatus(false);
			throw new ImDataException("Im数据异常，数据回滚中。"+e.getMessage());
		}
		
		return bWrapper;
	}
	@DynDatasource
    public ImChatListWrappers<ImChatList> getImChatList(String from_uid){
    	ImChatListWrappers<ImChatList> wrappers =new ImChatListWrappers<ImChatList>();
    	wrappers.setFlag(false);
    	if(StringUtils.checkNull(from_uid)){
    		wrappers.setMsg("缺少必要的参数，请确保您的信息合法");
    		wrappers.setStatus(false);
    		return wrappers;
    	}
    	
    	List<ImChatList> datas= chatlistMapper.selectByFromId(from_uid);
    	if(datas==null||datas.size()==0){
    		wrappers.setMsg("没有数据，请稍后尝试");
    		wrappers.setStatus(false);
    	}else{
    		wrappers.setMsg("数据获取成功");
    		wrappers.setStatus(true);
    		wrappers.setFlag(true);
    		wrappers.setDatas(datas);
    	}
    	return wrappers;
    }
	
	
	
	@DynDatasource
	@Transactional(rollbackFor=ImDataException.class)
	public BaseWrapper rollBackMessage(String from_id,String delete_uuid){
		//删除此消息 
		BaseWrapper bw=	new BaseWrapper();
		if(StringUtils.checkNull(from_id)||StringUtils.checkNull(delete_uuid)){
			bw.setFlag(false);
			bw.setStatus(false);
			bw.setMsg("缺少必要参数");
			return bw;
		}
		//三分钟内可撤销	
		Long nowL=new Date(System.currentTimeMillis()-1000*3*60).getTime();
		Integer now = nowL.intValue();
		L.w("now is ",now);
	    int der =	messageMapper.deleteByUUID(from_id,delete_uuid,now);
		if(der<1){
			bw.setFlag(false);
			bw.setStatus(false);
			bw.setMsg("撤销失败");
			return bw;
		}
		//更新最后一条记录
		
		
		
		
		return new BaseWrapper();
	}
	
}

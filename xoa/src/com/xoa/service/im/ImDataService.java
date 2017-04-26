package com.xoa.service.im;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.xoa.model.im.ImMessageExample;
import com.xoa.model.im.ImMessageWithBLOBs;
import com.xoa.service.im.wrapper.ImChatListWrappers;
import com.xoa.service.im.wrapper.ImMessageWrappers;
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
	@Transactional(rollbackFor = ImDataException.class)
	public BaseWrapper putMessageInfo(Integer flag, String from_uid,
			String to_uid, String of_from, String of_to, String content,
			String type, String time, String uuid) {
		BaseWrapper bWrapper = new BaseWrapper();
		try {
			String checkResult = StringUtils.checkNullUtils(
					new CheckCallBack() {
						@Override
						public boolean isNull(Object obj) {
							// TODO Auto-generated method stub
							if (obj instanceof String) {
								String a = (String) obj;
								if (a == null || "".equals(a)
										|| a.length() == 0)
									return true;
							}
							if (obj instanceof Integer) {
								Integer a = (Integer) obj;
								if (a == null)
									return true;
							}
							return false;
						}
					}, flag, "flag不能为空", from_uid, "from_uid不能为空", to_uid,
					"to_uid不能为空", of_from, "of_from不能为空", of_to, "of_to不能为空",
					content, "content不能为空", type, "type不能为空", time, "time不能为空",
					uuid, "uuid不能为空");
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
			PageParams pageParams = new PageParams();
			pageParams.setUseFlag(false);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("fromUid", from_uid);
			paramsMap.put("toUid", to_uid);
			paramsMap.put("page", pageParams);
			ImChatList chatModel = chatlistMapper
					.selectChatListByParams(paramsMap);
			if (chatModel == null) {
				L.a("chatModel is  null");
			} else {
				L.a("chatModel is not null:", JSONArray.toJSON(chatModel));
			}
			int meResult = messageMapper.insertSelective(record);

			L.w("meResult is ok ", String.valueOf(meResult));
			// TODO 检查消息列表更新或添加

			ImChatList putDateChatList = new ImChatList();
			putDateChatList.setFromUid(from_uid);
			putDateChatList.setToUid(to_uid);
			putDateChatList.setOfFrom(of_from);
			putDateChatList.setOfTo(of_to);
			putDateChatList.setLastTime(time);
			putDateChatList.setLastAtime(String.valueOf(atime));
			putDateChatList.setLastContent(content);
			putDateChatList.setType(type);
			putDateChatList.setUuid(UUID.randomUUID().toString());
			int chResult = 0;
			if (chatModel == null) {
				// TODO insert
				chResult = chatlistMapper.insertSelective(putDateChatList);
			} else {
				// TODO update;
				putDateChatList.setListId(chatModel.getListId());
				chResult = chatlistMapper
						.updateByPrimaryKeySelective(putDateChatList);
			}
			if (meResult < 1 || chResult < 1) {
				throw new ImDataException("Im存入出现异常，进入catch块。");
			} else {
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
			throw new ImDataException("Im数据异常，数据回滚中。" + e.getMessage());
		}

		return bWrapper;
	}
    
	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-25 下午5:02:59 
	 * @方法介绍  回话列表
	 * @参数说明 @param from_uid
	 * @参数说明 @return
	 * @return
	 */
	@DynDatasource
	public ImChatListWrappers<ImChatList> getImChatList(String from_uid) {
		ImChatListWrappers<ImChatList> wrappers = new ImChatListWrappers<ImChatList>();
		wrappers.setFlag(false);
		if (StringUtils.checkNull(from_uid)) {
			wrappers.setMsg("缺少必要的参数，请确保您的信息合法");
			wrappers.setStatus(false);
			return wrappers;
		}

		List<ImChatList> datas = chatlistMapper.selectByFromId(from_uid);
		if (datas == null || datas.size() == 0) {
			wrappers.setMsg("没有数据，请稍后尝试");
			wrappers.setStatus(false);
		} else {
			wrappers.setMsg("数据获取成功");
			wrappers.setStatus(true);
			wrappers.setFlag(true);
			wrappers.setDatas(datas);
		}
		return wrappers;
	}
    
	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-26 下午1:58:29 
	 * @方法介绍 消息撤回
	 * @参数说明 @param from_id 谁要撤回
	 * @参数说明 @param delete_uuid 要撤回的消息
	 * @参数说明 @return
	 * @return
	 */
	@DynDatasource
	@Transactional(rollbackFor = ImDataException.class)
	public BaseWrapper rollBackMessage(String from_id, String delete_uuid) {
		// 删除此消息
		BaseWrapper bw = new BaseWrapper();
		if (StringUtils.checkNull(from_id)
				|| StringUtils.checkNull(delete_uuid)) {
			bw.setFlag(false);
			bw.setStatus(false);
			bw.setMsg("缺少必要参数");
			return bw;
		}
        try {
        	ImMessageWithBLOBs message = messageMapper.selectByUUID(from_id,
    				delete_uuid);
    		if (message == null) {
    			bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("无效的撤回信息");
    			return bw;
    		}
    		List<ImMessageWithBLOBs> messages = messageMapper.selectByFromAndTo(
    				from_id, message.getToUid());
    		if (messages == null || messages.size() == 0) {
    			bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("无效的撤回信息");
    			return bw;
    		}
    		// 更新最后一条记录
    		int upRe=0;
    		if (delete_uuid.equals(messages.get(0).getUuid())) {
    			// 撤回的是最后一条信息
    			// 列表更新上一条
    			ImChatList chatList = new ImChatList();
    			chatList.setFromUid(from_id);
    			chatList.setToUid(message.getToUid());
    			chatList.setOfFrom(message.getOfFrom());
    			chatList.setOfTo(message.getOfTo());
    			chatList.setLastTime(message.getStime());
    			chatList.setLastAtime(message.getAtime());
    			if (messages.size() == 2) {
    				chatList.setLastContent(messages.get(1).getContent());
    			} else {
    				chatList.setLastContent("消息已经撤回");
    			}
    			upRe=chatlistMapper.updateByRollBack(chatList);
    		}
    		// 三分钟内可撤销
    		Long nowL = new Date(System.currentTimeMillis() - 1000 * 3 * 60)
    				.getTime();
    		String now = String.valueOf(nowL);
    		L.w("now is ", now);
    		int der = messageMapper.deleteByUUID(from_id, delete_uuid, now);
    		if (der < 1) {
    			bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("撤销失败");
    			return bw;
    		}
    	    if(der<=0||upRe<=0){
    	    	bw.setFlag(false);
    			bw.setStatus(false);
    			bw.setMsg("撤销失败");
    			throw new ImDataException("撤销失败");
    	    }else{
    	    	bw.setFlag(true);
    			bw.setStatus(true);
    			bw.setMsg("撤销成功");
    	    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bw.setFlag(false);
			bw.setStatus(false);
			bw.setMsg("撤销失败");
			throw new ImDataException("撤销失败"+e.getMessage());
		}
		return bw;
	}
    
	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-26 下午2:52:48 
	 * @方法介绍 获取消息列表
	 * @参数说明 @param from_uid
	 * @参数说明 @param to_uid
	 * @参数说明 @param last_time
	 * @参数说明 @param page
	 * @参数说明 @return
	 * @return
	 */
	@DynDatasource
	public ImMessageWrappers<ImMessageWithBLOBs> showMessageList(String from_uid,String to_uid,String last_time,Integer page){
		ImMessageWrappers<ImMessageWithBLOBs> mw =new ImMessageWrappers<ImMessageWithBLOBs>();
		String checkResult = StringUtils.checkNullUtils(
				new CheckCallBack() {
					@Override
					public boolean isNull(Object obj) {
						// TODO Auto-generated method stub
						if (obj instanceof String) {
							String a = (String) obj;
							if (a == null || "".equals(a)
									|| a.length() == 0)
								return true;
						}
						if (obj instanceof Integer) {
							Integer a = (Integer) obj;
							if (a == null)
								return true;
						}
						return false;
					}
				},  from_uid, "from_uid不能为空", to_uid,
				"to_uid不能为空",  last_time, "last_time不能为空");
		if (checkResult != null) {
			mw.setMsg(checkResult);
			mw.setStatus(false);
			mw.setFlag(false);
			return mw;
		}
		
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("fromId", from_uid);
		params.put("toId", to_uid);
		params.put("lastTime", last_time);
		params.put("pageSize", 10);
		params.put("pageNo", page);
		List<ImMessageWithBLOBs> datas=messageMapper.selectMessageByPage(params);
		if(datas==null||datas.size()==0){
			mw.setMsg("没有数据了！");
			mw.setStatus(false);
			mw.setFlag(false);
		}else{
			mw.setMsg("数据获取成功");
			mw.setStatus(true);
			mw.setFlag(true);
			mw.setDatas(datas);
		}
		return mw;
	}
	
	
}

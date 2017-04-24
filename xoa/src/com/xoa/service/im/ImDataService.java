package com.xoa.service.im;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.TODO;
import com.xoa.dao.im.ImChatListMapper;
import com.xoa.dao.im.ImMessageMapper;
import com.xoa.model.im.ImChatList;
import com.xoa.model.im.ImChatListExample;
import com.xoa.model.im.ImMessage;
import com.xoa.model.im.ImMessageWithBLOBs;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;

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
			record.setMsgType(type);
			record.setOfTo(of_to);
			record.setOfFrom(of_from);
			record.setToUid(to_uid);
			record.setUuid(uuid);
			record.setContent(content);
			record.setStime(time);
			Long atime = new Date().getTime();
			record.setAtime(atime.intValue());
			// TODO 处理附近信息
			// FIXME 类型不知道按什么区分现在默认文本类型
			switch (flag) {
			case 1:

				break;
			default:
				break;
			}
			int meResult = messageMapper.insert(record);
			// TODO 检查消息列表更新或添加
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("fromUid", from_uid);
			paramsMap.put("toUid", to_uid);
			ImChatList chatModel = chatlistMapper.selectChatListByParams(paramsMap);
			ImChatList putDateChatList= new ImChatList();
			putDateChatList.setFromUid(from_uid);
			putDateChatList.setToUid(to_uid);
			putDateChatList.setOfFrom(of_from);
			putDateChatList.setOfTo(of_to);
			putDateChatList.setLastTime(time);
			putDateChatList.setLastAtime(atime.intValue());
			putDateChatList.setLastContent(content);
			putDateChatList.setType(type);
			putDateChatList.setUuid(uuid);
			int chResult=0;
			if(chatModel==null){
//				TODO insert
				chResult=chatlistMapper.insert(putDateChatList);
			}else{
//				TODO update;
				putDateChatList.setListId(chatModel.getListId());
				chResult=chatlistMapper.insert(putDateChatList);
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
			bWrapper.setFlag(false);
			bWrapper.setMsg("操作失败");
			bWrapper.setStatus(false);
			throw new ImDataException("Im数据异常，数据回滚中。");
		}
		
		return bWrapper;
	}
}

package com.xoa.service.diary.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xoa.dao.diary.DiaryModelMapper;
import com.xoa.model.diary.DiaryModel;
import com.xoa.model.enclosure.Attachment;
import com.xoa.model.file.FileSortModel;
import com.xoa.service.diary.DiaryService;
import com.xoa.util.GetAttachmentListUtil;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;
/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:23:32
 * 类介绍  :    工作日志
 * 构造参数:   
 *
 */
@Service
public class DiaryServiceImpl implements DiaryService{
	private Logger loger = Logger.getLogger(DiaryServiceImpl.class);
	
	@Resource
	DiaryModelMapper diaryModelMapper;
    
	
	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:41:51
	 * 方法介绍:   工作日志首页接口
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel> 取得的首页加载内容
	 */
	public ToJson<DiaryModel> getDiaryIndex(DiaryModel diaryModel,PageParams pageParams ) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       //用户Id
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("pageParams", pageParams);
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiarySelf(diaryMap);
		   for(DiaryModel dm:diaryList){
				String tempDiaTime=dm.getDiaTime().substring(0, 19);
				String tempReaders=this.readerFlag(diaryModel.getUserId(), dm.getReaders());//\\s*|\t|\r|\n   .substring(0, 59)
				if(diaryModel.getPostType()!=null&&"1".equals(diaryModel.getPostType())){
				String tempContent=dm.getContent().replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").
						replaceAll("\\s*|\t|\r|\n", "");
				if(tempContent.length()>60){
					tempContent.substring(0, 59);
				}
				  dm.setContent(tempContent);
				}
				dm.setReaders(tempReaders);
				dm.setDiaTime(tempDiaTime);
				
				dm.setToId("");
		   }
		   //取得别人日志日志数量
		   Map<String, Object>  otherdiaryMap=new  HashMap<String, Object>();
		   otherdiaryMap.put("userIdOther", diaryModel.getUserId());
		   otherdiaryMap.put("diaTypeOther", "1");
		   List<DiaryModel> otherdiaryList=diaryModelMapper.getDiaryOtherList(otherdiaryMap);
		   Iterator<DiaryModel> iterator=otherdiaryList.iterator();
			while(iterator.hasNext()){
				DiaryModel dm=iterator.next();
				String temp=dm.getDiaTime().substring(0, 19);
				dm.setDiaTime(temp);
				if(!"1".equals(dm.getToAll())){
					 String[] dmStrings=dm.getToId().split(",");
					 List<String> userList = Arrays.asList(dmStrings);
					if(!userList.contains(diaryModel.getUserId())){
						iterator.remove();
						}
				}
			}
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, (otherdiaryList.size()+diaryList.size())+","+diaryList.size()+","+otherdiaryList.size());
		   diaryListToJson.setObj(diaryList);
		   return diaryListToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午6:58:23
	 * 方法介绍:   取得全部共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	public ToJson<DiaryModel> getDiaryAll(DiaryModel diaryModel, PageParams pageParams ) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("diaType", "1");
	       diaryMap.put("pageParams", pageParams);
		   List<DiaryModel> diaryAllList=diaryModelMapper.getDiaryList(diaryMap);
		   Iterator<DiaryModel> iterator=diaryAllList.iterator();
			while(iterator.hasNext()){
				DiaryModel dm=iterator.next();
				String temp=dm.getDiaTime().substring(0, 19);
				dm.setDiaTime(temp);
				if(dm.getUserId()!=diaryModel.getUserId()||!dm.getUserId().equals(diaryModel.getUserId())){
				if(!"1".equals(dm.getToAll())){
					 String[] dmStrings=dm.getToId().split(",");
					 List<String> userList = Arrays.asList(dmStrings);
					if(!userList.contains(diaryModel.getUserId())){
						iterator.remove();
					  }
				 }
				}
			}
			ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0,"");
			diaryListToJson.setObj(diaryAllList);
			diaryListToJson.setTotleNum(pageParams.getTotal());
		   return diaryListToJson;
	}
	 
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午6:58:23
	 * 方法介绍:   取得他人共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	public ToJson<DiaryModel> getDiaryOther(DiaryModel diaryModel,PageParams pageParams) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       diaryMap.put("userIdOther", diaryModel.getUserId());
	       diaryMap.put("diaTypeOther", "1");
	       diaryMap.put("pageParams", pageParams);
	       //他人日志 
		   List<DiaryModel> otherdiaryList=diaryModelMapper.getDiaryOtherList(diaryMap);
		   //加入权限处理字段
		   Iterator<DiaryModel> iterator=otherdiaryList.iterator();
			while(iterator.hasNext()){
				DiaryModel dm=iterator.next();
				//去除日期后面.0
				String temp=dm.getDiaTime().substring(0, 19);
				dm.setDiaTime(temp);
				//抛出不符合的记录
				if(!"1".equals(dm.getToAll())){
					 String[] dmStrings=dm.getToId().split(",");
					 List<String> userList = Arrays.asList(dmStrings);
					if(!userList.contains(diaryModel.getUserId())){
						iterator.remove();
						}
				}
			}
			  for(DiaryModel dm:otherdiaryList){
					String tempDiaTime=dm.getDiaTime().substring(0, 19);
					String tempReaders=this.readerFlag(diaryModel.getUserId(), dm.getReaders());//\\s*|\t|\r|\n
					if(diaryModel.getPostType()!=null&&"1".equals(diaryModel.getPostType())){
					String tempContent=dm.getContent().replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").
							replaceAll("\\s*|\t|\r|\n", "").substring(0, 59);
					  dm.setContent(tempContent);
					}
					dm.setReaders(tempReaders);
					dm.setDiaTime(tempDiaTime);
			   }
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, "");
		   diaryListToJson.setObj(otherdiaryList);
		   diaryListToJson.setTotleNum(pageParams.getTotal());
		   return diaryListToJson;
	}
	/**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 下午3:10:17
     * 方法介绍:   工作日志添加操作
     * 参数说明:   @param diaryModel
     * 参数说明:   @return
     * @return   int 添加数量影响行
     */
	public int saveDiary(DiaryModel diaryModel) {
		return diaryModelMapper.saveDiary(diaryModel);
	}
	 /**
	    * 
	    * 创建作者:   杨 胜
	    * 创建日期:   2017-4-19 下午3:39:29
	    * 方法介绍:   工作日志编辑操作
	    * 参数说明:   @param diaryModel
	    * 参数说明:   @return
	    * @return   int  修改
	    */
	public int updateDiary(DiaryModel diaryModel) {
		return diaryModelMapper.updateDiary(diaryModel);
	}
	 /**
	    * 
	    * 创建作者:   杨 胜
	    * 创建日期:   2017-4-19 下午3:39:29
	    * 方法介绍:   工作日志根据ID删除
	    * 参数说明:   @param diaryModel
	    * 参数说明:   @return
	    * @return   int  修改
	    */
	@Override
	public int deletDiaById(DiaryModel diaryModel) {
		return diaryModelMapper.deletDiaById(diaryModel);
	}
	 /**
	    * 
	    * 创建作者:   杨 胜
	    * 创建日期:   2017-4-19 下午3:39:29
	    * 方法介绍:   通过DiaId取得日志详情 并设置已读未读
	    * 参数说明:   @param diaryModel
	    * 参数说明:   @return
	    * @return   ToJson<DiaryModel> 详情单条列表对象
	    */
	public ToJson<Attachment> getDiaryByDiaId(DiaryModel diaryModel,String sqlType) {
		ToJson<Attachment> diaryListToJson=new ToJson<Attachment>(0, "");
		DiaryModel diary=diaryModelMapper.getDiaryByDiaId(diaryModel);
		if(diary==null){
			return diaryListToJson;
		}
		if("0".equals(readerFlag(diaryModel.getUserId(),diary.getReaders()))){
		   diary.setReaders(diary.getReaders()+diaryModel.getUserId()+",");
		   diaryModelMapper.updateReadersByDiaId(diary);
		}
		String temp=diary.getDiaTime().substring(0, 19);
		diary.setDiaTime(temp);
		diary.setReaders("");
		List<Attachment> attachmentList=new ArrayList<Attachment>();
		if(diary.getAttachmentName()!=null&&!"".equals(diary.getAttachmentName())){
		attachmentList=GetAttachmentListUtil.returnAttachment(diary.getAttachmentName(),diary.getAttachmentId(),sqlType,GetAttachmentListUtil.MODULE_DIARY);
		}
		diary.setAttachment(attachmentList);
		diaryListToJson.setObject(diary);
		return diaryListToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-3 下午2:54:56
	 * 方法介绍:   判断已读未读
	 * 参数说明:   @param userId
	 * 参数说明:   @param readers
	 * 参数说明:   @return
	 * @return     String 返回字符串“1”为已读 “0”为未读通过前端判断进行辨别
	 */
	   public String readerFlag(String userId,String readers){
	    	 String[] readersStrings=readers.split(",");
			 List<String> userList = Arrays.asList(readersStrings);
			 if(userList.contains(userId)){
				 return "1";
			 }
			return "0";
	     }
    public static String decompress(String data) throws UnsupportedEncodingException {
        return decompress(data,"ISO-8859-1");
        
//		   for(DiaryModel dm:diaryAllList){
//			 System.out.println("---------------getCompressContentBefore-------------"+dm.getCompressContent());
//			 String compressString=null;
//			try {
//				compressString=decompress(URLDecoder.decode(dm.getCompressContent(), "ISO-8859-1"));
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		      dm.setCompressContent(compressString);
//		      System.out.println("---------------getCompressContentAfter-------------"+dm.getCompressContent());
//		   }
}
public static String decompress(String data, String charset) throws UnsupportedEncodingException {

        byte[] bytes = data.getBytes(charset);

        byte[] output = new byte[1024];

        Inflater decompresser = new Inflater();
        decompresser.reset();
        decompresser.setInput(bytes);

        ByteArrayOutputStream o = new ByteArrayOutputStream(bytes.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        decompresser.end();
        return new String(output);
    }

	
//	public String transfor(String s){
//		byte[] compressByte=s.getBytes();
//    	InputStream tempIs=new ByteArrayInputStream(compressByte);
//    	InputStreamReader isr=null;
//    	try {
//		   isr=new InputStreamReader(tempIs,"Unicode");
//		} catch (UnsupportedEncodingException e) {
//            loger.info("mediumblob二进制转化异常");
//			e.printStackTrace();
//		}
//    	BufferedReader br=new BufferedReader(isr);
//    	StringBuffer compressBuffer=null;
//    	try {
//    		compressBuffer=new StringBuffer();
//			while (br.readLine()!=null) {
//    			compressBuffer.append(br.readLine());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//    	String  compressString=null;
//    	try {
//			compressString=new String(compressBuffer.toString().getBytes("ISO-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return compressString;
//	} 
  
	
}

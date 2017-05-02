package com.xoa.service.diary.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.xoa.model.file.FileSortModel;
import com.xoa.service.diary.DiaryService;
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
	 * @return   ToJson<DiaryModel>
	 */
	public ToJson<DiaryModel> getDiaryIndex(DiaryModel diaryModel,PageParams pageParams ) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       //用户Id
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("diaType", "1");
	       diaryMap.put("pageParams", pageParams);
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiarySelf(diaryMap);
		   Iterator<DiaryModel> iterator=diaryList.iterator();
			while(iterator.hasNext()){
				DiaryModel dm=iterator.next();
				if(!"1".equals(dm.getToAll())){
					 String[] dmStrings=dm.getToId().split(",");
					 List<String> userList = Arrays.asList(dmStrings);
					if(!userList.contains(diaryModel.getUserId())){
						iterator.remove();
						}
				}
			}
		   //取得共享日志数量
		   diaryModel.setDiaType("1");
		   int diaryCount=diaryModelMapper.getDiaryCount(diaryModel);
		   int  sharListSelf=diaryModelMapper.getDiarySelfLess(diaryModel);
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, diaryCount+","+diaryList.size()+","+(diaryCount-sharListSelf));
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
	public List<DiaryModel> getDiaryAll(DiaryModel diaryModel, PageParams pageParams ) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("diaType", "1");
	       diaryMap.put("pageParams", pageParams);
		   List<DiaryModel> diaryAllList=diaryModelMapper.getDiaryList(diaryMap);
		   Iterator<DiaryModel> iterator=diaryAllList.iterator();
			while(iterator.hasNext()){
				DiaryModel dm=iterator.next();
				if(!"1".equals(dm.getToAll())){
					 String[] dmStrings=dm.getToId().split(",");
					 List<String> userList = Arrays.asList(dmStrings);
					if(!userList.contains(diaryModel.getUserId())){
						iterator.remove();
					}
				}
			}
		   return diaryAllList;
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
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("diaType", "1");
	       diaryMap.put("pageParams", pageParams);
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiaryOtherList(diaryMap);
		   Iterator<DiaryModel> iterator=diaryList.iterator();
			while(iterator.hasNext()){
				DiaryModel dm=iterator.next();
				if(!"1".equals(dm.getToAll())){
					 String[] dmStrings=dm.getToId().split(",");
					 List<String> userList = Arrays.asList(dmStrings);
					if(!userList.contains(diaryModel.getUserId())){
						iterator.remove();
						}
				}
			}
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, "");
		   diaryListToJson.setObj(diaryList);
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

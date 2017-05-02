package com.xoa.service.diary.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xoa.dao.diary.DiaryModelMapper;
import com.xoa.model.diary.DiaryModel;
import com.xoa.service.diary.DiaryService;
import com.xoa.util.ToJson;
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
	public ToJson<DiaryModel> getDiaryIndex(DiaryModel diaryModel) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       //用户Id
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("toAll", "0");
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiarySelf(diaryMap);
		   //取得共享日志数量
		   int diaryCount=diaryModelMapper.getDiaryCount(diaryMap);
		   Map<String, Object> tempNo=new  HashMap<String, Object>();
	       //用户Id
		   tempNo.put("userId", diaryModel.getUserId());
		   tempNo.put("toAll", "0");
		   int  sharListSelf=diaryModelMapper.getDiarySelfLess(tempNo);
		   
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
	public List<DiaryModel> getDiaryAll(DiaryModel diaryModel) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
		   List<DiaryModel> diaryAllList=diaryModelMapper.getDiaryList(diaryMap);
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
	public ToJson<DiaryModel> getDiaryOther(DiaryModel diaryModel) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("toAll", "0");
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiaryOtherList(diaryMap);
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

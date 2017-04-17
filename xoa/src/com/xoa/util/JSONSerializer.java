package com.xoa.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName (类名):  JSONSerializer
 * @Description(简述): JSON初始化
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:52:22
 *
 */
public class JSONSerializer {
	 private static final String DEFAULT_CHARSET_NAME = "UTF-8";

	 /**
	  * 
	  * @Title: serialize
	  * @Description: 对象转换为json
	  * @author(作者):      zy
	  * @param: @param object
	  * @param: @return   
	  * @return: String   
	  * @throws
	  */
     public static <T> String serialize(T object) {
         return JSON.toJSONString(object);
     }

     /**
      * 
      * @Title: deserialize
      * @Description: 获取json中的对象
      * @author(作者):      zy
      * @param: @param string
      * @param: @param clz
      * @param: @return   
      * @return: T   
      * @throws
      */
     public static <T> T deserialize(String string, Class<T> clz) {
         return JSON.parseObject(string, clz);
     }

     /**
      * 
      * @Title: load
      * @Description: 路径的类转换为对象
      * @author(作者):      zy
      * @param: @param path
      * @param: @param clz
      * @param: @return
      * @param: @throws IOException   
      * @return: T   
      * @throws
      */
     public static <T> T load(Path path, Class<T> clz) throws IOException {
         return deserialize(
                 new String(Files.readAllBytes(path), DEFAULT_CHARSET_NAME), clz);
     }

     /**
      * 
      * @Title: save
      * @Description: 对象保存为文件
      * @author(作者):      zy
      * @param: @param path
      * @param: @param object
      * @param: @throws IOException   
      * @return: void   
      * @throws
      */
     public static <T> void save(Path path, T object) throws IOException {
         if (Files.notExists(path.getParent())) {
             Files.createDirectories(path.getParent());
         }
         Files.write(path,
                 serialize(object).getBytes(DEFAULT_CHARSET_NAME),
                 StandardOpenOption.WRITE,
                 StandardOpenOption.CREATE,
                 StandardOpenOption.TRUNCATE_EXISTING);
     }
     
     public static void main(String[] args) {
//         System.out.println(serialize(Object));
     }
     
}

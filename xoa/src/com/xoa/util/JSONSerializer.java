package com.xoa.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.alibaba.fastjson.JSON;

/**
 * @author  zhangyong
 * @version 1.0
 * @parameter 
 * @since 
 * @return 
 */
public class JSONSerializer {
	 private static final String DEFAULT_CHARSET_NAME = "UTF-8";

     public static <T> String serialize(T object) {
         return JSON.toJSONString(object);
     }

     public static <T> T deserialize(String string, Class<T> clz) {
         return JSON.parseObject(string, clz);
     }

     public static <T> T load(Path path, Class<T> clz) throws IOException {
         return deserialize(
                 new String(Files.readAllBytes(path), DEFAULT_CHARSET_NAME), clz);
     }

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

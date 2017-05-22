package com.xoa.util;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

 /**
 * 创建作者:   zlf
 * 创建日期:   2017年5月22日 上午11:08:15
 * 类介绍  :   	 文件上传工具类
 * 构造参数:   
 *
 */
public class FileUploadUtil {
     public static final List<String> ALLOW_TYPES = Arrays.asList(
                "image/jpg","image/jpeg","image/png","image/gif"
        );
    //文件重命名
        public static String rename(String fileName){
            int i = fileName.lastIndexOf(".");
            String str = fileName.substring(i);
            return new Date().getTime()+""+ new Random().nextInt(99999999) +str;
        }
    //校验文件类型是否是被允许的
        public static boolean allowUpload(String postfix){
            return ALLOW_TYPES.contains(postfix);
        }
}
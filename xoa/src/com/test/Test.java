package com.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.xoa.util.http.HttpClientUtil;

public class Test {
	    @Value("${app_login_path_php}")
	    String b;
	    private String url = b;  
	    private String charset = "utf-8";  
	    private HttpClientUtil httpClientUtil = null;  
	      
	    public Test(){  
	        httpClientUtil = new HttpClientUtil();  
	    }  
	      
	    public void test(){  
	        String httpOrgCreateTest = url + "httpOrg/create";  
	        Map<String,String> createMap = new HashMap<String,String>();  
	        createMap.put("userid","username");  
	        createMap.put("password","password");  
	        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
	        System.out.println("result:"+httpOrgCreateTestRtn);  
	    }  
	      
	    public static void main(String[] args){  
	        Test  main = new Test();  
	        main.test();  
	    }  
}

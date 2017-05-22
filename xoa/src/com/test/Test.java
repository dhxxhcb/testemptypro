package com.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	      
//	    public static void main(String[] args){
//	        Test  main = new Test();
//	        main.test();
//	    }

	public static String match(String source, String element, String attr) {
		List<String> result = new ArrayList<String>();
		String reg = "<" + "input" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		Matcher m = Pattern.compile(reg).matcher(source);
//		System.out.print(m.pattern());
       int regl=source.length();
       int i=0;
		if(m.find()) {
			String 	a=m.group(1);
			int start=m.start();
			int end=m.end();

//			String r = m.group();
//		    String b=	source.replaceAll(r,"a");
			result.add(a);
//			System.out.println("start:"+start+"end:"+end+"length:"+source.length());
			source=replaceByPostion(source,Arrays.toString(result.toArray()),start,end);
//			System.out.println(source);
			source=	match(source,element,attr);
		}
		return source;
	}

	public static String replaceByPostion(String source,String replace,Integer start,Integer end){

		String res=source.substring(0,start)+replace+source.substring(end,source.length());
        return res;
	}

	public static void main(String[] args) {

	    	String b="<table align=\"center\" border=\"0\" bordercolor=\"#ffffff\" class=\"xdLayout\" style=\"border: currentColor; border-collapse: collapse; table-layout: fixed; -ms-word-wrap: break-word;\" tabindex=\"65535\" width=\"650\">\n" +
					"\t<colgroup>\n" +
					"\t\t<col style=\"width: 650px;\" />\n" +
					"\t</colgroup>\n" +
					"\t<tbody valign=\"top\">\n" +
					"\t\t<tr style=\"min-height: 17px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-bottom-color: rgb(255, 0, 0); border-bottom-width: 1pt; border-bottom-style: solid;\">\n" +
					"\t\t\t<div align=\"center\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><span style=\"font-size: 22pt;\"><font color=\"#ff0000\" face=\"宋体\"><strong>内部事项报批单</strong></font></span></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 19px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: solid; border-bottom-style: none;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font color=\"#ff0000\" face=\"Times New Roman\"><span style=\"font-size: 16pt;\">批示：</span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 233px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: top; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: none; border-bottom-style: solid;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font color=\"#ff0000\" face=\"Times New Roman\"><span style=\"font-size: 16pt;\"><textarea class=\"AUTO3\" cols=\"70\" name=\"DATA_17\" rich=\"0\" style=\"width: 645px; height: 36px;\" title=\"中心领导批示\"></textarea></span></font></div>\n" +
					"\n" +
					"\t\t\t<div style=\"text-align: right; padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><img align=\"absMiddle\" alt=\"\" border=\"0\" class=\"SIGN\" name=\"DATA_15\" sign_color=\"0x0000FF\" sign_type=\"1,0,\" src=\"/static/images/form/websign.png\" title=\"签章控件:分管领导盖章\" value=\"分管领导盖章\" /><input class=\"AUTO3\" datafld=\"SYS_DATE_CN\" hidden=\"1\" name=\"DATA_21\" title=\"中心领导批示日期\" type=\"text\" value=\"{MACRO}\" /></div>\n" +
					"\n" +
					"\t\t\t<div style=\"text-align: right; padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><textarea cols=\"70\" name=\"DATA_1\" rich=\"0\" rows=\"1\" style=\"width: 646px; height: 38px;\" title=\"分管领导批示\"></textarea><img align=\"absMiddle\" alt=\"\" border=\"0\" class=\"SIGN\" name=\"DATA_16\" sign_color=\"0x0000FF\" sign_type=\"1,0,\" src=\"/static/images/form/websign.png\" title=\"签章控件:中心领导签章\" value=\"中心领导签章\" /></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 66px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: solid; border-bottom-style: solid;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font face=\"Times New Roman\"><span style=\"font-size: 16pt;\"><font color=\"#ff0000\">呈报： <input align=\"left\" class=\"AUTO3\" hidden=\"0\" name=\"DATA_2\" size=\"18\" style=\"width: 141px; height: 30px; text-align: left;\" title=\"呈报人\" type=\"text\" /></font></span><span style=\"font-size: 14pt;\"><font color=\"#ff0000\">同志</font></span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 43px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: solid; border-bottom-style: none;\">\n" +
					"\t\t\t<div style=\"text-align: center; padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><input align=\"center\" class=\"AUTO1\" hidden=\"0\" name=\"DATA_3\" size=\"43\" style=\"width: 333px; height: 30px; text-align: center;\" title=\"标题\" type=\"text\" /></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 211px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: top; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: none; border-bottom-style: solid;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"line-height: 26pt; font-size: 14pt; margin-top: 0pt; margin-bottom: 0pt;\"><span style=\"font-size: 16pt;\"><font color=\"#ff0000\"><textarea class=\"AUTO2\" cols=\"70\" name=\"DATA_4\" rich=\"0\" rows=\"11\" style=\"width: 647px; height: 208px;\" title=\"事由\"></textarea></font></span></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 45px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: solid; border-bottom-style: solid;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font face=\"Times New Roman\"><span style=\"font-size: 16pt;\"><font color=\"#ff0000\">文件类型：<select name=\"DATA_13\" title=\"文件类型\"><option selected=\"selected\" value=\"请示\">请示</option><option value=\"报告\">报告</option><option value=\"情况说明\">情况说明</option><option value=\"其他\">其他</option> </select></font></span><span><font color=\"#ff0000\"> <input align=\"left\" class=\"AUTO\" id=\"DATA_18\" name=\"DATA_18\" size=\"18\" style=\"width: 109px; height: 19px; text-align: left;\" title=\"其他\" type=\"text\" /></font></span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 45px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: solid; border-bottom-style: none;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font color=\"#ff0000\" face=\"Times New Roman\"><span style=\"font-size: 16pt;\">经办处室：<input class=\"AUTO\" datafld=\"SYS_DEPTNAME_SHORT\" hidden=\"0\" name=\"DATA_19\" title=\"经办处室\" type=\"text\" value=\"{MACRO}\" /></span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 37px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: none; border-bottom-style: none;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font color=\"#ff0000\" face=\"Times New Roman\"><span style=\"font-size: 16pt;\">处室负责人：<img align=\"absMiddle\" alt=\"\" border=\"0\" class=\"SIGN\" name=\"DATA_10\" sign_color=\"0x0000FF\" sign_type=\"1,0,\" src=\"/static/images/form/websign.png\" title=\"签章控件:处室负责人\" value=\"处室负责人\" /></span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 42px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: none; border-bottom-style: none;\">\n" +
					"\t\t\t<div align=\"justify\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font color=\"#ff0000\" face=\"Times New Roman\"><span style=\"font-size: 16pt;\">经办人：<input class=\"AUTO\" datafld=\"SYS_USERNAME\" hidden=\"0\" name=\"DATA_20\" title=\"经办人\" type=\"text\" value=\"{MACRO}\" /></span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t\t<tr style=\"min-height: 38px;\">\n" +
					"\t\t\t<td style=\"padding: 1px; vertical-align: middle; border-top-color: rgb(255, 0, 0); border-bottom-color: rgb(255, 0, 0); border-top-width: 1pt; border-bottom-width: 1pt; border-top-style: none; border-bottom-style: solid;\">\n" +
					"\t\t\t<div align=\"right\" style=\"padding-right: 0pt; padding-left: 0pt; font-size: 10.5pt; margin-top: 0pt; margin-bottom: 0pt;\"><font color=\"#ff0000\" face=\"Times New Roman\"><span style=\"font-size: 16pt;\"><input class=\"AUTO\" datafld=\"SYS_DATE_CN\" hidden=\"0\" name=\"DATA_12\" title=\"日期\" type=\"text\" value=\"{MACRO}\" /></span></font></div>\n" +
					"\t\t\t</td>\n" +
					"\t\t</tr>\n" +
					"\t</tbody>\n" +
					"</table>\n";
		String source = "<p>宏控件：<input title=\"宏控件\" class=\"AUTO\" \n" +
				"datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_6\" value=\"{MACRO}\" type=\"text\"/>" +
				"<input title=\"宏控件\" class=\"AUTO\" \n" +
				"datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_8\" value=\"{MACRO}\" type=\"text\"/>" +
				"" +
				"</p>" +
				"<p>测试件：<input title=\"宏控件\" class=\"AUTO\" \n" +
				"datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_7\" value=\"{MACRO}\" type=\"text\"/></p> ";
		String list = match(b, "input", "name");
		System.out.println(list);
	}

}

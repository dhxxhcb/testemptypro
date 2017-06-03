package com.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xoa.util.DateFormat;
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
		Matcher m;
//		List<String> result = new ArrayList<String>();
//		String reg = "<" + "input" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		//String i1="<option\b(?=[^>]*value='([^']*)')(?:[^>]*([^']*)')?[^>]*>(.*?)</option>"+"<option(?=[^>]*value='([^']*)')(?:[^>]*([^']*)')?[^>]*>(.*?)</option>";
     	//String reg = "<" + "textarea" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>"+"</textarea>";
		String reg1 = /*"<" + "select" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>[^<>]*?['\"]?(.*?)['\"]?(\\s.*?)?"+*/"<option[^<>]*?['\"]?(.*?)['\"]?(\\s.*?)?>[^<>]*?['\"]?(.*?)['\"]?(\\s.*?)?</option>"/*+"</select>"*/;
		//String reg1 = "<option[^>]*?>[\\\\s\\\\S]*?<\\\\/option>";
//		String reg1=""
//		StringBuffer reg1 = new StringBuffer();
//		if (source.matches("<input")){
//			reg1.append( "<" + "input" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>");ss
//		}else if (){
//			reg1.append("<" + "textarea" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>"+"</textarea>");
//
//		}


		//String reg2 = "/<.*?[input|textarea|select].*?>/i";
		 m = Pattern.compile(reg1).matcher(source);
		 System.out.print(m.pattern());
		// m = Pattern.compile(reg1).matcher(source);
//		System.out.print(m.pattern());
       int regl=source.length();
       int i=0;
		if(m.find()) {
			String 	a=m.group(1);
			int start=m.start();
			int end=m.end();

//			String r = m.group();
//		    String b=	source.replaceAll(r,"a");
//			result.add(a);
			/*a="{"+a+"}";*/
			System.out.println("start:"+start+"end:"+end+"length:"+source.length());
			source=replaceByPostion(source,a,start,end);
//			System.out.println(source);
			source=	match(source,element,attr);
		}
		return source;
	}
	public static String matchB(String source , String attr) {
		Matcher m;
//		String reg = "<" + "input" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		String reg = "<" + "select" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>[^<>]*?['\"]?(.*?)['\"]?(\\s.*?)?"+"</select>";
		m = Pattern.compile(reg).matcher(source);
		int regl=source.length();
		int i=0;
		if(m.find()) {
			String 	a=m.group(1);
			int start=m.start();
			int end=m.end();
			a="{"+a+"}";
			System.out.println("start:"+start+"end:"+end+"length:"+source.length());
			source=replaceByPostion(source,a,start,end);
			source=	matchB(source,attr);
		}
		return source;
	}
	public static String matchC(String source , String attr) {
		Matcher m;
		String reg = "<" + "img" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?/>";
		m = Pattern.compile(reg).matcher(source);
		int regl=source.length();
		int i=0;
		if(m.find()) {
			String 	a=m.group(1);
			int start=m.start();
			int end=m.end();
			a="{"+a+"}";
			System.out.println("start:"+start+"end:"+end+"length:"+source.length());
			source=replaceByPostion(source,a,start,end);
			source=	matchC(source,attr);
		}
		return source;
	}
	public static String matchD(String source , String attr) {
		Matcher m;
		String reg = "<" + "input" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		//String reg = "<" + "select" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>[^<>]*?['\"]?(.*?)['\"]?(\\s.*?)?"+"</select>";
		m = Pattern.compile(reg).matcher(source);
		int regl=source.length();
		int i=0;
		if(m.find()) {
			String 	a=m.group(1);
			int start=m.start();
			int end=m.end();
			a="{"+a+"}";
			System.out.println("start:"+start+"end:"+end+"length:"+source.length());
			source=replaceByPostion(source,a,start,end);
			source=	matchD(source,attr);
		}
		return source;
	}

	public static String replaceByPostion(String source,String replace,Integer start,Integer end){

		String res=source.substring(0,start)+replace+source.substring(end,source.length());
        return res;
	}
	public static String matchE(String source , String attr) {
		Matcher m;
		//String reg = "<" + "input" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		String reg = "<" + "textarea" + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>"+"</textarea>";
		m = Pattern.compile(reg).matcher(source);
		int regl=source.length();
		int i=0;
		if(m.find()) {
			String 	a=m.group(1);
			int start=m.start();
			int end=m.end();
			a="{"+a+"}";
			System.out.println("start:"+start+"end:"+end+"length:"+source.length());
			source=replaceByPostion(source,a,start,end);
			source=	matchE(source,attr);
		}
		return source;
	}



	public static void main(String[] args) {

		String name = "{\"intoTheCondition\":{\"list\":[\"\",\"\"],\"prcsInSet\":\"fdsafsda\",\"conditionDesc\":\"fdasdfas\"},\"transferConditions\":{\"list\":[\"\"],\"prcsOutSet\":\"fdafdsa\",\"conditionDesc\":\"fdasdfas\"}}\n";
		JSONObject obj = JSONArray.parseObject(name);
		String obj1 = obj.getString("intoTheCondition");
		String obj2 = obj.getString("transferConditions");
		String  name1 = JSONArray.parseObject(obj1).getString("list");
		String  name2 = JSONArray.parseObject(obj1).getString("prcsInSet");
		String  name3 = JSONArray.parseObject(obj1).getString("conditionDesc");
		String  name4 = JSONArray.parseObject(obj2).getString("list");
		String  name5 = JSONArray.parseObject(obj2).getString("prcsOutSet");
		String  name6 = JSONArray.parseObject(obj2).getString("conditionDesc");
		System.out.println(name1+">>>>>"+name2+">>>>>"+">>>>>"+name3+">>>>>"+name4+">>>>>"+name5+">>>>>"+name6);


//		Date date = new Date();
//			String time = "0000-00-00 00:00:00";
//			int  l =DateFormat.getTime(DateFormat.getStrDate(date))-DateFormat.getTime(time);
//        long day=l/(24*60*60);
//        long hour=(l/(60*60)-day*24);
//        long min=((l/(60))-day*24*60-hour*60);
//        long s=(l-day*24*60*60-hour*60*60-min*60);
//			System.out.println(DateFormat.getTime(time));

//	    	String b="<p>\n" +DateFormat.getTime(flowRunPrcs.getDeliverTime()))iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
//					"    单行输入框：<input type=\"text\" name=\"DATA_1\" align=\"left\" hidden=\"0\" title=\"单行输入框\" style=\"text-align:left;\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    多行输入框：<textarea title=\"多行输入框\" rich=\"0\" style=\"\" name=\"DATA_2\"></textarea>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    下拉菜单：<select title=\"下拉菜单\" name=\"DATA_3\">" +
//					"    <option value=\"A项目\">\n" +
//					"        A项目\n" +
//					"    </option>\n" +
//					"    <option value=\"B项目\" selected=\"selected\">\n" +
//					"        B项目\n" +
//					"    </option></select>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    单选框：<img name=\"DATA_4\" title=\"单选框\" radio_check=\"\" radio_field=\"A`B`C`\" src=\"/static/images/form/radio.png\" class=\"RADIO\" classname=\"RADIO\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    复选框：<input type=\"checkbox\" name=\"DATA_5\" title=\"复选框\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    列表控件：<img title=\"列表控件\" default_cols=\"\" border=\"0\" name=\"DATA_9\" alt=\"\" align=\"absMiddle\" lv_title=\"序号`产品`数量`价格`\" lv_sum=\"0`0`0`0`\" lv_field=\"xuhao`chanpin`shuliang`jiage`\" lv_size=\"70`70`70`70`\" lv_colvalue=\"````\" lv_coltype=\"text`text`text`text`\" lv_cal=\"````\" datatype=\"1\" lv_value=\"1\" new_width=\"true\" class=\"LIST_VIEW\" style=\"cursor: hand\" src=\"/static/images/form/listview.png\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    宏控件：<input title=\"宏控件\" class=\"AUTO\" datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_6\" value=\"{MACRO}\" type=\"text\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    日历控件：<input title=\"日历控件\" class=\"AUTO\" datafld=\"SYS_DATE_CN\" hidden=\"0\" style=\"\" name=\"DATA_7\" value=\"{MACRO}\" type=\"text\"/><img title=\"日期控件:日历控件\" value=\"日历控件\" date_format=\"yyyy-MM-dd\" border=\"0\" align=\"absMiddle\" class=\"DATE\" classname=\"DATE\" src=\"/static/images/form/calendar.png\" style=\"cursor: pointer;width:18px;height:18px;\" alt=\"\" name=\"OTHER_1\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    计算控件：<input class=\"CALC\" classname=\"CALC\" title=\"计算控件\" prec=\"4\" name=\"DATA_8\" value=\"单行输入框+多行输入框\" type=\"text\" hidden=\"0\"/>\n" +
//					"</p>\n" +
//					"<p>\n" +
//					"    <br/>\n" +
//					"</p>";
//		String source = "<p>宏控件：<input title=\"宏控件\" class=\"AUTO\" \n" +
//				"datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_6\" value=\"{MACRO}\" type=\"text\"/>" +
//				"<input title=\"宏控件\" class=\"AUTO\" \n" +
//				"datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_8\" value=\"{MACRO}\" type=\"text\"/>" +
//				"" +
//				"</p>" +
//				"<p>测试件：<input title=\"宏控件\" class=\"AUTO\" \n" +
//				"datafld=\"SYS_USERNAME\" hidden=\"0\" style=\"\" name=\"DATA_7\" value=\"{MACRO}\" type=\"text\"/></p> ";
//		        String list = match(b, "input", "name");
//		        String aw=matchB(list,"name");
//		       String a2=matchC(aw,"name");
//				String a3=matchD(a2,"name");
//		       String a4=matchE(a3,"name");
//
//
//		System.out.println(a4);
	}

}

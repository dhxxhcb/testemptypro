package com.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.swing.*;

import com.xoa.model.email.EmailBoxModel;
import com.xoa.model.unitmanagement.UnitManage;
import com.xoa.model.users.Users;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.unitmanagement.UnitManageService;
import com.xoa.service.users.UsersService;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.dataSource.ContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailModel;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.worldnews.News;
import com.xoa.service.email.EmailService;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;

@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"}) 
public class Ctest {

//	@Resource
//	private FlowTypeService flowTypeService;
//
//	@Test
//	public void test() throws Exception {
//
//
//
//	}



//	@Resource  
//	private NewService newService;

//	邮箱测试
//	@Resource
//	private EmailService emailUtilService;

	//新建流程测试
//	@Resource
//	private FlowProcessService flowProcessService;

//	@Resource
//	private FlowTypeService flowTypeService;

	@Test
	public void test()throws  Exception{
//		FlowTypeModel flowTypeModel = new FlowTypeModel();
//		flowTypeModel.setFlowName("测试修改");
//		flowTypeModel.setFlowNo(1);
//		flowTypeModel.setDeptId(1);
//		flowTypeModel.setFlowSort(1);
//		flowTypeModel.setFlowType("1");
//		flowTypeModel.setFormId(117);
//		flowTypeModel.setFreeOther("2");
//		flowTypeModel.setFlowId(136);
//		ToJson<FlowTypeModel> toJson = flowTypeService.updateFlow(flowTypeModel);
//		System.out.println(toJson.getMsg());
//		String name ="<p dir=\"ltr\">&#28207;&#23186;&#31216;&#26607;&#27905;&#36814;&#25112;AlphaGo&#34920;&#29616;&#20248;&#20110;&#26446;&#19990;&#30707;&#65306;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#13;<br>\n" +
//				"                                                                2017-05-23 17:11:32 &#26469;&#28304;&#65306;&#21442;&#32771;&#28040;&#24687;&#32593; &#36131;&#20219;&#32534;&#36753;&#65306;&#24352;&#31243;&#13;<br>\n" +
//				"                                                                &#26680;&#24515;&#25552;&#31034;&#65306;&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
//				"                                                                &#21442;&#32771;&#28040;&#24687;&#32593;5&#26376;23&#26085;&#25253;&#36947; &#28207;&#23186;&#31216;&#65292;&#20013;&#22269;&#22260;&#26827;&#21517;&#23558;&#26607;&#27905;&#19982;&#35895;&#27468;&#20154;&#24037;&#26234;&#33021;&#31995;&#32479;AlphaGo&#30340;&#20154;&#26426;&#22260;&#26827;&#22823;&#25112;&#65292;&#23613;&#31649;&#33853;&#36133;&#65292;&#20294;&#19982;&#21435;&#24180;&#25361;&#25112;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#12290;&#13;<br>\n" +
//				"                                                                &#25454;&#39321;&#28207;&#12298;&#32463;&#27982;&#26085;&#25253;&#12299;5&#26376;23&#26085;&#25253;&#36947;&#65292;&#26681;&#25454;&#28165;&#21326;&#33322;&#38498;AI&#31070;&#31639;&#23376;&#32473;&#20986;&#30340;&#25968;&#25454;&#26159;&#65292;&#21452;&#26041;&#34892;&#26827;&#33267;106&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#25345;&#32493;&#25552;&#21319;&#33267;45.91&#65292;&#33853;&#21518;&#20165;7&#30446;&#12290;&#33267;108&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#20026;45.63&#12290;&#13;<br>\n" +
//				"                                                                &#19982;&#21435;&#24180;&#23545;&#24328;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26446;&#19990;&#30707;&#39318;&#23616;4&#20010;&#21322;&#23567;&#26102;&#23436;&#25104;186&#25163;&#65307;&#20854;&#32988;&#29575;&#26366;&#32500;&#25345;&#22312;40&#65285;&#24320;&#22836;&#65292;&#19968;&#24230;&#21319;&#33267;47&#65285;&#24038;&#21491;&#65292;&#20294;&#38543;&#21518;&#21448;&#22312;116&#25163;&#21518;&#36300;&#33267;&#20165;&#20004;&#25104;&#22810;&#12290;&#13;<br>\n" +
//				"                                                                &#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
//				"                                                                &#20013;&#22269;&#22260;&#26827;&#21327;&#20250;&#20027;&#24109;&#29579;&#27741;&#21335;&#35748;&#20026;&#65292;&#21040;&#30446;&#21069;&#20026;&#27490;&#36824;&#26159;&#24456;&#26377;&#24847;&#24605;&#30340;&#65292;&#26607;&#27905;&#26377;&#22791;&#32780;&#26469;&#65292;&#22791;&#25112;&#36824;&#26159;&#24456;&#35814;&#32454;&#30340;&#12290;&#13;<br>\n" +
//				"                                                                &#38889;&#22269;&#26827;&#25163;&#37329;&#24237;&#36132;&#28857;&#35780;&#26607;&#27905;&#20170;&#22825;&#30340;&#34920;&#29616;&#26102;&#65292;&#20197;&#21069;&#26607;&#27905;&#21644;&#20154;&#31867;&#19979;&#65292;&#22987;&#32456;&#26174;&#24471;&#24456;&#20174;&#23481;&#12290;&#20294;&#20170;&#22825;&#33080;&#19978;&#20805;&#34880;&#65292;&#26174;&#24471;&#24456;&#32039;&#24352;&#12290;&#28207;&#23186;&#31216;&#26607;&#27905;&#36814;&#25112;AlphaGo&#34920;&#29616;&#20248;&#20110;&#26446;&#19990;&#30707;&#65306;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#13;<br>\n" +
//				"                                                                2017-05-23 17:11:32 &#26469;&#28304;&#65306;&#21442;&#32771;&#28040;&#24687;&#32593; &#36131;&#20219;&#32534;&#36753;&#65306;&#24352;&#31243;&#13;<br>\n" +
//				"                                                                &#26680;&#24515;&#25552;&#31034;&#65306;&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
//				"                                                                &#21442;&#32771;&#28040";
		String name = "<p dir=\"ltr\">&#28207;&#23186;&#31216;&#26607;&#27905;&#36814;&#25112;AlphaGo&#34920;&#29616;&#20248;&#20110;&#26446;&#19990;&#30707;&#65306;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#13;<br>\n" +
				"                                                                2017-05-23 17:11:32 &#26469;&#28304;&#65306;&#21442;&#32771;&#28040;&#24687;&#32593; &#36131;&#20219;&#32534;&#36753;&#65306;&#24352;&#31243;&#13;<br>\n" +
				"                                                                &#26680;&#24515;&#25552;&#31034;&#65306;&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
				"                                                                &#21442;&#32771;&#28040;&#24687;&#32593;5&#26376;23&#26085;&#25253;&#36947; &#28207;&#23186;&#31216;&#65292;&#20013;&#22269;&#22260;&#26827;&#21517;&#23558;&#26607;&#27905;&#19982;&#35895;&#27468;&#20154;&#24037;&#26234;&#33021;&#31995;&#32479;AlphaGo&#30340;&#20154;&#26426;&#22260;&#26827;&#22823;&#25112;&#65292;&#23613;&#31649;&#33853;&#36133;&#65292;&#20294;&#19982;&#21435;&#24180;&#25361;&#25112;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#12290;&#13;<br>\n" +
				"                                                                &#25454;&#39321;&#28207;&#12298;&#32463;&#27982;&#26085;&#25253;&#12299;5&#26376;23&#26085;&#25253;&#36947;&#65292;&#26681;&#25454;&#28165;&#21326;&#33322;&#38498;AI&#31070;&#31639;&#23376;&#32473;&#20986;&#30340;&#25968;&#25454;&#26159;&#65292;&#21452;&#26041;&#34892;&#26827;&#33267;106&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#25345;&#32493;&#25552;&#21319;&#33267;45.91&#65292;&#33853;&#21518;&#20165;7&#30446;&#12290;&#33267;108&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#20026;45.63&#12290;&#13;<br>\n" +
				"                                                                &#19982;&#21435;&#24180;&#23545;&#24328;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26446;&#19990;&#30707;&#39318;&#23616;4&#20010;&#21322;&#23567;&#26102;&#23436;&#25104;186&#25163;&#65307;&#20854;&#32988;&#29575;&#26366;&#32500;&#25345;&#22312;40&#65285;&#24320;&#22836;&#65292;&#19968;&#24230;&#21319;&#33267;47&#65285;&#24038;&#21491;&#65292;&#20294;&#38543;&#21518;&#21448;&#22312;116&#25163;&#21518;&#36300;&#33267;&#20165;&#20004;&#25104;&#22810;&#12290;&#13;<br>\n" +
				"                                                                &#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
				"                                                                &#20013;&#22269;&#22260;&#26827;&#21327;&#20250;&#20027;&#24109;&#29579;&#27741;&#21335;&#35748;&#20026;&#65292;&#21040;&#30446;&#21069;&#20026;&#27490;&#36824;&#26159;&#24456;&#26377;&#24847;&#24605;&#30340;&#65292;&#26607;&#27905;&#26377;&#22791;&#32780;&#26469;&#65292;&#22791;&#25112;&#36824;&#26159;&#24456;&#35814;&#32454;&#30340;&#12290;&#13;<br>\n" +
				"                                                                &#38889;&#22269;&#26827;&#25163;&#37329;&#24237;&#36132;&#28857;&#35780;&#26607;&#27905;&#20170;&#22825;&#30340;&#34920;&#29616;&#26102;&#65292;&#20197;&#21069;&#26607;&#27905;&#21644;&#20154;&#31867;&#19979;&#65292;&#22987;&#32456;&#26174;&#24471;&#24456;&#20174;&#23481;&#12290;&#20294;&#20170;&#22825;&#33080;&#19978;&#20805;&#34880;&#65292;&#26174;&#24471;&#24456;&#32039;&#24352;&#12290;&#28207;&#23186;&#31216;&#26607;&#27905;&#36814;&#25112;AlphaGo&#34920;&#29616;&#20248;&#20110;&#26446;&#19990;&#30707;&#65306;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#13;<br>\n" +
				"                                                                2017-05-23 17:11:32 &#26469;&#28304;&#65306;&#21442;&#32771;&#28040;&#24687;&#32593; &#36131;&#20219;&#32534;&#36753;&#65306;&#24352;&#31243;&#13;<br>\n" +
				"                                                                &#26680;&#24515;&#25552;&#31034;&#65306;&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
				"                                                                &#21442;&#32771;&#28040;&#24687;&#32593;5&#26376;23&#26085;&#25253;&#36947; &#28207;&#23186;&#31216;&#65292;&#20013;&#22269;&#22260;&#26827;&#21517;&#23558;&#26607;&#27905;&#19982;&#35895;&#27468;&#20154;&#24037;&#26234;&#33021;&#31995;&#32479;AlphaGo&#30340;&#20154;&#26426;&#22260;&#26827;&#22823;&#25112;&#65292;&#23613;&#31649;&#33853;&#36133;&#65292;&#20294;&#19982;&#21435;&#24180;&#25361;&#25112;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#25454;&#39321;&#28207;&#12298;&#32463;&#27982;&#26085;&#25253;&#12299;5&#26376;23&#26085;&#25253;&#36947;&#65292;&#26681;&#25454;&#28165;&#21326;&#33322;&#38498;AI&#31070;&#31639;&#23376;&#32473;&#20986;&#30340;&#25968;&#25454;&#26159;&#65292;&#21452;&#26041;&#34892;&#26827;&#33267;106&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#25345;&#32493;&#25552;&#21319;&#33267;45.91&#65292;&#33853;&#21518;&#20165;7&#30446;&#12290;&#33267;108&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#20026;45.63&#12290;&#13;<br>\n" +
				"\t\t\t\t&#19982;&#21435;&#24180;&#23545;&#24328;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26446;&#19990;&#30707;&#39318;&#23616;4&#20010;&#21322;&#23567;&#26102;&#23436;&#25104;186&#25163;&#65307;&#20854;&#32988;&#29575;&#26366;&#32500;&#25345;&#22312;40&#65285;&#24320;&#22836;&#65292;&#19968;&#24230;&#21319;&#33267;47&#65285;&#24038;&#21491;&#65292;&#20294;&#38543;&#21518;&#21448;&#22312;116&#25163;&#21518;&#36300;&#33267;&#20165;&#20004;&#25104;&#22810;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#20013;&#22269;&#22260;&#26827;&#21327;&#20250;&#20027;&#24109;&#29579;&#27741;&#21335;&#35748;&#20026;&#65292;&#21040;&#30446;&#21069;&#20026;&#27490;&#36824;&#26159;&#24456;&#26377;&#24847;&#24605;&#30340;&#65292;&#26607;&#27905;&#26377;&#22791;&#32780;&#26469;&#65292;&#22791;&#25112;&#36824;&#26159;&#24456;&#35814;&#32454;&#30340;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#38889;&#22269;&#26827;&#25163;&#37329;&#24237;&#36132;&#28857;&#35780;&#26607;&#27905;&#20170;&#22825;&#30340;&#34920;&#29616;&#26102;&#65292;&#20197;&#21069;&#26607;&#27905;&#21644;&#20154;&#31867;&#19979;&#65292;&#22987;&#32456;&#26174;&#24471;&#24456;&#20174;&#23481;&#12290;&#20294;&#20170;&#22825;&#33080;&#19978;&#20805;&#34880;&#65292;&#26174;&#24471;&#24456;&#32039;&#24352;&#12290;<br>\n" +
				"\t\t\t\t&#28207;&#23186;&#31216;&#26607;&#27905;&#36814;&#25112;AlphaGo&#34920;&#29616;&#20248;&#20110;&#26446;&#19990;&#30707;&#65306;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#13;<br>\n" +
				"\t\t\t\t2017-05-23 17:11:32 &#26469;&#28304;&#65306;&#21442;&#32771;&#28040;&#24687;&#32593; &#36131;&#20219;&#32534;&#36753;&#65306;&#24352;&#31243;&#13;<br>\n" +
				"\t\t\t\t&#26680;&#24515;&#25552;&#31034;&#65306;&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#21442;&#32771;&#28040;&#24687;&#32593;5&#26376;23&#26085;&#25253;&#36947; &#28207;&#23186;&#31216;&#65292;&#20013;&#22269;&#22260;&#26827;&#21517;&#23558;&#26607;&#27905;&#19982;&#35895;&#27468;&#20154;&#24037;&#26234;&#33021;&#31995;&#32479;AlphaGo&#30340;&#20154;&#26426;&#22260;&#26827;&#22823;&#25112;&#65292;&#23613;&#31649;&#33853;&#36133;&#65292;&#20294;&#19982;&#21435;&#24180;&#25361;&#25112;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#26377;&#36807;&#20043;&#32780;&#26080;&#19981;&#21450;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#25454;&#39321;&#28207;&#12298;&#32463;&#27982;&#26085;&#25253;&#12299;5&#26376;23&#26085;&#25253;&#36947;&#65292;&#26681;&#25454;&#28165;&#21326;&#33322;&#38498;AI&#31070;&#31639;&#23376;&#32473;&#20986;&#30340;&#2\n" +
				"\t\t5968;&#25454;&#26159;&#65292;&#21452;&#26041;&#34892;&#26827;&#33267;106&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#25345;&#32493;&#25552;&#21319;&#33267;45.91&#65292;&#33853;&#21518;&#20165;7&#30446;&#12290;&#33267;108&#25163;&#65292;&#26607;&#27905;&#32988;&#29575;&#20026;45.63&#12290;&#13;<br>\n" +
				"\t\t\t\t&#19982;&#21435;&#24180;&#23545;&#24328;AlphaGo&#30340;&#38889;&#22269;&#26827;&#25163;&#26446;&#19990;&#30707;&#30456;&#27604;&#65292;&#26446;&#19990;&#30707;&#39318;&#23616;4&#20010;&#21322;&#23567;&#26102;&#23436;&#25104;186&#25163;&#65307;&#20854;&#32988;&#29575;&#26366;&#32500;&#25345;&#22312;40&#65285;&#24320;&#22836;&#65292;&#19968;&#24230;&#21319;&#33267;47&#65285;&#24038;&#21491;&#65292;&#20294;&#38543;&#21518;&#21448;&#22312;116&#25163;&#21518;&#36300;&#33267;&#20165;&#20004;&#25104;&#22810;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#20174;&#21021;&#27493;&#25512;&#25454;&#25512;&#31639;&#65292;&#26607;&#27905;&#30340;&#34920;&#29616;&#21487;&#33021;&#24050;&#22909;&#20110;&#21435;&#24180;&#26446;&#19990;&#30707;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#20013;&#22269;&#22260;&#26827;&#21327;&#20250;&#20027;&#24109;&#29579;&#27741;&#21335;&#35748;&#20026;&#65292;&#21040;&#30446;&#21069;&#20026;&#27490;&#36824;&#26159;&#24456;&#26377;&#24847;&#24605;&#30340;&#65292;&#26607;&#27905;&#26377;&#22791;&#32780;&#26469;&#65292;&#22791;&#25112;&#36824;&#26159;&#24456;&#35814;&#32454;&#30340;&#12290;&#13;<br>\n" +
				"\t\t\t\t&#38889;&#22269;&#26827;&#25163;&#37329;&#24237;&#36132;&#28857;&#35780;&#26607;&#27905;&#20170;&#22825;&#30340;&#34920;&#29616;&#26102;&#65292;&#20197;&#21069;&#26607;&#27905;&#21644;&#20154;&#31867;&#19979;&#65292;&#22987;&#32456;&#26174;&#24471;&#24456;&#20174;&#23481;&#12290;&#20294;&#20170;&#22825;&#33080;&#19978;&#20805;&#34880;&#65292;&#26174;&#24471;&#24456;&#32039;&#24352;&#12290;<br>\n" +
				"\t\t\t\t--&#21457;&#33258;&#25105;&#30340;&#24515;&#36890;&#36798;OA&#29256;--</p>";

		System.out.println(name.trim().length());
		System.out.println(16777215/16);

//		4516
//		10434

//		flowName: $('#projectName').val(),
//				flowNo: $('#orderID').val(),
//				deptId: 1,
//				flowSort: 1,
//				flowType: 1,
//				formId: 117,
//				freeOther: 2
	}






//    @Resource
//    private UsersService usersService;
//
//    @Resource
//	private UnitManageService unitManageService;
	
//	@Test
//	public void test() throws Exception {
//		FlowProcess flowProcess = new FlowProcess();
////		==>  Preparing: insert into flow_process ( FLOW_ID , PRCS_ID , PRCS_NAME , SET_LEFT , SET_TOP ) values ( ?, ?, ?, ?, ? )
////==> Parameters: 2(Integer), 9(Integer), node_1(String), 719(Integer), 280(Integer)
//		flowProcess.setFlowId(2);
//		flowProcess.setPrcsId(9);
//		flowProcess.setPrcsName("node_1");
//		flowProcess.setSetLeft(719);
//		flowProcess.setSetTop(280);
////		flowProcess.setPluginSave("4546546");
//		flowProcess.setRemindFlag(0);
//		flowProcessService.insertSelective(flowProcess);
////		System.out.println(JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
////		System.out.println(i);
//
//	}

//		Integer page = 1;
//		Integer pageSize = 5;
//		boolean useFlag = true;
//		Map<String, Object> maps = new HashMap<String, Object>();
//		maps.put("fromId","zhanglan");
//		maps.put("sendFlag","1");
//		maps.put("firstFlag","");
//		maps.put("secondFlag","");
////			maps.put("startTime", DateFormat.getTime("2015-10-10 10:10:10"));
////			maps.put("endTime", DateFormat.getTime("2017-04-12 10:10:10"));
////		maps.put("readFlag","");
////		maps.put("boxId", "");
////		maps.put("sign","");
////		maps.put("keyword","");
//		List<EmailBody> list = emailUtilService.selectEmail(maps, page, pageSize,
//				useFlag);
//		int listLength = list.size();
//		if (listLength > 0) {
//			ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "查询成功");
//			tojson.setObj(list);
//			System.out.println(JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss"));
//		} else {
//			ToJson<EmailBody> tojson = new ToJson<EmailBody>(1, "查询失败");
//			System.out.println(JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss"));
//		}
//	
	}


//	邮箱测试
//	@Test
//	public void test() throws Exception {
//
//		Map<String,Object> maps = new HashMap<String,Object>();
//		maps.put("fromId","admin");
//		maps.put("boxId",4);
//		ToJson<EmailBodyModel> toJson =
//		emailUtilService.deleteBoxEmail(maps,  1, 5, false);
//		System.out.println(toJson);


//		System.out.println(DateFormat.getStrTime(1494929129));
//		EmailBoxModel emailBoxModel = new EmailBoxModel();
//		emailBoxModel.setBoxName("测试盒子");
//		emailBoxModel.setUserId("admin");
//		emailBoxModel.setBoxNo(1);
//		Map<String,Object> maps = new HashMap<String,Object>();
//		maps.put("userId","admin");
//		EmailModel emailModel = new EmailModel();
//		emailModel.setBoxId(1);
//		emailModel.setEmailId(1110);
//		emailModel.setToId("admin");
//		Map<String,Object> maps = new HashMap<String,Object>();
//		maps.put("fromId","admin");
//		maps.put("boxId","1");
//		ToJson<EmailBodyModel> toJson =emailUtilService.selectBoxEmail( maps,1, 5, true,"xoa1001");
//		System.out.println(toJson.getMsg());

//		ContextHolder.setConsumerType("xoa1001");
//		UnitManage um = unitManageService.showUnitManage();
////		loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(um, "yyyy-MM-dd HH:mm:ss"));
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("showNews", JSON.toJSONStringWithDateFormat(um, "yyyy-MM-dd HH:mm:ss"));
//		System.out.println(JSON.toJSONStringWithDateFormat(um, "yyyy-MM-dd HH:mm:ss"));
//		return ;


//		String names = "<p dir=\"ltr\"><br>\n&#27979;&#35797;<br></p>\n<p dir=\"ltr\">&#27979;&#35797;<br></p>\n" +
//				"<p dir=\"ltr\">&#27979;&#35797;<br>\n--&#21457;&#33258;&#25105;&#30340;&#24515;&#36890;&#36798;OA&#29256;--</p>\n";
//		System.out.println(JEditorPane.getKeymap(names));
//		Html.get

//		ResourceBundle rb =  ResourceBundle.getBundle("jdbc-sql");
//		String name = rb.getString("mysql.driverClassName");
//		System.out.println("jieguo:"+name);
		
//        ContextHolder.setConsumerType("xoa");
//        System.out.println("类型："+ContextHolder.getConsumerType());
//                Users user=usersService.findUserByName("zhangyong");
//        ToJson<Users> json=new ToJson<Users>(0, null);
//        try {
//            if (user.getBpNo()=="") {
//                System.out.println("登录失败");
//            }else {
//                System.out.println("登录成功");
//            }
//
//        } catch (Exception e) {
//            json.setMsg(e.getMessage());
//
//        }
        
        
        
        
        
//		Map<String,Object> maps = new HashMap<String, Object>();
//		maps.put("bodyId", Integer.valueOf("11"));
//		maps.put("fromId", "zhanglan");
//		EmailBodyModel emailBody = emailUtilService.queryById(maps, 1, 5, false);
//		EmailBodyModel emailbo = new EmailBodyModel();
//
//		System.out.println("emailBody:"+!StringUtils.isEmpty(emailBody));
//		System.out.println("\n emailbo:"+emailBody.getBodyId());
//
//		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "查询成功");
//		tojson.setObject(emailBody);
//
//		System.out.println(JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss"));
		
		
//		
//		 Map<String,Object> maps = new HashMap<String, Object>();
//	     maps.put("typeId", null);
//	     maps.put("newsTime", null);
//	    List<News> page = newService.selectNews(maps, 1, 5, true);
//		System.out.println(JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss"));
		
		
//		EmailBodyModel emailBody = new EmailBodyModel();
//		emailBody.setFromId("admin");
//		emailBody.setToId2(
//				"liumingcai,liuyingwu,wangyun,changbai,chenchangliu,chenqiang,lichang,liuyongkang,liuna,wangde,litian,wuhai,lihai,zhangshan,");
//		emailBody.setCopyToId("wangde,zhaomin,");
//		emailBody.setSecretToId("liuna,");
//		emailBody.setSubject("植一株小草于心间");
//		emailBody.setContent("下班回家的时候，我无意间看到了墙头的草。我就惊叹于它的自强和坚韧。于草来说，这应该是最恶劣的环境了吧。砖头墙的中间，上不着天，下不着地，没有及时的雨水，更没有丰厚的土壤。唯一赖以生存的，就是砖头缝里的那一丁点泥土。而它，没有萎蔫，也没有抱怨，鲜嫩的叶子正昭示着它蓬勃的生命力。后来，观察那株小草成为我生活中必不可少的事儿。有一次，因为一个小小的差错，我被主管狠狠地批评了一顿。那天，心情极为黑暗，眼泪随时都有掉下来的冲动。下班回家的时候，我照例观察起了墙角的那棵小草。它一如既往地展示着动人的生命力，与平日并无两样。有那么一瞬间，我被小草感动了。这是一种多么坦然的心境啊，不以物喜，不以己悲，我们都没法做到，可是它做到了。（励志文章）毒辣的阳光、猛烈的暴雨、强劲的阵风……当它们次第在小草身上经过的时候，小草没有妥协，更没有自暴自弃，只是默默地绽放着自己的色彩。这么想着的时候，我的心里顿时舒坦了许多。相对于小草，我的处境显然优越了许多，我又有什么理由不比它更坚强呢？秋天的时候，小草终究枯萎了。而我，并没有悲伤，因为我已经把它植于我的心间。现在的社会，工作忙碌，生活节奏快，人际关系复杂。而我们，正需要这样一棵草，来提醒我们要自立，要坚强，要拼搏！");
//		emailBody.setSendTime(DateFormat.getTime(DateFormat.getStrDate(new Date())));
//		emailBody.setAttachmentId("");
//		emailBody.setAttachmentName("");
//		emailBody.setSendFlag("1");
//		emailBody.setSmsRemind("0");
//		// 重要程度(空-一般邮件,1-重要,2-非常重要)
//		emailBody.setImportant("");
//		emailBody.setSize((long) 0);
//		emailBody.setFromWebmailId(0);
//		emailBody.setFromWebmail("");
//		emailBody.setToWebmail("");
//		emailBody.setCompressContent(new byte[0]);
//		emailBody.setWebmailContent(new byte[0]);
//		emailBody.setWebmailFlag("0");
//		emailBody.setRecvFromName("");
//		emailBody.setRecvFrom("");
//		emailBody.setRecvToId(0);
//		emailBody.setRecvTo("");
//		emailBody.setIsWebmail("0");
//		emailBody.setIsWf("0");
//		emailBody.setKeyword("项目,项目,训练营,精英,魔鬼");
//		// 标识符 未定义
//		emailBody.setSecretLevel(0);
//		// 审核人 需要明确关系
//		emailBody.setAuditMan("");
//		// 审核不通过备注 需明确
//		emailBody.setAuditRemark("");
//		// 抄送外部邮箱串 需明确
//		emailBody.setCopyToWebmail("");
//		// 密送外部邮箱串 需明确
//		emailBody.setSecretToWebmail("");
//		// 点赞人 需明确
//		emailBody.setPraise("");
//		EmailModel email = new EmailModel();
//		email.setEmailId(241);
//		email.setReadFlag("");
//		// 邮件删除状态
//		email.setDeleteFlag("");
//		// 邮件箱分类ID 需明确
//		email.setBoxId(0);
//		// 邮件体ID 需明确
//		email.setBodyId(0);
//		email.setReceipt("");
//		// 需明确关系 显示不能为空
//		email.setIsF("");
//		// 需明确关系 显示不能为空
//		email.setIsR("");
//		// 显示不能为空
//		email.setSign("");
//		emailUtilService.sendEmail(emailBody, email);
//}

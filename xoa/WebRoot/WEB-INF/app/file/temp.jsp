<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<title>权限设置</title>
		<link rel="stylesheet" type="text/css" href="../css/file/temp.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/file/temp.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
	<div class="content">
		<div  class="cabinet_left">

		</div>
		<div  class="cabinet_right">
			<div class="nav">
				<ul class="index_head">
					<li id="visitJurisd" style="margin-left: 10px;">
						<span class="one headli">访问权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="addJurisd">
						<span class="headli">新建权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="editJurisd">
						<span class="headli">编辑权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="deleteJurisd">
						<span class="headli">删除权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="commentJurisd">
						<span class="headli">评论权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="downloadJurisd">
						<span class="headli">下载/打印权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="signJurisd">
						<span class="headli">签阅权限</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="owner">
						<span class="headli">所有者</span>
						<img src="../img/02.png" alt=""/>
					</li>
					<li id="batchSettings">
						<span class="headli" style="margin-top: 1px;">批量设置</span>
					</li>
				</ul>
			</div>
			<div class="title">
				<div class="img"></div>
				<div class="divTitle">公司管理制度 - 复件</div>
			</div>
			<div class="tabTypeOne" style="display: block;">
				<div class="specPermiss">
					<span style="font-size: 18px;margin-left: 20px;color: #124164;font-weight: bold;">指定权限</span>
					<span class="explain" style="font-size: 14px;">指定访问权限，有权限的人员可以访问该文件夹、子文件夹和文件</span>
				</div>
				<div class="table">
					<table cellspacing="0" cellpadding="0" style="border-collapse:collapse;background-color: #fff;width: 80%;">
						<tr>
							<td width="20%" style="text-align: center;">
								<p>授权范围：</p>
								<p>（部门）</p>
							</td>
							<td>
								<div class="inPole">
									<textarea name="txt" id="SendCompany" user_id='id' value="admin" disabled style="min-width: 300px;min-height:150px;"></textarea>
									<span class="add_img" style="margin-left: 10px">
		                                    <a href="javascript:;" id="SelectCompany" class="Add ">添加</a>
		                                </span>
									<span class="add_img">
		                                    <a href="javascript:;" class="deClearUser">清除</a>
		                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								<p>授权范围：</p>
								<p>（角色）</p>
							</td>
							<td>
								<div class="inPole">
									<textarea name="txt" id="SendPriv" user_id='id' value="admin" disabled style="min-width: 300px;min-height:150px;"></textarea>
									<span class="add_img" style="margin-left: 10px">
		                                    <a href="javascript:;" id="SelectPriv" class="Add ">添加</a>
		                                </span>
									<span class="add_img">
		                                    <a href="javascript:;" class="deClearUser">清除</a>
		                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								<p>授权范围：</p>
								<p>（人员）</p>
							</td>
							<td>
								<div class="inPole">
									<textarea name="txt" id="Senduser" user_id='id' value="admin" disabled style="min-width: 300px;min-height:150px;"></textarea>
									<span class="add_img" style="margin-left: 10px">
		                                    <a href="javascript:;" id="SelectUser" class="Add ">添加</a>
		                                </span>
									<span class="add_img">
		                                    <a href="javascript:;" class="deClearUser">清除</a>
		                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								选项：
							</td>
							<td>
								<input type="checkbox" name="check" id="checks" value="" />
								<span>重置所有下级子文件夹的权限</span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="div_btn">
									<input type="button" class="inpuBtn" id="btnSure" value="确定" />
									<input type="button" class="inpuBtn" id="btnBack" value="返回" />
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="tabTypeTwo" style="display: none;">
				<div class="specPermiss">
					<span style="font-size: 18px;margin-left: 20px;color: #124164;font-weight: bold;">批量设置</span>
					<span class="explain" style="font-size: 14px;">作用于本文件夹和下级所有子文件夹</span>
				</div>
				<div class="table">
					<table cellspacing="0" cellpadding="0" style="border-collapse:collapse;background-color: #fff;width: 80%;">
						<tr>
							<td width="20%" style="text-align: center;">
								<p>授权范围：</p>
								<p>（部门）</p>
							</td>
							<td>
								<div class="inPole">
									<textarea name="txt" id="batchSendCompany" user_id='id' value="admin" disabled style="min-width: 300px;min-height:50px;"></textarea>
									<span class="add_img" style="margin-left: 10px">
		                                    <a href="javascript:;" id="batchSelectCompany" class="Add ">添加</a>
		                                </span>
									<span class="add_img">
		                                    <a href="javascript:;" class="deClearUser">清除</a>
		                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								<p>授权范围：</p>
								<p>（角色）</p>
							</td>
							<td>
								<div class="inPole">
									<textarea name="txt" id="batchSendPriv" user_id='id' value="admin" disabled style="min-width: 300px;min-height:50px;"></textarea>
									<span class="add_img" style="margin-left: 10px">
		                                    <a href="javascript:;" id="batchSelectPriv" class="Add ">添加</a>
		                                </span>
									<span class="add_img">
		                                    <a href="javascript:;" class="deClearUser">清除</a>
		                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								<p>授权范围：</p>
								<p>（人员）</p>
							</td>
							<td>
								<div class="inPole">
									<textarea name="txt" id="batchSenduser" user_id='id' value="admin" disabled style="min-width: 300px;min-height:50px;"></textarea>
									<span class="add_img" style="margin-left: 10px">
		                                    <a href="javascript:;" id="batchSelectUser" class="Add ">添加</a>
		                                </span>
									<span class="add_img">
		                                    <a href="javascript:;" class="deClearUser">清除</a>
		                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								设置选项：
							</td>
							<td>
								<div>
									<input type="checkbox" name="check" value="" />
									<span>访问权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" id="" value="" />
									<span>新建权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" id="" value="" />
									<span>编辑权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" id="" value="" />
									<span>删除权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" id="" value="" />
									<span>评论权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" id="" value="" />
									<span>下载/打印权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" id="" value="" />
									<span>签阅权限</span>
								</div>
								<div>
									<input type="checkbox" name="check" value="" />
									<span>所有者</span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" style="text-align: center;">
								操作：
							</td>
							<td>
								<input type="radio" name="radios" id="addRadios" value="" />
								<span style="margin-right: 10px;">添加权限</span>
								<input type="radio" name="radios" id="deleteRadios" value="" />
								<span>删除权限</span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="div_btn">
									<input type="button" class="inpuBtn" id="Btn_sure" value="确定" />
									<input type="button" class="inpuBtn" id="Btn_back" value="返回" />
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>

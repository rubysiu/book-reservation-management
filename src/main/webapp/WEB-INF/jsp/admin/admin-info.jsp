<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<%@include file="../common/head.jsp" %>
		<link rel="stylesheet" type="text/css" href="/resources/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="/resources/static/admin/css/admin.css"/>
		<script src="/resources/script/admin.js"></script>
	</head>
	<body>
		<div class="layui-tab page-content-wrap">
		  <ul class="layui-tab-title">
		    <li class="layui-this">个人资料</li>
		  </ul>
		  <div class="layui-tab-content">

		    <div class="ayui-tab-iteml layui-show">
		    	<form class="layui-form" v style="width: 90%;padding-top: 20px;">
					<input type="hidden" name="id" disabled autocomplete="off" class="layui-input layui-disabled" value="${admin.id}">
					<input type="hidden" name="token" disabled autocomplete="off" class="layui-input layui-disabled" value="${admin.token}">
				  <div class="layui-form-item">
				    <label class="layui-form-label">用户名：</label>
				    <div class="layui-input-block">
				      <input type="text" name="username" disabled autocomplete="off" class="layui-input layui-disabled" value="${token} *注:账号即密码，密码即账号">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">新密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
<%--				  <div class="layui-form-item">--%>
<%--				    <label class="layui-form-label">新密码：</label>--%>
<%--				    <div class="layui-input-block">--%>
<%--				      <input type="password" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">--%>
<%--				    </div>--%>
<%--				  </div>--%>
<%--				  <div class="layui-form-item">--%>
<%--				    <label class="layui-form-label">重复密码：</label>--%>
<%--				    <div class="layui-input-block">--%>
<%--				      <input type="password" name="password3" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">--%>
<%--				    </div>--%>
<%--				  </div>--%>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminPassword">立即提交</button>
				    </div>
				  </div>
				</form>
		    </div>
		  </div>
		</div>
	<script src="/resources/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>

		//Demo
		layui.use(['form','element'], function(){
		  var form = layui.form();
		  var element = layui.element();
		  form.render();
		  // //监听信息提交
		  // form.on('submit(adminInfo)', function(data){
		  //   layer.msg(JSON.stringify(data.field));
		  //   return false;
		  // });
		  //监听密码提交
		   form.on('submit(adminPassword)', function(data){
			   // layer.msg(JSON.stringify(data.field));
			   // layer.msg(JSON.stringify(data.field));
			   var id = data.field.id;
			   var token = data.field.token;
			   var password = data.field.password;
			   // console.log(id);
			   // return  false;
			   // alert(JSON.stringify(data.field));
			   $.ajax({
				   type: 'post',
				   url: "/admin/edit",
				   data: {
				   	id:id,token:token,password:password
				   },
				   dataType:'text',
				   success: function (res) {
					   if (res>0){
						   layer.msg("修改成功！", {
							   time: 1000,
							   end: function(){
							   	admin.delCookie();
							   }
						   });
					   }else {
					   		layer.msg("修改失败")
					   }
				   }
			   });
			   return false;
		  });
		});
	</script>
	</body>
</html>
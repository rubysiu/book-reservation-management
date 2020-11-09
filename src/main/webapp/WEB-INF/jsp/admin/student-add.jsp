<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>添加书籍</title>
		<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/resources/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="/resources/static/admin/css/admin.css"/>
	</head>
	<body>
	<form class="layui-form column-content-detail">
					<div class="layui-tab">
<%--						<ul class="layui-tab-title">--%>
<%--							<li class="layui-this">文章内容</li>--%>
<%--							<li>SEO优化</li>--%>
<%--						</ul>--%>
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">学号：</label>
									<div class="layui-input-block">
										<input type="text" name="studentId" required lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">密码：</label>
									<div class="layui-input-block">
										<input type="text" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" >
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="addStudent">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
	<script src="/resources/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="/resources/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	<script>
		layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',  'tool', 'element', 'upload', 'layedit'], function() {
				var form = layui.form(),
					layer = layui.layer,
					$ = layui.jquery,
					dialog = layui.dialog;
			form.on('submit(addStudent)', function(data){
				var studentId = data.field.studentId;
				var password = data.field.password;
				$.ajax({
					type: 'post',
					url: "/admin/addStudent",
					data: {
						studentId:studentId,password:password
					},
					dataType:'text',
					success: function (res) {
						console.log(res)
						if (res>0){
						layer.msg("添加成功！", {
								time: 1000,
								end: function(){
									var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index); //再执行关闭
									parent.window.frames['iframe3'].location.reload();
								}
							});
						}else {
							layer.msg("添加失败")
						}
					}
				});
				return false;
			});
			});
	</script>
	</body>
</html>
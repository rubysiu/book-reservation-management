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
									<label class="layui-form-label">书名：</label>
									<div class="layui-input-block">
										<input type="text" name="name" required lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
									</div>
								</div>
<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">分类栏目：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<select name="category" lay-verify="required">--%>
<%--											<option value="">请选择分类栏目</option>--%>
<%--												<option value="1">公司新闻</option>--%>
<%--												<option value="2">行业新闻</option>--%>
<%--										</select>--%>
<%--									</div>--%>
<%--								</div>--%>
<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">图像上传：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<input type="file" name="file（可随便定义）" class="layui-upload-file">--%>
<%--									</div>--%>
<%--								</div>--%>
<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">标签：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<input type="checkbox" name="label[tj]" title="推荐" checked>--%>
<%--										<input type="checkbox" name="label[zd]" title="置顶">--%>
<%--										<input type="checkbox" name="label[hot]" title="热门">--%>
<%--									</div>--%>
<%--								</div>--%>
<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">是否单页：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<input type="checkbox" name="switch" lay-skin="switch">--%>
<%--									</div>--%>
<%--								</div>--%>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">简介：</label>
									<div class="layui-input-block">
										<textarea class="layui-textarea " name="introd" lay-verify="content" id="LAY_demo_editor"></textarea>
									</div>
								</div>

<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">文章来源：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<input type="text" name="laiyuan" required lay-verify="required" placeholder="请输入文章来源" autocomplete="off" class="layui-input">--%>
<%--									</div>--%>
<%--								</div>--%>
<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">文章排序：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<input type="text" name="listorder" required lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input" value="100">--%>
<%--									</div>--%>
<%--								</div>--%>
								<div class="layui-form-item">
									<label class="layui-form-label">库存：</label>
									<div class="layui-input-block">
										<input type="text" name="number" required lay-verify="required" placeholder="库存" autocomplete="off" class="layui-input" value="10">
									</div>
								</div>
							</div>
<%--							<div class="layui-tab-item">--%>
<%--								<div class="layui-form-item">--%>
<%--									<label class="layui-form-label">关键字：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<input type="text" name="laiyuan" placeholder="请输入关键字" autocomplete="off" class="layui-input">--%>
<%--									</div>--%>
<%--								</div>--%>
<%--								<div class="layui-form-item layui-form-text">--%>
<%--									<label class="layui-form-label">描述：</label>--%>
<%--									<div class="layui-input-block">--%>
<%--										<textarea placeholder="请输入内容" class="layui-textarea"></textarea>--%>
<%--									</div>--%>
<%--								</div>--%>
<%--							</div>--%>
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="addBook">立即提交</button>
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
					laypage = layui.laypage,
					laydate = layui.laydate,
					layedit = layui.layedit,
					common = layui.common,
					tool = layui.tool,
					element = layui.element(),
					dialog = layui.dialog;

				// //获取当前iframe的name值
				// var iframeObj = $(window.frameElement).attr('name');
				// //创建一个编辑器
				// var editIndex = layedit.build('LAY_demo_editor', {
				// 	tool: ['strong' //加粗
				// 		, 'italic' //斜体
				// 		, 'underline' //下划线
				// 		, 'del' //删除线
				// 		, '|' //分割线
				// 		, 'left' //左对齐
				// 		, 'center' //居中对齐
				// 		, 'right' //右对齐
				// 		, 'link' //超链接
				// 		, 'unlink' //清除链接
				// 		, 'image' //插入图片
				// 	],
				// 	height: 100
				// })
				// //全选
				// form.on('checkbox(allChoose)', function(data) {
				// 	var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
				// 	child.each(function(index, item) {
				// 		item.checked = data.elem.checked;
				// 	});
				// 	form.render('checkbox');
				// });
				// form.render();

				// layui.upload({
				// 	url: '上传接口url',
				// 	success: function(res) {
				// 		console.log(res); //上传成功返回值，必须为json格式
				// 	}
				// });
			//顶部添加


			form.on('submit(addBook)', function(data){
				var name = data.field.name;
				var introd = data.field.introd;
				var number = data.field.number;
				$.ajax({
					type: 'post',
					url: "/admin/addBook",
					data: {
						name:name,introd:introd,number:number
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
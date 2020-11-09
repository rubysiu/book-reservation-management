<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="iframe-h">
<%@include file="../common/tag.jsp"%>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>网站后台管理模版</title>
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="/resources/static/admin/css/admin.css" />
</head>

<body>
<div class="wrap-container clearfix">
	<div class="column-content-detail">
		<div class="layui-form-item">
			<div class="layui-inline tool-btn">
				<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="/admin/addStudentInfo"><i class="layui-icon">&#xe654;</i></button>
				<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  ><i class="layui-icon">&#xe640;</i></button>
<%--					<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="article-add.jsp"><i class="iconfont">&#xe656;</i></button>--%>
			</div>
			<form class="layui-form layui-form-search" action="/admin/student/1?studenId=${studenId}">
				<div class="layui-inline">
					<input type="text" name="studentId"   value="${studenId}" placeholder="请输入学号" autocomplete="off" class="layui-input">
				</div>
	<%--				<div class="layui-inline">--%>
	<%--					<select name="states" lay-filter="status">--%>
	<%--						<option value="">请选择一个状态</option>--%>
	<%--						<option value="010">正常</option>--%>
	<%--						<option value="021">停止</option>--%>
	<%--						<option value="0571">删除</option>--%>
	<%--					</select>--%>
	<%--				</div>--%>
				<button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
			</form>
		</div>

		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-even lay-skin="nob">
<%--				<colgroup>--%>
<%--					<col width="50">--%>
<%--					<col class="hidden-xs" width="50">--%>
<%--					<col class="hidden-xs" width="100">--%>
<%--					<col>--%>
<%--					<col class="hidden-xs" width="150">--%>
<%--					<col class="hidden-xs" width="150">--%>
<%--					<col width="80">--%>
<%--					<col width="150">--%>
<%--				</colgroup>--%>
				<thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
					<th class="hidden-xs">学号</th>
					<th class="hidden-xs">密码</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="i" >
					<tr>
						<td><input type="checkbox" name="" lay-skin="primary"  value="${i.id}" data-id="${i.id}"></td>
						<td class="hidden-xs">${i.studentId}</td>
						<td class="hidden-xs">${i.password}</td>
						<td>
							<div class="layui-inline">
								<button class="layui-btn layui-btn-small layui-btn-normal editBtn" data-id="1" data-url="/admin/editStudentInfo/${i.id}"><i class="layui-icon">&#xe642;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="/admin/delStudent/${i.id}"><i class="layui-icon">&#xe640;</i></button>
							</div>
						</td>
					</tr>
				</c:forEach>

				</tbody>
			</table>
			<div class="page-wrap">
				<ul class="pagination">

						<li class="disabled"><span><a href="/admin/student/${page.firstPage}?studenId=${studenId}">«</a> </span></li>
						<c:forEach begin="1" end="${page.pages}" var="pages">

							<li <c:if test="${page.pageNum==pages}">
								class="active"
							</c:if>><a href="/admin/student/${pages}?studenId=${studenId}"><span>${pages}</span></a></li>
						</c:forEach>

						<li>
							<a href="/admin/student/${page.lastPage}?studenId=${studenId}">»</a>
						</li>

				</ul>
			</div>
		</div>
	</div>
</div>

<script src="/resources/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>

<script src="/resources/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
<script>
	if(${page.pageNum}>${page.lastPage}){
		location.href = "/admin/student/${page.lastPage}?studenId=${studenId}"
	}


	layui.use(['layer','dialog','form'], function(){
		var form = layui.form(),
			$ = layui.jquery,
			dialog = layui.dialog;
		var iframeObj = $(window.frameElement).attr('name');
		$('#table-list').on('click', '.del-btn', function() {
			var url=$(this).attr('data-url');
			var id = $(this).attr('data-id');
			dialog.confirm({
				message:'您确定要进行删除吗？',
				success:function(){
					$.ajax({
						type: 'get',
						url: url,
						dataType:'text',
						success: function (res) {
							if (res>0){
								console.log(res)
								layer.msg("删除成功！", {
									time: 1000,
									end: function(){
										parent.window.frames[iframeObj].location.reload();

									}
								});
							}else {
								layer.msg("删除失败")
							}
						}
					});
				},
			})
			return false;
		});

		$('.delBtn').click(function() {
			var id =[];
			var child = $("table").find('tbody input[type="checkbox"]');
			for (let i = 0; i <child.length; i++) {
				if (child[i].checked==true){
					id.push(child[i].value);
				}
			}
			child.each(function(index, item) {
				if (item.checked ==true){

						dialog.confirm({
							message:'您确定要删除选中项',
							success:function(){
								$.ajax({
									type: 'get',
									url: '/admin/delStudent/'+id,
									dataType:'text',
									success: function (res) {
										if (res>0){
											console.log(res)
											layer.msg("删除成功！", {
												time: 1000,
												end: function(){
													parent.window.frames[iframeObj].location.reload();
												}
											});
										}else {
											layer.msg("删除失败")
										}
									}
								});
							},
						})
						return false;
				}
			});

			return false;


		}).mouseenter(function() {

			dialog.tips('批量删除', '.delBtn');

		})

		$('.addBtn').click(function() {
			var url=$(this).attr('data-url');
			//将iframeObj传递给父级窗口,执行操作完成刷新
			parent.page("用户添加", url, iframeObj, w = "700px", h = "620px");
			return false;

		}).mouseenter(function() {

			dialog.tips('添加', '.addBtn');

		})

		$('.editBtn').click(function() {
			var url=$(this).attr('data-url');
			//将iframeObj传递给父级窗口,执行操作完成刷新
			parent.page("用户修改", url, iframeObj, w = "700px", h = "620px");
			return false;

		}).mouseenter(function() {

			dialog.tips('添加', '.editBtn');

		})
	});
</script>
</body>

</html>
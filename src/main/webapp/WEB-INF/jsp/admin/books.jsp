<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="iframe-h">
<%@include file="../common/tag.jsp"%>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>网站后台管理模版</title>
	<link rel="stylesheet" type="text/css" href="/resources/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="/resources/static/admin/css/admin.css" />
</head>

<body>
<div class="wrap-container clearfix">
	<div class="column-content-detail">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-inline tool-btn">
					<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="article-add.jsp"><i class="layui-icon">&#xe654;</i></button>
					<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="article-add.jsp"><i class="layui-icon">&#xe640;</i></button>
<%--					<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="article-add.jsp"><i class="iconfont">&#xe656;</i></button>--%>
				</div>
				<div class="layui-inline">
					<input type="text" name="name" required lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
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
			</div>
		</form>
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
					<th class="hidden-xs">书籍ID</th>
					<th class="hidden-xs">书籍名称</th>
					<th class="hidden-xs">库存</th>
					<th class="hidden-xs">简介</th>
					<th class="hidden-xs">操作</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="book" >
					<tr>
						<td><input type="checkbox" name="" lay-skin="primary" data-id="${book.bookId}"></td>
						<td class="hidden-xs">${book.bookId}</td>
						<td class="hidden-xs">${book.name}</td>
						<td class="hidden-xs">${book.number}</td>
						<td class="hidden-xs">${book.introd}</td>

						<td>
							<div class="layui-inline">
								<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="1" data-url="article-detail.jsp"><i class="layui-icon">&#xe642;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="article-detail.jsp"><i class="layui-icon">&#xe640;</i></button>
							</div>
						</td>
					</tr>
				</c:forEach>

				</tbody>
			</table>
			<div class="page-wrap">
				<ul class="pagination">

						<li class="disabled"><span><a href="/admin/books/${page.firstPage}">«</a> </span></li>
						<c:forEach begin="1" end="${page.pages}" var="pages">

							<li <c:if test="${page.pageNum==pages}">
								class="active"
							</c:if>><a href="/admin/books/${pages}"><span>${pages}</span></a></li>
						</c:forEach>

						<li>
							<a href="/admin/books/${page.lastPage}">»</a>
						</li>

				</ul>
			</div>
		</div>
	</div>
</div>
<script src="/resources/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="/resources/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
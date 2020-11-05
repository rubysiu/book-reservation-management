<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2020/11/3
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/component.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/demo.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/normalize.css">
	<%--jQery文件,务必在bootstrap.min.js之前引入--%>
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<%--使用CDN 获取公共js http://www.bootcdn.cn/--%>
	<%--jQuery Cookie操作插件--%>
	<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<%--jQuery countDown倒计时插件--%>
	<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
	<script src="/resources/script/classie.js"></script>
	<script src="/resources/script/admin.js"></script>
	<style>
		html,body,container,section{
			height: 100%;
			margin: 0;
			padding: 0;
		}
		.content{
			display: flex;
			align-items: center;
			justify-content: center;
		}

	</style>
</head>
<body>
<div class="container">
	<section class="content bgcolor-3">
		<div class="login">
			<h2>Login</h2>
			<span class="input input--kyo">
			<input class="input__field input__field--kyo"  type="text" name="token" id="input-19"/>
			<label class="input__label input__label--kyo" for="input-19">
				<span class="input__label-content input__label-content--kyo">Please enter your existing key!</span>
			</label>
		</span>
		</div>

	</section>
</div>
<script>
	(function() {
		$(function () {
			//使用EL表达式传入参数
			admin.detail.init({


			});
		})
		// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
		if (!String.prototype.trim) {
			(function() {
				// Make sure we trim BOM and NBSP
				var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
				String.prototype.trim = function() {
					return this.replace(rtrim, '');
				};
			})();
		}

		[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
			// in case the input is already filled..
			if( inputEl.value.trim() !== '' ) {
				classie.add( inputEl.parentNode, 'input--filled' );
			}

			// events:
			inputEl.addEventListener( 'focus', onInputFocus );
			inputEl.addEventListener( 'blur', onInputBlur );
		} );

		function onInputFocus( ev ) {
			classie.add( ev.target.parentNode, 'input--filled' );
		}

		function onInputBlur( ev ) {
			if( ev.target.value.trim() === '' ) {
				classie.remove( ev.target.parentNode, 'input--filled' );
			}
		}
	})();
</script>
</body>
</html>

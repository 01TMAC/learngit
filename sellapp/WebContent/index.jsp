<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/register.css" />
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<!-- <a href="" class="books" data-icon="custom" ></a> -->
			<a href="index.jsp" class="ui-btn" style="width: 3px;height:6px;margin-top: 0.4em;"><img src="./img/back.png" alt="Finland" style="width: 20px;height:20px; margin-top: -0.70em; margin-left:-1em"></a>
			<h2>售货机</h2>
			<!-- <a href="" class="ui-btn ui-icon-plus ui-btn-icon-right ui-corner-all ui-nodisc-icon ui-alt-icon ui-btn-icon-right"></a> -->
		</div><!--header div-->
		<div data-role="content">
			<div>
				<center><h1>欢迎登陆</h1>
				</center>
				<form method="post" action="./login">
					<div class="ui-grid-a">
						<div class="ui-block-a"><label for="username">username:</label></div>
						<div class="ui-block-b"><input type="text" name="username" id="username"></div>
					</div>
					<div class="ui-grid-a">
						<div class="ui-block-a"><label for="password">password:</label></div>
						<div class="ui-block-b"><input type="password" name="password" id="password"></div>
					</div>
					

						<!-- <table>
							<tr>
								<td><label for="username">username:</label></td>
								<div class="ui-block-a"><td><input type="text" name="username" id="username"></td></div>
							</tr> 
							<tr>
								<td><label for="password">password:</label></td>
								<td><input type="password" name="password" id="password"></td>
							</tr>
							<tr>
								<td><label for="nickname">nickname:</label></td>
								<td><input type="text" name="nickname" id="nickname"></td>
							</tr>
							<tr>
								<td><label for="telephone">telephone:</label></td>
								<td><input type="text" name="telephone" id="telephone"></td>
							</tr>
							<tr>
								<td><label for="telephone">telephone:</label></td>
								<td><input type="telephone" name="telephone" id="telephone"></td>
							</tr>
						</table> -->
						
						
						
<!-- 						<label>nickname<input type="text" name="nickname"></label>
						<label>telephone:<input type="telephone" name="telephone"></label>
						<label>telephone:<input type="text" name="telephone"></label> -->
						<center>
							<input type="submit" data-inline="true" value="立即登陆">
							<input type="reset" data-inline="true" value="立即重置">
							</br>
							<a href="./register.html">没有账号?立即注册!</a>
						</center>
					</div>
				</form>
			</div>
		</div><!--content div-->
		<div data-role="footer">
		</div><!--footer div-->
	</div><!-- main div-->
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="js/showcartlist.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<script src="js/ajaxstock.js"></script>
	<script src="js/ajaxview.js"></script>
	
	
</body>
</html>
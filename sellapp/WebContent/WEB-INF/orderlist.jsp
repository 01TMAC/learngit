<%@  page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@page import="java.util.ArrayList,java.util.List,java.util.Map"%>
<%
	List orderInfo = (List)request.getSession().getAttribute("orderInfo");
	Map map = null;
	int ID = 0;
	String orderSN = null;
	int machineID = 0;
	int userID = 0;
	
	
	for(int i = 0; i< orderInfo.size() ; i++){
		map = (Map)orderInfo.get(i);
		
	}
%>
<!DOCTYPE html>
<html>
<head>
	<title>订单列表</title>
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" href="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="https://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js">
	</script>
	<script src="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js">
	</script>
	<style type="text/css">
		#tokenframe{
			height: 30%;
			position: fixed;
			/*left: -999em;*/
			opacity:0.8;
		}
		#tokenframe button{
			border: 1px solid #000;
			background-color: #9EA5B2 !important;
		}
		.gianlink{
			float: right;
			position: relative;
			margin-top:18px;
			margin-right: 5px;
			padding: 0px;
			color: #EA2000;
		}
		.gianedlink{
			float: right;
			position: relative;
			margin-top:18px;
			margin-right: 5px;
			padding: 0px;
			color: #7ECD44 !important;
		}
		.banicon .ui-btn-icon-right:after{
			right:-10000px;
		}
		.listnum{
			float: left;
			color: #983C7C !important;
			margin-left:5px !important;
		}
	</style>
	<!-- <script type="text/javascript">
		// var changefooter=function(){
		// 	var token=document.getElementByid("tokenframe");
		// 	token.attr('left',0);
		// }
		$("#123").click(function(){
		$("#tokenframe").css({
		"position":"absolute",
		"left":"0"
	})
})
	</script> -->
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<a href="#" class="ui-btn" style="width: 3px;height:6px;margin-top: 0.4em;"><img src="./image/back.svg" alt="Finland" style="width: 20px;height:20px; margin-top: -0.70em; margin-left:-1em"></a>
			<h2>售货机</h2>
		</div><!--header div-->
		<div data-role="content">
			<div>
				<p class="listnum">订单号1</p>
				<a id="123" class="gianlink">未领取</a><!--点击设置显示tokenframe-->
			</div>
		<div class="banicon">
			<ul data-role="listview" data-inset="true" style="clear:both">
				<li style="clear:both">
					<a href="#" >
					<img src="./image/coke.jpg">
					<h2>可口可乐</h2>
					<p>X<span style="margin-left:5px" class="amount">2</span></p>
					</a>
				</li>
				<li>
					<a href="#">
					<img src="./image/coke.jpg">
					<h2>可口可乐</h2>
					<p>X<span style="margin-left:5px" class="amount">2</span></p>
					</a>
				</li>
			</ul>
		</div>
			<div>
				<p class="listnum">订单号1</p>
				<a id="123" class="gianlink">未领取</a>
			</div>
		<div class="banicon">
			<ul data-role="listview" data-inset="true" style="clear:both">
				<li style="clear:both">
					<a href="#" >
					<img src="./image/coke.jpg">
					<h2>可口可乐</h2>
					<p>X<span style="margin-left:5px" class="amount">2</span></p>
					</a>
				</li>
				<li>
					<a href="#">
					<img src="./image/coke.jpg">
					<h2>可口可乐</h2>
					<p>X<span style="margin-left:5px" class="amount">2</span></p>
					</a>
				</li>
			</ul>
		</div>
			<div>
				<p class="listnum">订单号1</p>
				<a id="123" class="gianedlink">已领取</a>
			</div>
		<div class="banicon">
			<ul data-role="listview" data-inset="true" style="clear:both">
				<li style="clear:both">
					<a href="#" >
					<img src="./image/coke.jpg">
					<h2>可口可乐</h2>
					<p>X<span style="margin-left:5px" class="amount">2</span></p>
					</a>
				</li>
				<li>
					<a href="#">
					<img src="./image/coke.jpg">
					<h2>可口可乐</h2>
					<p>X<span style="margin-left:5px" class="amount">2</span></p>
					</a>
				</li>
			</ul>
		</div>
		</div><!--content div-->
		<div data-role="footer" data-position="fixed" data-fullscreen="false" id="tokenframe">
			<div><center>
				<h2>取货码</h2>
				<button data-role="inline">1</button>
				<button data-role="inline">1</button>
				<button data-role="inline">1</button>
				<button data-role="inline">1</button>
			</center>
		</div>
		</div><!--footer div-->
	</div><!-- page div-->
</body>
</html>
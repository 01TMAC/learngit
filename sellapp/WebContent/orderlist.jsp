<%@page import="orders.OrderOperate"%>
<%@  page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@page import="java.util.ArrayList,java.util.List,java.util.Map,java.util.Iterator,java.util.Map.Entry"%>
<%@page import="orders.Orders,cart.*"%>
<%
	Orders order =(Orders) request.getAttribute("order");
	int status = order.getStatus();
	String token = order.getToken();
	char [] tokenStr = token.toCharArray();
 	String goodsListStr = order.getGoodsList();
 	CartOperate cartOperate = new CartOperate();
 	OrderOperate orderOperate = new OrderOperate();
	Map itemList = cartOperate.getItemList(goodsListStr);
	Iterator it = itemList.entrySet().iterator();
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
			<a href="./goodlist.jsp" class="ui-btn" style="width: 3px;height:6px;margin-top: 0.4em;" data-rel="back"><img src="./img/back.png" alt="Finland" style="width: 20px;height:20px; margin-top: -0.70em; margin-left:-1em"></a>
			<h2>售货机</h2>
		</div><!--header div-->
		<div data-role="content">
			<div>
				<p class="listnum"><%=order.getOrderSN()%></p>
				<a id="123" class="gianlink"><%if(status==0) out.print("未付款");
				if(status==1) out.print("已付款");if(status==2) out.print("已领取");
				if(status==3) out.print("已过期");if(status==4) out.print("已退款");%>：￥<%=orderOperate.getPrice(order.getGoodsList()) %></a><!--点击设置显示tokenframe-->
			</div>
		<div class="banicon">
			<ul data-role="listview" data-inset="true" style="clear:both">
			<% while(it.hasNext()){
			 	Map.Entry entry = (Entry) it.next();
				String key = (String) entry.getKey();
				CartItem item = (CartItem) entry.getValue();
				//System.out.println("goodsID = " + key + "; num = " + item.getGoodsNum());%>
				<li style="clear:both">
					<a href="#" >
					<img src="./img/1.jpg">
					<h2><%=item.getItemID()%></h2>
					<p>X<span style="margin-left:5px" class="amount"><%=item.getGoodsNum() %></span></p>
					</a>
				</li>
				<% }%>
				
			</ul>
		</div>	
		</div><!--content div-->
		
		<div data-role="footer" data-position="fixed" data-fullscreen="false" id="tokenframe">
		
			<div><center>
				<h2>取货码</h2>
				<%for(int i=0;i<tokenStr.length;i++){ %>
				<button data-role="inline"><%=tokenStr[i]%></button>
				<% }%>
			</center>	
		</div>
		
		
		
		<% %>
		</div><!--footer div-->
	</div><!-- page div-->
</body>
</html>
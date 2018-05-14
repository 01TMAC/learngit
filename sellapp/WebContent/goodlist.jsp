<%@page import="java.util.ArrayList,java.util.List,java.util.Map,java.util.Iterator,java.util.Map.Entry"%>
<%@page import="hibernate.*"%>
<%@page import="orders.*,cart.*"%>
<%@  page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%
	
	JDBCUtils dboperate = new JDBCUtils();
	ListResource typeList = new ListResource();
	ListResource goodsList = new ListResource();
	String sqlType = "select * from sell_type";
	typeList = dboperate.execToList(sqlType);
	/* String userID =(String)session.getAttribute("userID"); */
	/* String userID = (String)application.getAttribute("userName");
	String sqlCart = "select * from sell_cart where UserID = ?";
	OrderOperate orderOperate = new OrderOperate();
	CartOperate cartOperate = new CartOperate();
	List listCart = new ArrayList();
	listCart.add(userID);
	String goodsListStr =(String) dboperate.execToList(sqlCart,listCart).getRow(0).getColValue("GoodsList");
	Map itemList = cartOperate.getItemList(goodsListStr);
	Iterator it = itemList.entrySet().iterator(); */
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<link rel="stylesheet" href="css/style.css" />
</head>

<body onload = "change(1)">
<div data-role="page" id="page1">
	    <script type="text/javascript">

    $(document).ready(function(){
        var height = $(window).height();
        $('.float').css('height', height);
        change(1);
        
        $("#cartimg").click(function(){
    		$.ajax({url:"ajaxcart.jsp",success:function(result){
    			$("#showcart").html(result);
    			$("#showcart").listview('refresh');
    		}});
    	});
    });

    $(window).resize(function(){
        var height = $(window).height();
        $('.float').css('height', height);
    });
</script>
	

    <div data-role="header" class="whiteBackground">
        <h1>14栋售卖机</h1>
    </div>
    <div class="ui-grid-c">
        <div class="ui-block-a float">
            <ul data-role="listview" data-inset="true" >
            <%for(int i = 0;i<typeList.getDataList().size();i++){ %>
                <li id= "<%=typeList.getRow(i).getColValue("ID")%>" onclick="change(this.id)" data-inset="true"><%=typeList.getRow(i).getColValue("TypeName")%></li>
                <% }%>
            </ul>
        </div>

        <div class="ui-grid-solo float" >
            <ul data-role="listview" data-inset="true" id="goodslist">
                
            </ul>
        </div>
    </div>
    
    <div class="cart">
        <div class="ui-grid-d">
            <div class="ui-block-a">
                <a href="#myPopup" data-rel="popup" ><img class="cartImg" src="./img/cart.png" id="cartimg"></a>
            </div>
            <div class="ui-block-b">
                <span class="yuan">&nbsp;¥</span><span class="money" id="goodsSum">0</span>
            </div>
            <div class="ui-block-c"></div>
            <div class="ui-block-d">
                <img class="detailImg" src="./img/detail.png">
            </div>
            <div class="ui-block-e">
                <button class="submit" onclick="window.location='./order'">下单</button>
            </div>
        </div>
    </div>
    <div data-role="popup" id="myPopup">
      <ul data-role="listview" data-inset="true" style="clear:both" id="showcart">				
	  </ul>
    </div>
 </div>
</body>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script src="js/ajaxstock.js"></script>
<script src="js/ajaxview.js"></script>
<script src="js/showcartlist.js"></script>

</html>
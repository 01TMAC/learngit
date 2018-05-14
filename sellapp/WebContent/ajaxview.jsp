<%@page import="java.util.HashMap,java.util.Map"%>
<%@page import="java.util.ArrayList,java.util.List"%>
<%@page import="hibernate.*" %>
<%@page import="goods.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    DB_Operate dboperate = new JDBCUtils();
   
   int id =Integer.parseInt(request.getParameter("id"));
   Map mapQuery = new HashMap();
    mapQuery.put("TypeID", id);
    Goods goods = new Goods();
    GoodsOperateInter goodsOperate = new GoodsOperateImpl(dboperate,goods); 
   	List goodsList = new ArrayList();
   	goodsList = goodsOperate.getGoodsInfo(mapQuery);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/style.css" />
<title>ajaxprocessjsp</title>
</head>
 <body>
 <%
 String add = "adda";
 String sub = "suba";
 for(int i=0;i<goodsList.size();i++)
 {goods =(Goods) goodsList.get(i);
%>
 <li class='listItem' data-inset="true">
                    <div class="ui-grid-b">
                        <div class="ui-block-a">
                            <img src="./img/1.jpg" class="listImg">
                        </div>
                        <div class="ui-grid-solo">
                            <div class="ui-grid-solo listTitle">
                                <span><%=goods.getName() %></span>
                            </div>
                            <!--<div class="ui-grid-solo listSub">
                                <span>喝了返老还童</span>
                            </div>-->
                            <div class="ui-grid-solo listSub">
                                <div class="ui-block-a">
                                    <span class="listLast" id="<%=goods.getName()%>">库存:<%=goods.getStock() %></span>
                                </div>
                            </div>
                            <div class="ui-grid-c listBar">
                                <div class="ui-block-a text-right">
                                    <img src="./img/sub.png" class="barImg" name ="<%=goods.getName() %>" onclick="changeStock(this)" >
                                </div>
                                <div class="ui-block-b text-center">
                                    <span class="barNum"></span>
                                </div>
                                <div class="ui-block-c text-left">
                                    <img src="./img/add.png" class="barImg" name = "<%=goods.getName()%>" onclick="changeStock(this)">
                                </div>
                                <div class="ui-block-d">
                                    <span class="listMoney"><%=goods.getPrice() %></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
 			<hr>
   <%System.out.print(Integer.parseInt(request.getParameter("id")));} %>
</body>
</html>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,java.util.List,java.util.Map,java.util.Iterator,java.util.Map.Entry"%>
<%@page import="hibernate.*"%>
<%@page import="orders.*,cart.*"%>
<%  JDBCUtils dboperate = new JDBCUtils();
   String sqlCart = "select * from sell_cart where UserID = ?";
    OrderOperate orderOperate = new OrderOperate();
	CartOperate cartOperate = new CartOperate();
	List listCart = new ArrayList();
	String userID= (String)application.getAttribute("userName");
	listCart.add(userID);
	Map itemList = new HashMap();
	if(dboperate.execToList(sqlCart,listCart).getDataList().size()>0){
			String goodsListStr =(String) dboperate.execToList(sqlCart,listCart).getRow(0).getColValue("GoodsList");
			
			itemList = cartOperate.getItemList(goodsListStr);
			
		}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
				<%
					Iterator it = itemList.entrySet().iterator(); 
					while(it.hasNext()){
					 	Map.Entry entry = (Entry) it.next();
						String key = (String) entry.getKey();
						CartItem item = (CartItem) entry.getValue();
						//System.out.println("goodsID = " + key + "; num = " + item.getGoodsNum());%>
						<li style="clear:both" data-icon="false" data-inset="true">
							<a href="#" >
							<img src="./img/1.jpg">
							<h2><%=item.getItemID()%></h2>
					<p>X<span style="margin-left:5px" class="amount"><%=item.getGoodsNum() %></span></p>
					</a>
				</li>
				<% }%>
</body>

</html>
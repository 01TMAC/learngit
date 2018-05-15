<%@page import="java.util.ArrayList,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="cart.*,hibernate.*,staticparam.*" %>
	<%
	JDBCUtils dbOperate = new JDBCUtils();
	CartOperate cartOperate = new CartOperate();
	String stockID = request.getParameter("stockName");
	String stockAction = request.getParameter("stockAction");
	String userID = (String)application.getAttribute("userName");
	//stockAction = stockAction.replace("http://localhost:8080/sellapp/img/", "");
	/* System.out.println("获取信息："+stockID +' '+ stockAction);
	switch(stockAction){
	case "add.png":
		cartOperate.addToCart(12, stockID);
		break;
	case "sub.png":
		cartOperate.subToCart(12, stockID);
		break;	
	} */
	if(stockAction.contains("add"))
	{
		System.out.println("USERID"+USER.ID);
		cartOperate.addToCart(USER.ID, stockID);
	}
	if(stockAction.contains("sub"))
		cartOperate.subToCart(USER.ID, stockID);
	List listQuery = new ArrayList();
	String sqlQuery = "select GoodsList from sell_cart where UserID = ? ";
	listQuery.add(userID);
	double price = 0;
	if(dbOperate.execToList(sqlQuery,listQuery).getDataList().size()>0){
		String goodsListStr =(String) dbOperate.execToList(sqlQuery,listQuery).getRow(0).getColValue("GoodsList");
		price = cartOperate.getPrice(goodsListStr);
		System.out.print("价格："+price);
	}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%out.print(price);%>
</body>
</html>
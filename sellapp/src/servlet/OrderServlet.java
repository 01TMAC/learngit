package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import goods.Goods;
import hibernate.DB_Operate;
import hibernate.JDBCUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import orders.OrderOperate;
import orders.Orders;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_Operate dbOperate = null;
		OrderOperate orderOperate = new OrderOperate();
		
		String orderSN = null;
		try {
			
			String userID = (String) super.getServletContext().getAttribute("userName");
			orderSN = orderOperate.payTheCart(userID);
			
			List listQuery = new ArrayList();
			Map mapQuery = new HashMap();
			mapQuery.put("OrderSN", orderSN);
			listQuery.add(mapQuery);
			Orders order = new Orders();
			
			order = orderOperate.getOrderInfo(listQuery);
			request.setAttribute("order", order);	
			request.getRequestDispatcher("orderlist.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

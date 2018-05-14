package servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserOperate;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/regist")
public class RegisterServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserOperate userOperate = new UserOperate();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String nickName = request.getParameter("nickname");
		String telephone = request.getParameter("telephone");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		Long createTime = Long.parseLong(df.format(Calendar.getInstance().getTimeInMillis()));// new Date()为获取当前系统时间，也可使用当前时间戳
		try {
			if(userOperate.userRegister(userName, password, nickName, telephone, createTime))
				request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
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

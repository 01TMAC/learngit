package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import staticparam.USER;
import user.UserOperate;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserOperate userOperate = new UserOperate();
		try {
			String userName = request.getParameter("username");
			String userPassword = request.getParameter("password");
			if(userOperate.userIsMatch(userName,userPassword)) {		
				 super.getServletContext().setAttribute("userName", userName);
				 USER.ID = userName;
			}
				/*request.getSession().setAttribute("userID", userOperate.getUserId(request.getParameter("username")));*/
		
			request.getRequestDispatcher("goodlist.jsp").forward(request, response);  
		} catch (ClassNotFoundException | NoSuchAlgorithmException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.views.register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DB.DBconnect;
import com.DAO.*;
import com.helperFunctions.HelperFunctions;
import com.query.Queries;
import com.user.UserDetails;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * 
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upw = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		String rePass = request.getParameter("re_pass");
		
		// user details object
		UserDetails user = new UserDetails(uname,uemail,umobile,upw);
		//dispatcher
		RequestDispatcher dispatcher = null;
		//Connection
		Connection conn= null;
		
		// helper functions for server-side validation
		HelperFunctions.checkEmpty("emptyName","register.jsp",uname,request,dispatcher,response);
		HelperFunctions.checkEmpty("emptyEmail","register.jsp",uemail,request,dispatcher,response);
		HelperFunctions.checkEmpty("emptyPassword","register.jsp",upw,request,dispatcher,response);
		HelperFunctions.resetPassEqualsPass("passwordDontMatch","register.jsp",upw,rePass,request,dispatcher,response);
		HelperFunctions.checkEmpty("emptyMobile","register.jsp",umobile,request,dispatcher,response);
		HelperFunctions.mobileValidation("invalidMobileLength","register.jsp",umobile,request,dispatcher,response);
		
		try {
			// db connection
			conn = DBconnect.connect();
			// user DAO
			UserDAO dao = new UserDAO(conn);
			// add user
			boolean added = dao.addUser(user);
//			
			
			if(added) {
				HttpSession session = request.getSession();
				session.setAttribute("RegisterStatus", "success");
				
				response.sendRedirect("login.jsp");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("RegisterStatus", "failed");
				response.sendRedirect("register.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

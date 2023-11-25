package com.views.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.DB.DBconnect;
import com.helperFunctions.HelperFunctions;
import com.DAO.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		Connection conn = null;
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		// helper functions
		HelperFunctions.checkEmpty("invalidEmail", "login.jsp", email, request, dispatcher, response);
		HelperFunctions.checkEmpty("emptyPassword", "login.jsp", password, request, dispatcher, response);
		
		try {
			// db connection
			conn = DBconnect.connect();
			// dao
			UserDAO dao = new UserDAO(conn);
			// validation
			String valid = dao.validateUser(email, password);
			
			if(valid!=null) {
				session.setAttribute("name", valid);
				dispatcher = request.getRequestDispatcher("showNotes.jsp");
			}else {
				request.setAttribute("status","failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch (Exception e) {
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

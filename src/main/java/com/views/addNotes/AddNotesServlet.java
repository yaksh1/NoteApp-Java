package com.views.addNotes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.DAO.PostDAO;
import com.DB.DBconnect;
import com.user.PostDetails;

/**
 * Servlet implementation class AddNotesServlet
 */
@WebServlet("/addNotes")
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	/**
	 * 
	 */
	public AddNotesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String content = request.getParameter("noteContent");
		
		Connection conn = null;
		RequestDispatcher dispatcher = null;
		
		try {
			// database connection
			conn = DBconnect.connect();
			// dao object
			PostDAO postDao = new PostDAO(conn);
			// query execution
			boolean added = postDao.addPost(title,content,userId);
			
			if(added) {
				dispatcher = request.getRequestDispatcher("showNotes.jsp");
				System.out.println("Done");
			}else {
				dispatcher = request.getRequestDispatcher("addNotes.jsp");
				System.out.println("NotDone");
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

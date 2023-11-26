package com.views.editNotes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import com.DAO.PostDAO;
import com.DB.DBconnect;

/**
 * Servlet implementation class EditNotesServlet
 */

@WebServlet("/editNotes")
public class EditNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNotesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("editId"));
		String title = request.getParameter("title");
		String content = request.getParameter("noteContent");
		
		
		RequestDispatcher dispatcher = null;
		
		
		try {
			PostDAO dao = new PostDAO(DBconnect.connect());
			boolean posted = dao.postEdit(postId, title, content);
			if(posted) {
//				System.out.println("updates");
				request.setAttribute("updated", "success");
				dispatcher=request.getRequestDispatcher("showNotes.jsp");
				
			}else {
//				System.out.println("not");
				request.setAttribute("updated", "failed");
				dispatcher = request.getRequestDispatcher("editPost.jsp");
				
			}
			dispatcher.forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}

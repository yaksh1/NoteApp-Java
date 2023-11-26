package com.views.deleteNote;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.DAO.PostDAO;
import com.DB.DBconnect;

/**
 * Servlet implementation class DeleteNote
 */

@WebServlet("/delete")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteNote() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("note_id"));
		RequestDispatcher dispatcher = null;
		try {
			PostDAO dao = new PostDAO(DBconnect.connect());
			boolean deleted = dao.deleteNote(id);
			
			if(deleted) {
				request.setAttribute("deleted", "success");
				response.sendRedirect("showNotes.jsp");
			}else {
				request.setAttribute("deleted", "failed");
				response.sendRedirect("showNotes.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	

}

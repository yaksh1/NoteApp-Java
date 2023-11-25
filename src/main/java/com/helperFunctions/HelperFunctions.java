package com.helperFunctions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelperFunctions {
	// check for empty fields
		public static void checkEmpty(String status,String redirect,String var,HttpServletRequest request,RequestDispatcher dispatcher,HttpServletResponse response) throws ServletException, IOException {
			if(var==null||var.equals("")) {
				request.setAttribute("status", status);
				dispatcher = request.getRequestDispatcher(redirect);
				dispatcher.forward(request, response);
			
			}
		}
		
		// check if both passwords match
		public static void resetPassEqualsPass(String status,String redirect,String pass,String resetPass,HttpServletRequest request,RequestDispatcher dispatcher,HttpServletResponse response) throws ServletException, IOException {
			if(!pass.equals(resetPass)) {
				request.setAttribute("status", status);
				dispatcher = request.getRequestDispatcher(redirect);
				dispatcher.forward(request, response);
			
			}
		}
		
		// mobile number check
		public static void mobileValidation(String status,String redirect,String mobile,HttpServletRequest request,RequestDispatcher dispatcher,HttpServletResponse response) throws ServletException, IOException {
			if(mobile.length()!=10) {
				request.setAttribute("status", status);
				dispatcher = request.getRequestDispatcher(redirect);
				dispatcher.forward(request, response);
			
			}
		
	}
}

<%
if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home Page</title>
<%@include file="allComponent/allCss.jsp" %>
</head>
<body>
	<%@include file = "allComponent/navbar.jsp" %>
	
	<div class="text-center">
	<h1>Note Taking App Using Java Servlet</h1>

	<a href="login.jsp" class="btn btn-outline-success m-2" type="submit">Sign In</a>
    <a href="register.jsp" class="btn btn-outline-success m-2" type="submit">Sign Up</a>
	</div>

</body>
</html>
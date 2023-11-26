


<%@page import="java.util.List"%>
<%@page import="com.user.PostDetails"%>
<%@page import="com.DAO.PostDAO"%>

<%@page import="com.DB.DBconnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allComponent/allCss.jsp"%>
</head>
<body>

	<div class="container-fluid p-0">
		<%@include file="allComponent/navbar.jsp"%>
		

		<div class="container">
			<h2 class="mt-3">My Notes:</h2>
			<div class="row">
				<div class="col-md-12">

					<%
					if (user != null ) {
						PostDAO postDao = new PostDAO(DBconnect.connect());
						List<PostDetails> list = postDao.getNotes(user.getUserId());
						if(list.isEmpty())
						{%>
							<div class="card mt-3">
						<div class="card-body text-center">
							<img alt="" src="images/notebook.png" class="img-fluid mx-auto"
								style="max-width: 500px;">
							<h1>Start taking your notes here</h1>
							<a href="addNotes.jsp" class="btn btn-outline-primary mt-3">Write
								a note</a>
						</div>

					</div>
						<%}
						for (PostDetails post : list) {
					%>
					<div class="card mt-3 md-3">
						<div class="card-header"><%=post.getPostTile()%></div>
						<div class="card-body">
							<p class="card-text"><%=post.getPostContent()%></p>
							
							<p>
							<b class="text-success">Published Date: <%= post.getDate() %></b><br><b class="text-primary"></b>
							</p>
							<a href="#" class="btn btn-primary">Edit</a> <a href="#"
								class="btn btn-primary">Delete</a>
						</div>
					</div>
					<%
					}
					} 
					%>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
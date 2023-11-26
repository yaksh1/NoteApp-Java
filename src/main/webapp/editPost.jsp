<%@page import="com.user.PostDetails"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.PostDAO"%>
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
<title>Edit Note</title>
<%@include file="allComponent/allCss.jsp"%>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("updated") %>">
	<%
	int id = Integer.parseInt(request.getParameter("note_id"));
	
	PostDAO dao = new PostDAO(DBconnect.connect()); 
	PostDetails post = dao.getDataById(id);
	%>
	<%@include file="allComponent/navbar.jsp"%>
	<div class="text-center py-3">
		<h1>Edit Your Note</h1>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="container">
				<div class="row justify-content-center">



					<h5 class="text-center text-success"></h5>
					<form action="editNotes" method="post" id="form-box"
						class="p-2 px-5">
<input type="hidden" name="editId" value="<%=id%>">
						<div class="form-group input-group">
							 <input
								type="text" name="title" class="form-control"
								placeholder="Enter title" required="required" value="<%= post.getPostTile() %>">
						</div>

						<div class="form-group input-group">

							<textarea name="noteContent" id="msg" class="form-control"
								placeholder="Write your note" cols="30" rows="8"
								required="required"><%=post.getPostContent() %></textarea>
						</div>
						<div class="form-group text-center mb-3">
							<button type="submit" class="btn btn-primary">Edit note</button>
						</div>
					</form>
				</div>

			</div>

		</div>

	</div>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status=="failed"){
		swal("","Update Failed.Please try again.","error");
	}
	</script>
	
</body>
</html>
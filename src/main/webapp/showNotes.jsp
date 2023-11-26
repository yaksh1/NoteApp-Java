


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

	<input type="hidden" id="updateStatus"
		value="<%=request.getAttribute("updated")%>">
	<input type="hidden" id="deleteStatus"
		value="<%=request.getAttribute("deleted")%>">

	<div class="container-fluid p-0">
		<%@include file="allComponent/navbar.jsp"%>


		<div class="container">
			<h2 class="mt-3">My Notes:</h2>
			<div class="row">
				<div class="col-md-12">

					<%
					if (user != null) {
						PostDAO postDao = new PostDAO(DBconnect.connect());
						List<PostDetails> list = postDao.getNotes(user.getUserId());
						if (list.isEmpty()) {
					%>
					<div class="card mt-3">
						<div class="card-body text-center">
							<img alt="" src="images/notebook.png" class="img-fluid mx-auto"
								style="max-width: 500px;">
							<h1>Start taking your notes here</h1>
							<a href="addNotes.jsp" class="btn btn-outline-primary mt-3">Write
								a note</a>
						</div>

					</div>
					<%
					}
					for (PostDetails post : list) {
					%>
					<div class="card mt-3 md-3">
						<div class="card-header"><%=post.getPostTile()%></div>
						<div class="card-body">
							<p class="card-text"><%=post.getPostContent()%></p>

							<p>
								<b class="text-success">Published Date: <%=post.getDate()%></b><br>
								<b class="text-primary"></b>
							</p>


							<a href="editPost.jsp?note_id=<%=post.getPostId()%>"
								class="btn btn-primary">Edit</a> <a
								href="delete?note_id=<%=post.getPostId()%>"
								class="btn btn-danger">Delete</a>
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
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

	<script type="text/javascript">
		var updateStatus = document.getElementById("updateStatus").value;
		var deleteStatus = document.getElementById("deleteStatus").value;
		if (updateStatus == "success") {
			swal("", "Note updated successfully", "success");
		} else if (deleteStatus == "success") {
			swal("", "Note deleted successfully", "success");
		}else if (deleteStatus == "failed") {
			swal("", "Something went wrong.Please try again.", "error");
		}
	</script>

</body>
</html>
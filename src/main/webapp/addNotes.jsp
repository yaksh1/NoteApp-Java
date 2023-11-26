<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
if(session.getAttribute("name")==null){
	
	session.setAttribute("RegisterStatus","failed");
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="allComponent/allCss.jsp"%>
</head>
<body>
	<%@include file="allComponent/navbar.jsp"%>
	<div class="text-center py-3">
	<h1>Add Your Notes</h1>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="container">
				<div class="row justify-content-center">


				
					<h5 class="text-center text-success"></h5>
					<form action="addNotes" method="post" id="form-box" class="p-2 px-5">
						
						<%
							if(user!=null){%>
								<!-- user id retrieval -->
							<input type="hidden" name="uid" value="<%= user.getUserId() %>">
							<%}
						
						%>
						<div class="form-group input-group">
						
						
							
							<input type="text" name="title" class="form-control"
								placeholder="Enter title" required="required">
						</div>

						<div class="form-group input-group">

							<textarea name="noteContent" id="msg" class="form-control"
								placeholder="Write your note" cols="30" rows="8" required="required"></textarea>
						</div>
						<div class="form-group text-center mb-3">
							<button type="submit" class="btn btn-primary">Add note</button>
						</div>
					</form>
				</div>

			</div>

		</div>

	</div>
</body>
</html>
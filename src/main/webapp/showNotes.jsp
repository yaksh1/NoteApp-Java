<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allComponent/allCss.jsp" %>
</head>
<body>

<div class="container-fluid p-0" >
<%@include file="allComponent/navbar.jsp" %>
<div class="card mt-3">
<div class="card-body text-center">
<img alt = "" src="images/notebook.png" class="img-fluid mx-auto" style="max-width:500px;">
<h1>Start taking your notes here</h1>
<a href="addNotes.jsp" class = "btn btn-outline-primary mt-3">Write a note</a>
</div>

</div>
</div>

</body>
</html>
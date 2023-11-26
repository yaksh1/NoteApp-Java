<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.user.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allComponent/allCss.jsp" %>
</head>
<body>
<%@include file="allComponent/navbar.jsp" %>


<section class="vh-100" style="background-color: #eee;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-12 col-xl-4">

        <div class="card" style="border-radius: 15px;">
          <div class="card-body text-center">
            <div class="mt-3 mb-4">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                class="rounded-circle img-fluid" style="width: 100px;" />
            </div>
            <h4 class="mb-4">ID: <%= user.getUserId()%></h4>
            <h4 class="mb-4">Name: <%= user.getName() %></h4>
            <h4 class="mb-4">Email: <%= user.getEmail() %></h4>
            <h4 class="mb-4">Mobile: <%= user.getMobile() %></h4>
            
            <button type="button" class="btn btn-primary btn-rounded btn-lg">
              Message now
            </button>
            
          </div>
        </div>

      </div>
    </div>
  </div>
</section>
</body>
</html>
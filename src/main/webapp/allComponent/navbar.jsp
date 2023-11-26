
<%@page import="com.user.UserDetails"%>
<nav
	class="navbar navbar-expand-lg navbar-light navbar-custom bg-custom"
	style="background-color: #e3f2fd;">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">NoteApp</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="addNotes.jsp">Add Notes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="showNotes.jsp" tabindex="-1"
					aria-disabled="true">Show Notes</a></li>
			</ul>

			<%
			UserDetails user = (UserDetails) session.getAttribute("userD");

			if (user != null) {
			%>
			<a href="userProfile.jsp" class="btn btn-outline-success m-2"
				type="submit">Profile</a> <a href="logout"
				class="btn btn-outline-success m-2" type="submit">Logout</a>

			<%
			} else {
			%>
			<a href="login.jsp" class="btn btn-outline-success m-2" type="submit">Sign
				In</a> <a href="register.jsp" class="btn btn-outline-success m-2"
				type="submit">Sign Up</a>
			<%
			}
			%>



		</div>
	</div>
</nav>
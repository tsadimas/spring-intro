<h1>Hello world!</h1>

<P>The time on the server is ${serverTime}.</P>

<a href="<c:url value="/users/all"/>">See All Users</a>
<a href="<c:url value="/users/register"/>">Register a new User</a>

<p>
	Hello <b><c:out value="${pageContext.request.remoteUser}" /></b><br>
	Roles: <b><sec:authentication property="principal.authorities" /></b>
</p>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<br /> <br /> <br />
	<h2>User | You are now logged in</h2>
	<h3>
		<a href="${logoutUrl}">Logout</a>
	</h3>

</body>
</html>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="<c:url value="/users/all"/>">See All Users</a>
<a href="<c:url value="/users/register"/>">Register a new User</a>

	<p>
      Hello <b><c:out value="${pageContext.request.remoteUser}"/></b><br>
      Roles: <b><sec:authentication property="principal.authorities" /></b>
    </p>
    
    <form action="logout" method="post">
      <input type="submit" value="Logout" />
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    
</body>
</html>

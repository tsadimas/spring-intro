
<form action="/login" method="post">

		Email: <input type="text" name="name"> <br> 
		Password: <input type="password" name="password"> <br> 
		<input type="submit" value="Login">
	</form>
	
	<c:if test="${param.status=='error'}">
		<label style="color:red">Invalid username or password!!</label>
	</c:if>
	<c:if test="${param.status=='logout'}">
		<label style="color:green">Logged out successfully!</label>
	</c:if>
<br>
</body>
</html>
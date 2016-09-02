<c:set var="users" value="${usersList}" />
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Country</th>
			<th>Link</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.phone}" /></td>
				<td><c:out value="${user.country}" /></td>
				<td><a href="<c:url value="/users/user/${user.id}"/>">Details</a>
					<c:if test="${action == 'edit'}"> <a href="<c:url value="/users/delete/${user.id}"/>">Delete</a></c:if></td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
	</body>
	</html>
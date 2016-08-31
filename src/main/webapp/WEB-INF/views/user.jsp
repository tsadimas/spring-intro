<h3>${title}</h3>
<form:form method="POST" action="/dit/users/register"
	modelAttribute="user">
	<table>
		<tr>
			<td><form:label path="name">Name</form:label></td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="phone">Phone</form:label></td>
			<td><form:input path="phone" /></td>
			<td><form:errors path="phone" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Password</form:label></td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
			<td><form:label path="country">Country</form:label></td>
			<td><form:input path="country" /></td>
		</tr>
		<c:if test="${user.id != 0}">
		<tr>
			<td><form:label path="id">Id</form:label></td>
			<td><form:input path="id" readonly="true" /></td>
		</tr>
		</c:if>

		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
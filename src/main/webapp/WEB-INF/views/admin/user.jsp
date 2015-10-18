<%@ include file="../../header.jsp" %>
<h2>Users List</h2>
<hr/>
<table>
	<thead>
		<tr>
			<td>ID</td>
			<td>Login Name</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${users}">
			<tr>
				<td>${row.id}</td>
				<td>${row.loginName}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="../../footer.jsp" %>
<%@ include file="../header.jsp" %>
<h2>Welcome, ${USER.loginName}</h2>
<hr />
<table>
	<thead>
		<tr>
			<td/>
			<td>ID</td>
			<td>Message</td>
			<td>Posted By</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${messages}">
			<tr>
				<td><a class="d-cell" href='home/delete/${row.messageId}' onclick="return confirm('Delete it?');">&nbsp;&nbsp;</a></td>
				<td>${row.messageId}</td>
				<td>${row.message}</td>
				<td>${row.user}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<br/>
<form action="home/post" method="POST">
	<div style="margin-bottom: 3px">
		<label for="message">Say something here: </label>
	</div>
	<div>
		<textarea rows="5" style="width: 100%" name="message"></textarea>
	</div>
	<br />
	<div>
		<input type="submit" value="Post" />
	</div>
	<input type="hidden" name="userId" value="${USER.id}" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script type="text/javascript">
function _delete(id) {
	
}
</script>
<%@ include file="../footer.jsp" %>
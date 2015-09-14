<jsp:include page="../header.jsp"></jsp:include>
<h2>Unsecure Login</h2>
<jsp:include page="login.jsp">
	<jsp:param name="action" value="unsafelogin" />
</jsp:include>
<script type="text/javascript">
<!--
window.onload = function() {
	document.forms[0].loginName.value = "userA' or 'A' = 'A";
}
-->
</script>
<jsp:include page="../footer.jsp"></jsp:include>

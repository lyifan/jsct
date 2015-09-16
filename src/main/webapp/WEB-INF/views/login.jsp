<%@ include file="../header.jsp" %>
<h2>Please login</h2>
<hr/>
<p style="color:${resultColor}">${result}</p>
<form method="POST">
	<div>
		<div>
			<div>
				<label for="loginName">Login name: </label>
			</div>
			<div>
				<input name="loginName" />
			</div>
		</div>
		<br/>
		<div>
			<div>
				<label for="password">Password: </label>
			</div>
			<div>
				<input name="password" type="password" />
			</div>
		</div>
		<br />
		<div>
			<input type="submit" value="Login"/>
		</div>
	</div>
</form>
<%@ include file="../footer.jsp" %>
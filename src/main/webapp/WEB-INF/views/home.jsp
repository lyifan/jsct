<jsp:include page="../header.jsp"></jsp:include>
<h2>Welcome, ${USER}</h2>
<hr/>
<p>${message}</p>
<hr />
<form action="home/post" method="POST">
<div><label for="message">Say something here: </label></div>
<br/>
<div>
	<textarea rows="5" style="width:100%" name="message"></textarea>
</div>
<br/>
<div><input type="submit" value="Post"/></div>
</form>
<jsp:include page="../footer.jsp"></jsp:include>
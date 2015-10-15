<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="/jsct/" />
<title>Java Secure Coding</title>
<link rel="stylesheet" type="text/css" href="content/css/main.css"/>
<script type="text/javascript">
// <!--



// -->
</script>
</head>
<body>
	<div>
		<a href="home">Home</a>
		<form id='logoff-form' method='post' action='logoff'>
			<a href='#' style='float: right' onclick='this.parentNode.submit();return false;'>Log off</a>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />			
		</form>
	</div>
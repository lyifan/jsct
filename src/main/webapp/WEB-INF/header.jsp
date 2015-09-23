<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="/jsct/" />
<title>Java Secure Coding</title>
<style>
body {
	margin: 10% 10%;
	padding: 0;
	font-size: 150%;
	background-color: rgba(255, 255, 0, 0.3);
}

form {
	
}

label {
	line-height: 150%;
}

input[type=submit] {
	font-size: 120%;
}

input[type=text], input[type=password] {
	line-height: 150%;
	font-size: 150%;
	width: 40%;
}

textarea {
	font-size: 150%;
}

table {
	width: 100%;
	line-height: 150%;
	text-align: center;
	border-collapse: collapse;
}

tr td {
	border-bottom: 1px dotted #000;
}

tr:last-child td {
	border-bottom: 2px solid #000;
}

tr:nth-child(even) {
	background-color: rgba(192, 192, 192, 0.3);
}

td a.d-cell {
	background-image: url(content/img/remove.svg);
	background-repeat: no-repeat;
	background-position: center;
	background-size: 16px 16px;
	cursor: pointer;
}

.copy-left {
	display: inline-block;
	text-align: right;
	margin: 0px;
	-moz-transform: scaleX(-1);
	-o-transform: scaleX(-1);
	-webkit-transform: scaleX(-1);
	transform: scaleX(-1);
	filter: FlipH;
	-ms-filter: "FlipH";
}
</style>
</head>
<body>
	<div>
		<a href="home">Home</a><a href='logoff' style='float: right'>Log
			off</a>
	</div>
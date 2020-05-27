<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 페이지입니다</title>
</head>
<body align= "center">
<%@include file = "/common/menu.jsp" %>
<form action="/myHome/Login.do" method="post">
<input name="id" placeholder="id"><br>
<input name= "pwd" placeholder="pwd" type="password"><br>
<button>로그인</button>
</form>


</body>
</html>
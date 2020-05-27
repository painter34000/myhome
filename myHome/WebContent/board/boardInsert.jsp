<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- Navigation bar -->
<%@include file="/common/menu.jsp" %>
</head>
<body>
<h3 align="center">등록페이지</h3>

<form action="BoardInsert.do" align ="center" method="post" enctype = "multipart/form-data">

제목 : <input type="text" name ="title" id ="title"><br>
내용 : <input type="text" name ="contents" id ="contents"><br>
작성자 : <input type="text" name ="id" id ="id" value=${loginId}><br>
첨부파일: <input type="file" name="filename"><br>

<button type="submit">등록하기</button>
</form>
</body>
</html>   
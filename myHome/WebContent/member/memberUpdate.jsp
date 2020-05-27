<%@page import="co.yedam.app.member.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
function a(){
	alert("수정 완료");
	frm.submit();

}
</script>
</head>
<body align = "center">
<%MemberVO member = (MemberVO)request.getAttribute("member"); %>
<!-- Navigation bar -->
<%@include file="/common/menu.jsp" %>
<h3>회원정보</h3>
<form action="/myHome/MemberUpdate.do" method="post" name="frm">

ID : <input type="text" name = "id" id="id" readonly="readonly" value="${member.id}"/><br/>

비밀번호 :  <input type = "text" name = "pwd" id="pwd" value="${member.pwd}"><br>

first_name: <input type="text" name="first_name" id="first_name" value="${member.first_name}"><br>
Last_name: <input type="text" name="last_name" id="last_name" value="${member.last_name}"><br>
이메일: <input type = "text" name="email"><br>
전화번호:<input type="text" name="phone_number"><br>
취미 : 
	<input type= "checkBox" name="hobby" value="h01"/>등산
	<input type= "checkBox" name="hobby" value="h02"/>마라톤
	<input type= "checkBox" name="hobby" value="h03"/>낚시
	<input type= "checkBox" name="hobby" value="h04"/>여행<br>
	<input type= "checkBox" name="hobby" value="h05"/>사진
	<input type= "checkBox" name="hobby" value="h06"/>독서
	<input type= "checkBox" name="hobby" value="h07"/>영화
	<input type= "checkBox" name="hobby" value="h08"/>야구<br>
성별 : 
    <input type="radio" name="gender" value="m">남자
	<input type="radio" name="gender" value="f">여자

종교 : <select name="religion" id="religion">
<option value="r01" <%if( member.getReligion()!=null && member.getReligion().indexOf("r01")>=0) {%>selected="selected"<%} %>>기독교
<option value="r02" <%if( member.getReligion()!=null && member.getReligion().indexOf("r02")>=0) {%>selected="selected"<%} %>>불교
<option value="r03" <%if( member.getReligion()!=null && member.getReligion().indexOf("r03")>=0) {%>selected="selected"<%} %>>천주교
<option value="r04" <%if( member.getReligion()!=null && member.getReligion().indexOf("r04")>=0) {%>selected="selected"<%} %>>이슬람교
<option value="r05" <%if( member.getReligion()!=null && member.getReligion().indexOf("r05")>=0) {%>selected="selected"<%} %>>무교
</select><br>
자기소개:<br>
<textarea cols="30" rows="20" name="introduction" id="introduction" >
${member.introduction}
</textarea><br>
<!-- <input type="submit" value="전송"> -->
<button onclick="a()">전송</button>
<input type="reset" value="지우기">

</form>

</body>
</html>
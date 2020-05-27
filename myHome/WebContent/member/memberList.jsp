<%@ page import="java.util.ArrayList" %>
<%@ page import="co.yedam.app.member.MemberVO" %>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<style>
.malebg{
background-color: white;
}
.fmalebg{
background-color: white;
}
.nogenderbg{
background-color: white;
}
</style>
</head>
<body>

	<!-- Navigation bar-->
	<%@ include file="/common/menu.jsp" %>
	<%--JSP 주석 --%>
	<!-- HTML -->
	<h3>회원목록</h3>
	<table border="1" align="center">
		<tr>
		<td>ID</td>
		<td>이름</td>
		<td>성</td>
		<td>이메일</td>
		<td>핸드폰</td>
		</tr>
		<%
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
		for (MemberVO vo : list){
		%>
		<tr
		<%if ("m".equals(vo.getGender())){ %> class="malebg"
		<%} else if("f".equals(vo.getGender())) {%>
		class="fmalebg"
		<%} else{ %>
		class="nogenderbg"
		<%} %>
		>
		
		<td><%=vo.getId() %></td>
		<td><%=vo.getFirst_name() %></td>
		<td><%=vo.getLast_name() %></td>
		<td><%=vo.getEmail() %></td>
		<td><%=vo.getPhone_number() %></td>
		</tr>		
		<%} %>
	</table>
</body>
</html>
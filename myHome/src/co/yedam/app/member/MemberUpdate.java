package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 id 받아오기
		String id = (String) request.getSession().getAttribute("loginId");
		if(id ==null) {
			response.sendRedirect("/myHome/member/login.jsp");
			return;
		}
		
		//서비스 로직 처리(회원정보 1건 조회)
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		
		//결과 저장
		request.setAttribute("member", vo); //member란 이름을 조회된 vo를 넘겨주겠다.
		
		//뷰페이지로 이동
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//응답 결과 인코딩
		response.setContentType("text/html; charset=UTF-8"); //한글 출력되도록
		
		//요청 정보 인코딩
		request.setCharacterEncoding("utf-8"); //GET방식은 setCharacterEncoding할 필요 없음
		
		//1.파라미터 받기
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String gender = request.getParameter("gerder");
		String phone_number = request.getParameter("phone_number");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String salary = request.getParameter("salary");
		String hobby = request.getParameter("hobby");
		String religion = request.getParameter("religion");

		//자기소개, 이름, 종교, 
		//취미
		
		//2.서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setNum(num);
		member.setId(id);
		member.setFirst_name(first_name);
		member.setLast_name(last_name);
		member.setGender(gender);
		member.setPhone_number(phone_number);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setSalary(salary);
		member.setHobby(hobby);
		member.setReligion(religion);
		
		int r = memberDAO.memberUpdate(member);
		
		PrintWriter out = response.getWriter();
		out.print("<br>id =" +id);
		out.print("<br>first_name=" +first_name);
		out.print("<br>last_name =" +last_name);
		out.print("<br>gender =" +gender);
		out.print("<br>phone_number =" +phone_number);
		out.print("<br>pwd =" +pwd);
		out.print("<br>email =" +email);
		out.print("<br>salary =" +salary);
		out.print("<br>hobby =" +hobby);
		out.print("<br>religion =" +religion);
		
		request.getRequestDispatcher("MemberList.do").forward(request, response);

	}

}

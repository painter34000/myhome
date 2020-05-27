package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jdt.internal.compiler.parser.diagnose.DiagnoseParser;


@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    
    	//응답 결과 인코딩
    	response.setContentType("text/html; charset=UTF-8"); //한글 출력
    	
    	//요청 정보 인코딩
    	request.setCharacterEncoding("utf-8"); //GET방식은  setCharacterEncoding 할 필요 없음
    	
    	//1.파라미터 받기
	
    	String id = request.getParameter("id");
    	String first_name = request.getParameter("first_name");
    	String last_name = request.getParameter("last_name");
    	String gender = request.getParameter("gender");
    	String phone_number = request.getParameter("phone_number");
    	String email = request.getParameter("email");
    	String salary = request.getParameter("salary");
    	String hobbys = request.getParameter("hobby");
    	String pwd = request.getParameter("pwd");
    	String introduction = request.getParameter("introduction");
    	String religion = request.getParameter("religion");
	
    	
    	
    	String[] hobby = request.getParameterValues("hobby");
    	hobbys = "";
    	if(hobby != null)
    		for(String temp : hobby) {
    			hobbys += temp +",";
    		}
    	//2. 서비스 로직 처리(DAO)
    	MemberVO member = new MemberVO();
    	MemberDAO memberDAO  = new MemberDAO();
    	
    	member.setEmail(email);
    	member.setFirst_name(first_name);
    	member.setGender(gender);
    	member.setId(id);
    	member.setIntroduction(introduction);
    	member.setLast_name(last_name);
    	member.setPhone_number(phone_number);
    	member.setPwd(pwd);
    	member.setReligion(religion);
    	member.setSalary(salary);
    	
    	try {
    		BeanUtils.copyProperties(member, request.getParameterMap());
    	}catch(IllegalAccessException e) {
    		e.printStackTrace();
    	}catch(InvocationTargetException e) {
    		e.printStackTrace();
    	}
    	
    	int r = memberDAO.memberInsert(member);
    	
    	//회원 목록 이동 / include, forward, sendRedirect
    	String contexPath = getServletContext().getContextPath();
    	response.sendRedirect(contexPath + "/MemberList.do");   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//응답 결과 인코딩
		response.setContentType("text/html; charset=UTF-8");//한글 변환해줌
		//요청 정보 인코딩
		//1.파라미터 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//자기소개 , 이름 , 종교, 이메일, 전화번호, 성별
		String[] hobby = request.getParameterValues("hobby");
		String hobbys = "";
		if(hobby !=null)
			for(String temp : hobby) {
				hobbys +=temp +",";
			}
		request.getParameter("hobby");
		PrintWriter out = response.getWriter();
		out.print("<br>id = "+id);
		out.append("<br>pwd = "+pwd)
		.append("<br>hobby = "+hobbys);
		
		request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
    }
}

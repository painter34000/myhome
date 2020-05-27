package co.yedam.app.member;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;

public class MemberDAO {

	public int memberInsert(MemberVO member) {  //회원등록
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. db 연결
			conn = ConnectionManager.getConnection();

			// 2.sql 구문 준비
			String sql = "insert into myhome( id, first_name, "
					+ "last_name, gender, phone_number, pwd, email, "
					+ "salary, religion, introduction, todate)"
					+ "values ( ?,?,?,?,?,?,?,?,?,?,sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getFirst_name());
			psmt.setString(3, member.getLast_name());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getPhone_number());
			psmt.setString(6, member.getPwd());
			psmt.setString(7, member.getEmail());
			psmt.setString(8, member.getSalary());
			psmt.setString(9, member.getReligion());
			psmt.setString(10, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + "건이 등록되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		// 6. 반환
		return r;
	}

	 // emd of insert

	public ArrayList<MemberVO> getMemberList(){
		ArrayList<MemberVO> list= new ArrayList<MemberVO>();
		try {
			//1.db연결
			Connection conn = null;
			PreparedStatement psmt = null;
			
			//2.쿼리준비
			conn = ConnectionManager.getConnection();
			String sql = "select * from myhome order by id ";
			psmt = conn.prepareStatement(sql);
			
			//3.statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
			
				vo.setId(rs.getString("id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getString("salary"));
				vo.setHobby(rs.getString("hobby"));
				vo.setReligion(rs.getString("religion"));
				vo.setTodate(rs.getString("todate"));
				vo.setIntroduction(rs.getString("introduction"));
				
				list.add(vo);
			}
			//4. 결과저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}	//5. 연결해제		
	return list; // 6. 반환
}
	public MemberVO getMember(String id) {  //단건조회
		MemberVO vo = new MemberVO();
		try {
			//1.db연결
			Connection conn = null;
			PreparedStatement psmt = null;
			
			//2.쿼리준비
			conn = ConnectionManager.getConnection();
			String sql = "select * from myhome where id =?";
			psmt =conn.prepareStatement(sql);
			psmt.setString(1,  id);
			
			//3. statement 실행
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
			
				vo.setId(rs.getString("id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getString("salary"));
				vo.setHobby(rs.getString("hobby"));
				vo.setReligion(rs.getString("religion"));
				vo.setTodate(rs.getString("todate"));
				vo.setIntroduction(rs.getString("introduction"));
			}else {
				
			}
			
			//4. 결과저장
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5. 연결해제
		}
			//6. 리턴
		return vo;	
		}
	public int memberUpdate(MemberVO member) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//1.db 연결
			conn =ConnectionManager.getConnection();
                                //num, id, first_name, last_name, 
			                    //gender, phone_number, pwd, email, 
			                    //salary, hobby, religion, todate)			
			//2.sql 구문 준비
			String sql = "update myhome set id=?, first_name=?, "
					+ "last_name=?, gender=?, phone_number=?,  pwd=?, email=?, "
					+ "salary=?, hobby=?, religion=?, introduction=?";
			
			psmt = conn.prepareStatement(sql);
			
			//3.실행
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getFirst_name());
			psmt.setString(3, member.getLast_name());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getPhone_number());
			psmt.setString(6, member.getPwd());
			psmt.setString(7, member.getEmail());
			psmt.setString(8, member.getSalary());
			psmt.setString(9, member.getHobby());
			psmt.setString(10, member.getReligion());
			psmt.setString(11, member.getIntroduction());
			
			r = psmt.executeUpdate();
			
			//4.결과처리
			System.out.println(r+"건이 등록되었습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.연결해제
			ConnectionManager.close(conn);
		}
			//6.리턴
		return r;
	}//end of class
	
	}


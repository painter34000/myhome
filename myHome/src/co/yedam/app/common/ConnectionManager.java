package co.yedam.app.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// driverManager 이용하여 연결
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr"); // hr계정으로 연결 , 아이디 hr/비번hr
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // return 없음 (void 는 리턴값이 없음)

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				if (!pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
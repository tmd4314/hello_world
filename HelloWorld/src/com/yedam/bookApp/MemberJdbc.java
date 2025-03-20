package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} //end of getConnect.
	
	//로그인 처리
	
	public User login(String id, String pw) {
		// id, pw 조회 후 결과가 있으면 로그인 성공, 실패.
		Connection conn = getConnect();
		String sql = "select user_id,"
				   + "       password,"
				   + "       user_name "
				   + "from   tbl_member "
				   + "where  user_id = ? "
				   + " and   password = ? ";
		try {
			PreparedStatement lsmt = conn.prepareStatement(sql);
			lsmt.setString(1, id);
			lsmt.setString(2, pw);
			ResultSet ls = lsmt.executeQuery();
			if(ls.next()) {
				System.out.println("로그인 성공");
				User user = new User(ls.getString("user_id"), ls.getString("user_name"), ls.getString("password"));
				return user;
			}
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String, String>> memberList() {
		// [{userId: "user01"}, {password: "1111"}, {username:"홍길동"}]
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection conn = getConnect(); // db seeion.
		String sql = "select user_id, "
				+           "password, "
				+           "user_name "
				+    "from tbl_member";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				// userId, password, userName 저장할 컬렉션.
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("password", rs.getString("password"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

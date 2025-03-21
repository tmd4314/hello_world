package com.yedam.java_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDAO {
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
	
	//추가
	public boolean insert(Employee employee) {
		Connection conn = getConnect();
		String insert = "insert into tbl_emp (emp_no, "
				      + "                     emp_name, "
				      + "                     phone, "
				      + "                     hire_date, "
				      + "                     salary)\r\n "
				      + "values (?, "
				      + "        ?, "
				      + "        ?, "
				      + "        ?, "
				      + "        ? )";
		try {
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setString(1, employee.getNo());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getPhone());
			stmt.setString(4, employee.getHiredate());
			stmt.setInt(5, employee.getSalary());
			int r = stmt.executeUpdate();
			if( r > 0) {
				return true; // 등록성공;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패.
		
	}
	
	//수정
	
	public boolean update(Employee employee) {
		Connection conn = getConnect();
		String update = "update tbl_emp "
				      + "set   salary = nvl(?, salary) "
				      + "where emp_no = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(update);
			stmt.setInt(1, employee.getSalary());
			stmt.setString(2, employee.getNo());
			
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//삭제
	
	public boolean delete(Employee employee) {
		Connection conn = getConnect();
		String delete = "delete from tbl_emp "
				        + "where emp_no = ?" ;
		try {
			PreparedStatement stmt = conn.prepareStatement(delete);
			stmt.setString(1, employee.getNo());
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//목록
	public List<Employee> list(){
	    List<Employee> list = new ArrayList<Employee>();
	    Connection conn = getConnect();
	    String sql = "select   emp_no, "
	            + "            emp_name, "
	            + "            phone  "
	            + "   from     tbl_emp "
	            + "   order by emp_no";
	    try {
	        PreparedStatement psmt = conn.prepareStatement(sql);
	        ResultSet rs = psmt.executeQuery(); // 조회.
	        while (rs.next()) {
	            Employee emp = new Employee();
	            emp.setNo(rs.getString("emp_no"));
	            emp.setName(rs.getString("emp_name"));
	            emp.setPhone(rs.getString("phone"));
	            list.add(emp); // 컬렉션 저장.
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 해제
	        try {
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return list;
	}

	//조회(입사일자 기준)
	public List<Employee> list(String hiredate){
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = getConnect();
		String sql = "select   emp_no, "
				+ "            emp_name,"
				+ "            hire_date "
				+ "   from     tbl_emp"
				+ "   where    hire_date = ? "
				+ "   order by emp_no";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, hiredate);
			ResultSet rs = psmt.executeQuery(); // 조회.
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setNo(rs.getString("emp_no"));
				emp.setName(rs.getString("emp_name"));
				emp.setHiredate(rs.getString("hire_date"));
				list.add(emp); // 컬렉션 저장.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
}

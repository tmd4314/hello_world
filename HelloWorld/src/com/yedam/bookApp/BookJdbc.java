package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * jdbc를 활용.
 */
public class BookJdbc {
	
	// Connection 생성.
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
	}
	
	// 추가.
	public boolean insert(Book book) {
		Connection conn = getConnect();
		String insert = "insert into tbl_book(book_code,"
				+ "                     	  book_title,"
				+ "                     	  author,"
				+ "                     	  company,"
				+ "                     	  price)\r\n"
				+ "  	values (book_seq.nextval,"
			    + "             ?, "
				+ "        		?, "
				+ "        		?, "
				+ "       		? )";
		try {
//			Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getCompany());
			stmt.setInt(4, book.getPrice());
			int r = stmt.executeUpdate();
			if( r > 0) {
				return true; // 등록성공;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패.
		
	}
	
	// 삭제.
	public boolean delete(Book book) {
		Connection conn = getConnect();
		String delete = "delete from tbl_book\r\n "
				        + "where book_code = ?" ;
		try {
//			Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(delete);
			stmt.setString(1, book.getBookCode());
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//수정.
	public boolean update(Book book) {
		Connection conn = getConnect();
		String update = "update tbl_book "
				       + "set   book_title =  nvl(?, book_title), "
				       +"       price =  ?,"
				       +"       author = nvl(?, author), "
				       + "      company = nvl(?, company) \r\n "
				       +" where  book_code = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(update);
			stmt.setString(1, book.getTitle());
			stmt.setInt(2, book.getPrice());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getCompany());
			stmt.setString(5, book.getBookCode());
			
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 목록.
	public List<Book> list(String company) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = getConnect();
		String sql = "select book_code, "
				   + "       book_title, "
				   + "       author, "
				   + "       company, "
				   + "       price "
		           + "from   tbl_book "
		           + "where  company = nvl(?, company) "
		           + "order by book_code";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, company);
			ResultSet rs = psmt.executeQuery(); // 조회.
			while (rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setBookCode(rs.getString("book_code"));
				book.setCompany(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				book.setTitle(rs.getString("book_title"));
				list.add(book); // 컬렉션 저장.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return list;
	}
	
	// 책 조회
	public Book select(String title) {
		
		Connection conn = getConnect();
		String sql = "select book_code, "
				   + "       book_title,"
				   + "       author,"
				   + "       company,"
				   + "       price "
		           + "from   tbl_book "
		           + "where  book_title = ? ";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			ResultSet rs = psmt.executeQuery(); // 조회.
			if (rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setBookCode(rs.getString("book_code"));
				book.setCompany(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				book.setTitle(rs.getString("book_title"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return null; // 조회결과 없음.
	}
}

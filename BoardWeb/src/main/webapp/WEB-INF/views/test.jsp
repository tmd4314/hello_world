<%@page import="com.yedam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.mapper.BoardMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp/views/test.jsp -->
	<%
		// 자바영역.
		String msg = "Hello World";
		System.out.println(msg);
		int age = 30;
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVo> list = mapper.selectBoard(null); 
	%>
	<h3>글목록</h3>
	<ul>
	<%
		for(BoardVo board : list){
	%>
	<li>글번호(<%=board.getBoardNo() %>)/ 글제목(<%=board.getTitle() %>)/ 글쓴이(<%=board.getWriter() %>)</li>
	<%
		}
	%>
	</ul>
	<p>저장정보</p>
	<p>age에 저장된 값은 <%=age %></p>
	<p>msg에 저장된 값은 <%=msg %></p>
	<%
		if(age > 20){
	%>
	<p>성인입니다.</p>
	<%
		}else{
	%>
	<p>미성년자입니다.</p>
	<%
		}
	%>
</body>
</html>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
<%
	BoardVo board = (BoardVo)request.getAttribute("board");
	String paging = (String) request.getAttribute("page");
%>
<h3>수정화면(modify.do)</h3>
<form action="modifyBoard.do">
	<input type = "hidden" name="bno" value="<%=board.getBoardNo() %>">
	<input type = "hidden" name="page" value="<%=paging %>">
	<table class = "table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo() %></td>
			<th>작성자</th>
			<td><%=board.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name = "title" class = "form-control" value="<%=board.getTitle() %>">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name = "content" class = "form-control" cols = "30" rows="3"> <%=board.getContent() %></textarea></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan = "3"><%=board.getWriteDate() %></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type = "submit" value="수정" class = "btn btn-warning">
			</td>
			
		</tr>
	</table>
</form>
<jsp:include page="includes/footer.jsp"/>
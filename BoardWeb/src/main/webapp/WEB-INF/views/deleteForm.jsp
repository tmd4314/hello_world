<%@page import="com.yedam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="includes/header.jsp"/>
<%
	BoardVo board = (BoardVo)request.getAttribute("board");
%>
<h3>삭제화면(delete.do)</h3>
<form action="deleteBoard.do"  onsubmit="return delOk()">
	<input type = "hidden" name="bno" value="<%=board.getBoardNo() %>">
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
				<input type = "submit" value = "삭제" class = "btn btn-danger">
			</td>
		</tr>
	</table>
</form>
<script>
	function delOk() {
		if(!confirm('삭제하시면 복구할수 없습니다. \n 정말로 삭제하시겠습니까??')){
	       return false;
		}else{
			return true; 
		}
	}
</script>
<jsp:include page="includes/footer.jsp"/>
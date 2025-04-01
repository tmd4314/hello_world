<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
	<!-- webapps/WEB-INF/views/board.jsp -->
	<% 
		BoardVo board = (BoardVo)request.getAttribute("board");
		String paging = (String) request.getAttribute("page");
	%>
	<form action="modifyForm.do">
	<input type="hidden" name ="bno" value="<%=board.getBoardNo() %>">
	<input type="hidden" name ="page" value="<%=paging %>">
	<h3><%=board.getTitle() %>(상세정보)</h3>
	<table class = "table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo() %></td>
			<th>작성자</th>
			<td><%=board.getWriter() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class = "form-control" cols = "30" rows="3"> <%=board.getContent() %></textarea></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan = "3"><%=board.getWriteDate() %></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type = "submit" value="수정" class = "btn btn-warning">
				<button type="button" class="btn btn-danger">삭제</button>
			</td>
			
		</tr>
	</table>
	</form>
	<p><a href='boardList.do' class = "btn btn-secondary">목록으로</a></p>
	<script>
		document.querySelector('button.btn.btn-danger').addEventListener('click', deleteFnc);
		
		function deleteFnc() {
			location.href = 'deleteForm.do?bno=<%=board.getBoardNo() %>';
		}
	</script>
<jsp:include page="includes/footer.jsp"/>
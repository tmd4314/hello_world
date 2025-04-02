<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<jsp:include page="includes/header.jsp"/>

<h3>삭제화면(delete.do)</h3>
<form action="deleteBoard.do"  onsubmit="return delOk()">
	<input type = "hidden" name="bno" value="${board.boardNo }">
	<table class = "table">
		<tr>
			<th>글번호</th>
			<td><c:out value="${board.boardNo }" /></td>
			<th>작성자</th>
			<td><c:out value="${board.writer }" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name = "title" class = "form-control" value="${board.title }">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name = "content" class = "form-control" cols = "30" rows="3"> <c:out value="${board.content }" /></textarea></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan = "3"><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type = "submit" value = "삭제" class = "btn btn-danger">
				<a href='boardList.do' class = "btn btn-secondary">목록으로</a>
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
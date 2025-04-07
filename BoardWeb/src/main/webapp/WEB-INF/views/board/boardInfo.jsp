<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- webapps/WEB-INF/views/board.jsp -->
<form action="modifyForm.do">
<input type="hidden" name ="bno" value="${board.boardNo }">
<input type="hidden" name ="page" value="${page }">
<h3><c:out value="${board.title }" />(상세페이지)</h3>
<table class = "table">
	<tr>
		<th>글번호</th>
		<td><c:out value="${board.boardNo }" /></td>
		<th>작성자</th>
		<td><c:out value="${board.writer }" /></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea class = "form-control" cols = "30" rows="3"> <c:out value="${board.content }" /></textarea></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan = "3"><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type = "submit" value="수정" class = "btn btn-warning">
			<c:choose>
				<c:when test="${logId != null && logId == board.writer }">
					<button type="button" class="btn btn-danger">삭제</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-danger" disabled>삭제</button>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<c:if test="${msg != null }">
		<tr><td align = "center" style = "color: red;" colspan="4"><c:out value="${msg }" /></td></tr>
	</c:if>
</table>
</form>
<!-- 댓글관련. -->
<style>
	div.reply span {
	   padding: 5px;
	   display: inline-block;
	}
	div.reply ul {
	  list-style-type: none;
	}
</style>
<div class="container reply">
	<!-- 등록. -->
	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-2 btn btn-primary addReply">댓글등록</button>
	</div>
	<!-- 목록. -->
	<div class="content">
		<ul>
			
			<li>
			  <span class="col-sm-2">글번호</span>
			  <span class="col-sm-5">내용</span>
			  <span class="col-sm-2">작성자</span>
			  <span class="col-sm-2">삭제</span>
			</li>
		</ul>
	</div>
	
	<!-- 페이징. -->
	
</div>

<p><a href='boardList.do' class = "btn btn-secondary">목록으로</a></p>
<script>
	const bno = "${board.boardNo}";
	const replyer = "${logId}";
	document.querySelector('button.btn.btn-danger').addEventListener('click', deleteFnc);
	
	function deleteFnc() {
		location.href = 'deleteForm.do?bno=${board.boardNo}';
	}
</script>
<script src="js/boardService.js"></script>
<script src="js/board1.js"></script>
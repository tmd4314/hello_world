<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- webapps/WEB-INF/views/board.jsp -->
<form action="passwordForm.do" method="post">
<h3>회원페이지(<c:out value="${member.userName }" />)</h3>
<table class = "table">
	<tr>
		<th>현재 비밀번호</th>
		<td><input class="form-control" type="password" name="userPw"></td>
	</tr>
	<tr>
		<th>새 비밀번호</th>
		<td><input class="form-control" type="password" name="newPw" id="newPw"></td>
	</tr>
	<tr>
		<th>비밀번호 확인</th>
		<td><input class="form-control" type="password" name="newPwCheck" id="newPwCheck"></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type = "submit" value="변경" class = "btn btn-warning">
		</td>
	</tr>
	<c:if test="${msg != null }">
		<tr><td align = "center" style = "color: red;" colspan="4"><c:out value="${msg }" /></td></tr>
	</c:if>
</table>
</form>
<p><a href='boardList.do' class = "btn btn-secondary">목록으로</a></p>
<script>
  const form = document.getElementById('passwordForm');
  form.addEventListener('submit', function(event) {
    const newPw = document.getElementById('newPw').value;
    const newPwCheck = document.getElementById('newPwCheck').value;

    if (newPw !== newPwCheck) {
      alert('새 비밀번호와 비밀번호 확인이 일치하지 않습니다. 다시 입력해주세요.');
      event.preventDefault(); // 폼 제출 막기
    }
  });
</script>
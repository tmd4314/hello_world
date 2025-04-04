<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- webapps/WEB-INF/views/board.jsp -->
<form action="passwordForm.do" method="post" >
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
		<td><input class="form-control" type="password"  id="newPwCheck"></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<button type = "submit"  onclick="return test();" class = "btn btn-warning">변경</button>
		</td>
	</tr>
	
</table>
</form>
<p><a href='boardList.do' class = "btn btn-secondary">목록으로</a></p>
<c:if test="${msg != null }">
   <script>
       window.onload = function() {
           alert("<c:out value='${msg}' />");
       };
   </script>
</c:if>
<script>
function test() {
    var p1 = document.getElementById('newPw').value;
    var p2 = document.getElementById('newPwCheck').value;
    
  	if(p1 != p2 ){
       alert("비밀번호가 일치하지 않습니다."); 
       return false;
   	}
  }
</script>

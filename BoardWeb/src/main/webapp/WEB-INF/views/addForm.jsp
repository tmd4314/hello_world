<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="includes/header.jsp"/>

	<!-- addForm.jsp -->
	<form action = "addBoard.do" method = "post">
		<table class = "table">
			<tr>
				<th>글제목</th>
				<td><input class = "form-control" type = "text" name = "title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<c:out value="${logId }" />
					<input class = "form-control" type = "hidden" value = "${logId }" name = "writer">
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea class = "form-control" name = "content" rows ="3" cols = "40"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
					<input type = "submit" class= "btn btn-primary">
					<input type = "reset" class= "btn btn-secondary">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="includes/footer.jsp"/>
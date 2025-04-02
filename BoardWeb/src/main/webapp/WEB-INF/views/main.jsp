<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="includes/header.jsp"/>
<table class="table">
	<tr>
		<td>userName 값: ${userName}</td>
		<td>responsibility 값: ${responsibility}</td>
	</tr>
</table>
<jsp:include page="includes/footer.jsp"/>
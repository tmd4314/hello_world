<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
    <div class="list-group list-group-flush">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">글목록</a>
        <c:choose>
        	<c:when test="${logId == null }">
         	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
         	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="signForm.do">회원가입</a>
         </c:when>
         <c:otherwise>
         	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="addBoard.do">글등록</a>
         	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃(<c:out value="${logId }"/>)</a>
         </c:otherwise>
        </c:choose>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="javascript.do">JS연습</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="eventForm.do">Event</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="chart.do">Chart</a>
    </div>
</div>
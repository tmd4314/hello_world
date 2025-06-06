<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- header.jsp -->
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                <li class="nav-item active"><a class="nav-link" href="main.do">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                <li class="nav-item dropdown">
                <c:choose>
                    <c:when test="${!empty logId }">
                    	<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img class="iconimg" src="images/${img }"></a>
                    	<div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
		                     <a class="dropdown-item" href="memberForm.do">비밀번호 변경</a>
		                     <a class="dropdown-item" href="#!">Another action</a>
		                     <div class="dropdown-divider"></div>
		                     <a class="dropdown-item" href="#!">Something else here</a>
		                </div>
		            </c:when>
                    <c:otherwise>
                    	<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                    	<div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
		                     <a class="dropdown-item" href="#!">Another action</a>
		                     <div class="dropdown-divider"></div>
		                     <a class="dropdown-item" href="#!">Something else here</a>
		                </div>
                    </c:otherwise>
                </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>


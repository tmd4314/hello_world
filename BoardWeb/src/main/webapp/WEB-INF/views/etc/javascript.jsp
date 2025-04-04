<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>javascript.jsp</h3>
<div class="row">
	<div class="col-sm-6">
	  <input type ="text" class="form-control" id="userInput">
	</div>
	<div class="col-sm-4">
	  <button id="addBtn" class="btn btn-primary">추가</button>
	</div>
</div>
<ul id="list" style="display: none">
	<li>apple</li>
	<li>banana</li>
</ul>
<!-- 성별목록. -->
<select class="form-control" id="searchGender">
	<option value="all">전체</option>
	<option value="Male">남성</option>
	<option value="Female">여성</option>
</select>
<table class="table">
  <thead>
    <tr><th><input type="checkbox"  id="selectAll"></th><th>id</th><th>first</th><th>last</th><th>gender</th><th>삭제</th></tr>
  </thead>
  <tbody id="target">
  </tbody>
</table>
<script src="js/ajax.js"></script>
<!--  <script src="js/object.js"></script> -->
<!-- <script src="js/array.js"></script> -->
<!-- <script src="js/json.js"></script> -->
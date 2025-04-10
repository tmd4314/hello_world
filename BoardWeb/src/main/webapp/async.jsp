<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="button">버튼</button>
	<script>
	//비동기코드 -> 동기방식.
	document.querySelector('#button')
		.addEventListener('click', async function(){
			console.log('1');
			let result = await fetch('eventListDatatable.do');
			console.log('2');
			let resolve = await result.json();
			console.log(resolve);
	})
	</script>
</body>
</html>
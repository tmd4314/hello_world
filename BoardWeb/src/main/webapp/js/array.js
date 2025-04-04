/**
 *  array.js
 * push, unshift 추가.
 * pop, shift 제거.
 * splice 추가,수정,삭제
 * forEach()
 */
const ary = [];
//push, unshift
ary.push('홍길동');
ary.push('김길동');
ary.unshift('최길동');

//ary.pop(); // 삭제.
//ary.shift(); //삭제.
//ary.splice(0, 1);

ary.forEach(function(item, idx, ary) {
	console.log(`item => ${item}, index => ${idx}, array => ${ary}`);
});

// 함수.
function addElement(elem = "noElem"){
	ary.push(elem);
}

function deleteElement(e){
	console.log(e.target.parentElement);
	e.target.parentElement.remove();
}

// 추가버튼에 클릭이벤트.
document.querySelector('button#addBtn').addEventListener('click', function(){
	let val = document.querySelector('input#userInput').value;
	addElement(val);
	// 화면 출력
	let html ='';
	ary.forEach(function(item,idx,ary){
		html += '<li>' + item + '<button onclick="deleteElement(event)">삭제</button></li>';
	});
	
	document.querySelector('ul#list').innerHTML = html;
});

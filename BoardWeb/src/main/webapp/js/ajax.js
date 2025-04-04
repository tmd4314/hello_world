/**
 * ajax.js
 */
let dataAry = [];
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json');
xhtp.send();
xhtp.onload = function() { //load 이벤트 발생.
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	dataAry = obj; //대입
	//화면 출력
	obj.forEach(function(item, idx, ary) {
		let tr = makeRow(item);
		document.querySelector('tbody#target').appendChild(tr);
	})
}

// 한건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = { id, first_name, last_name, email, gender, salary }) {
	const fields = ['id', 'first_name', 'last_name', 'gender'];
	let tr = document.createElement('tr'); // <tr></tr> 생성

	//checkbox 생성
	let tdd = document.createElement('td');
	let chk = document.createElement('input');
	chk.setAttribute('type', 'checkbox');

	//부모-자식
	tdd.appendChild(chk);
	tr.appendChild(tdd);

	//td 생성
	for (let i = 0; i < fields.length; i++) {
		let td = document.createElement('td'); //<td></td>
		td.innerHTML = emp[fields[i]]	       //<td>1</td>
		tr.appendChild(td);   //<tr><td> id </td><td> firstname </td><td> lastname </td><td> email </td></tr>
	}
	//button 생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger');
	btn.innerText = '삭제';
	btn.addEventListener('click', deleteRow);
	// 부모-자식
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

//btn의 이벤트 핸들러
function deleteRow(e) {
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
}


//thead의 checkbox에 이벤트(change) 등록.  전체선택.
document.querySelector('thead input[type="checkbox"]').addEventListener('change', function(e) {
	//tbody 영역의 checkbox의 값 변경.
	let checked = e.target.checked;
	document.querySelectorAll('tbody input[type="checkbox"]').forEach(function(item) {
		item.checked = checked;
	})
})

//select의 change 이벤트
document.querySelector('select#searchGender').addEventListener('change', function(e) {
	console.log(e.target.value);
	let genderValue = e.target.value;
	//dataAry의 배열을 활용해서 출력.
	//dataAry의 gender속성을 비교해서 출력하기(출력하기 전에 목록을 초기화.)
	document.querySelector('tbody#target').innerHTML = "";
	dataAry.forEach(function(item) {
		// 비교문을 사용해 같은 값만 출력.
		if (genderValue == 'all' || item.gender == genderValue) {
			let tr = makeRow(item);
			document.querySelector('tbody#target').appendChild(tr);
		}
	});
})


























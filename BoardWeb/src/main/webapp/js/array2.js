/**
* js/array2.js
 */
const numAry = [10, 17, 23, 26, 49];
let fileterAry = numAry.filter(function(item, idx, ary) {
	return item % 2 == 0;
});
console.log(fileterAry);

const jsonStr = `[{"id":1,"first_name":"Shea","last_name":"Yanez","email":"syanez0@opera.com","gender":"Female","salary":2452},
{"id":2,"first_name":"Larina","last_name":"Pollastrino","email":"lpollastrino1@washingtonpost.com","gender":"Female","salary":5973},
{"id":3,"first_name":"Dario","last_name":"Redmille","email":"dredmille2@forbes.com","gender":"Male","salary":2951},
{"id":4,"first_name":"Krystle","last_name":"Polye","email":"kpolye3@shop-pro.jp","gender":"Female","salary":1667},
{"id":5,"first_name":"Giacobo","last_name":"Grimble","email":"ggrimble4@imgur.com","gender":"Genderqueer","salary":7870},
{"id":6,"first_name":"Daron","last_name":"Duchatel","email":"dduchatel5@surveymonkey.com","gender":"Female","salary":5428},
{"id":7,"first_name":"Nickie","last_name":"Stallworthy","email":"nstallworthy6@flavors.me","gender":"Female","salary":6259},
{"id":8,"first_name":"Carole","last_name":"Duchateau","email":"cduchateau7@ameblo.jp","gender":"Female","salary":2374},
{"id":9,"first_name":"Hubey","last_name":"Denisyev","email":"hdenisyev8@apple.com","gender":"Male","salary":8101},
{"id":10,"first_name":"Marielle","last_name":"Szachniewicz","email":"mszachniewicz9@harvard.edu","gender":"Female","salary":7930},
{"id":11,"first_name":"Lucias","last_name":"Schapero","email":"lschaperoa@chron.com","gender":"Male","salary":5433},
{"id":12,"first_name":"Rey","last_name":"Durnin","email":"rdurninb@redcross.org","gender":"Non-binary","salary":8571},
{"id":13,"first_name":"Rebe","last_name":"Guiu","email":"rguiuc@webeden.co.uk","gender":"Female","salary":7268},
{"id":14,"first_name":"Tyrone","last_name":"Jimenez","email":"tjimenezd@slashdot.org","gender":"Male","salary":5207},
{"id":15,"first_name":"Freeland","last_name":"Guisler","email":"fguislere@studiopress.com","gender":"Bigender","salary":9286}]`;

const jsonAry = JSON.parse(jsonStr);
// {id, first_name, .....}

fileterAry =  jsonAry.filter((item) => item.gender == "Male" && item.salary >= 5000);
console.log(fileterAry);

// reduce()
console.clear();
let result = [10, 23, 34, 48, 51].reduce(function(acc, item){
	console.log(acc, item);
	if(item > 30){
		acc.push(item);
	}
	return acc; // acc값으로 활용.
}, []);

console.log('result: ', result);
console.clear();

let list = document.querySelector('#list');
[10, 23, 34, 48, 51].reduce((acc, item) => {
	let li = document.createElement('LI');
	li.innerHTML = item;
	acc.appendChild(li);
	
	return acc;
}, list);

const ary = [
	{name:"홍길동", phone: "010-1111-2222"},
	{name:"최길동", phone: "010-1111-3333"},
	{name:"박길동", phone: "010-1111-4444"},
	{name:"김길동", phone: "010-1111-5555"}
]
// ul의 요소로 이름 - 연락처 출력.
let rlist = document.querySelector('#list');
ary.reduce((acc, item) => {
	let li = document.createElement('LI');
	 li.innerHTML = `name: ${item.name},  phone: ${item.phone}`;  // 현재 요소의 이름과 전화번호를 사용
	acc.appendChild(li);
	
	return acc;
}, rlist);












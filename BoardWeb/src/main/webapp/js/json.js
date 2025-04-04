/**
 * 
 */
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


let obj = JSON.parse(jsonStr); // json문자열 -> object 변경.
let str = JSON.stringify(obj); // object->json문자열 변경.
console.log(obj);

// 한건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = {id, first_name, last_name, email, gender, salary}){
  const fields = ['id', 'first_name', 'last_name', 'email'];
  let tr = document.createElement('tr'); // <tr></tr>
  for (let i=0; i<fields.length; i++){
	let td = document.createElement('td'); //<td></td>
	td.innerHTML = emp[fields[i]]; //<td>1</td>
	tr.appendChild(td); // <tr><td>1</td><td>Matthieu</td></tr>
  }
  return tr;
}

obj.forEach(function(item, idx, ary){
	let tr = makeRow(item);
	document.querySelector('tbody#target').appendChild(tr);
})





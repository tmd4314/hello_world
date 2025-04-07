/**
 * 
 */
console.log(bno);
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=' + bno);
xhtp.send();
xhtp.onload = function() {
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	console.log(data);
	data.forEach(function(item){
		makeRow2(item);
	}) // end of forEach.
			
}// end of onload.

function makeRow2(item){
	let html =`	<li>
				  <span class="col-sm-2">${item.replyNo}</span>
				  <span class="col-sm-5">${item.reply}</span>
				  <span class="col-sm-2">${item.replyer}</span>
				  <span class="col-sm-2"><button class="btn btn-danger">삭제</button></span>
				</li>`;
	let templ = document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend', html);
}

function makeRow(item) {
	// template 가져오기.
	let templ = document.querySelector('div.content>ul>li').cloneNode(true);
	
	console.log(templ);
	templ.querySelector('span:nth-of-type(1)').innerHTML = item.replyNo;
	templ.querySelector('span:nth-of-type(2)').innerHTML = item.reply;	
	templ.querySelector('span:nth-of-type(3)').innerHTML = item.replyer;
	templ.querySelector('span:nth-of-type(4)').innerHTML = '<button class="btn btn-danger">삭제</button>';
	
	document.querySelector('div.content>ul').appendChild(templ);
}
// 동기, 비동기(Asynchronous Javascript And Xml)
setTimeout(function() {
  console.log('1');

  setTimeout(function() {
    console.log('2');

    setTimeout(function() {
      console.log('3');
    }, 1000);
  }, 1000);
}, 1000);
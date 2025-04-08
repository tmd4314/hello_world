/**
 * board1.js
 * XMLHttpRequest, fetch => 실행순서.
 */

let page = 1;

let succesCallback = function succesCallback(result){
    console.log(result);
	document.querySelectorAll('div.reply div.content>ul>li')
		.forEach(function(item, idx){
			if(idx){
				item.remove();
			}
		})
    result.forEach(item => {
      makeRow2(item);
    });
}


function errorCallback(err){
	console.error(err);
} 

function pagingCallback(result){
	document.querySelector('nav>ul.pagination').innerHTML = "";
	let totalCnt = result.totalCnt;
	// 첫페이지, 마지막페이지, => 현재페이지로 계산.
	let startPage, endPage;
	// 이전페이지, 이후페이지 
	let prev, next;
	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = endPage > realEnd ? realEnd : endPage;
	prev = startPage == 1 ? false : true;
	next = endPage < realEnd ? true : false;
	
	let prevhtml;
	if(!prev){
		prevhtml = `<li class="page-item disabled">
				      <a class="page-link" >Previous</a>
				    </li>`;
	}else{
		prevhtml = `<li class="page-item">
				      <a class="page-link" data-page="${startPage-1}" href="#">Previous</a>
				    </li>`;
	}
	let prevtarget = document.querySelector('nav>ul.pagination');
	prevtarget.insertAdjacentHTML('beforeend', prevhtml);
	
	let html;
	for(let p=startPage; p<= endPage; p++){
		if(p == page){
			html = `<li class="page-item active" aria-current="page">
				      <a class="page-link" data-page="${p}" href="#">${p}</a>
				    </li>`;
			
		}else{
			html= `<li class="page-item"><a class="page-link" data-page="${p}"  href="#">${p}</a></li>`;
		}
		let target = document.querySelector('nav>ul.pagination');
		target.insertAdjacentHTML('beforeend', html);
	}
	
	let nexthtml;
	if(!next){
		nexthtml = `<li class="page-item disabled">
					      <a class="page-link">Next</a>
					    </li>`;
	}else{
		nexthtml = `<li class="page-item">
					      <a class="page-link" data-page="${endPage+1}" href="#">Next</a>
					    </li>`;
	}
	nexttarget = document.querySelector('nav>ul.pagination');
	nexttarget.insertAdjacentHTML('beforeend', nexthtml);
	

	// 링크이벤트.
	pageLink();
}

function deleteFnc(rno){
	let deleteOk = confirm("삭제하겠습니까?");
	if(!deleteOk){
		return;
	}
	svc.removeReply(rno,function(result){ 
		console.log(result); //retCode
		if(result.retCode == 'OK'){
			alert("삭제 성공!")
			//id 속성.
			document.querySelector('#rno_'+ rno).remove();
			svc.replyList({bno, page }, succesCallback, errorCallback);
			svc.pagingList(bno, pagingCallback, errorCallback);
		}
	},errorCallback)
}

// 이벤트.
document.querySelector('button.addReply')
	.addEventListener('click', function(e){
		if(replyer == ''){
			alert('로그인하세요.');
			return;
		}
		let reply = document.querySelector('#reply').value;
		if(reply =='') {
			alert('댓글을 등록하세요.');
			return;
		}
		svc.addReply({bno, reply, replyer}//등록의 첫번째 param
			,function(result){
				if(result.retCode == 'OK'){
					alert('등록성공!');
					let item = result.retVal; // 반환결과값 활용.
					makeRow2(item);
					svc.replyList({bno, page }, succesCallback, errorCallback);
					svc.pagingList(bno, pagingCallback, errorCallback);
				}else{
					alert('등록실패!');
				}
			}, errorCallback);
	})
	

function pageLink(){
	document.querySelectorAll('div.reply ul a')
		.forEach(function(atag) {
			atag.addEventListener('click', function(e) {
				e.preventDefault(); // 이벤트의 기본기능 차단.
				page = atag.dataset.page; // <a>3</a>
				// 댓글목록.
				svc.replyList({bno, page }, succesCallback, errorCallback);
				svc.pagingList(bno, pagingCallback, errorCallback);
			})
		});
}

// 목록 보여주기.
svc.replyList({bno, page }, succesCallback, errorCallback);
// 페이징목록 보여주기.
svc.pagingList(bno, pagingCallback, errorCallback);

  
function makeRow2(item) {
  let html = `
		    <li id="rno_${item.replyNo}">
		      <span class="col-sm-2">${item.replyNo}</span>
		      <span class="col-sm-5">${item.reply}</span>
		      <span class="col-sm-2">${item.replyer}</span>
		      <span class="col-sm-2"><button onclick="deleteFnc(${item.replyNo})" class="btn btn-danger">삭제</button></span>
		    </li>`;
	let templ = document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend', html);
}

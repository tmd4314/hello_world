/**
 * board1.js
 * XMLHttpRequest, fetch => 실행순서.
 */

let succesCallback = function succesCallback(result){
    console.log(result);
    result.forEach(item => {
      makeRow2(item);
    });
}

function errorCallback(err){
	console.error(err);
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
				}else{
					alert('등록실패!');
				}
			}, errorCallback);
	})


// 목록 보여주기.
svc.replyList(bno, succesCallback, errorCallback);

  
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

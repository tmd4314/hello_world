/**
 * board2.js
 */
//목록
const table = new DataTable('#example', {
    ajax: 'replyListDatatable.do?bno=' + bno,
    columns: [
        { data: 'REPLY_NO' },
        { data: 'REPLY' },
        { data: 'REPLYER' },
        { data: 'REPLY_DATE' }
    ],
	lengthMenu: [
        [5, 10, 25, 50, -1],
        [5, 10, 25, 50, 'All']
    ],
	order: [[0, 'desc']]
});

//등록
function addNewRow() {
	let reply = document.querySelector('#reply').value;
	// control을 통해서 db 
	fetch('addReply.do?bno=' + bno + '&replyer=' + replyer + '&reply=' + reply)
	.then(result => result.json())
	.then(result => {
		//console.log(result);
		let obj = result.retVal
		table.row
	        .add({
	            REPLY_NO: obj.replyNo,
	            REPLY: obj.reply,
	            REPLYER: obj.replyer,
	            REPLY_DATE: obj.replyDate
	        })
	        .draw(false);
	})
	.catch(err => console.error(err));
	
}
 
document.querySelector('#addRow').addEventListener('click', addNewRow);

//삭제
table.on('click', 'tbody tr', (e) => {
	//console.log(e);
    let classList = e.currentTarget.classList; // class목록을 배열 형태로 가짐
	let data = table.row(e.currentTarget).data();
	let rno = data.REPLY_NO;
	//classList에 contains('클래스명'), 제거(remove('클래스명'), 추가(add('클래스명')))
    if (classList.contains('selected')) {
		classList.remove('selected');
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        console.log(rno);
		classList.add('selected');
    }
});
 
document.querySelector('#delRow').addEventListener('click', function () {
	if (table.row('.selected').any()) {
		let data = table.row('.selected').data();
		let rno = data.REPLY_NO;
		fetch('removeReply.do?rno=' + rno)
		.then(result => result.json())
		.then(result => {
			alert("삭제 성공");
		    table.row('.selected').remove().draw(false);
		})
		.catch(err => console.error(err));
	}else{
		alert("행을 선택해주세요!!");
	}
});







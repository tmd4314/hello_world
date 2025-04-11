<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="css/styles.css" rel="stylesheet" />
</head>

<body>
  시도선택: <select id="choice" class="form-control">
  </select>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>센터명</th>
        <th>연락처</th>
        <th>시/도 정보</th>
      </tr>
    </thead>
    <tbody id="centerList"></tbody>
  </table>
  
  <ul id="list"></ul>

  <script>
    let url =
      'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=300&serviceKey=xEJpXXHayJUwulwtB20PjwlKz10sbO%2F02B2mWeS%2BEQaxBT4IQnffLBemv%2FFckwjAYCKnohuayjPNyPtpMCJfSA%3D%3D'
    let centerList = [];

    fetch(url)
      .then(result => result.json())
      .then(result => {
        console.log(result.data);
        centerList = result.data; //센터전체.
        
        let sidoAry = [];
        centerList.forEach(center => {
        	if(sidoAry.indexOf(center.sido) == -1) {
        		sidoAry.push(center.sido);
        	}
        })
        
        console.log(sidoAry);
        
        sidoAry.forEach(sido => {
        	let opt = document.createElement('option');
        	opt.innerHTML = sido;
        	document.querySelector('#choice').appendChild(opt);
        })
        
        centerList.forEach((center, idx) => {
          if(idx < 10){
            let tr = makeCenter(center); // center 의 정보를 활용해서 tr 생성.
            document.querySelector("#centerList").appendChild(tr);
          }
        })
      })
      .catch(err => console.error(err))

      //이벤트..
      document.querySelector('#choice').addEventListener('change', function(e){
        let val = this.value;
        document.querySelector('#centerList').innerHTML = "";
        centerList
            .filter(center => center.sido == val)
            .forEach((center, idx) => {
              let tr = makeCenter(center); // center 의 정보를 활용해서 tr 생성.
              document.querySelector("#centerList").appendChild(tr);
            })
      })

      
    //센터정보를 활용해서 tr 생성하는 함수
    function makeCenter(center = {}) {
      let tr = document.createElement('tr');
      
      //tr 영역 클릭 이벤트
      tr.addEventListener('click', function(e){
    	  openWindow(center);
      });
      
      let fields = ['id', 'centerName', 'phoneNumber', 'sido'];
      // td생성.
      fields.forEach(field => {
        let td = document.createElement('td');
        td.innerHTML = center[field];
        tr.appendChild(td);
      })

      return tr;
    }// end of makeCenter.
    
    //tr 클릭 이벤트 핸들러.
    function openWindow(center={}) {
    	window.open('sample.jsp?lat=' + center.lat +'&lng=' + center.lng + '&address=' + center.address);
    }
  </script>
  <script src="js/array2.js"></script>
</body>

</html>
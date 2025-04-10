<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset='utf-8' />
	<script src='js/index.global.js'></script>
	<script>
		document.addEventListener('DOMContentLoaded', async function () {
			var calendarEl = document.getElementById('calendar');
			var events = [];

			let result = await fetch('eventListDatatable.do');
			let resolve = await result.json();
			//events = resolve;
			resolve.forEach(item =>{
				events.push({
					title: item.TITLE, 
					start: item.START_DATE, 
					end: item.END_DATE
				});
			});
			
			console.log(resolve);

			var calendar = new FullCalendar.Calendar(calendarEl, {
				headerToolbar: {
					left: 'prev,next today',
					center: 'title',
					right: 'dayGridMonth,timeGridWeek,timeGridDay'
				},
				initialDate: new Date(),
				navLinks: true,
				selectable: true,
				selectMirror: true,
				select: async function (arg) {
					var title = prompt('Event Title:');
					if (title) {
						let allDay = arg.allDay;
						let startStr = allDay ? arg.startStr : arg.startStr.substring(0, 19);
						let endStr = allDay ? arg.endStr : arg.endStr.substring(0, 19);
						//let result = await fetch('addEvent.do?title=' + title + '&start=' + startStr + '&end=' + endStr);
						let r1 = await fetch('addEvent.do', {
							method: 'post',
							headers: {'Content-Type': 'application/x-www-form-urlencoded'},
							body: 'title=' + title + '&start=' + startStr + '&end=' + endStr
						});
						let r2 = await r1.json();
						if (r2.retCode == 'OK') {
							calendar.addEvent({
								title: title,
								start: arg.start,
								end: arg.end,
								allDay: arg.allDay
							})
						} else {
							alert('등록 실패');
						}
					}
					calendar.unselect();
				},
				eventClick: async function (arg) {
					if (confirm('정말 삭제하시겠습니까?')) {
						console.log(arg)
						let title = arg.event.title;
						let start = arg.event.startStr.substring(0, 19);
						let end = arg.event.endStr.substring(0, 19);
						//let result = await fetch('removeEvent.do?title=' + title + '&start=' + start + '&end=' + end);
						let result = await fetch('removeEvent.do', {
							method: 'post',
							headers: {'Content-Type': 'application/x-www-form-urlencoded'},
							body: 'title=' + title + '&start=' + start + '&end=' + end
						});
						let resolve = await result.json();
						if(resolve.retCode == 'OK'){
							alert("삭제 성공");
							arg.event.remove();
						}else{
							alert("삭제 실패");
						}
					}
				},
				editable: true,
				dayMaxEvents: true,
				events: events
			});
			calendar.render();
		});
	</script>
	<style>
		body {
			margin: 40px 10px;
			padding: 0;
			font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
			font-size: 14px;
		}

		#calendar {
			max-width: 1100px;
			margin: 0 auto;
		}
	</style>
</head>

<body>

	<div id='calendar'></div>

</body>

</html>
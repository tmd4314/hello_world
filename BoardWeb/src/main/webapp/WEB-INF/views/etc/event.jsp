<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='js/index.global.js'></script>
<script>

document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');
  var events = [];

  function loadEvents() {
    fetch('eventListDatatable.do')
      .then(response => response.json())
      .then(data => {
    	//console.log(data); 
        events = data.map(event => {
          return {
            title: event.TITLE,
            start: event.START_DATE,
            end: event.END_DATE
          };
        });

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
          select: function(arg) {
            var title = prompt('Event Title:');
            console.log(arg);
            if (title) {
              let allDay = arg.allDay;
              let startStr = allDay ? arg.startStr : arg.startStr.substring(0, 19);
              let endStr = allDay ? arg.endStr : arg.endStr.substring(0, 19);
              fetch('addEvent.do?title=' + title + '&start=' + startStr + '&end=' + endStr)
                .then(result => result.json())
                .then(result => {
                 if (result.retCode == 'OK') {
                    calendar.addEvent({
                      title: title,
                      start: arg.start,
                      end: arg.end,
                      allDay: arg.allDay
                    })
                  }else {
                      alert('등록 실패');
                  }
                  calendar.unselect();
                })
                .catch(err => console.error(err));
            } else {
              calendar.unselect();
            }
          },
          eventClick: function(arg) {
            if (confirm('정말 삭제하시겠습니까?')) {
            	console.log(arg)
            	let start = arg.event.startStr
            	let end = arg.event.endStr
            	fetch('removeEvent.do?start=' + start + '&end=' + end)
        		.then(result => result.json())
        		.then(result => {
        			alert("삭제 성공");
        			//console.log(result);
        			//console.log(start);
        			//console.log(end);
        			arg.event.remove();
        		})
        		.catch(err => console.error(err));
              
            }
          },
          editable: true,
          dayMaxEvents: true,
          events: events
        });

        calendar.render();
      })
      .catch(error => console.error('Error fetching events:', error));
  }

  loadEvents();
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

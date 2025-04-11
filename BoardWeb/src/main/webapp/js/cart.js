const basket = {
    changePNum: function(event) {
        const element = event.target;
        const rowElement = element.closest('.row');
        const index = rowElement.dataset.id;
        const pNumInput = document.getElementById(`p_num${index}`);
        let currentValue = parseInt(pNumInput.value);

        const isUbtn = element.classList.contains('up');
        const isDbtn = element.classList.contains('down');

        if (isUbtn) {
            currentValue++;
        } else if (isDbtn) {
            currentValue = Math.max(0, currentValue - 1);
        }

        pNumInput.value = currentValue;

        this.updateSum(index);
        this.updateTotal();
    },

    updateSum: function(index) {
		console.log(index);
        const pPrice = document.getElementById(`p_price${index}`);
        const pNum = document.getElementById(`p_num${index}`);
        const price = parseInt(pPrice.value);
		
        const num = parseInt(pNum.value);

		
        const sum = price * num;

        const sumEl = document.querySelector(`.row[data-id="${index}"] .sum`);
	
        sumEl.textContent = sum.toLocaleString() + '원';
        this.updateTotal();
    },

    delItem: function(event) {
	   const e = event || window.event; // event 객체 가져오기

	   if (!e) {
	       console.error("Event 객체가 전달되지 않았습니다.");
	       return; // 함수 종료
	   }

	   const element = e.target;
	   const rowElement = element.closest('.row');

	   if (rowElement) {
	       rowElement.remove();
	       this.updateTotal();
	   }
    },
	
	delAllItem: function(){
		const rowElements = document.querySelectorAll(".row");
		
		rowElements.forEach(row => {
			row.remove();
		});
		
		this.updateTotal();
	},
	
	delCheckedItem: function() {
        const checkedItems = document.querySelectorAll('.row.data input[name="buy"]:checked');

        checkedItems.forEach(item => {
            const rowElement = item.closest('.row.data');
            if (rowElement) {
                rowElement.remove();
            }
        });

        this.updateTotal();
    },
	
	updateTotal: function() {
	    let totalCount = 0;
	    let totalPrice = 0;

	    document.querySelectorAll('.row.data').forEach(row => {
	        const checkbox = row.querySelector('input[name="buy"]');
	        if (checkbox && checkbox.checked) { // 체크된 상품만 합계에 포함
	            const index = row.dataset.id;
	            const pNumInput = document.getElementById(`p_num${index}`);
	            const pPriceInput = document.getElementById(`p_price${index}`);

	            if (!pNumInput || !pPriceInput) {
	                console.warn(`p_num 또는 p_price 요소를 찾을 수 없습니다. index: ${index}`);
	                return;
	            }

	            const num = parseInt(pNumInput.value);
	            const price = parseInt(pPriceInput.value);

	            totalCount += num;
	            totalPrice += price * num;
	        }
	    });
	    document.querySelector('#sum_p_num').textContent = '상품갯수: ' + totalCount.toLocaleString() + '개';
	    document.querySelector('#sum_p_price').textContent = '합계금액: ' +totalPrice.toLocaleString() + '원';
	},
	
	updateTotalByCheckbox: function(event) {
	    this.updateTotal();
	}
};

document.addEventListener('DOMContentLoaded', function() {
    const checkboxes = document.querySelectorAll('.row.data input[name="buy"]');
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function(event) {
            basket.updateTotalByCheckbox(event);
        });
    });
});



// 감소 버튼 클릭 이벤트 핸들러 등록
const decreaseButtons = document.querySelectorAll('.decrease');
decreaseButtons.forEach(function (button) {
    button.addEventListener('click', function (event) {
        handleDecreaseClick(event);
    });
});

// 상품 수량 감소 처리 함수
function handleDecreaseClick(event) {
    decrease(event);
    onePrice(event);
}

// 상품 수량 감소 함수
function decrease(event) {
    // 현재 수량을 가져오고 1 감소시킵니다
    const quantityElement = event.currentTarget.nextElementSibling;
    const currentQuantity = parseInt(quantityElement.innerText);
    const newQuantity = Math.max(currentQuantity - 1, 1);
    quantityElement.innerText = newQuantity;

    event.preventDefault();
    // hidden input에 최종 수량을 설정합니다

    document.getElementById('hdCounterValue').value = newQuantity;


    // 감소할 때 각 상품의 가격을 업데이트합니다
    onePrice(event);
    updateTotalPrice(event);
    finalTotalPrice();
}




// 증가 버튼 클릭 이벤트 핸들러 등록
const increaseButtons = document.querySelectorAll('.increase');
increaseButtons.forEach(function (button) {
    button.addEventListener('click', function (event) {
        handleIncreaseClick(event);
    });
});

// 상품 수량 증가 처리 함수
function handleIncreaseClick(event) {
    increase(event);
    onePrice(event);
}

// 상품 수량 증가 함수
function increase(event) {
    // 현재 수량을 가져오고 1 증가시킵니다
    const quantityElement = event.currentTarget.previousElementSibling;
    const currentQuantity = parseInt(quantityElement.innerText);
    const newQuantity = currentQuantity + 1;
    quantityElement.innerText = newQuantity;

    // hidden input에 최종 수량을 설정합니다

    document.getElementById('hdCounterValue').value = newQuantity;

    event.preventDefault();

    // 추가로 수량이 증가할 때 각 상품의 가격을 업데이트합니다
    onePrice(event);
    updateTotalPrice(event);
    finalTotalPrice();
}

// 상품 하나 가격 계산 함수
function onePrice(event) {
    const totalButtons = document.querySelectorAll('.total');

    totalButtons.forEach(function (text) {

        // 가격과 수량 엘리먼트를 가져옵니다
        const menucheckElement = text.closest('.menucheck');
        const onePriceElement = menucheckElement.querySelector(".price");
        const counterValueElement = menucheckElement.querySelector('.btn-con #counter-value');

        // 텍스트 내용을 숫자로 파싱합니다
        const onePrice = parseInt(onePriceElement.value);

        // 총 가격을 계산합니다
        const result = onePrice * parseInt(counterValueElement.textContent);

        // 버튼 텍스트를 업데이트합니다
        text.innerText = result.toLocaleString() + "won";
        event.preventDefault();
    });
}


//쓰레기통 버튼 누르면 사라지게 하기
const trash = document.querySelectorAll('.trash-btn');
trash.forEach(function (trashBo) {
    trashBo.addEventListener('click', function () {
        removeRow(this); // 'this'를 통해 현재 클릭된 버튼을 전달합니다.
    });
});

//상품 제거 및 가격제거 하는 기능
function removeRow(button) {
    // 삭제되는 행을 찾아서
    var row = button.closest('.menucheck');

    // 삭제되는 행의 가격 요소를 찾습니다.
    var priceElement = row.querySelector('.price');

    // 만약 해당 행의 체크박스가 선택되어 있으면 가격을 처리합니다.
    if (row.querySelector('.checkbox').checked) {
        // 삭제되는 행의 가격을 가져와서 총액에서 차감합니다.
        const bilgeElement = document.querySelector('.bilge');
        const totalPriceElement = bilgeElement.querySelector('.total-product-amount #total-price');
        const currentTotalPrice = parseInt(totalPriceElement.textContent.replace(/[^\d]/g, ''), 10);

        const couponPriceElement = document.querySelector('.apply-coupon .coupon-price');
        const currentCoupon = parseInt(couponPriceElement.textContent.replace(/[^\d]/g, ''), 10);

        const deliverElement = bilgeElement.querySelector('.delivery-fee #deliveryCost');
        const currentDeliver = parseInt(deliverElement.textContent.replace(/[^\d]/g, ''), 10);

        const finalElement = bilgeElement.querySelector('.final-amount #gun-won');
        const currentFinal = parseInt(finalElement.textContent.replace(/[^\d]/g, ''), 10);

        //선택한 상품 전체 금액만큼 제거
        const removedTotal = currentTotalPrice;
        const newTotal = currentTotalPrice - removedTotal;
        totalPriceElement.innerText = newTotal;

        // 선택한 쿠폰 가격만큼 제거
        const removedCoupon = currentCoupon; // 쿠폰 가격
        const newCouponTotal = currentCoupon - removedCoupon;
        couponPriceElement.innerText = newCouponTotal;

        //선택한 배송비만큼 제거
        const removedDeliver = currentDeliver;
        const newDeliver = currentDeliver - removedDeliver;
        deliverElement.innerText = newDeliver;

        // 선택한 gun-won 만큼 제거
        const removedGunWon = currentFinal; // 선택한 행의 가격을 gun-won으로 처리
        const newGunWonTotal = currentFinal - removedGunWon;
        finalElement.innerText = newGunWonTotal;
    }
    // 행을 제거합니다.
    row.remove();
}




// 체크박스
document.querySelectorAll('.checkbox').forEach(function (checkbox) {
    checkbox.addEventListener('click', function () {
        // Find the closest '.menucheck' container
        const menucheckElement = checkbox.closest('.menucheck');

        // Find elements within the current '.menucheck'
        const remaining = menucheckElement.querySelector('.nameAndCount #remain');
        const endTime = new Date(remaining.nextElementSibling.value);

        // remainingTime를 반환하는 updateRemainingTime 함수 호출
        const resultTime = updateRemainingTime(checkbox, endTime).remainingTime;

        // 남은 시간이 양수인지 확인
        if (resultTime > 0) {
            // 양수이면 각종 가격 업데이트 함수 호출
            updateTotalPrice();
            deliverPrice();
            finalTotalPrice();

        } else {
            // 음수이면 알람 표시 및 체크 취소
            alert('펀딩이 종료되었습니다.');
            checkbox.checked = false;
        }
    });
});




// 최종금액 업데이트 함수
function finalTotalPrice() {
    const bilgeElement = document.querySelector('.bilge');
    const couponPriceElement = bilgeElement.querySelector('.apply-coupon .coupon-price');
    const deliverElement = bilgeElement.querySelector('.delivery-fee .cost');

    // Extract numeric values from elements
    const deliver = parseInt(deliverElement.textContent.replace(/[^\d]/g, ''), 10) || 0;
    const coupon = parseInt(couponPriceElement.textContent.replace(/[^\d]/g, ''), 10) || 0;

    // Calculate final amount
    const finalAmount = deliver + coupon;

    // Update the DOM with the formatted final amount
    const finalPriceElement = document.querySelector('.final-amount .gun-won');
    finalPriceElement.innerText = finalAmount.toLocaleString() + " won";

    document.getElementById('hdGunWon').value = finalAmount;

}



//고른 상품 총합
function updateTotalPrice(event) {
    const checkedCheckboxes = document.querySelectorAll('.checkbox:checked');
    let totalPrice = 0;

    checkedCheckboxes.forEach(function (checkedCheckbox) {
        const menucheckElement = checkedCheckbox.closest('.menucheck');
        const oneTotalElement = menucheckElement.querySelector('.price-con .total.product');

        // Add other elements if needed

        totalPrice += parseInt(oneTotalElement.textContent.replace(',', '')) || 0; // Remove commas if any
    });

    // 총 가격 요소 업데이트
    const bilgeElement = document.querySelector('.bilge');
    const totalElement = bilgeElement.querySelector('.total-product-amount #total-price');
    const couponPriceElement = bilgeElement.querySelector('.apply-coupon .coupon-price');

    totalElement.textContent = totalPrice.toLocaleString() + "won";

    couponPriceElement.textContent = totalPrice.toLocaleString() + "won";

    document.getElementById('hdTotalPrice').value = totalPrice;
    document.getElementById('hdCouponPrice').value = totalPrice;
}


//베송가격 기능
function deliverPrice() {
    const checkedCheckboxes = document.querySelectorAll('.checkbox:checked');
    let feePrice = 0;

    checkedCheckboxes.forEach(function (checkedCheckbox) {
        feePrice += 3000;
    });

    const deliverElement = document.querySelector('.bilge .delivery-fee #deliveryCost');
    deliverElement.textContent = feePrice.toLocaleString() + "won";

    document.getElementById('hdDeliveryCost').value = feePrice;
}



//쿠폰적용 버튼
    const applyButtons = document.querySelectorAll('.applybutton');
    applyButtons.forEach(function (coupon) {
        coupon.addEventListener('click', function (event) {
            applyCoupon(event);
            finalTotalPrice()
            event.preventDefault();
        });
    });


// 쿠폰 적용 기능
// 쿠폰 적용 여부를 저장하는 변수
let isCouponApplied = false;
function applyCoupon(event) {
    const bilgeElement = event.currentTarget.closest('.bilge');
    const totalPriceElement = bilgeElement.querySelector('.total-product-amount #total-price');
    const couponPriceElement = bilgeElement.querySelector('.apply-coupon .coupon-price');
    const couponElement = document.querySelector('.coupon');

    // 총 상품 가격 확인
    let totalPrice = parseInt(totalPriceElement.textContent.replace(/[^\d]/g, ''), 10);

    // 총 상품 가격이 0이면 알람창 표시하고 함수 종료
    if (totalPrice === 0) {
        alert('상품을 선택해주세요');
        return;
    }


    // 이미 적용했으면 알람창을 띄우고 함수를 종료
    if (isCouponApplied) {
        alert('이미 적용했습니다');
        return;
    }

    // 쿠폰 적용 여부 확인
    var cartCoupon = couponElement.value;

    // 쿠폰 적용 조건문
    if (cartCoupon === 'Y') {
        alert('쿠폰이 적용되었습니다');
        const couponValue = 3000;
        let totalPrice = parseInt(totalPriceElement.textContent.replace(/[^\d]/g, ''), 10);
        totalPrice -= couponValue;
        couponPriceElement.innerText = totalPrice.toLocaleString() + "won";
        document.getElementById('hdCouponPrice').value = totalPrice;

        // 쿠폰이 적용되었음을 표시
        isCouponApplied = true;
    } else {
        alert('쿠폰이 없습니다');
    }

}



//맨처음 가격 기입
document.addEventListener("DOMContentLoaded", function () {
    // 상품 하나 가격 계산
    const totalButtons = document.querySelectorAll('.total');

    totalButtons.forEach(function (text) {
        // 현재 버튼의 다음 형제 엘리먼트를 찾아 수량 엘리먼트로 설정합니다
        var quantityElement = text.previousElementSibling;
        // 가격과 수량 엘리먼트를 가져옵니다
        const menucheckElement = text.closest('.menucheck');
        const onePriceElement = menucheckElement.querySelector(".price");
        const counterValueElement = menucheckElement.querySelector('.btn-con #counter-value');

        // 텍스트 내용을 숫자로 파싱합니다
        const onePrice = parseInt(onePriceElement.value);
        // 총 가격을 계산합니다
        const result = onePrice * parseInt(counterValueElement.textContent);
        document.getElementById('hdCounterValue').value = parseInt(counterValueElement.textContent);


        // 버튼 텍스트를 업데이트합니다
        text.innerText = result.toLocaleString() + "won";


    });
});


//펀딩남은 시간
function updateRemainingTime(button, endTime) {
    const todayTime = new Date();
    const remainingTime = endTime - todayTime;

    if (remainingTime <= 0) {
        button.innerText = "펀딩 종료";
        clearInterval(button.intervalId);
    } else {
        const days = Math.floor(remainingTime / (1000 * 60 * 60 * 24));
        const hours = Math.floor((remainingTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutes = Math.floor((remainingTime % (1000 * 60 * 60)) / (1000 * 60));
        const seconds = Math.floor((remainingTime % (1000 * 60)) / 1000);

        button.innerText = "남은시간: " + days + "일 " + hours + "시간 " + minutes + "분 " + seconds + "초";
    }

    // 반환
    return {
        remainingTime: remainingTime,
    };
}

document.querySelectorAll('.remain').forEach(function (button) {
    const endTime = new Date(button.nextElementSibling.value);

    function update() {
        updateRemainingTime(button, endTime);
    }

    // Initial update and then every 5 seconds
    update();
    button.intervalId = setInterval(update, 5000);

    button.addEventListener('click', function (event) {
        event.preventDefault();
    });
});

//결제 버튼
const paymentButton = document.querySelector('.paybtn-con') ;
    paymentButton.addEventListener('click', function () {
        checkAndProceed();
    });


//결제 버튼 기능
function checkAndProceed() {
    const gunWonElement = document.getElementById('gun-won');
    const gunWonValue = parseInt(gunWonElement.innerText.replace(/[^\d]/g, ''), 10);

    if (gunWonValue !== 0) {
        // If gun-won is not 0, proceed to the payment page
        window.location.href = "/order/buypage";
    } else {
        // If gun-won is 0, show an alert
        alert('상품을 선택해주세요.');
    }
}


//체크된 정보 결제 화면으로 전달
function paymentInfo(event) {
    const checkedCheckboxes = $('.checkbox:checked');


    // 동적으로 폼 생성
    const form = $('<form>', {
        action: 'http://localhost:8080/order/buypage',
        method: 'get'
    });

    // 필요한 폼 요소 추가
    checkedCheckboxes.each(function(index, checkbox) {
        const input = $('<input>', {
            type: 'hidden',
            name: 'selectedItems[]',  // 서버에서 배열로 받을 수 있도록 name 설정
            value: checkbox.value
        });

        form.append(input);
    });

    // 생성한 폼을 body에 추가하고 자동으로 submit
    form.appendTo('body').submit();
}









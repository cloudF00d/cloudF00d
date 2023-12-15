
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

    // 감소할 때 각 상품의 가격을 업데이트합니다
    onePrice(event);
    updateTotalPrice(event);
    finalTotalPrice();
}



// 증가 버튼 + 가격 합계 + 쿠폰 가격

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




//체크 박스
const checkboxes = document.querySelectorAll('.checkbox');
checkboxes.forEach(function (checkbox) {
    checkbox.addEventListener('click', function () {
        updateTotalPrice();
        deliverPrice();
        finalTotalPrice();
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
}



//쿠폰적용 버튼
    const applyButtons = document.querySelectorAll('.applybutton');
    applyButtons.forEach(function (coupon) {
        coupon.addEventListener('click', function (event) {
            applyCoupon(event);
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
        // 버튼 텍스트를 업데이트합니다
        text.innerText = result.toLocaleString() + "won";
    });
});



//펀딩남은 시간
document.addEventListener("DOMContentLoaded", function () {
    // "remain" 클래스를 가진 모든 버튼을 선택합니다.
    const remainButtons = document.querySelectorAll('.remain');

    // 각 버튼에 대해 처리하는 반복문
    remainButtons.forEach(function (button) {
        // 버튼 다음에 있는 입력 요소에서 종료 시간을 가져옵니다.
        const endTime = new Date(button.nextElementSibling.value);

        // 남은 시간을 업데이트하는 함수
        function updateRemainingTime() {
            // 현재 시간을 가져옵니다.
            const todayTime = new Date();
            // 종료 시간과 현재 시간의 차이를 계산합니다.
            const remainingTime = endTime - todayTime;

            // 일, 시간, 분, 초로 변환합니다.
            const days = Math.floor(remainingTime / (1000 * 60 * 60 * 24));
            const hours = Math.floor((remainingTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            const minutes = Math.floor((remainingTime % (1000 * 60 * 60)) / (1000 * 60));
            const seconds = Math.floor((remainingTime % (1000 * 60)) / 1000);

            // 버튼의 텍스트 내용을 업데이트합니다.
            button.innerText = "남은시간: " + days + "일 " + hours + "시간 " + minutes + "분 " + seconds + "초";
        }

        // 초기에 한 번은 실행하고, 그 후 5초마다 업데이트합니다.
        updateRemainingTime();
        setInterval(updateRemainingTime, 5000);

        // 각 버튼에 클릭 이벤트 리스너를 추가합니다.
        button.addEventListener('click', function (event) {
            // 클릭 이벤트의 기본 동작을 막습니다.
            event.preventDefault();

        });
    });
});



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

    // 삭제되는 행의 가격을 가져와서 총액에서 차감합니다.
    const bilgeElement = document.querySelector('.bilge');

    var totalPriceElement = bilgeElement.querySelector('#totalPrice'); // 여기에 총액을 표시하는 요소의 ID를 넣으세요.
    var currentTotal = parseFloat(totalPriceElement.innerText); // 현재 총액을 가져옵니다.

    var couponPriceElement = bilgeElement.querySelector('#coupon-price');
    var currentCoupon = parseFloat(couponPriceElement.innerText);

    var deliverElement = bilgeElement.querySelector('#deliveryCost');
    var currentDeliver = parseFloat(deliverElement.innerText);

    var finalElement = bilgeElement.querySelector('#gun-won');
    var currentFinal = parseFloat(finalElement.innerText);

    var removedPrice = parseInt(priceElement.value); // 삭제되는 행의 가격을 가져옵니다.

    // 현재 총액에서 삭제되는 행의 가격을 빼서 업데이트합니다.
    var newTotal = currentTotal - removedPrice;
    totalPriceElement.innerText = newTotal; // 업데이트된 총액을 표시합니다.

    var currentCoupon = parseFloat(couponPriceElement.innerText);
    var currentDeliver = parseFloat(deliverElement.innerText);
    var finalTotal = newTotal - currentCoupon - currentDeliver;

    finalElement.innerText = finalTotal;

    // 행을 제거합니다.
    row.remove();
}

















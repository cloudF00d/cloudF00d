


//증가 버튼
document.addEventListener("DOMContentLoaded", function () {

    var increaseButtons = document.querySelectorAll('.increase');

    increaseButtons.forEach(function (button) {
        button.addEventListener('click', function (event) {
            var quantityElement = this.previousElementSibling;
            var currentQuantity = parseInt(quantityElement.innerText);
            var newQuantity = currentQuantity + 1;
            quantityElement.innerText = newQuantity;

            //가격계산
            const totalButtons = document.querySelectorAll('.total');

            totalButtons.forEach(function (text) {

                // 현재 버튼의 다음 형제 엘리먼트를 찾아 수량 엘리먼트로 설정합니다
                var quantityElement = this.nextElementSibling;

                // 가격과 수량 엘리먼트를 가져옵니다
                const menucheckElement = text.closest('.menucheck');
                const onePriceElement = menucheckElement.querySelector(".price");
                const counterValueElement = menucheckElement.querySelector('.btn-con #counter-value');

                // 텍스트 내용을 숫자로 파싱합니다
                const onePrice = parseInt(onePriceElement.value);

                // 총 가격을 계산합니다
                const result = onePrice * parseInt(counterValueElement.textContent);

                // 버튼 텍스트를 업데이트합니다
                text.innerText = result + "원";
                event.preventDefault();
            });
        });
    });

});



//감소 버튼
document.addEventListener("DOMContentLoaded", function () {
    var decreaseButtons = document.querySelectorAll('.decrease');

    decreaseButtons.forEach(function (button) {
        button.addEventListener('click', function (event) {
            var quantityElement = this.nextElementSibling;
            var currentQuantity = parseInt(quantityElement.innerText);
            var newQuantity = Math.max(currentQuantity - 1,1);
            quantityElement.innerText = newQuantity;
            event.preventDefault();

            //가격계산
            const totalButtons = document.querySelectorAll('.total');

            totalButtons.forEach(function (text) {

                // 현재 버튼의 다음 형제 엘리먼트를 찾아 수량 엘리먼트로 설정합니다
                var quantityElement = this.nextElementSibling;

                // 가격과 수량 엘리먼트를 가져옵니다
                const menucheckElement = text.closest('.menucheck');
                const onePriceElement = menucheckElement.querySelector(".price");
                const counterValueElement = menucheckElement.querySelector('.btn-con #counter-value');

                // 텍스트 내용을 숫자로 파싱합니다
                const onePrice = parseInt(onePriceElement.value);

                // 총 가격을 계산합니다
                const result = onePrice * parseInt(counterValueElement.textContent);

                // 버튼 텍스트를 업데이트합니다
                text.innerText = result + "원";


                event.preventDefault();
            });
        });
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
            // 클릭 시 수행할 추가적인 로직을 여기에 추가할 수 있습니다.
        });
    });
});


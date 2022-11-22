![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

## Event Storming
www.msaez.io/#/storming/eLZXDH2NciQcX7mpy0NETVpVT353/3cd164530fa17c1c886b1f4dc39467e4
<img width="591" alt="es" src="https://user-images.githubusercontent.com/59468442/203247825-57d14d6f-8d91-4529-a051-2bf10981af3e.png">

## 서비스 시나리오
 고객이 메뉴를 선택하여 주문한다.
 고객이 선택한 메뉴에 대해 결제한다.
 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
 상점주는 주문을 수락하거나 거절할 수 있다
 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
 라이더가 해당 요리를 pick 한후, pick했다고 앱을 통해 통보한다.
 고객이 주문상태를 중간중간 조회한다
 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다
![image](https://user-images.githubusercontent.com/59468442/203250223-4433eaba-2ea8-4801-a45c-a8540b94f92d.png)

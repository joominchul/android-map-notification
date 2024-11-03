# 카카오 테크 캠퍼스 스텝2 클론 코딩 프로젝트, 지도 검색 앱
- 제작 : 주민철
- 기간 : 24.07~08
- 사용 기술 : 코틀린, 안드로이드 스튜디오, 리사이클러뷰, Retrofit, LiveData, Mock, Hilt, MVVM, DataBinding, 코루틴, 파이어베이스, Room 데이터베이스.

## 앱 설명
![권한 설정](https://github.com/user-attachments/assets/e86063e0-6edb-4e99-84c3-05d8b5f6f28b)
앱을 처음 실행하면 스플래시 화면에서 알림 권한을 요청함.
![초기 화면](https://github.com/user-attachments/assets/e6fd2f98-211a-46a8-b5c3-dc9ce936269c)
초기 화면. 카카오 맵 API 사용. 검색창 클릭 시 검색 화면으로 이동.
![검색 화면](https://github.com/user-attachments/assets/d7c32e34-65f1-46ea-8c12-f3da512f268a)
검색 화면에서 검색어 입력 시 카카오 로컬 API를 사용해 검색 결과가 리사이클러뷰로 나옴.
![결과 클릭 시](https://github.com/user-attachments/assets/84de7d5d-311d-4bc7-a266-faac30a7d185)
검색 결과 클릭 시 지도에 장소를 표시함. BottomSheet로 간단한 정보도 표시. 이후 다시 검색창을 클릭 시
![다시 검색 화면](https://github.com/user-attachments/assets/e5cfe1de-476c-4640-ab31-a7f13518ae09)
클릭 했던 검색 결과가 기록으로 남음. 검색 기록은 Room 데이터베이스에 저장.
![알림 화면](https://github.com/user-attachments/assets/3580b023-5711-4088-91d9-fd507d72669f)
파이어베이스를 통해 앱에 알림을 보낼 수도 있음.

# android-map-notification

## 1단계 - Splash Screen
### 기능 요구 사항
- 초기 진입 화면을 추가한다.
- Firebase의 Remote Config를 설정한다.
  - 서비스 상태를 나타내는 매개변수를 아래와 같이 각각 등록한다.
    - 매개변수 이름:serviceState, serviceMessage
- 매개변수 serviceState 값이 ON_SERVICE일 때만 초기 진입 화면이 지도 화면으로 넘어간다.
- 매개변수 serviceState 값이 ON_SERVICE이 아닌 경우에는 serviceMessage 값을 초기 진입 화면 하단에 표시하고 지도 화면으로 진입하지 않는다.
### 프로그래밍 요구 사항
- 서버 상태, UI 로딩 등에 대한 상태 관리를 한다.
- 새로 추가되는 부분에도 MVVM 아키텍처 패턴을 적용한다.
- 코드 컨벤션을 준수하며 프로그래밍한다.

## 2단계 - 푸시 알림
### 기능 요구 사항
- Firebase Cloud Message를 설정한다.
- 테스트 메시지를 보낸다.
  - 앱이 백그라운드 상태일 경우 FCM 기본 값을 사용하여 Notification을 발생한다.
  - 앱이 포그라운드 상태일 경우 커스텀 Notification을 발생한다.
- Notification 창을 터치하면 초기 진입 화면이 호출된다.
### 프로그래밍 요구 사항
- 코드 컨벤션을 준수하며 프로그래밍한다.

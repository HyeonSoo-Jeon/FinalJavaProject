# FinalJavaProject

# 개요

# 기능
 
JPanel을 전환하는 방식으로 작동


## 기본 프레임

* 타이틀 바 제거
* 커스텀 타이틀 바 제작
  * 최소화, 최대화, 닫기
    * 버튼위에 마우스를 올리면 색상 변경
  * 타이틀 바 더블 클릭 시 최대화, 보통
  * 최대화 된 상태에서 타이틀 바를 움직이면 축소
  * 메뉴 버튼 구현
    * 메뉴 버튼 다시 누르면 사라지게(미완성)
* 기본 프레임 Resize 가능(미완성)

# setting Folder

## SetInitialFile

프로그램 실행 전 초기 세팅을 위한 파일

    * Data 폴터
    * Client 폴더 : 유저 정보가 담긴 폴더
    * Post 폴더 : 게시글 정보가 담긴 폴더

* checkPath() : Data가 저장될 폴더들이 있는지 확인
* checkUserInfoFile() : userInfo.dat이 있는지 확인

# DataManager Folder

## ClientData

userInfo.dat에 저장될 ClientData


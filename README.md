# Final Java Project
#####  12173067 전현수

---


## 개요

자바 GUI를 활용하여 게시판 응용 프로그램을 만들었습니다. 

<br>

사용자는 회원가입을 통해 계정을 만들 수 있습니다. 

각 계정으로 게시글을 작성할 수 있고, 게시글의 작성자는 해당 게시글을 삭제할 수 있습니다.

또한 게시글에 댓글도 작성할 수 있습니다.

원하는 모습의 GUI를 만들기 위해 Title Bar를 따로 만들었습니다.

자세한 내용은 파일설명에서 이어서 작성하겠습니다.



>   프로그램 실행은 <b>[Main 디렉터리]의 [Main.java]를 실행</b>하시면 됩니다.

---

## 파일 설명

## 1. Main Directory

### 1.1  Main.java

프로그램 실행을 위한 Main함수가 있습니다.

초기 Data 파일 설정을 위한 initPath( )와 initDataFile( )함수를 실행하고, 프로그램의 GUI를 실행하기 위해 MainGUI객체를 생성합니다.

## 2. DataManager Directory

각 계정의 정보를 ClientData라는 객체로, 게시글을 PostData로, 댓글을 CommentData 객체로 저장합니다. 해당 데이터를 처리하기 위해 각 객체 타입을 정의하고, 데이터를 저장하고 불러오는 함수를 DataManager클래스에서 관리합니다.

### 2.1 ClientData.java

사용자의 정보를 저장하는 ClientData 클래스입니다. 사용자의 ID, 닉네임, 비밀번호를 저장하여 관리합니다.

### 2.2 ClientDataManager.java



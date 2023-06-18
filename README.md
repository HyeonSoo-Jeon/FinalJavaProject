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

초기 Data 파일 설정을 위한 initPath( )와 initDataFile( )함수를 실행하고, 
프로그램의 GUI를 실행하기 위해 MainGUI객체를 생성합니다.

<br> 

## 2. Setting Directory

프로그램 실행을 위한 Data Directory와 Data 파일들을 생성해줍니다.

```
[Data]                      : 데이터 Directory
  ├── [Client]              : 사용자 정보 파일이 있는 Directory
  │      └── userInfo.dat   : 사용자 계정 정보 파일
  │ 
  └─── [Post]               : 게시글 정보 파일이 있는 Directory
         └── postInfo.dat   : 게시글 계정 정보 파일
``` 

### 2.1 InitialSetting.java

    public static void initPath()

Directory 경로를 설정해줍니다. 경로는 상대경로로 설정되어 있습니다.

만약 폴더가 없다면 새로 생성해주고, 생성이 실패됐을 경우 오류 메시지를 출력합니다.

[Data], [Client], [Post] 경로를 각각 생성합니다.

    public static void initDataFile()

[userInfo.dat] 파일과 [postInfo.dat]파일을 생성해줍니다.

만약 파일이 존재하지 않다면 새로 생성해주고, 생성을 실패했다면 오류 메시지를 출력합니다.

<br>

## 3. DataManager Directory

각 계정의 정보를 ClientData라는 객체로, 게시글을 PostData로, 댓글을 CommentData 객체로 저장합니다. 해당 데이터를 처리하기 위해 각 객체 타입을 정의하고, 데이터를 저장하고 불러오는 함수를 DataManager클래스에서 관리합니다.

### 3.1 ClientData.java

사용자의 정보를 저장하는 ClientData 클래스입니다. 사용자의 ID, 닉네임, 비밀번호를 저장하여 관리합니다.

클래스의 파일을 dat파일로 저장하기 위해서는 직렬화가 필요합니다. 직렬화란 객체를 바이트로 바꿔서 나열하는 것입니다.
따라서 Serializable 인터페이스를 구현합니다.

### 3.2 ClientDataManager.java

    public static ArrayList<ClientData> loadClientData()

[userInfo.dat]을 불러옵니다. 해당 파일에는 ```ArrayList<ClientData>``` 형식으로 저장되어 있습니다. 

FileInputStream 객체를 통하여 파일의 경로에서 객체를 불러오고,
ObjectInputStream 객체를 통하여 파일을 역질렬화 한 후 ```ArrayList<ClientData>```객체로 반환합니다.

만약 파일을 불러오는 것에 실패한 경우 오류메시지를 출력합니다.

    public static void saveClientData(ArrayList<ClientData> clients)

[userInfo.dat]을 저장합니다. 

FileOutputStream 객체를 통하여 파일의 경로를 설정하고, 
ObjectOutputStream 객체를 통하여 직렬화 후 파일에 저장합니다.

만약 파일을 저장하는 것에 실패한 경우 오류메시지를 출력합니다.

### 3.3 PostData.java

게시글 정보를 저장하는 클래스입니다. 게시글의 제목, 작성자 닉네임, 내용, 댓글들이 저장됩니다.
댓글은 ```ArrayList<CommentData>```  형식으로 관리됩니다.

마찬가지로 직렬화가 필요하므로 Serializable 인터페이스를 구현합니다.

### 3.4 PostDataManager.java

    public static ArrayList<PostData> loadPostData(){

[ClientDataManager.java]와 비슷하게 작동합니다. 해당 파일에는 ```ArrayList<PostData>``` 형식으로 저장되어 있습니다. 




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

## 1. [Main Directory]

### 1. 1.  Main.java

프로그램 실행을 위한 Main함수가 있습니다.

초기 Data 파일 설정을 위한 initPath( )와 initDataFile( )함수를 실행하고, 
프로그램의 GUI를 실행하기 위해 MainGUI객체를 생성합니다.

## 2. [Setting Directory]

프로그램 실행을 위한 Data Directory와 Data 파일들을 생성해줍니다.

```
[Data]                      : 데이터 Directory
  ├── [Client]              : 사용자 정보 파일이 있는 Directory
  │      └── userInfo.dat   : 사용자 계정 정보 파일
  │ 
  └─── [Post]               : 게시글 정보 파일이 있는 Directory
         └── postInfo.dat   : 게시글 계정 정보 파일
``` 

### 2. 1. InitialSetting.java

    public static void initPath()

Directory 경로를 설정해줍니다. 경로는 상대경로로 설정되어 있습니다.

만약 폴더가 없다면 새로 생성해주고, 생성이 실패됐을 경우 오류 메시지를 출력합니다.

[Data], [Client], [Post] 경로를 각각 생성합니다.

    public static void initDataFile()

[userInfo.dat] 파일과 [postInfo.dat]파일을 생성해줍니다.

만약 파일이 존재하지 않다면 새로 생성해주고, 생성을 실패했다면 오류 메시지를 출력합니다.

## 3. [DataManager Directory]

각 계정의 정보를 ClientData라는 객체로, 게시글을 PostData로, 댓글을 CommentData 객체로 저장합니다. 해당 데이터를 처리하기 위해 각 객체 타입을 정의하고, 데이터를 저장하고 불러오는 함수를 DataManager클래스에서 관리합니다.

### 3. 1. ClientData.java

사용자의 정보를 저장하는 ClientData 클래스입니다. 사용자의 ID, 닉네임, 비밀번호를 저장하여 관리합니다.

클래스의 파일을 dat파일로 저장하기 위해서는 직렬화가 필요합니다. 직렬화란 객체를 바이트로 바꿔서 나열하는 것입니다.
따라서 Serializable 인터페이스를 구현합니다.

### 3. 2. ClientDataManager.java

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

### 3. 3. PostData.java

게시글 정보를 저장하는 클래스입니다. 게시글의 제목, 작성자 닉네임, 내용, 댓글들이 저장됩니다.
댓글은 ```ArrayList<CommentData>```  형식으로 관리됩니다.

마찬가지로 직렬화가 필요하므로 Serializable 인터페이스를 구현합니다.

### 3. 4. PostDataManager.java

    public static ArrayList<PostData> loadPostData(){

[postInfo.dat]을 불러옵니다.
[ClientDataManager.java]와 비슷하게 작동합니다. 해당 파일에는 ```ArrayList<PostData>``` 형식으로 저장되어 있습니다. 

FileInputStream 객체를 통하여 파일의 경로에서 객체를 불러오고,
ObjectInputStream 객체를 통하여 파일을 역질렬화 한 후 ```ArrayList<PostData>```객체로 반환합니다.

만약 파일을 불러오는 것에 실패한 경우 오류메시지를 출력합니다.

    public static void savePostData(ArrayList<PostData> posts)

[postInfo.dat]을 저장합니다.

FileOutputStream 객체를 통하여 파일의 경로를 설정하고,
ObjectOutputStream 객체를 통하여 직렬화 후 파일에 저장합니다.

만약 파일을 저장하는 것에 실패한 경우 오류메시지를 출력합니다.

### 3. 5. CommentData.java

댓글 정보를 저장하는 클래스입니다. 댓글의 작성자 닉네임, 내용이 담겨있습니다.

## 4. [CustomAdapter Directory]

사용자의 Key 입력을 제한하기 위해 생성한 KeyAdapter 상속 클래스가 있습니다.

### 4. 1. NoSpaceAdapter.java

사용자가 스페이스바를 입력하는 것을 방지합니다. 

로그인과 회원가입을 할 때 Text Field에 ' '를 입력하는 경우를 방지하기 위함입니다.

### 4. 2. TitleLimitAdapter.java

사용자가 게시글의 제목을 너무 길게 작성하는 것을 막습니다.

게시글 제목의 폰트는 "Monospaced"으로 대소문자, 숫자 모두 간격이 일정한 고정폭 글씨체 입니다.
구현한 프로그램은 Size조절이 불가능하다는 점을 이용하여 Text Field를 넘지않게 하였습니다.

## 5. [UI Directory]

게시판 프로그램에서 보여질 GUI를 각 class로 작성하였습니다. 1개의 Frame과 5개의 Panel이 존재합니다.

CardLayout을 이용하여 각 Panel을 전환하는 방식으로 구현하였습니다.

### 5. 0. Fonts.java

GUI에 자주 사용되는 글씨체를 Font를 상속받아 사용하기 편리하도록 정의하였습니다.

### 5. 1. MainFrame.java

GUI에서 사용될 주 Frame입니다. JFrame을 상속받았습니다.

        setUndecorated(true);

위의 함수를 사용하여 기존의 Title Bar를 제거하였습니다. 
해당 함수를 사용하게 되면 프로그램의 Size조절을 사용자가 할 수 없게 됩니다.

Jpanel를 이용하여 Custom Title Bar를 생성하였습니다. 
기존의 Title Bar가 제공해주는 기능을 사용할 수 없기 때문에 따로 기능을 구현해야 합니다.

아래의 내용은 구현한 Custom Title Bar의 기능입니다.

> * 마우스 왼버튼으로 더블클릭 시 최대화/최소화
> * Title Bar를 드래그하여 화면 이동
> * 마우스가 위에 올라왔을 때 버튼 색상 변경
> * Title Bar Icon
> * Title Bar Menu
> * Minimize Button
> * Maximize Button
> * Close Button

Title Bar를 클릭하였을 때 마우스의 (x, y)를 저장합니다. 
두번 클릭하였을 때 ```toggleMaximizeRestore()```을 이용하여 최소화 합니다.

마우스로 드래그 하는 경우 만약 전체화면( ```JFrame.MAXIMIZED_BOTH```)이 아닌 경우 위치를 계산하여 이동시켜줍니다.
전체화면이었다면 ```JFrame.NORMAL```상태로 돌린 후 기존에 저장한 위치로 돌아갑니다.

Title Bar의 버튼에 마우스가 올라가게 된다면 [X]버튼을 제외한 나머지 버튼은 글자색과 배경색을 회색계열로 변경해주고,
[X]버튼의 경우는 빨간색으로 변경해줍니다. 마우스가 내려가면 원래 상태로 되돌려 줍니다.

Title Bar에 Icon, PopupMenu, Button 3개(최소화, 최대화, 닫기) 버튼을 구현해 줍니다.

PopupMenu에는 로그아웃과 종료를 위한 버튼이 있습니다. 해당 기능은 <b>[MainGUI.java]</b>에서 구현합니다.
Menu를 누르면 앞의 두 버튼이 나오게 됩니다.

최소화 버튼은 해당 Frame의 상태를 ```JFrame.ICONIFIED```로 변경해줍니다.

최대화 버튼은 해당 Frame의 상태를 정의한 ```setMaximizeRestore()```함수를 이용해 최대화 합니다.

닫기 버튼은 ```System.exit(0)```을 이용해 종료합니다.

Title Bar의 좌측과 우측으로 정렬하기 위해 [BorderLayout]의 BorderLayout.WEST와 BorderLayout.EAST를 이용하였고, 
아이콘과 Menu는 [FlowLayout.LEFT]로 왼쪽 정렬하여 WEST에,
최소화, 최대화, 닫기 버튼은 [FlowLayout.EAST]로 우측 정렬하여 EAST에 달았습니다.

Title Bar Panel은 Main Frame의 [BorderLayout.NORTH]에 붙여 상단에 위치하게 했습니다.

또한 상태표시줄의 아이콘에 쓰일 이미지와 프로그램 이름을 설정하고, 사이즈를 고정하였습니다.

```setMaximizeRestore()```함수는 최대화 상태이면 원래 상태로 변경하고, 
최대화가 아니라면 현재의 위치를 저장하고 최대화를 진행합니다.

### 5.2. LoginPanel.java

로그인 창을 보여줄 Panel입니다.

제목 Label은 SwingConstants로 설정하는데 이는 가운데 정렬을 이용하기 위함입니다.

```setPreferredSize```는 해당 컴포넌트의 Size를 지정해주는 것에 이용됩니다.
```Dimension(width, height)```를 이용하여 크기를 설정할 수 있습니다.

ID와 비밀번호 입력 컴포넌트를 수직으로 배치하기 위해서 ```BoxLayout```을 사용하였습니다.
매개변수의 값으로 ```BoxLayout.Y_AXIS```을 주었습니다.

```setBorder()```를 이용하여 컴포넌트의 경계선에 관한 값을 설정할 수 있습니다.
```new EmptyBorder(top, left, bottom, right)```을 인자로 넘겨서 내부의 간격을 설정하였습니다.

ID Panel, Password Panel을 ```FlowLayout()```로 설정하여 각각 Label과 Text Field가 수평적으로 배치될 수 있게 하고, 
각 패널을 ```BoxLayout```로 설정한 패널에 붙여서 수직으로 보일 수 있도록 설정하였습니다.
또한 경고메시지를 보일 label도 추가합니다.

하단에는 로그인 버튼과 회원가입 버튼이 있습니다. 해당 기능은 <b>[MainGUI.java]</b>에서 구현합니다.

```public String getID()```와 ```public String getPW()``` 를 구현했습니다.
```JPasswordField```는 ```char[]```형식으로 반환되므로 String type으로 변환해주었습니다.

```    public String verifyAccount()``` 는 로그인 버튼이 눌렸을 때 수행될 함수입니다.
만약 ID Field나 Password Field가 비어있다면 경고메시지를 출력합니다.
저장된 ClientData를 for문으로 비교하며 ID와 비밀번호가 일치한다면 로그인에 성공하므로 해당 사용자의 닉네임을 반환해주고,
로그인에 실패한 경우 null을 반환합니다.

### 5.3. CreateAccountPanel.java

회원가입을 진행할 Panel입니다.

Login Panel과 비슷한 구조로 구성되어 있습니다. 
맨 위에 Title Label을 붙이고, 아래에 ID, 닉네임, 비밀번호를 입력할 수 있도록 구현하였습니다.
또한 수직으로 배치될 수 있도록 ```BorderLayout.CENTER```에 붙일 Panel을 
```new BoxLayout(inputPanel, BoxLayout.Y_AXIS)```로 설정하였습니다.

ID, 닉네임, 비밀번호 패널은 마찬가지로 ```Flowlayout```으로 설정하여 수평적으로 배치하였고, 중복을 확인할 수 있는 




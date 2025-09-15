<h1>KH 도서관 프로그램</h1>

---------------------------------------------------------------------------------------------------------------------
<h3>프로잭트 개요</h3>

<ul>
    <li>프로잭트명 - KH Library</li>
    <li>프로그램 간단 설명 - JSP/JSTL + JDBC를 통해 구현한 도서관 관리 프로그램</li>
    <li>기술스택 -Oracle,Java,JDBC,JSP,JSTL,CSS 등</li>
   <h4> 역할분담</h4>
      <li>남동혁 - 일반회원 기능 구현(도서 검색/대여, 개인정보 관리,도서 대여 이력 조회 등)</li>
      <li>윤태혁 - 관리자회원 기능 구현(도서 추가/삭제/수정/조회, 회원 추가/삭제/수정/조회,로그인,회원가입</li> 
</ul>
---------------------------------------------------------------------------------------------------------------------
<h3>프로잭트 진행 과정 요약</h3>

1. 페이지 디자인/구성을 와이어프레임으로 제작
2. 테이블 설계 & 역할 분담 - 회원 등급에 따라 개발할 분야를 양분한 뒤 각자 개발 진행했습니다
3. 프론트엔드 구현 - 와이어프레임을 참고하여 html/css 작업, 페이지에 사용될 각종 이미지 제작을 했습니다
4. 백엔드 구현 - 서블릿, JSP/JSTL, Oracle을 사용하여 프로잭트에 사용될 기능들을 구현했습니다
---------------------------------------------------------------------------------------------------------------------
<h3>주요 기능 설명</h3>

<ul>
  <h4>공통</h4>
  <li>회원가입,로그인,아이디/비밀번호 찾기</li>
    <h4>회원 기능</h4>
  <li>도서 검색/대여/반납,대여 이력/대여중인 도서 조회, 개인정보 수정</li>
    <h4>관리자 기능</h4>
  <li>회원 추가/수정/삭제, 도서 추가/수정/삭제, 대여 이력 관리</li>
</ul>
---------------------------------------------------------------------------------------------------------------------
<h3>주요 구현 포인트 요약</h3>

<ul>
  <h4>메인페이지</h4>
  <li>세션에 따라 변경되는 헤더 구현, 도서명/작가명/출판사 카태고리와 검색어를 통한 자료 검색 기능</li>
  <h4>마이페이지</h4>
  <li>로그인 된 상태에서만 페이지 이동 가능,서명/작가명/출판사 카태고리와 검색어를 이용해서 대여 이력 조회기능을 구현, JSP 페이지 구현을 위한 파라미터들이 없을 경우를 대비해서 기본값 설정(ex 대여이력이 전무할 경우), 페이지네이션 구현</li>
  <h4>자료검색 페이지</h4>
  <li>모든 도서 리스트/ 검색된 도서 리스트 출력, 로그인이 되어있는 경우 도서 대여 버튼이 활성화, 로그인이 안되었더라도 해당 도서의 대여가능 여부가 확인되도록 JSP 활용, 페이지네이션 구현</li>
  <h4>관리자 기능 페이지</h4>
  <li>검색어를 통한 상세 검색 또는 모든 도서/회원/대여 이력을 관리 가능하도록 메서드 세분화, 관리자 기능의 경우 헤더가 변경되어 사용 가능한 메뉴가 달라지도록 구현 </li>
</ul>

---------------------------------------------------------------------------------------------------------------------
<h3>프로잭트 구조</h3>
<img width="214" height="558" alt="캡처5" src="https://github.com/user-attachments/assets/90bb68a2-4224-4f65-a54c-5cc9ed63f70e" />

                    
---------------------------------------------------------------------------------------------------------------------
<h3>사용된 테이블</h3>

<img width="617" height="122" alt="캡처" src="https://github.com/user-attachments/assets/71add26a-5b50-46de-9a3d-53305e7424fe" />
<img width="613" height="123" alt="캡처2" src="https://github.com/user-attachments/assets/fb2bc131-ead5-4090-ac4c-1be2fb5e32c1" />
<img width="617" height="184" alt="캡처3" src="https://github.com/user-attachments/assets/e7fcb14f-7a34-4d18-9d19-66f9ee3fa0c4" />
<img width="630" height="142" alt="캡처4" src="https://github.com/user-attachments/assets/9079526c-622e-46ef-bbe9-e52c49a018dc" />

---------------------------------------------------------------------------------------------------------------------
<h3>구현된화면</h3> 

<img width="809" height="618" alt="image" src="https://github.com/user-attachments/assets/27beea88-8b2e-4864-a269-0f9b58fe9e52" />
<img width="816" height="613" alt="image" src="https://github.com/user-attachments/assets/4491da9f-6ca6-4641-82b4-40c3470d098c" />
<img width="819" height="611" alt="image" src="https://github.com/user-attachments/assets/81db7e5f-be97-4265-9696-1a99690ea756" />
<img width="894" height="559" alt="image" src="https://github.com/user-attachments/assets/552ad810-a6c6-4ecb-b319-fb50686e2165" />
<img width="896" height="558" alt="image" src="https://github.com/user-attachments/assets/9ba181b6-8c29-49f9-a2f8-6b73ab67a549" />
<img width="809" height="618" alt="image" src="https://github.com/user-attachments/assets/4ddc73fd-6ed2-47dc-95d5-d46f12075afd" />
<img width="814" height="614" alt="image" src="https://github.com/user-attachments/assets/a7ee9b54-d9b4-461c-a5f7-99e32169e45d" />
<img width="857" height="583" alt="image" src="https://github.com/user-attachments/assets/cee7f8a3-3b10-4786-98f2-638b4cd4dffa" />
<img width="822" height="608" alt="image" src="https://github.com/user-attachments/assets/9fb91d39-ada4-4beb-b47c-79229f97ef67" />
<img width="809" height="618" alt="image" src="https://github.com/user-attachments/assets/0921e66d-e846-4461-a124-9ee5e2b4c519" />
<img width="857" height="583" alt="image" src="https://github.com/user-attachments/assets/4c7c68b4-554f-4388-a776-f989fa93daf1" />
<img width="819" height="610" alt="image" src="https://github.com/user-attachments/assets/75b4df85-8cf4-43aa-a71b-1e8ae9f2509d" />
<img width="834" height="599" alt="image" src="https://github.com/user-attachments/assets/6b815a63-7571-4ccd-913c-cb585ef7f963" />
<img width="823" height="608" alt="image" src="https://github.com/user-attachments/assets/069b473f-4767-4b6f-9136-6c7657333dc7" />
<img width="828" height="604" alt="image" src="https://github.com/user-attachments/assets/dc1308d6-5c5b-4bd0-b4fb-34d95a85d887" />

---------------------------------------------------------------------------------------------------------------------
<h3>향후 개선해보고싶은 점</h3> 

1. 기능을 합치는 과정중 발생한 각종 오류 해결
2. 미구현 기능 추가(공지사항 테이블 관련)
3. 반납 연기 등의 기능을 추가
4. 일부 DAO의 메서드의 경우 비슷한 기능이 다수 존재하는걸 완화

---------------------------------------------------------------------------------------------------------------------
<h3>마무리 & 느낀점</h3>

1. 404,500등 수많은 오류를 접하고 해결하면서 원인 파악-> 많은 오류 해결 연습의 시간 되었다 생각합니다.
2. 서로 제작한 기능을 합치는 작업을 하던 중, 회원 등급에 따른 패키지 구분으로 정리가 힘들었던 기억이 있습니다
   때문에 기능에 따른 구분을 우선시 해야겠다는 생각이 들었습니다
3. 기능적으로 겹치는 부분이 없다 생각했기에 깃허브에 파일을 프로그램 완성 직전까지도 올린적이 없습니다.
   때문에깃허브에 올려둔 마스터가 되는 파일이 없다보니 변수명,필드 등등 다른게 상당수 있어 하나의 프로그램으로 합치는데
   더욱 오랜 시간이 걸렸습니다. 떄문에 다음 프로잭트 진행시에는 깃허브를 좀 더 적극 활용할 생각입니다
4. HTML~ Jsp 까지 배운 내용의 대부분을 직접 사용해보는 기회가 되어 좋은 연습이 되었던것 같습니다.
5. 이번에는 시간 부족/실력 부족으로 프론트 엔드를 React를 활용하지 못하거나, JSTL을 적극적으로 활용하지는 못한것 같아서 아쉬움이 조금 남습니다.
    다음에는 컴포넌트처럼 활용해보고싶다는 생각이 들었습니다.
6. 페이지네이션 구현을 위해, 또 구현 방법을 이해하기 위해 꽤 많은 시간을 들였으나 구현은 하더라도 완전히 이해하지는 못해서 추후 좀 더 연습을 해보고싶습니다.
7. 처음 와이어프레임 제작 하던 때에도 느꼇던 자신의 단점이 다시 드러난 느낌을 받았고, 앞으로도 다른 ppt를 참고해서 다음에는 좀 더 보완해보고싶습니다.
   



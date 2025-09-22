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
<img width="3200" height="1800" alt="Frame 59" src="https://github.com/user-attachments/assets/3abbc47e-e3fc-4c6b-be8a-370ca3247f2b" />
<img width="3200" height="1800" alt="Frame 60" src="https://github.com/user-attachments/assets/ddc9d672-0fd2-44c7-a987-309c883a3f0e" />
<img width="3200" height="1800" alt="Frame 61" src="https://github.com/user-attachments/assets/58119df8-0bb3-4a0d-9bb4-7dc1f584411e" />
<img width="3200" height="1800" alt="Frame 62" src="https://github.com/user-attachments/assets/ae9b96b4-4512-4290-8fc6-868eff9cfbb2" />
<img width="3200" height="1800" alt="Frame 64" src="https://github.com/user-attachments/assets/9aa509c4-1696-4e79-9f8d-a5f1ba712dd5" />
<img width="3200" height="1800" alt="Frame 65" src="https://github.com/user-attachments/assets/56a7d2c6-3769-457b-9a6b-e457e3c1f578" />
<img width="3200" height="1800" alt="Frame 66" src="https://github.com/user-attachments/assets/f48d77f4-e5ec-4843-8239-9f6e1d79c0c8" />
<img width="3200" height="1800" alt="Frame 67" src="https://github.com/user-attachments/assets/e1e5fc05-2bd6-4e0e-847c-8761a40d6758" />
<img width="3200" height="1800" alt="Frame 68" src="https://github.com/user-attachments/assets/c282c03b-d8f8-497a-9e96-48638fc9aa92" />
<img width="3200" height="1800" alt="Frame 77" src="https://github.com/user-attachments/assets/fe3c27cb-47c0-4533-a8ca-94cb0090920e" />
<img width="3200" height="1800" alt="Frame 69" src="https://github.com/user-attachments/assets/4c11faf6-355b-4b2b-8794-4133114fba44" />
<img width="3200" height="1800" alt="Frame 70" src="https://github.com/user-attachments/assets/3ad155e5-a081-4527-ba71-54c8d787f939" />
<img width="3200" height="1800" alt="Frame 71" src="https://github.com/user-attachments/assets/23327247-ea2c-44dc-9730-35f214c5b50b" />
<img width="3200" height="1800" alt="Frame 72" src="https://github.com/user-attachments/assets/5720587f-fbd5-419b-8313-0f0f9b378b67" />
<img width="3200" height="1800" alt="Frame 73" src="https://github.com/user-attachments/assets/4ca2eb3b-fb9d-49dd-afa5-378c6161fece" />
<img width="3200" height="1800" alt="Frame 74" src="https://github.com/user-attachments/assets/0d59ffc4-296b-439a-8e6d-f96af0619950" />
<img width="3200" height="1800" alt="Frame 75" src="https://github.com/user-attachments/assets/da1038fb-5c80-41e8-be45-d64ea7fa32f6" />
<img width="3200" height="1800" alt="Frame 76" src="https://github.com/user-attachments/assets/0ba9e02e-826a-433f-b184-f52364bcf92f" />
<img width="3200" height="1800" alt="Frame 78" src="https://github.com/user-attachments/assets/3a5d1757-1563-4a8e-bd59-7701b8f36283" />


---------------------------------------------------------------------------------------------------------------------
<h3>향후 개선해보고싶은 점</h3> 

1. 기능을 합치는 과정중 발생한 각종 오류 해결
2. 미구현 기능 추가(공지사항 테이블 관련)
3. 반납 연기 등의 기능을 추가
4. 일부 DAO의 메서드의 경우 비슷한 기능이 다수 존재하는걸 완화
5. 더 나은 기능을 구현할 아이디어가 있음에도 그러지 못한 점
6. 페이징 처리 부분은 ai의 도움을 크게 받았는데, 다음에는 ai의 도움 없이 스스로 구현해보고싶습니다

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
   



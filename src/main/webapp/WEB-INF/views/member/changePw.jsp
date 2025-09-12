<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="${ctx }/sources/User_css/개인정보수정.css"/>
    <script>
    	function alertError() {
    		let error = document.querySelector(".link").addEevnetLisener();
    	}
    </script>
</head>
<body>
    <div id="container">
        <!-- 상단 푸른색 로고~메뉴 -->
        <div id="headWidthControl">
	      <div id="header">
	        <div id="logo">
	          <a href="${ctx}/"><img src="${ctx}/sources/image/logo_kh_60px.png" alt=""></a>
	        </div>
	        <div class="headerNavi" id="wellcome">환영합니다 ${sessionScope.memberName} 님.</div>
	        <div class="headerNavi"><a href="/khlibary/logout"><u>로그아웃</u></a></div>
	        <div class="headerNavi"><a href="${ctx}/member/recode">나의책장</a></div>
	        <div id="headerMenu"><img src="${ctx}/sources/image/icon_menu_50px.png" alt=""></div>
	      </div>
        </div>
        <div id="mainWidthControl">
            <!-- 상단 아레 보라색 메인페이지 & 검색창 -->
            <div id="myPageAndSearch">
                <div id="myPage">
                    <img src="${ctx }/sources/image/book_icon_white_50px.png" id="bookImg" alt="">
                    나의 책장</div>
                <div id="searchPlace1">
                    <div class="searchContainer">
						<form class="innerSearchContainer" action="${ctx}/book/list" method="get">
						  <select name="type" class="select">
						    <option value="bookName">도서명</option>
						    <option value="author">작가명</option>
						    <option value="publisher">출판사</option>
						  </select>
						  <input type="text" class="searchinput" name="searchKey" placeholder="검색어를 입력해주세요">
						  <button class="searchBtn" type="submit">
						    <img src="${ctx}/sources/image/search_30dp_1F1F1F_FILL0_wght400_GRAD0_opsz24.png" alt="">
						  </button>
						</form>
                    </div>
                </div>
            </div>
            <!-- 4종 네비 -->
            <div id="Navi">
                <div id="mainNavi">
                    <a herf="" class="mainNavis">도서관안내</a>
                    <a herf="" class="mainNavis">진행중인행사</a>
                    <a herf="" class="mainNavis">도서관달력</a>
                    <a herf="" class="mainNavis">공지사항</a>
                </div>
            </div>
            <!-- 메인 -->
            <div id="main">
                <!-- 메인 왼쪽 4종 메뉴 -->
                <div id="mainLeft">
                    <div class="mainMenus" ><a href="/member/recode">대여 이력</a></div>
                    <div class="mainMenus"><a href="/member/current">대여중인 도서</a></div>
                    <div class="mainMenus"><a href="/member/modify">개인정보 수정</a></div>
                    <div class="mainMenus" id="selected" ><a href="/member/changePw">비밀번호 변경</a></div>
                </div>

                
            
                <div id="mainRight">
                    <div id="mainHeader">
                        <div id="pageName">
                            <h4 id="nameText">
                                비밀번호 변경
                            </h4>
                        </div>
                    </div>
                    
                <c:if test="${not empty error }">
                	<div style-"color:#b91c1c; font-weight:700; padding:8px 0;">${error}</div>
                </c:if>
                
                <!-- =====1. 비밀번호 확인======= -->
                <c:if test="${mode eq 'verify' }">
                    <form action="${ctx }/member/changePw" method="post" id="mainPlace">
                    	<input type="hidden" name="step" value="verify"/>
                        <div id="mainContent">
                            <div id="putPassWord">
                                <label for="inputPassword">비밀번호를 입력해주세요  </label>
                                <input name="inputPassword" id="inputPassword" type="password">
                            </div>
                        </div>
                        <div id="shiftPageAndBtnPlace">
                            <button id="submitBtn">확인</button>
                        </div>
                    </form>
                  </c:if>
                  
                  
                   <!-- 다음 비밀번호 수정 페이지로 이동 -->
                   <c:if test="${mode eq 'edit'}">
                   	<form id="mainPlace" action="${ctx }/member/changePw" method="post">
                   		<input type="hidden" name="step" value="update"/>
                   		
                   		<div id=mainContent>
                   			<div id="inputHead" style="display:grid; ,grid-template-colums: repeat(5, 1fr); gap: 8px;font-weight:700; padding:10px 12px;">
                   			<div class="coulumn"></div>
                   			<div class="coulumn"></div>
                   		</div> 
                   		
                   		<div id="inputArea" style="display:grid; grid-template-columns: repeat(5, 1fr); gap:8px; padding:0 12px 12px;">
                   			<div class="inputs" id="inputNewPw" >변경 비밀번호
                   				<input type="password" name="newPw" >
                   			</div>
                   			<div class="inputs" id="checkNewPw">변경 비밀번호 확인
                   				<input type="password" name="checkPw">
                   			</div>
      		            <div id="shiftPageAndBtnPlace">
			              <button id="submitBtn" type="submit">수정 완료</button>
			            </div>
                   	</form>
                   </c:if>	
                </div>
            </div>
        </div>
    
    <!-- 푸터 -->
<div id="footerWidthControl">
    <footer id="footer">
    <div class="footerInner">
        <ul class="footLinks" onclick="alertError()">
            <a class="link" id="firstLink" href="#">개인정보처리방침</a>
            <a class="link" href="#">이용약관</a>
            <a class="link" href="#">사이트맵</a>
        </ul>
        <div class="footInfo">
            <span class="footInfoSpan" >tel 02-000-0000</span>
            <span class="footInfoSpan" >fax 02-000-0000</span>
            <span class="footInfoSpan" >email kh@library.com</span>
            <span class="footInfoSpan" ><a class="link" id="firstLink2" href="#">관련 홈페이지 안내 <img src="./sources/img/book_icon_white_40px.png" alt=""></a></span>
            <span class="footInfoSpan" ><a class="link" id="secondLink" href="#">관련 홈페이지 안내 <img src="./sources/img/icon_person_add_40px.png" alt=""></a></span>
        </div>
        <div class="footToggles">
            <span class="toggleDot">XXX.XXXXX.XXXXXX</span>
            <span class="toggleDot">XXX.XXXX.XXXXXX</span>
        </div>
    </div>
    </footer>
</div>
</div>
</body>
</html>
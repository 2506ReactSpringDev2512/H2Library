<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/sources/User_css/index2.css"/>
</head>
<body>

<c:choose>
<%-- 로그인 후 --%>
  <c:when test="${not empty sessionScope.memberId}">
    <div id="headWidthControl">
      <div id="header">
        <div id="logo">
          <a href="${ctx}/"><img src="${ctx}/sources/image/logo_kh_60px.png" alt=""></a>
        </div>
        <div class="headerNavi" id="wellcome">환영합니다 ${sessionScope.memberName} 님.</div>
        <div class="headerNavi"><a href="${ctx}/khlibary/logout">로그아웃</a></div>
        <div class="headerNavi"><a href="${ctx}/member/recode">나의책장</a></div>
        <div id="headerMenu"><a href="${ctx}/notice/list"><img src="${ctx}/sources/image/icon_menu_50px.png" alt=""></a></div>
      </div>
    </div>
  </c:when>

 <%-- 로그인 이전 --%>
  <c:otherwise>
    <div id="headWidthControl">
      <div id="header">
        <div id="logo">
          <a href="${ctx}/"><img src="${ctx}/sources/image/logo_kh_60px.png" alt=""></a>
        </div>
        <div class="headerNavi" id="wellcome"></div>
        <div class="headerNavi">
          <a href="${ctx}/member/login">
            <img src="${ctx}/sources/image/icon_login_40px.png" alt="">로그인
          </a>
        </div>
        <div class="headerNavi">
          <a href="${ctx}/member/signup">
            <img src="${ctx}/sources/image/icon_person_add_40px.png" alt="">회원가입
          </a>
        </div>
        <div id="headerMenu">
          <div id="headerMenu"><a href="${ctx}/notice/list"><img src="${ctx}/sources/image/icon_menu_50px.png" alt=""></a></div>
        </div>
      </div>
    </div>
  </c:otherwise>
</c:choose>

        <div id="mainWidthControl">
            <div id="head">
                <h1 id="mainPage" >자료검색</h1>
            </div>
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
        <!-- 푸터 -->
<div id="footerWidthControl">
    <footer id="footer">
    <div class="footerInner">
        <ul class="footLinks">
            <a class="link" id="firstLink" href="#">개인정보처리방침</a>
            <a class="link" href="#">이용약관</a>
            <a class="link" href="#">사이트맵</a>
        </ul>
        <div class="footInfo">
            <span class="footInfoSpan" >tel 02-000-0000</span>
            <span class="footInfoSpan" >fax 02-000-0000</span>
            <span class="footInfoSpan" >email kh@library.com</span>
            <span class="footInfoSpan" ><a class="link" id="firstLink2" href="#">관련 홈페이지 안내 <img src="./sources/image/book_icon_white_40px.png" alt=""></a></span>
            <span class="footInfoSpan" ><a class="link" id="secondLink" href="#">관련 홈페이지 안내 <img src="./sources/image/icon_person_add_40px.png" alt=""></a></span>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="${ctx}/sources/User_css/대여 이력.css"/>
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
                    <img src="${ctx}/sources/image/book_icon_white_50px.png" id="bookImg" alt="">
                    나의 책장</div>
                <div class="searchPlace">
                    <div class="searchContainer">
                        <form action="${ctx}/book/list" method="get" class="innerSearchContainer">
                            <select name="select" class="select">
							    <option value="bookName">도서명</option>
							    <option value="author">작가명</option>
							    <option value="publisher">출판사</option>
                            </select>
                     	    <input type="text" class="searchinput" name="searchKey" placeholder="검색어를 입력해주세요">
                            <button type="submit" value="" class="searchBtn">
                                <img src="${ctx}/sources/image/search_30dp_1F1F1F_FILL0_wght400_GRAD0_opsz24.png" alt="">
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 4종 네비 -->
            <div id="Navi">
                <div id="mainNavi">
                    <div class="mainNavis"><a href="">도서관안내</a></div>
                    <div class="mainNavis"><a href="">진행중인행사</a></div>
                    <div class="mainNavis"><a href="">도서관달력</a></div>
                    <div class="mainNavis"><a href="">공지사항</a></div>
                </div>
            </div>
            <!-- 메인 -->
            <div id="main">
                <!-- 메인 왼쪽 4종 메뉴 -->
                <div id="mainLeft">
                    <div class="mainMenus" ><a href="/member/recode">대여 이력</a></div>
                    <div class="mainMenus" id="selected" ><a href="/member/current">대여중인 도서</a></div>
                    <div class="mainMenus"><a href="/member/modify">개인정보 수정</a></div>
                    <div class="mainMenus"><a href="/member/changePw">비밀번호 변경</a></div>
                </div>
                <!-- 메인 중앙~오른쪽 주요 기능 -->
                <div id="mainRight">
                    <div id="mainHeader">
                        <div id="pageName">
                            <h4 id="nameText">
                                대여 이력
                            </h4>
                            <h5 class="userInfo">회원 이름: ${sessionScope.memberName} </h5>
                            <h5 class="userInfo">검색 결과 : ${rList.size() }</h5>
                        </div>
                    </div>
                    <div class="searchPlace">
                        <div class="searchContainer">
                               <form action="${ctx}/member/current " method="post" class="innerSearchContainer">
                                <select name="recodeSelect" class="select">
                                    <option value="">검색조건 선택</option>
                                    <option value="bookName">도서명</option>
                                    <option value="author">작가명</option>
                                    <option value="publisher">출판사</option>
                                </select>
                                	 <input type="text" class="searchinput" name="searchKey" placeholder="검색어를 입력해주세요">
                                <input type="submit" value="기록검색" class="searchBtn">
                                    <img src="/sources/image/search_30dp_1F1F1F_FILL0_wght400_GRAD0_opsz24.png" alt="">
                                </input>
                               </form>
                        </div>
                    </div>
                    <div id="mainPlace">
                        <div id="mainContent">
                           <table class="listTable">
                               <thead>
                                   <tr>
                                       <th>도서명</th>
                                       <th>작가</th>
                                       <th>출판사</th>
                                       <th>대출일</th>
                                       <th>반납일</th>
                                       <th>
                                           반납하기
                                       </th>
                                   </tr>
                               </thead>
                               <tbody>
                               <c:choose>
                               <c:when test="${not empty rList}">
                               <c:forEach  items="${rList }" var="rent">
                                   <tr>
                                       <td>${rent.bookName}</td>
										<td>${rent.author}</td>
										<td>${rent.publisher}</td>
										<td>${rent.lendDate}</td>
										<td>${rent.returnDate}</td>
                                       <td>
                                       <c:choose>
                                       <c:when  test="${rent.returnYn eq 'N' }">
                                		<form action="${ctx }/rent/return" method="post">
                                		<input type="hidden" name="bookNo" value="${rent.bookNo }">
                                		<input type="hidden" name="memberId" value="${sessionScope.memberId }">
                                        <button type="submit" value="삭제" id="returnBook">반납하기</button>
                                	</form>
                                	</c:when>
                                	<c:otherwise>
                                	 <span class="RentAble" aria-disabled="ture">도서 반납 완료</span>
                                	</c:otherwise>
                                	</c:choose>
                                       </td>
                                   <tr>
                               </c:forEach>
                               </c:when>
                               
                               <c:otherwise>
                               	<tr>
                               		<td colspan="6" style="text-align: center;">대여 이력이 없습니다</td>
                               	</tr>
                               </c:otherwise>
                               </c:choose>
                               </tbody>
                           </table>
                        </div>
                        <div id="shiftPageAndBtnPlace">
                            <div class="pagination">
                            
                            	<c:if test="${page >1 }">
                                <a class="pageBtn" href="${ctx}/member/recode?page=${page-1 }&type=${type }&searchKey=${fn:escapeXml(searchKey)} ">&lt;</a>
								</c:if>
								
								<c:forEach var="i" begin="1" end="${totalPages }">
								<c:choose>
									<c:when test="${i == page }">
										<span class="pageBtn" style="font-weight:700;">${i}</span>
									</c:when>
									<c:otherwise>
										<a class="pageBtn" 
										href="${ctx}/member/recode?page=${i }&type=${type}&searchKey=${fn:escapeXml(searchKey)}">${i}</a>
									</c:otherwise>
								</c:choose>
								</c:forEach>
								
								<c:if test="${page < totalPages }">
								<a class="pageBtn"
								href="${ctx}/member/recode?page=${i}&type=${type}&searchKey=${fn:escapeXml(searchKey)}">&gt;</a>
								</c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<!-- 푸터 -->
        <div id="footerWidthControl">
            <div id="footer">
                <div id="footerHead">
                    <div id="footerHeadContent"></div>
                </div>
                <div id="footerMain">
                    <div id="footerMaincontent">
                        <a href="">개인정보처리방침</a>
                        <a href="">협력단체 정보</a>
                    </div>
                </div>
                <div id="footerBottom">
                    <div id="footerBottomContent"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
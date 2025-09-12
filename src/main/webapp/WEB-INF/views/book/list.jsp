<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/sources/User_css/list.css"/>
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
        <div class="headerNavi"><a href="${ctx}/member/logout">로그아웃</a></div>
        <div class="headerNavi"><a href="${ctx}/member/recode">나의책장</a></div>
        <div id="headerMenu"><img src="${ctx}/sources/image/icon_menu_50px.png" alt=""></div>
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
          <a href="${ctx}/book/list"><img src="${ctx}/sources/image/icon_menu_50px.png" alt=""></a>
        </div>
      </div>
    </div>
  </c:otherwise>
</c:choose>
        <div id="mainWidthControl">
            <!-- 상단 아레 메인페이지 & 검색창 -->
            <div id="myPageAndSearch">
                <div id="myPage">자료 검색</div>
                <div id="searchPlace1">
                    <div class="searchContainer">
                         <form action="${ctx}/book/list" method="get" class="innerSearchContainer">
						  <select name="type" class="select">
						    <option value="bookName"  ${type=="bookName"?"selected":""}>도서명</option>
						    <option value="author"    ${type=="author"?"selected":""}>작가명</option>
						    <option value="publisher" ${type=="publisher"?"selected":""}>출판사</option>
						  </select>
						  <input type="text" class="searchinput" name="searchKey"
						         placeholder="검색어를 입력해주세요" value="${fn:escapeXml(searchKey)}">
						  <button type="submit" class="searchBtn">
						    <img src="${ctx}/sources/image/search_30dp_1F1F1F_FILL0_wght400_GRAD0_opsz24.png" alt="">
						  </button>
						</form>
                    </div>
                </div>
            </div>
            <!-- 4종 네비 -->
            <div id="Navi">
                <div id="mainNavi">
                    <button class="mainNavis">도서관안내</button>
                    <button class="mainNavis">진행중인행사</button>
                    <button class="mainNavis">도서관달력</button>
                    <button class="mainNavis">공지사항</button>
                </div>
            </div>
            <!-- 메인 -->
            <div id="main">
                <div id="pageName">
                    <h2 id="nameText">검색결과</h2>
                </div>
                <div id="searchPlace2">
                    <div class="searchContainer">
                        <form action="${ctx}/book/list" method="get" class="innerSearchContainer">
						  <select name="type" class="select">
						    <option value="bookName"  ${type=="bookName"?"selected":""}>도서명</option>
						    <option value="author"    ${type=="author"?"selected":""}>작가명</option>
						    <option value="publisher" ${type=="publisher"?"selected":""}>출판사</option>
						  </select>
						  <input type="text" class="searchinput" name="searchKey"
						         placeholder="검색어를 입력해주세요" value="${fn:escapeXml(searchKey)}">
						  <button type="submit" class="searchBtn">
						    <img src="${ctx}/sources/image/search_30dp_1F1F1F_FILL0_wght400_GRAD0_opsz24.png" alt="">
						  </button>
						</form>
                    </div>
                </div>
            <div id="mainContent">
                <table id="list">
                    <thead id="listHead">
                    	<tr class="th">
	                        <th class="listHeader" >도서번호</th>
	                        <th class="listHeader" >도서명</th>
	                        <th class="listHeader" >작가</th>
	                        <th class="listHeader" >출판사</th>
	                        <th class="listHeader" >도서상태</th>
                        </tr>
                    </thead>
                    <tbody>
				    	<c:forEach  items="${bList}" var="book">
                    		<tr class="th">
		                        <td>${book.book_No }</td>
		                        <td>${book.book_Name }</td>
		                        <td>${book.book_Author }</td>
		                        <td>${book.book_Publisher }</td>
		                        <td>
		                   <c:choose>
	                             <%-- 로그인 O --%>
	                        <c:when test="${not empty sessionScope.memberId}">
	                           	<c:choose>
	                            	<c:when test="${book.lend_YN eq 'Y' or book.lend_YN eq '대여가능' }">
	                            		<form action="${ctx}/rent/rent " method="post" class="rent">
	                            			<input type="hidden" name="bookNo" value="${book.book_No }">
	                            			<input type="hidden" name="memberId" value="${sessionScope.member_Id }">
	                            			<button type="submit" class="rentBtn">도서 대여하기</button>
	                            		</form>
	                         		</c:when>
	                         		<c:otherwise>
	                         			<span class="RentDisable" aria-disabled="ture">도서 대여중</span>
	                         		</c:otherwise>
	                         	</c:choose>
	                         </c:when>
	                         
   							 <%-- 로그인 X --%>
	                         <c:otherwise>
	                         	<c:choose>
	                         		<c:when test="${book.lend_YN eq 'Y' or book.lend_YN eq '대여가능' }">
	                         		<span class="RentAble" aria-disabled="ture">로그인 후 대여 가능</span>
	                         		</c:when>
	                         		<c:otherwise>
	                         		<span class="RentDisable" aria-disabled="ture">도서 대여중</span>
	                         		</c:otherwise>
	                         	</c:choose>
	                         </c:otherwise>
	                        </c:choose>
	                        	</td>
		                    </tr>       
				    	</c:forEach>
				    	</tbody>
				    </table>
		        </div>
	            <div id="shiftPageAndBtnPlace">
					<div class="pagenation">
					<!-- 이전 -->
						<c:if test="${page >1 }">
							<a class="pageBtn" href="${ctx}/book/list?page=${page-1}&type=${type}&searchKey=${fn:escapeXml(searchKey)}">&lt;</a>
						</c:if>
						
						<!-- 번호 -->
						<c:forEach var="i" begin="1" end="${totalPages }">
						<c:choose>
							<c:when test="${i == page }">
								<span class="pageBtn" style="font-weight:700;">${i} </span>
							</c:when>
						 	<c:otherwise>
						 		<a class="pageBtn"
						 		href="${ctx}/book/list?page=${i}&type=${type}&searchKey=${fn:escapeXml(searchKey)}">${i} </a>
						 	</c:otherwise>
						 </c:choose>
						</c:forEach>
					</div>
				    <!-- 다음 -->
					<c:if test="${page < totalPages }">
					<a class="pageBtn"
					href="${ctx}/book/list?page=${i}&type=${type}&searchKey=${fn:escapeXml(searchKey)}">&gt;</a>
					</c:if>
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
                        <a href=""></a>
                        <a href=""></a>
                    </div>
                </div>
                <div id="footerBottom">
                    <div id="footerBottomContent"></div>
                </div>
            </div>
        </div>

</body>
</html>
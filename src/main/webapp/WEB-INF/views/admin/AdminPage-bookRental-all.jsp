<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-전체 조회</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/Admin_css/book-rental/AdminPage-bookRental-search.css">
</head>
<body>
	<script src="${pageContext.request.contextPath}/sources/JavaScript/ScrollFunction.js"></script>
    <div class="container">
        <div class="header">
            <div class="header_rigth_logo">
                <a href="/khlibary/admin/main"><img src="/sources/image/kh_gray_logo.png" alt="kh_logo" width="110px"></a>
            </div>
            <div class="header_menu">
                <ul id="menu_list">
                    <li><a href="/khlibary/admin/main">회원관리</a></li>
                    <li><a href="/khlibary/admin/book/main">도서관리</a></li>                    
                    <li><a href="/khlibary/admin/bookrental/main">대여관리</a></li>
                </ul>
            </div>
            <div class="header_user">
                <ul id="user_info">
                    <li>${memberName}님 환영합니다.</li>
                    <li><a href="/khlibary/logout"><u>로그아웃</u></a></li>
                </ul>
            </div>
        </div>
        <div class="main">
            <h2>도서 관리 - 전체 조회</h2>
            <table border="1">
                    <colgroup>
                    <col style="width: auto">
                    <col style="width: auto">
                    <col style="width: auto">
                    <col style="width: auto">
                    <col style="width: auto">
                    <col style="width: auto">
                </colgroup>
                <thead>
                    <tr>
                        <th>회원아이디</th>
                        <th>책번호</th>
                        <th>책이름</th>
                        <th>대출 시작일</th>
                        <th>대출 종료일</th>
                        <th>상태</th>
<!--                         <th>반납</th> -->
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookRentalInfo}">
                    <tr>
                        <td>${book.memberId}</td>
                        <td>${book.bookNo}</td>
                        <td>${book.bookName}</td>
                        <td>${book.lendDate}</td>
                        <td>${book.returnDate}</td>              
                        <c:choose>
                        	<c:when test="${book.returnYn != 'Y' }">
                        		<td><div class="book status_N">대출 중</div></td>
                        	</c:when>
                        	<c:otherwise>
                        		<td><div class="book status_Y">반납 완료</div></td>
                        	</c:otherwise>
                        </c:choose>
                        
<!--                         <td> -->
<!-- 	                        <form action="/khlibary/admin/bookrental/return" method="post"> -->
<%-- 	                        		<input type="hidden" name="memberId_return" value="${book.m_Id }"> --%>
<%-- 	                        		<input type="hidden" name="bookNo_return" value="${book.book_No }"> --%>
<%-- <%-- 	                        		<input type="hidden" name="bookName_return" value="${book.book_Name }"> --%>
<!-- 	                        		<input type="submit" class="book_return" value="반납"> -->
<!-- 	                        </form> -->
<!--                         </td> -->
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
            <button id="scrollToTopBtn" onclick="javascript:scrollToTop()">▲</button>
            <button id="scrollToBottomBtn" onclick="javascript:scrollToBottom()">▼</button>
        </div>
        <!-- <div class="footer">
            <div class="footer-top">
                <ul>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">버그발생신고</a></li>
                </ul>
            </div>
            <div class="footer-bottom">
                <ul>
                    <li><a href="#">&#40;우&#41; XXXXX XX시 XX구 XX로 XXXX</a></li>
                    <li><a href="#">전화 문의 : XXX-XXXX-XXXX</a></li>
                    <li><a href="#">Fex : XXX-XXX-XXXX</a></li>
                    <li><a href="#">Email 문의 : XXXXXXX@XXXX.com</a></li>
                    <li><a href="#">관련 사이트 :<button></button><button></button></a></li>
                </ul>
            </div>
        </div> -->
    </div>
</body>
</html>
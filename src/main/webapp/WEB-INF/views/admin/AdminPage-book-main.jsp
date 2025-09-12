<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-도서관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/Admin_css/book/AdminPage-book-management.css">
    <script>
    		function checkInput() {
    			let search = document.getElementById("searchInput").value;
    			if(!search) {
    				alert("검색할 자료를 입력해주세요.");
    				return false;
    			}
    			return true;
    		}
	</script>
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
                    <li><a href="/khlibary/logouy"><u>로그아웃</u></a></li>
                </ul>
            </div>
        </div>
        <div class="main">
            <h2>대여관리 - 도서 관리</h2>
            <form action="/khlibary/admin/book/main" method="post" class="searchbar"   onsubmit="return checkInput()">
                <select name="select" id="select">
                    <option value="Book_Name">책 제목</option>
                    <option value="Book_Author">저자</option>
                    <option value="Book_Publisher">출판사</option>
                </select>
                <input type="text" name="bookSearch" id="searchInput" placeholder="검색할 자료를 입력해주세요.">
                <input type="submit" value="검색" id="searchBtn">
            </form>
            <form action="/khlibary/admin/pagetype" method="post" class="table-controls">
            		<input class="btn modify" type="submit" name="action" value="도서수정">
                <input type="submit" class="btn add" name="action" value="도서추가">
            </form>   
            <table border="1">
                    <colgroup>
                    <col style="width: 10%">
                    <col style="width: 20%">
                    <col style="width: 25%">
                    <col style="width: 20%">
                    <col style="width: 15%">
                    <col style="width: 5%">
                </colgroup>
                <thead>
                    <tr>
                    	<th>책번호</th>
                        <th>책제목</th>
                        <th>저자</th>
                        <th>출판사</th>
                        <th>대출여부</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${booklist}">
                    <tr>
                    	<td>${book.book_No }</td>
                        <td>${book.book_Name }</td>
                        <td>${book.book_Author }</td>
                        <td>${book.book_Publisher }</td>
                        <c:choose>
	                        <c:when test="${book.lend_YN == 'N'}">
	                        		<td><div id="book_status_N">대출 불가능</div></td>
	                        </c:when>
                        		<c:otherwise>
                        			<td><div id="book_status_Y">대출 가능</div></td>
                        		</c:otherwise>
                        </c:choose>                   
                        </td>
                        <td>
	                        <form action="/khlibary/admin/book/delete" method="post">
	                        		<input type="hidden" name="book_delete" value="${book.book_No}">
	                        		<input type="submit" value="삭제" class="deleteBtn" >
	                        </form>
	                       	 <c:if test="${not empty errorMsg}">
							    <script>alert("${errorMsg}");</script>
							    <%-- request scope에서 errorMsg를 제거하여 새로고침 시 alert가 뜨지 않게 함 --%>
							    <c:remove var="errorMsg" scope="request"/>
							</c:if>
                        </td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-관리자</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/Admin_css/member/AdminPage-main.css">
    <script>
	    function checkInput() {
	        let input = document.getElementById("input").value;
	        if (!input) {
	            alert("검색할 회원의 아이디를 입력해주세요.");
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
                <a href="/khlibary/admin/main"><img src="${pageContext.request.contextPath}/sources/image/kh_gray_logo.png" alt="kh_logo" width="110px"></a>
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
            <h2>회원 관리</h2>
            <div class="searchbar">
                <form action="/khlibary/admin/main" method="post" onsubmit="return checkInput()">
                    <input type="text" id="input" name="memberIdSearch" placeholder="검색할 회원의 아이디를 입력해주세요.">
                    <input type="submit" id="searchBtn" value="검색">
                </form>
            </div>
            <form action="/khlibary/admin/pagetype" method="post" class="table-controls">
                <input class="btn modify" type="submit" name="action" value="수정">
                <input class="btn add"  type="submit" name="action" value="추가">           
            </form>
            <table border="1">
                    <colgroup>
                    <col style="width: 15%;">
                    <col style="width: 15%;">
                    <col style="width: 20%;">
                    <col style="width: 25%;">
                    <col style="width: 15%;">
                    <col style="width: 10%;">
                </colgroup>
                <thead>
                    <tr>
                        <th>회원이름</th>
                        <th>아이디</th>
                        <th>비밀번호</th>
                        <th>전화번호</th>
                        <th>나이</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <c:if test="${not empty errorMsg}">
				    <script>alert("${errorMsg}");</script>
				    <%-- request scope에서 errorMsg를 제거하여 새로고침 시 alert가 뜨지 않게 함 --%>
				    <c:remove var="errorMsg" scope="request"/>
				</c:if>
                <tbody>
				    <c:if test = "${not empty member}">
				        <tr>
				            <td>${member.memberName}</td>
				            <td>${member.memberId}</td>
				            <td>${member.memberPw}</td>
				            <td>${member.memberPhone}</td>
				            <td>${member.age}</td>
				            <td>
				                <form action="/khlibary/admin/delete" method="post">
				                    <input type="hidden" name="memberId" value="${member.memberId}">
				                    <input type="submit" class="deleteBtn" value="삭제">
				                </form>		                
				            </td>
				        </tr>
				    </c:if>
				    <c:if test="${not empty mList }">
				    <c:forEach var="mList" items="${mList }">
				    <tr>
			            <td>${mList.memberName}</td>
			            <td>${mList.memberId}</td>
			            <td>${mList.memberPw}</td>
			            <td>${mList.memberPhone}</td>
			            <td>${mList.age}</td>
			            <td>
			                <form action="/khlibary/admin/delete" method="post">
			                    <input type="hidden" name="memberId" value="${mList.memberId}">
			                    <input type="submit" class="deleteBtn" value="삭제">
			                </form>		                
			            </td>
			        </tr>
				    </c:forEach>
				    </c:if>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-회원추가</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/Admin_css/member/AdminPage-member-add.css">
    <script>
    		function checkInput() {
    			let userName = document.getElementById("username").value;
    			let userAge = document.getElementById("age").value;
    			let userID = document.getElementById("userid").value;
    			let userPw = document.getElementById("password").value;
    			let userPhone = document.getElementById("phone").value;
    			
    			if(!userName) {
    				alert("이름을 입력해주세요.");
    				return false;
    			}
    			if(userAge <= 0) {
    				alert("나이를 입력해주세요.");
    				return false;
    			}
    			if(!userID) {
    				alert("아이디를 입력해주세요.");
    				return false;
    			}
    			if(!userPw) {
    				alert("비밀번호를 입력해주세요.");
    				return false;
    			}
    			if(!userPhone) {
    				alert("전화번호를 입력해주세요.");
    				return false;
    			}
    			return true;
    		}
    </script>
</head>
<body>  
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
            <div class="user-add-div">
            <h2>회원 추가</h2>
                <form action="/khlibary/admin/add" method="post" onsubmit="return checkInput()">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="username">이름</label>
                            <input type="text" id="username" name="newName" placeholder="이름을 입력해주세요.">
                            </div>
                            <div class="form-group">
                            <label for="age">나이</label>
                            <input type="number" id="age" name="newAge" min="0" value="0" placeholder="나이를 입력해주세요.">
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="gender-group">
                            <label><input type="radio" name="newGender" value="M" checked> 남자</label>
                            <label><input type="radio" name="newGender" value="F"> 여자</label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="userid">아이디</label>
                        <input type="text" id="userid" name="newId" placeholder="아이디를 입력해주세요.">
                    </div>


                    <div class="form-group">
                        <label for="password">비밀번호</label>
                        <input type="password" id="password" name="newPassword" placeholder="비밀번호를 입력해주세요.">
                    </div>


                    <div class="form-group">
                        <label for="phone">전화번호</label>
                        <input type="text" id="phone" name="newPhone" placeholder="전화번호를 입력해주세요.">
                    </div>
                    <p class="warning-text">⚠ 추가할 회원의 정보가 맞는 정보를 입력했는지 한번 더 확인해주세요.</p>
                    <input type="submit" class="submit-btn" value="추가">
                </form>
               	<c:if test="${not empty errorMsg}">
    				<script>alert("${errorMsg}");</script>
				</c:if>
            </div>
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
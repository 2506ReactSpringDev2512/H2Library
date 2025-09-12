<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-회원추가</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/User_css/User-Signup.css">
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
                <a href="/"><img src="/sources/image/kh_gray_logo.png" alt="kh_logo" width="110px"></a>
            </div>
        </div>
        <div class="main">
            <div class="user-add-div">
            <h2>회원가입</h2>
                <form action="/khlibary/member/signup" method="post" onsubmit="return checkInput()">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="username">이름</label>
                            <input type="text" id="username" name="Name" placeholder="이름을 입력해주세요.">
                            </div>
                            <div class="form-group">
                            <label for="age">나이</label>
                            <input type="number" id="age" name="Age" min="0" value="0" placeholder="나이를 입력해주세요.">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="gender-group">
                            <label><input type="radio" name="Gender" value="M" checked> 남자</label>
                            <label><input type="radio" name="Gender" value="F"> 여자</label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="userid">아이디</label>
                        <input type="text" id="userid" name="Id" placeholder="아이디를 입력해주세요.">
                    </div>


                    <div class="form-group">
                        <label for="password">비밀번호</label>
                        <input type="password" id="password" name="Password" placeholder="비밀번호를 입력해주세요.">
                    </div>


                    <div class="form-group">
                        <label for="phone">전화번호</label>
                        <input type="text" id="phone" name="Phone" placeholder="전화번호를 입력해주세요.">
                    </div>
                    <p class="warning-text">⚠ 추가할 회원의 정보가 맞는 정보를 입력했는지 한번 더 확인해주세요.</p>
                    <input type="submit" class="submit-btn" value="추가">
                </form>
            </div>
        </div>
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
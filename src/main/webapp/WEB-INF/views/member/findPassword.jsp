<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-회원추가</title>
    <link rel="stylesheet" href="/sources/User_css/비밀번호찾기.css">
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
			<c:if test="${not empty sessionScope.resultMsg}">
			    <script>alert("${sessionScope.resultMsg}\n아이디: ${sessionScope.foundPw}");</script>
			    <c:remove var="resultMsg" scope="request"/>
			</c:if>
            <c:if test="${not empty sessionScope.errorMsg}">
			    <script>alert("${sessionScope.errorMsg}");</script>
			    <c:remove var="errorMsg" scope="request"/>
			</c:if>
            <h2>비밀번호 찾기</h2>
                <form action="/khlibary/member/findpw" method="post" onsubmit="return checkInput()">
                		<div class="form-group">                
                        <label for="id">아이디</label>
                        <input type="text" id="id" name="memberId" placeholder="아이디를 입력해주세요.">
                    </div>
               		<div class="form-row">
	                    <div class="form-group">                
	                        <label for="username">이름</label>
	                        <input type="text" id="name" name="memberName" placeholder="이름을 입력해주세요.">
	                    </div>
                    
	                    <div class="form-group">
	                        <label for="age">나이</label>
	                        <input type="number" id="age" name="Age" min="0" value="0" placeholder="나이를 입력해주세요.">
	                    </div>
                 	</div>
        
                    <div class="form-group">
                        <label for="phone">전화번호</label>
                        <input type="text" id="phone" name="memberPhone" placeholder="전화번호를 입력해주세요.">
                    </div>         
                    <input type="submit" class="submit-btn" value="찾기">       
                </form>
                <button onclick="location.href='/khlibary/login'" class ="login-btn">로그인 페이지</button>
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
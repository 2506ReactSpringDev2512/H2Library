<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/sources/User_css/LoginPage.css">
</head>
<body>
    <div class="main">
        <div class="main_logo_div">
            <img src="${pageContext.request.contextPath}/sources/image/kh_txt_logo.png" alt="kh_logo" width="130px" height="40px">
        </div>
        <div class="login_div">
            <div class="login_div_left">
                <form action="/member/login" method="post">
                    <p id="userptag">아이디</p>
                    <input type="text" name="memberId" placeholder="아이디를 입력해주세요."><br><br>

                    <p id="userptag">비밀번호</p>
                    <input type="password" name="memberPw" placeholder="비밀번호를 입력해주세요."><br>

                    <input type="submit" value="로그인">
                </form>
            </div>
        </div>
        <div class="login_div_bottom">
            <a href="#">회원가입</a> 
            <a href="#">아이디 찾기</a>
            <a href="#">비밀번호 찾기</a>
        </div>
    </div>
</body>
</html>
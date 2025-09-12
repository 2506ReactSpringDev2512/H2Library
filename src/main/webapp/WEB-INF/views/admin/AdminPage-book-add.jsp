<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH도서관-도서추가</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/Admin_css/book/AdminPage-book-add-modify.css">
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
                <div class="book-add-div">
                <h2>도서 추가</h2>
                <form action="/khlibary/admin/book/add" method="post">
                    <div class="form-row">
	                    <div class="form-group">
	                            <label for="bookno">책번호</label>
	                            <input type="text" id="bookno" name="add_bookNo" placeholder="책번호를 입력해주세요.">
	                    </div>
	                        
                        <div class="form-group">
                            <label for="bookname">도서명</label>
                            <input type="text" id="bookname" name="add_bookName" placeholder="도서명을 입력해주세요.">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="bookauthor">출판사명</label>
                        <input type="text" id="bookauthor" name="add_bookAuthor" placeholder="출판사를 입력해주세요.">
                    </div>


                    <div class="form-group">
                        <label for="bookpublisher">저자</label>
                        <input type="text" id="bookpublisher" name="add_bookPublisher" placeholder="저자를 입력해주세요.">
                    </div>
                    <p class="warning-text">⚠ 추가할 도서의 정보가 맞는 정보를 입력했는지 한번 더 확인해주세요.</p>
                    <input type="submit" class="submit-btn" value="추가">
                </form>
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
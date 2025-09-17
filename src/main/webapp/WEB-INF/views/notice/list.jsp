<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>공지사항</title>
  <link rel="stylesheet" href="${ctx}/sources/css/notice.css"/>
</head>
<body>
  <!-- 상단 헤더 -->
  <div id="headWidthControl">
    <div id="header">
      <div id="logo">
        <a href="${ctx}/">
          <img src="${ctx}/sources/img/logo_kh_60px.png" alt="KH Library Logo">
        </a>
      </div>
      <div id="headerNavi">
        <a href="${ctx}/book/list">자료검색</a>
        <a href="${ctx}/notice/list">공지사항</a>
        <a href="${ctx}/member/myPage">마이페이지</a>
      </div>
    </div>
  </div>

  <!-- 메인 컨텐츠 -->
  <div id="mainWidthControl">
    <h2 class="pageTitle">📢 공지사항</h2>
    <table class="noticeTable">
      <thead>
        <tr>
          <th>No</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="notice" items="${noticeList}">
          <tr>
            <td>${notice.noticeNo}</td>
            <td>
              <a href="${ctx}/notice/detail?no=${notice.noticeNo}">
                ${notice.noticeSubject}
              </a>
            </td>
            <td>${notice.noticeWriter}</td>
            <td>${notice.noticeDate}</td>
            <td>${notice.viewCount}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <!-- 하단 푸터 -->
  <div id="footerWidthControl">
    <div id="footer">
      <p>© 2025 KH Library. All rights reserved.</p>
    </div>
  </div>
</body>
</html>
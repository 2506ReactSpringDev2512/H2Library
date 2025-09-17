<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	    <h2 class="pageTitle">공지사항 작성</h2>
    <table class="noticeTable">
      <thead>
        <tr>
          <th>공지사항 제목
          	<input type="text" name="noticeSubjec">
          </th>
        </tr>
      </thead>
      <tbody>
          <tr>
            <td>내용<textarea name="noticeContent" style="widht:500px;  height:300px;"></textarea><br></td>
            <td>첨부파일<input type="file" name="attachmentName"><br> </td>
          </tr>
      </tbody>
      <button type="submit">저장</button>
    </table>
  </div>
  
</body>
</html>
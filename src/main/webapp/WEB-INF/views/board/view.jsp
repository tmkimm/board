<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 조회</title>
</head>
<body>

<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>

<form method="post">

<label>제목</label>
${view.title}<br />

<label>작성자</label>
${view.writer}<br />

<label>내용</label><br />
${view.content}<br />

<div>
<a href="/board/modify?bno=${view.bno}">수정하기</a> <a href="/board/delete?bno=${view.bno}">삭제하기</a>
</div>
<!--  <button type="submit">작성</button>  -->
</form>
</body>
</html>


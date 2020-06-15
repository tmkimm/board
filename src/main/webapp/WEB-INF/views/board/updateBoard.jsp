<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>게시글 등록</title>
</head>
<body>
    <div id="nav">
    <%@ include file="../include/nav.jsp" %>
    </div>
    <div class="container" rold="main"> 
        <h2>수정하기</h2>
        <form method="post">
            <div class="mb-3">
                <label for="title">제목</label>
                <input type="text" class="form-control" name="title" value="${view.title}" placeholder="제목을 입력해 주세요"/><br />
            </div>

            <div class="mb-3">
                <label>작성자</label>
                <input type="text" class="form-control" name="writer" value="${view.writer}" readonly/><br />
            </div>

            <div class="mb-3">
                <label>내용</label>
                <textarea cols="50" class="form-control"  rows="5" name="content" placeholder="내용을 입력해 주세요">
                    ${view.content}
                </textarea><br />
            </div>

            <button type="submit" class="btn btn-sm btn-primary">완료</button> 
            <button type="button" class="btn btn-sm btn-primary" onclick="location.href='/board/getBoardList'">목록</button>
        </form>
    </div>
</body>
</html>


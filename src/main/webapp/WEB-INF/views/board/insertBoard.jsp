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
        <h2>글쓰기</h2>
        <form method="post" name="frm" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="title">제목</label>
                <input type="text" class="form-control" name="title" placeholder="제목을 입력해 주세요"/><br />
            </div>

            <div class="mb-3">
                <label>작성자</label>
                <input type="text" class="form-control"  name="writer" placeholder="작성자를 입력해 주세요" /><br />
            </div>

            <div class="mb-3">
                <label>내용</label>
                <textarea cols="50" class="form-control"  rows="5" name="content" placeholder="내용을 입력해 주세요"></textarea><br />
                <input type="file" name="file"/><br />
            </div>
            
            <button type="submit" class="btn btn-sm btn-primary">작성</button>
            <button type="button" class="btn btn-sm btn-primary" onclick="location.href='/board/getBoardList'">목록</button>
        </form>
    </div>
</body>
</html>


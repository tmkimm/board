<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="EUC-KR">
        <title>게시글 상세</title>
    </head>
    <body>
        <div id="nav">
        <%@ include file="../include/nav.jsp" %>
        </div>
        <article>
            <div class="container" role="main">
                <h2>게시판 상세</h2>
                <div class="bg-white rounded shadow-sm">
                    <div class="board_title"><c:out value="${view.title}"/></div>
                    <div class="board_info_box">
                        <span class="board_author"><c:out value="${view.writer}"/>,</span>
                        <span class="board_date"><c:out value="${view.regDate}"/></span>
                    </div>
                    <div class="board_content">${view.content}</div>
                    <c:forEach items="${fileUpload}" var="fileUpload">
                        <a href="/board/downloadFile?idx=${fileUpload.idx}">${fileUpload.original_file_name}</a>
                        <c:out value="${fileUpload.file_size}" />
                    </c:forEach>
                </div>

                <div style="margin-top : 20px">
                    <button type="button" class="btn btn-sm btn-primary" onclick="location.href='/board/updateBoard?bno=${view.bno}'">수정</button>
                    <button type="button" class="btn btn-sm btn-primary" onclick="location.href='/board/deleteBoard?bno=${view.bno}'">삭제</button>
                    <button type="button" class="btn btn-sm btn-primary" onclick="location.href='/board/getBoardList'">목록</button>
            </div>
        </article>
    </body>
</html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>게시판</title>
</head>
<body>
    <div id="nav">
    <%@ include file="../include/nav.jsp" %>
    </div>
	<article>
		<div class="container">
			<div class="table-responsive">
				<table class="table table-striped table=sm">
					<colgroup>
						<col style="width:5%;" />
						<col style="width:auto;" />
						<col style="width:15%;" />
						<col style="width:10%;" />
						<col style="width:10%;" />
					</colgroup>
					<thead>
						<tr>
						<th>NO</th>
						<th>글 제목</th>
						<th>작성일</th>
						<th>작성자</th>
						<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td><c:out value="${list.bno}" /></td>
								<td> <a href="/board/getBoardContent?bno=${list.bno}">${list.title}</a> </td>
								<td><c:out value="${list.regDate}" /></td>
								<td><c:out value="${list.writer}"  /></td>
								<td><c:out value="${list.viewCnt}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm" onclick="location.href='/board/insertBoard'">글쓰기</button>
			</div>
		<!-- pagination{s} -->
		<div id="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
				</c:if>
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
				</c:forEach>
				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
				</c:if>
			</ul>
		</div>
		<!-- pagination{e} -->		
		</div>
	</article>

	<script>
		//이전 버튼 이벤트
		function fn_prev(page, range, rangeSize) {
			var page = ((range - 2) * rangeSize) + 1;
			var range = range - 1;
			var url = "${pageContext.request.contextPath}/board/getBoardList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;
			location.href = url;
		}
		//페이지 번호 클릭
		function fn_pagination(page, range, rangeSize, searchType, keyword) {
			var url = "${pageContext.request.contextPath}/board/getBoardList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;
			location.href = url;	
		}

		//다음 버튼 이벤트
		function fn_next(page, range, rangeSize) {
			var page = parseInt((range * rangeSize)) + 1;
			var range = parseInt(range) + 1;
			var url = "${pageContext.request.contextPath}/board/getBoardList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;
			location.href = url;
		}
	</script>
</body>
</html>
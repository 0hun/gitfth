<%@page import="com.test.dto.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty loginUser}">
	<script type="text/javascript">
		alert('로그인이 만료되었습니다.');
		location.href = '${pageContext.request.contextPath}/login';
	</script>
</c:if>

<jsp:include page="/common/header.jsp" flush="false" />


<style>
div#contentWrap {
	width: 80%;
	min-width: 500px;
	max-width: 960px;
	margin: 0 auto;
}

table {
	width: 100%;
	border: 0;
	background: #666666;
}

table td, th {
	border: 0;
	background: #ffffff;
	text-align: center;
}

div#listBar {
	position: relative;
}

div#listBar button {
	height: 25px;
}

div#listBar>h3 {
	font-size: 1.5em;
	text-align: center;
}

div#listBar button#joinBtn {
	position: absolute;
	right: 0;
	bottom: 0;
}

div#contentWrap * {
	color: #222222;
}

div#contentWrap>table td>a {
	text-decoration: none;
	color: #0000ff;
	font-weight: bold;
}
</style>

<br />
<br />
<div id="contentWrap" style="color: #222222;">
	<div id="listBar">
		<h3>상품리스트</h3>
		<form name="searchProduct">
			<select name="index">
				<option value="pronum">상품번호</option>
				<option value="proname">상품명</option>
				<option value="maker">제조회사</option>
			</select> <input type="text" name="key">
			<button onclick="searchProduct_go()">조회</button>
		</form>
		<button id="joinBtn" onclick="insertProduct_go()">상품등록</button>
	</div>

	<hr />
	<br />
	<table border="1">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>수량</th>
			<th>제조회사</th>
		</tr>
		<c:choose>
			<c:when test="${not empty productList}">
				<c:forEach var="proList" items="${productList}">
					<tr>
						<td><a href="${pageContext.request.contextPath}/product/detailProduct?pNum=${proList.proNum}">
								${proList.proNum}</a></td>
						<td>${proList.proName}</td>
						<td>${proList.price}</td>
						<td>${proList.account}</td>
						<td>${proList.maker}</td>
					</tr>
				</c:forEach>
			</c:when>
		<c:otherwise>
			<tr>
				<td colspan="5" style="text-align: center;">해당 내용이 없습니다.</td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
<jsp:include page="/common/footer.jsp" flush="false" />
<script>
	function insertProduct_go() {
		location.href = "${pageContext.request.contextPath}/product/insertProduct";
	};
	function searchProduct_go() {
		document.searchProduct.action = "${pageContext.request.contextPath}/product/searchProduct";
		document.searchProduct.method = "get";
		document.searchProduct.submit();
	};
</script>

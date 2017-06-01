<%@page import="java.util.ArrayList"%>
<%@page import="com.test.dto.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.loginUser}">
	<script>
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
		<h3>회원리스트</h3>
		<form name="searchMember">
			<select name="index">
				<option value="id">아이디</option>
				<option value="phone">전화번호</option>
				<option value="email">이메일</option>
				<option value="address">주소</option>
			</select> <input type="text" name="key" />
			<button onclick="searchMember_go()">조회</button>
		</form>
		<button id="joinBtn" onclick="joinMember_go()">회원등록</button>
	</div>

	<hr />
	<br />
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<c:choose>
			<c:when test="${not empty memberList}">
				<c:forEach var="memList" items="${memberList}">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/member/detailMember?id=${memList.id}">
								${memList.id}</a></td>
						<td>${memList.pwd }</td>
						<td>${memList.email}</td>
						<td>${memList.phone}</td>
						<td>${memList.address}</td>
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
	function joinMember_go() {
		location.href = "${pageContext.request.contextPath}/member/joinMember";
	};
	function searchMember_go() {
		document.searchMember.action = "${pageContext.request.contextPath}/member/searchMember";
		document.searchMember.method = "get";
		document.searchMember.submit();
	};
</script>






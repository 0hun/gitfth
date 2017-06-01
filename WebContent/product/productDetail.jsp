<%@page import="com.test.dto.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page trimDirectiveWhitespaces="true"%>

<jsp:include page="/common/header.jsp" flush="false" />


<script type="text/javascript">
	alert('로그인이 만료되었습니다.');
	location.href='${pageContext.request.contextPath}/login';
</script>

<style>
div#detailWrap {
	width: 80%;
	min-width: 400px;
	max-width: 960px;
	margin: 0 auto;
	margin-bottom: 50px;
}

div#detailWrap form label, table td, th {
	color: #222222;
}

div#detailWrap form td:nth-child(1) {
	text-align: center;
	width: 20%;
	color: #ffffff;
}

div#detailWrap table td {
	padding: 10px;
}

div#detailWrap table td label {
	display: block;
	width: 100%;
	height: 30px;
	line-height: 30px;
	background: #aaaaff;
	color: #ffffff;
	padding: 5px;
}

div#detailWrap>form>table td:nth-child(2) {
	width: 60%;
}

div#detailWrap>form>table td:nth-child(2)>input {
	width: 100%;
	height: 25px;
	line-height: 25px;
	color: #222222;
	padding: 5px;
}

div#detailWrap>form>table {
	width: 65%;
	margin: 0 auto;
}

div#btn {
	text-align: center;
}

div#btn>button {
	margin: 0 5%;
}

div#btn {
	min-width: 600px;
}
</style>

<br />
<br />
<div id="detailWrap">
	<form name="detailForm">
		<table>
			<tr>
				<td><label for="num">상품번호</label></td>
				<td><input readonly type="text" name="num" id="num"
					value="${product.proNum}" /><br /></td>
			</tr>
			<tr>
				<td><label for="name">상품명</label></td>
				<td><input type="text" name="name" id="name"
					value="${prduct.proName}" /><br /></td>
			</tr>
			<tr>
				<td><label for="price">상품가격</label></td>
				<td><input type="text" name="price" id="price"
					value="${product.Price}" /><br /></td>
			</tr>
			<tr>
				<td><label for="maker">제조회사</label></td>
				<td><input type="text" name="maker" id="maker"
					value="${product.Maker}" /><br /></td>
			</tr>
			<tr>
				<td><label for="account">수량</label></td>
				<td><input type="text" name="account" id="account"
					value="${product.Account}" /><br /></td>
			</tr>


		</table>
	</form>
	<div id="btn">
		<button onclick="modifyProduct_go()">수정</button>
		<button onclick="deleteProduct_go()">삭제</button>
		<button onclick="productList_go()">돌아가기</button>
	</div>
</div>
<jsp:include page="/common/footer.jsp" flush="false" />
<script type="text/javascript">
	function modifyProduct_go(){
		document.detailForm.action="${pageContext.request.contextPath}/product/modifyProduct";
		document.detailForm.method="post";
		document.detailForm.submit();
	};
	function deleteProduct_go(){
		document.detailForm.action="${pageContext.request.contextPath}/product/deleteProduct";
		document.detailForm.method="post";
		document.detailForm.submit();
	};
	function productList_go(){
		location.href="${pageContext.request.contextPath}/product/productList";
		
	};


</script>
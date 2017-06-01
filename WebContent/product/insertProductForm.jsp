<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/header.jsp" flush="false" />

<c:if test="${!loginUser}">
	<script>
		alert("로그인이 만료되었습니다.");
		location.href="/login";
	</script>
	
</c:if>
<style>
	div#detailWrap{
		width: 80%;
		min-width: 400px;
		max-width: 960px;
		margin: 0 auto;
		margin-bottom:50px;
	}
	div#detailWrap form label,table td,th{
		color:#222222;
	}
	
	div#detailWrap form td:nth-child(1){
		text-align:center;
		width:20%;		
		color:#ffffff;
	}
	div#detailWrap table td{
		padding:10px;		
	}
	div#detailWrap table td label{
		display:block;
		width:100%;
		height:30px;
		line-height:30px;
		background:#aaaaff;
		color:#ffffff;
		padding:5px;
	}
	div#detailWrap>form>table td:nth-child(2){
		width:60%;		
	}
	div#detailWrap>form>table td:nth-child(2)>input{
		width:100%;
		height:25px;
		line-height:25px;
		color:#222222;
		padding:5px;
	}
	div#detailWrap>form>table tr:nth-child(1)>td:nth-child(2)>input{
		width:100%;
	}
	div#detailWrap>form>table{
		width:65%;
		margin:0 auto;				
	}
	div#btn{
		text-align:center;
	}
	div#btn>button{
		margin:0 5%;
	}
	div#btn{
		min-width:600px;
	}
	
	
</style>

<br />
<br />
<div id="detailWrap">
	<form name="joinForm">
		<table>
			<tr>
				<td>
					<label for="id">상품번호</label>
				</td>
				<td>		 
					<input type="text" name="id" id="id" readonly="readonly"
					value="${num}"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label for="name">상품명</label>
				</td>
				<td> 
					<input type="text" name="name" id="name" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="price">상품가격</label>
				</td>
				<td> 
					<input type="text" name="price" id="price" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="maker">제조회사</label>
				</td>
				<td> 
					<input type="text" name="maker" id="maker" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="account">수량</label>
				</td>
				<td> 
					<input type="text" name="account" id="account" /><br/>
				</td>
			</tr>
		</table>		
	</form>
	<div id="btn">
			<button onclick="joinProduct_go()">등록</button>
			<button onclick="reset_go()">초기화</button>
			<button onclick="productList_go()">상품목록</button>
	</div>
</div>
<jsp:include page="/common/footer.jsp" flush="false" />


<script>
	function joinProduct_go(){
		if(document.joinForm.name.value==""){
			alert('상풍명은 필수사항입니다.');
			return;
		}
		if(document.joinForm.price.value==""){
			alert('상품가격은 필수사항입니다.')
		}
		document.joinForm.action=
			"${pageContext.request.contextPath}/product/insertProduct";
		document.joinForm.method="post";
		document.joinForm.submit();
	};
	function reset_go(){
		document.joinForm.reset();
	};
</script>



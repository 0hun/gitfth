<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${sessionScope.loginUser}">
<script>
	alert('로그인 하세요.')
	location.href = '${pageContext.request.contextPath}/login';
</script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<style>
	body{
		background-image:url("${pageContext.request.contextPath}/images/body_bg.jpg");
		background-repeat:repeat-x;
	}
	div#headWrap{
		position:relative;
		width:80%;
		min-width:400px;
		max-width:960px;
		height:200px;
		
		margin:0 auto;	
		margin-bottom:22px;			
		overflow:hidden
	}
	div#topMenu{
		float:right;
	}
	div#listMenu{
		position:absolute;
		left:0;
		bottom:0;
	}	
	button{
		background:#aaaaff;
		width: 100px;
		height:50px;	
		font-size:0.8em;	
	}
	*{
		color:#eeeeee;
		font-size:15px;
	}
</style>
</head>
<body>

<div id="headWrap">
	<div id="topMenu">
		<span>${sessionScope.loginUser}님 환영합니다.</span>
		<button onclick="myPage_go()">내정보수정</button>
		<button onclick="logout_go()">로그아웃</button>
	</div>
	<div id="listMenu">
		<button onclick="memberList_go()">회원리스트</button>
		<button onclick="productList_go()">상품리스트</button>
	</div>	
</div>
<hr/>

<script>
	function memberList_go(){
		location.href="${pageContext.request.contextPath}/member/memberList";		
	} 
	function productList_go(){
		location.href="${pageContext.request.contextPath}/product/productList";
	}
	function myPage_go(){
		location.href="${pageContext.request.contextPath}/member/myPage";
	}
	function logout_go(){
		location.href="${pageContext.request.contextPath}/logout";
	}
</script>






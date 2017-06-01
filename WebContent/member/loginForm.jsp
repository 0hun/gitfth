<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty message}">
	<script>
		alert('${message}');	
	</script>
</c:if>
<c:if test="${not empty sessionScope.loginUser}">
		<script>
		location.href='${pageContext.request.contextPath}/login';
		</script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>

<style>
	*{
		font-size:15px;
	}
	h1{
		font-size:30px;
	}
	
	#wrap{
		width:400px;
		height:400px;				
		margin:0 auto;
		margin-top:100px;
		text-align:center;
		border:1px solid #aaaaaa;		
	}
	#wrap>form>input{
		display:block;
		height:50px;
		line-height:50px;		
		width:330px;
		margin:0 auto;			
	}
	#btnWrap>button{
		background:#aaaaff;
		width: 150px;
		height:50px;
		font-size:0.8em;
	}
</style>
</head>
<body>
	<div id="wrap">
		<h1>로그인</h1>
		<form name="loginForm">
			<input type="text" name="id" placeholder="아이디를 입력하세요" value="${id}" /><br />
			<br /> <input type="password" name="pwd" placeholder="패스워드를 입력하세요." /><br />
			<br />
		</form>
		<div id="btnWrap">
			<button onclick="login_go();">로그인</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button>아이디/패스워드 찾기</button>
		</div>
	</div>
</body>

<script>
	function login_go() {		
		document.loginForm.method = "post";
		document.loginForm.action = "${pageContext.request.contextPath}/login";
		document.loginForm.submit();
	};
</script>

</html>








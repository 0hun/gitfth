<%@page import="com.test.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/common/header.jsp" flush="false" />

<c:if test="${empty loginUser}">
	<script type="text/javascript">
		alert('로그인이 만료되었습니다.');
		location.href='${pageContext.request.contextPath}/login';
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
	<form name="detailForm">
		<table>
			<tr>
				<td>
					<label for="id">아이디</label>
				</td>
				<td>		 
					<input readonly type="text" name="id" id="id" value="${member.id}"/><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="name">이름</label>
				</td>
				<td> 
					<input type="text" name="name" id="name" value="${member.name}"/><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="pwd">패스워드</label>
				</td>
				<td> 
					<input type="text" name="pwd" id="pwd" value="${member.pwd}"/><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="phone">전화번호</label>
				</td>
				<td> 
					<input type="text" name="phone" id="phone" value="${member.phone}"/><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="email">이메일</label>
				</td>
				<td> 
					<input type="text" name="email" id="email" value="${member.email}"/><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="address">주소</label>
				</td>
				<td> 
					<input type="text" name="address" id="address" value="${member.address}"/><br/>
				</td>
			</tr>		
		</table>		
	</form>
	<div id="btn">
			<button onclick="modifyMember_go()">수정</button>
			<button onclick="deleteMember_go()">삭제</button>
			<button onclick="memberList_go()">돌아가기</button>
	</div>
</div>
<jsp:include page="/common/footer.jsp" flush="false" />

<script>
	
	function modifyMember_go(){
		document.detailForm.action="${pageContext.request.contextPath}/member/modifyMember";
		document.detailForm.method="post";
		document.detailForm.submit();
	};
	function deleteMember_go(){
		
		if("${member.id}"=="${sessionScope.loginUser}"){
			alert("로그인 사용자는 삭제할 수 없습니다.");
			return;
		}
		
		document.detailForm.action="${pageContext.request.contextPath}/member/deleteMember";
		document.detailForm.method="post";
		document.detailForm.submit();
	};
</script>







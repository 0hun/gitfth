<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/header.jsp" flush="false" />

<c:if test="${sessionScope.loginUser }">

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
	div#detailWrap>form>table tr:nth-child(1)>td:nth-child(2)>input{
		width:73%;
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
					<label for="id">아이디</label>
				</td>
				<td>		 
					<input type="text" name="id" id="id" 
					value="${chk_id}"/>
					<input type="hidden" name="chk_id" 
							value="${chk_id}"/>
					<button onclick="chkID_go();return false;">중복확인</button>
					<br/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label for="name">이름</label>
				</td>
				<td> 
					<input type="text" name="name" id="name" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="pwd">패스워드</label>
				</td>
				<td> 
					<input type="text" name="pwd" id="pwd" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="phone">전화번호</label>
				</td>
				<td> 
					<input type="text" name="phone" id="phone" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="email">이메일</label>
				</td>
				<td> 
					<input type="text" name="email" id="email" /><br/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="address">주소</label>
				</td>
				<td> 
					<input type="text" name="address" id="address" /><br/>
				</td>
			</tr>		
		</table>		
	</form>
	<div id="btn">
			<button onclick="joinMember_go()">등록</button>
			<button onclick="reset_go()">초기화</button>
			<button onclick="memberList_go()">회원목록</button>
	</div>
</div>
<jsp:include page="/common/footer.jsp" flush="false" />


<script>
	function chkID_go(){		
		var chkId=document.joinForm.id.value;
		location.href=
			"${pageContext.request.contextPath}/member/checkID?chkId="+chkId;		
	}
	function joinMember_go(){
		if(document.joinForm.id.value=="" ){
			alert('아이디는 필수항목입니다.');
			return;
		}
		if(document.joinForm.pwd.value=="" ){
			alert('패스워드는 필수항목입니다.');
			return;
		}
			
		if(document.joinForm.id.value!=document.joinForm.chk_id.value){
			alert("중복체크를 하시기 바랍니다.");
			return;
		};
		document.joinForm.action=
			"${pageContext.request.contextPath}/member/joinMember";
		document.joinForm.method="post";
		document.joinForm.submit();
	}
	function reset_go(){
		document.joinForm.reset();
	}
</script>





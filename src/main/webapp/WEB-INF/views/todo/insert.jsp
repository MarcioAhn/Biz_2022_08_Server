<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<form:form method="POST">
		<input name="t_content" placeholder="할일을 입력하세요">

		<button>할일기록</button>
	</form:form>
	<table class="todo">
		<thead>
			<tr>
				<th>SEQ</th>
				<th>입력일자</th>
				<th>입력시간</th>
				<th>입력내용</th>
				<th>완료일자</th>
				<th>완료시각</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${TODO}" var="TODO">
				<tr>
					<td>${TODO.t_seq}</td>
					<td>${TODO.t_sdate }</td>
					<td>${TODO.t_stime}</td>
					<td>${TODO.t_content}<a href="${rootPath}/todo/${TODO.t_seq}/update">수정</a></td>
					<td>${TODO.t_edate}</td>
					<td>${TODO.t_etime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
	</div>


</body>
</html>
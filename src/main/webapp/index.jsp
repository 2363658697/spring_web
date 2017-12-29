<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="myController" method="get">
		<input type="text" name="content" value="${param.content}"> <input
			type="submit" value="搜索">
	</form>
	<table border="1">
		<tr>
			<th width="10%">新闻编号</th>
			<th width="30%">新闻标题</th>
			<th>新闻内容</th>
		</tr>
		<c:forEach var="news" items="${requestScope.list }">
			<tr>
					<td>${pageScope.news.id }</td>
					<td>${pageScope.news.title }</td>
					<td>${pageScope.news.content }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
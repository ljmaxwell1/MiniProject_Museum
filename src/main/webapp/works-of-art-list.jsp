<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Works</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allWorksOfArt}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>Title: ${currentitem.title}</td>
					<td>Medium: ${currentitem.medium}</td>
					<td>Date Published: ${currentitem.datePublished}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem">
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Item</title>
</head>
<body>
	<form action = "editWorkOfArtServlet" method="post">
		Title: <input type ="text" name = "title" value= "${itemToEdit.title}"><br><br>
		Medium: <input type = "text" name = "medium" value= "${itemToEdit.medium}"><br><br>
		Date published: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}">
		<input type ="text" name = "day" placeholder="dd" size="4" value= "${day}">
		<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}"><br><br>
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>
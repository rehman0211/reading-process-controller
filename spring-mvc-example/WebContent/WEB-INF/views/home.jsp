<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h3>Status :  ${message}</h3>

	<form action="upload" method="post" enctype="multipart/form-data">
          <label for="file">Select a file to read:</label>
          <input type="file" id="file" name="file" accept=".csv"><br><br>
          <input type="submit" value="Upload!">
	</form>
</body>
</html>
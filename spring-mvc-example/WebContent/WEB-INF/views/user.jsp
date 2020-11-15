<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Control Panel</title>
</head>
<body>
    <form action="resume" method="post">
          <input type="submit" value="Resume">
    </form>
    <form action="terminate" method="post">
          <input type="submit" value="Terminate">
    </form>
    <form action="pause" method="post">
          <input type="submit" value="Pause">
    </form>

<br><br>
<h3>Status :  ${message}</h3>
</body>
</html>
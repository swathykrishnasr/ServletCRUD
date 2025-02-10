<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>
<jsp:useBean id="u" class=""></jsp:useBean>
<jsp:setProperty property="id" value="1" name="u"/>
<jsp:setProperty property="name" value="midhun" name="u"/>
<jsp:setProperty property="age" value="23" name="u"/>
<jsp:getProperty property="id" name="u"/>
<jsp:getProperty property="name" name="u"/>
<jsp:getProperty property="age" name="u"/>
<%out.print(u); %>
</body>
</html>
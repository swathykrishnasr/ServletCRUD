<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="u" class="pack.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%out.print(u); %>
</body>
</html>
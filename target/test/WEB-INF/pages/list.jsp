<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>article list</title>
</head>
<body>
	<c:forEach items="${articles}" var="item">  
        ${item.id }--${item.title }--${item.content }<br />
	</c:forEach>
</body>
</html>
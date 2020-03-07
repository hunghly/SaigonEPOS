<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/register.css">
</head>
<body>
    <h1>Register with us!</h1>
    <%
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
    %>
    out.println(contextPath);
<h1><c:out value="${pageContext.request.contextPath}/webapp"/></h1>

    <script src="/resources/js/app.js"></script>
</body>
</html>

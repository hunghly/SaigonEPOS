<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Saigon Epos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
</head>
<body>

<section class="heading">
    <h1>Welcome to Saigon's Electronic Point of Sale System</h1>
</section>

<section class="login">
    <c:if test="${sessionScope.invalid}">
        <h3 style="color: red">Account credentials are invalid.</h3>
    </c:if>
    <h3>Please log in to continue</h3>
    <form action="/index" method="POST" class="login-form">
        <div class="input-container">
            <label for="username">Enter your username: </label>
            <input type="text" name="username" id="username" required>
        </div>
        <div class="input-container">
            <label for="password">Enter your password: </label>
            <input type="password" name="password" id="password" required>
        </div>
        <div class="input-container">
            <button type="submit" class="login-btn">Login</button>
        </div>
        <div class="options">
            <a href="/forgot-password">Forgot password</a>
            <br>
            <a href="/register">Create a new account</a>
        </div>
    </form>
</section>

</body>
</html>
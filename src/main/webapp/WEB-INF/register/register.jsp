<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register.css">
</head>
<body>
<section class="heading">
    <h1>Registration Form</h1>
</section>
<section class="register">
    <c:if test="${sessionScope.regDuplicate}">
        <h3 style="color: red">You entered a username or email that is already taken.</h3>
    </c:if>
    <h3>Please provide your details to register for an account:</h3>
    <form action="/register" method="POST" class="register-form">
        <div class="input-container">
            <label for="username">Username: </label>
            <input type="text" name="username" id="username" required>
        </div>
        <div class="input-container">
            <label for="email">Email: </label>
            <input type="email" name="email" id="email" required>
        </div>
        <div class="input-container">
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required>
        </div>
        <div class="input-container">
            <label for="password-confirm">Confirm Password: </label>
            <input type="password" name="password-confirm" id="password-confirm" required>
            <span class="match-flag invisible">*Passwords must match</span>
        </div>
        <div class="input-container">
            <button type="submit" class="register-btn" disabled>Register</button>
        </div>
    </form>

    <div class="input-container">
        <button type="submit" class="back-btn"><a href="/index">Back</a></button>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/register.js"></script>
</section>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Food</title>
</head>
<body>

<section class="heading">
    <h1>Create Food</h1>
</section>

<section class="create-food">
    <jsp:include page="../partials/errorMsg.jsp"/>
    <h3>Enter data below for new food</h3>
    <form action="/food/create" method="POST" class="create-food-form">
        <div class="input-container">
            <label for="name">Food name: </label>
            <input type="text" name="name" id="name" required>
        </div>
        <div class="input-container">
            <label for="price">Price: </label>
            <input type="number" name="price" id="price" required>
        </div>
        <div class="input-container">
            <button type="submit" class="create-food-btn">Create</button>
        </div>
    </form>

    <form method="post" action="multiPartServlet" enctype="multipart/form-data">
        Choose a file: <input type="file" name="multiPartServlet" />
        <input type="submit" value="Upload" />
    </form>
</section>

</body>
</html>

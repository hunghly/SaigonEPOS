<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.invalid}">
    <h3 style="color: red">Account credentials are invalid.</h3>
    <% request.getSession().removeAttribute("invalid");%>
</c:if>

<c:if test="${sessionScope.regDuplicate}">
    <h3 style="color: red">You entered a username or email that is already taken.</h3>
    <% request.getSession().removeAttribute("regDuplicate"); %>
</c:if>

<c:if test="${sessionScope.foodCreated}">
    <h3 style="color: red">Food successfully created.</h3>
    <% request.getSession().removeAttribute("foodCreated"); %>
</c:if>

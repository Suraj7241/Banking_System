<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="/bank/register" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required />
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <div>
            <button type="submit">Register</button>
        </div>
        <c:if test="${not empty error}">
            <div style="color: red;">${error}</div>
        </c:if>
    </form>
    <a href="/bank/login">Login</a>
</body>
</html>

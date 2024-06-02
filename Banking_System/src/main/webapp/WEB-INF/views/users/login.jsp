<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/bank/login" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required />
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
        <c:if test="${not empty error}">
            <div style="color: red;">${error}</div>
        </c:if>
    </form>
    <a href="/bank/register">Register</a>
</body>
</html>

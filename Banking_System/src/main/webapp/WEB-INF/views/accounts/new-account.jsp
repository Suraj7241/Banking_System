<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Account</title>
</head>
<body>
    <h2>Create New Account</h2>
    <form action="${pageContext.request.contextPath}/bank/accounts" method="post">
        <div>
            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" required />
        </div>
        <div>
            <label for="balance">Balance:</label>
            <input type="number" id="balance" name="balance" required />
        </div>
        <div>
            <button type="submit">Create Account</button>
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/bank/accounts">Back to Accounts</a>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
    <h2>Accounts</h2>
    <table>
        <thead>
            <tr>
                <th>Account Number</th>
                <th>Balance</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.accountNumber}</td>
                    <td>${account.balance}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/bank/accounts/${account.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/bank/accounts/new">New Account</a>
</body>
</html>

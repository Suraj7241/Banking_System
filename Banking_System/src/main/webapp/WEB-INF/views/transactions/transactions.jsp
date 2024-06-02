<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
    <h2>Transactions for Account: ${account.accountNumber}</h2>
    <table>
        <thead>
            <tr>
                <th>Transaction Date</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.transactionDate}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/bank/transactions/${transaction.id}/delete?accountId=${account.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/bank/transactions/new?accountId=${account.id}">New Transaction</a>
    <a href="${pageContext.request.contextPath}/bank/accounts">Back to Accounts</a>
</body>
</html>

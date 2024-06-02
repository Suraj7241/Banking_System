<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Transaction</title>
</head>
<body>
    <h2>Create New Transaction for Account: ${account.accountNumber}</h2>
    <form action="${pageContext.request.contextPath}/bank/transactions/credit" method="post">
        <input type="hidden" name="accountId" value="${account.id}" />
        <div>
            <label for="amount">Credit Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" required />
        </div>
        <div>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required />
        </div>
        <div>
            <button type="submit">Credit</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/bank/transactions/debit" method="post">
        <input type="hidden" name="accountId" value="${account.id}" />
        <div>
            <label for="amount">Debit Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" required />
        </div>
        <div>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required />
        </div>
        <div>
            <button type="submit">Debit</button>
        </div>
    </form>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/bank/transactions?accountId=${account.id}">Back to Transactions</a>
</body>
</html>

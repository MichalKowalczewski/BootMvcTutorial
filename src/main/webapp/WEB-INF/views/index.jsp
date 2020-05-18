<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
         </tr>
    </c:forEach>
</table>

<form action = "post">
    <input type = "submit" value = "Submit"/>
</form>
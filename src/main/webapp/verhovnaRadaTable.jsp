<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spisok verhovnoyi radi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Login</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${deputies}" var="deputyList" varStatus="loop">
                <tr>
                    <th scope="row"><c:out value="${deputyList.getId()}"/></th>
                    <td>
                        <c:out value="${deputyList.getLogin()}" />
                    </td>
                    <td>
                        <c:out value="${deputyList.getFirstName()}" />
                    </td>
                    <td>
                        <c:out value="${deputyList.getLastName()}" />
                    </td>
                    <td>
                        <c:out value="${deputyList.getAge()}" />
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form method="post" action="back" class="col">
        <input class="form-control mt-2" type="submit" value="Back">
    </form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cabinet ${deputy.getLastName()}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
    <div class="mid">
        <h2>Hello, ${deputy.getFirstName()} ${deputy.getLastName()}</h2>
        <div class="d-flex m-auto">
            <form method="post" action="checkTable" class="me-5">
                <input class="btn btn-outline-dark mt-2 shadow" type="submit" value="Check konkurentov">
            </form>
            <form method="post" action="logout" class="me-5">
                <input class="btn btn-outline-dark mt-2 shadow" type="submit" value="LogOut">
            </form>
        </div>
    </div>
</body>
</html>

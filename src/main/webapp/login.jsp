<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>VerhovnaRada</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="text-center">
    <div class="mid">
        <c:if test = "${isErrorLogin == true}">
            <p class="wrongLP">Wrong login or password<p>
        </c:if>
        <div class="form-control shadow">
            <p class="font-monospace fs-2">ProfitSoft | Sign In</p>
            <form method="post" action="login" class="col">
                <input class="form-control mt-2" type="text" placeholder="login" name="login">
                <input class="form-control mt-2" type="password" placeholder="password" name="password">
                <input class="btn btn-outline-dark mt-2" type="submit" value="SignIn">
            </form>
        </div>
    </div>
</body>
</html>
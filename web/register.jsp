<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>欢迎注册</title>
    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="static/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" method="post" action="${ctx}/register">
    <img class="mb-4" src="${ctx}/static/img/contacts-logo.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">注册账号</h1>
    <label>登录名</label>
    <input type="text" name="loginName" class="form-control" placeholder="登录名" required autofocus>
    <label>姓名</label>
    <input type="text" name="name" class="form-control" placeholder="姓名" required autofocus>
    <label>密码</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
    <button class="btn btn-lg btn-success btn-block" type="submit">注册</button>
    <p>
        已有账号？<a href="login.jsp">去登陆</a>
    </p>
    <c:if test="${!empty message}">
        <p class="text-danger">
            ${message}
        </p>
    </c:if>
    <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
</body>
</html>

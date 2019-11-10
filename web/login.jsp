<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>欢迎登陆</title>


    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="static/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" method="post" action="${ctx}/login">
    <img class="mb-4" src="${ctx}/static/img/contacts-logo.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
    <label class="sr-only">登录名</label>
    <input name="loginName" type="text" class="form-control" placeholder="登录名" required autofocus>
    <label for="inputPassword" class="sr-only">密码</label>
    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">点击登陆</button>
    <c:if test="${!empty message}">
        <p class="text-danger">
                ${message}
        </p>
    </c:if>
    <p>
        还没有账号？<a href="register.jsp">去注册</a>
    </p>
    <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
</body>
</html>

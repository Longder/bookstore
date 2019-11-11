<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>图书列表</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand my-0 mr-md-auto font-weight-normal" href="#">
        <img src="${ctx}/static/img/contacts-logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        图书列表
    </a>
    <c:if test="${!empty user}">
        <a class="p-2 text-dark">欢迎登陆！${user.name}</a>
    </c:if>
    <div class="my-2 my-md-0 mr-md-3">
        <c:if test="${!empty user}">
            <a class="p-2 text-dark" href="${ctx}/showCart">我的购物车</a>
            <a class="p-2 text-dark" href="${ctx}/listBook">后台管理</a>
        </c:if>
    </div>
    <c:choose>
        <c:when test="${!empty user}">
            <a class="btn btn-outline-primary" href="${ctx}/logout">登出</a>
        </c:when>
        <c:otherwise>
            <a class="btn btn-primary" href="${ctx}/login.jsp">点击登录</a>
        </c:otherwise>
    </c:choose>

</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">欢迎选购图书</h1>
        <p class="lead text-muted">这是一个神奇的书店</p>
    </div>
</section>
<div class="container">
    <form class="form-inline" method="post" action="${ctx}/index">
        <div class="form-group mx-sm-3 mb-2">
            <label>书名搜索：</label>
            <input type="text" class="form-control" name="bookName" placeholder="请输入书名">
        </div>
        <button type="submit" class="btn btn-primary mb-2">搜索</button>
        <a href="${ctx}/index" class="btn mb-2">重置</a>
    </form>
    <div class="row">
        <c:forEach items="${bookList}" var="book">
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <img class="bd-placeholder-img card-img-top" src="${book.image}" width="100%" height="225"/>
                    <div class="card-body">
                        <p class="card-text"><strong>${book.name}</strong></p>
                        <p class="card-text">价格：￥${book.price}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <a href="${ctx}/toBuy?id=${book.id}" class="btn btn-sm btn-warning">购买</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--    <table class="table table-bordered">--%>
    <%--        <thead>--%>
    <%--        <tr>--%>
    <%--            <th scope="col">书本名称</th>--%>
    <%--            <th scope="col">书本价格</th>--%>
    <%--            <th scope="col">操作</th>--%>
    <%--        </tr>--%>
    <%--        </thead>--%>
    <%--        <tbody>--%>
    <%--        <c:forEach items="${bookList}" var="book">--%>
    <%--            <tr>--%>
    <%--                <td>${book.name}</td>--%>
    <%--                <td>￥${book.price}</td>--%>
    <%--                <td>--%>
    <%--                    <a href="${ctx}/toBuy?id=${book.id}" class="btn btn-warning btn-sm">购买</a>--%>
    <%--                </td>--%>
    <%--            </tr>--%>
    <%--        </c:forEach>--%>
    <%--        </tbody>--%>
    <%--    </table>--%>
</div>
</body>
</html>

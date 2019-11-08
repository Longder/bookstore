<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>购买商品</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="${ctx}/static/img/contacts-logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        确定购买商品
    </a>
</nav>
<div class="container">
    <h2 style="margin-top: 100px;">您要购买的是：${book.name}</h2>
    <h4>书本价格：${book.price}</h4>
    <form class="form-inline" action="${ctx}/add" method="post">
        <div class="form-group mb-2">
            <label>数量：</label>
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <input type="hidden" name="bookId" value="${book.id}" />
            <input type="number" class="form-control" value="1" name="count"/>
        </div>
        <button type="submit" class="btn btn-primary mb-2">确定购买</button>
    </form>
</div>
</body>
</html>

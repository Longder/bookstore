<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>购物车</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="${ctx}/static/img/contacts-logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        购物车
    </a>
</nav>
<div class="container">
    <h2 style="margin-top: 100px;">我的购物车</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">书本名称</th>
            <th scope="col">书本单价</th>
            <th scope="col">数量</th>
            <th scope="col">价格</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${detailList}" var="detail">
            <tr>
                <td>${detail.bookName}</td>
                <td>${detail.bookPrice}</td>
                <td>${detail.count}</td>
                <td>${detail.price}</td>
                <td>
                    <a href="${ctx}/remove?id=${detail.id}" class="btn btn-danger btn-sm">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h5>总价：${total}</h5>
    <h4><a href="${ctx}/index">继续购物</a></h4>
</div>

</body>
</html>

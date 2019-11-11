<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>修改图书</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand my-0 mr-md-auto font-weight-normal" href="#">
        <img src="${ctx}/static/img/contacts-logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        修改图书
    </a>
    <a class="p-2 text-dark">欢迎登陆！${user.name}</a>
    <a class="btn btn-outline-primary" href="${ctx}/logout">登出</a>
</nav>
<div class="container">
    <h2 style="margin-top: 100px;">修改图书</h2>
    <form method="post" action="${ctx}/updateBook" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${book.id}"/>
        <div class="form-group">
            <label>图书名称</label>
            <input name="name" type="text" class="form-control" placeholder="图书名称" value="${book.name}" required>
        </div>
        <div class="form-group">
            <label>价格（￥）</label>
            <input name="price" type="number" class="form-control" placeholder="价格" value="${book.price}" required>
        </div>
        <div class="form-group">
            <label>图片：</label>
            <br/>
            <img src="${book.image}"/>
        </div>
        <div class="form-group">
            <label>上传图片</label>
            <input name="image" type="file" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">保存</button>
        <a href="${ctx}/listBook" class="btn btn-outline-dark">返回</a>
    </form>
</div>
</body>
</html>

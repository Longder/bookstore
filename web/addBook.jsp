<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>新增图书</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand my-0 mr-md-auto font-weight-normal" href="#">
        <img src="${ctx}/static/img/contacts-logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        后台管理
    </a>
    <a class="p-2 text-dark">欢迎登陆！${user.name}</a>
    <a class="p-2 text-dark" href="${ctx}/index">返回首页</a>
    <a class="btn btn-outline-primary" href="${ctx}/logout">登出</a>
</nav>
<div class="container-fluid">

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar" style="height: 1000px">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${ctx}/listBook">
                            图书管理
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            用户管理
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <h2>新增图书</h2>
            <form method="post" action="${ctx}/addBook" enctype="multipart/form-data">
                <div class="form-group">
                    <label>图书名称</label>
                    <input name="name" type="text" class="form-control" placeholder="图书名称" required>
                </div>
                <div class="form-group">
                    <label>价格（￥）</label>
                    <input name="price" type="number" class="form-control" placeholder="价格" required/>
                </div>
                <div class="form-group">
                    <label>上传图片</label>
                    <input name="image" type="file" class="form-control" required/>
                </div>
                <button type="submit" class="btn btn-primary">保存</button>
                <a href="${ctx}/listBook" class="btn btn-outline-dark">返回</a>
            </form>
        </main>
    </div>
</div>
</body>
</html>

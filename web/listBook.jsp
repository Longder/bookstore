<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>图书管理</title>

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
            <h2>图书列表</h2>
            <h4><a href="${ctx}/addBook.jsp">新增图书</a></h4>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">书本名称</th>
                    <th scope="col">书本价格</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.name}</td>
                        <td>￥${book.price}</td>
                        <td>
                            <a class="btn btn-success btn-sm" href="${ctx}/toUpdateBook?id=${book.id}">编辑</a>
                            <a class="btn btn-danger btn-sm" href="${ctx}/deleteBook?id=${book.id}"
                               onclick="return confirm('确定删除图书：${book.name}吗？')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</div>
</body>
</html>

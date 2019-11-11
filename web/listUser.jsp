<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>用户管理</title>

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
                        <a class="nav-link" href="${ctx}/listUser">
                            用户管理
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <h2>用户列表</h2>
            <h4><a href="${ctx}/addUser.jsp">新增用户</a></h4>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">登录名</th>
                    <th scope="col">姓名</th>
                    <th scope="col">用户类型</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.loginName}</td>
                        <td>${user.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${user.type=='admin'}">
                                    <span class="badge badge-primary">管理员</span>
                                </c:when>
                                <c:when test="${user.type=='user'}">
                                    <span class="badge badge-success">普通用户</span>
                                </c:when>
                            </c:choose>
                        </td>
                        <td>
                            <a class="btn btn-success btn-sm" href="${ctx}/toUpdateUser?id=${user.id}">编辑</a>
                            <c:if test="${user.type=='user'}">
                                <a class="btn btn-danger btn-sm" href="${ctx}/deleteUser?id=${user.id}"
                                   onclick="return confirm('确定删除用户：${user.name}吗？')">删除</a>
                            </c:if>
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

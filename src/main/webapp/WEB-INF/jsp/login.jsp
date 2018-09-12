<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>

<html>

<head>
    <meta charset="UTF-8" />

    <title>Login page</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-default navbar-inverse" role="navigation">
                <div class="collapse navbar-collapse nav navbar-nav" id="bs-example-navbar-collapse-1">
                    <li >
                        <a class="text-center" href="#">PhotoStudio</a>
                    </li>
                </div>
            </nav>
            <h3 class="text-center">
                Авторизация
            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <p>
                <a class="btn" href="#"></a>
            </p>
        </div>
        <div class="col-md-4">
            <form action="/login" method="post" class="form-horizontal" role="form">
                <div class="form-group">

                    <label class="col-sm-2 control-label">
                        Логин
                    </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" id="username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">
                        Пароль
                    </label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">

                        <!-- <div>
                            <label for="remember_me">
                                <input id="remember_me" type="checkbox" name="_spring_security_remember_me"> Запомнить меня
                            </label>
                        </div> -->

                        <button type="submit" name="submit" action="<%=request.getContextPath()%>/j_spring_security_check" class="btn btn-default btn-success">
                            Вход
                        </button>
                        <a href="/registration">Регистрация</a>
                    </div>
                </div>

            </form>

            <p>
                <a class="btn" href="#"></a>
            </p>

        </div>

        <div class="col-md-4">
            <p>
                <a class="btn" href="#"></a>
            </p>
        </div>

    </div>

</div>

<%--<script src="/resources/js/jquery.min.js"></script>--%>
<script src="/resources/js/bootstrap.min.js"></script>
<%--<script src="/resources/js/scripts.js"></script>--%>

<footer class="navbar-static-bottom navbar-inverse">
    <p class="text-center">&copy; PhotoStudio    телефон:8(908)-138-32-76</p>
</footer>
</body>
</html>
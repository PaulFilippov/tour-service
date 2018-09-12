<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />

    <title>Tours List</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-inverse" role="navigation">
                <div class="navbar-header">
                    </button> <a class="navbar-brand active" href="/mainLogin">TourService</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li >
                            <a href="/allService">Туры</a>
                        </li>
                        <li>
                            <a href="/allProduct">Заказы</a>
                        </li>
                        <li>
                            <a href="/allMaterial">Профиль</a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="/profile"> <c:out value="${pageContext.request.remoteUser}"/> </a>
                        </li>

                        <li>
                            <a href="<c:url value="/logout" />" type="button" class="btn btn-danger btn-xs">Выйти</a>
                            <%--<a href="${pageContext.request.logout()}" type="button" class="btn btn-danger btn-xs">Выйти</a>--%>
                        </li>>
                    </ul>

                </div>
            </nav>

            <div class="row">
                <h3 class="col-md-12 text-center">
                    Товары
                </h3>
            </div>

            <div class="row">
                <div class="col-md-2 btn-group-vertical-left">
                    <a href="/addProduct" type="button" class="btn btn-success">Добавить</a>
                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Location</th>
                    <th>Start_date</th>
                    <th>End_date</th>
                    <th>Count_limit</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allTours}" var="allTours">
                    <tr>
                        <td>${allTours.name}</td>
                        <td>${allTours.description}</td>
                        <td>${allTours.location}</td>
                        <td>${allTours.start_date}</td>
                        <td>${allTours.end_date}</td>
                        <td>${allTours.count_limit}</td>
                        <td>
                            <a href="/changeProduct/${products.id_product}" type="button" class="btn btn-primary btn-xs">Изменить</a>
                            <a href="/deleteProduct/${products.id_product}" type="button" class="btn btn-danger btn-xs">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="text-center">
                <ul class="pagination">
                    <li class="disabled"><span>«</span></li>
                    <li class="active"><span>1</span></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<footer class="navbar-static-bottom navbar-inverse">
    <p class="text-center">&copy; Tour Service    телефон:8(908)-777-77-77</p>
</footer>

</body>

</html>
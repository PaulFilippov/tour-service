<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />

    <title>Tours</title>

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
                            <a href="/tours">Туры</a>
                        </li>
                        <li>
                            <a href="/orders">Заказы</a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="/profile"> <c:out value="${pageContext.request.remoteUser}"/> </a>
                        </li>

                        <li>
                            <a href="<c:url value="/logout" />" type="button" class="btn btn-danger btn-xs">Выйти</a>
                        </li>
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
                    <th>Название</th>
                    <th>Описание</th>
                    <th>Место</th>
                    <th>Дата начала</th>
                    <th>Дата окончания</th>
                    <th>Количество мест</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allTours}" var="allTours">
                    <tr>
                        <td>${allTours.id_tour}</td>
                        <td>${allTours.name}</td>
                        <td>${allTours.description}</td>
                        <td>${allTours.location}</td>
                        <td><fmt:formatDate value="${allTours.start_date}" pattern="dd.MM.yyyy"/></td>
                        <td><fmt:formatDate value="${allTours.end_date}" pattern="dd.MM.yyyy"/></td>
                        <td>${allTours.count_limit}</td>
                        <td>
                            <a href="/orderTourByUser/${allTours.id_tour}" type="button" class="btn btn-primary btn-xs">Забронировать</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

<footer class="navbar-static-bottom navbar-inverse">
    <p class="text-center">&copy; Tour Service    телефон:8(908)-777-77-77</p>
</footer>

</body>

</html>
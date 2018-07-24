<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.devsav.model.pojo.People" %>

<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="container">
    <h2>Пользователи</h2>
    <table class="table table-hover">
        <tr>
            <td><b>#</b></td>
            <td><b>Имя</b></td>
            <td><b>Фамилия</b></td>
            <td><b>Емайл</b></td>
            <td><b>Логин</b></td>
            <td><b>Пароль</b></td>
            <td><b>Блокировка</b></td>
            <td><b>Действие</b></td>
        </tr>

        <c:forEach items="${listOfPeoples}" var="people">
            <tr class="${people.is_blocked == true ? "danger" : ""}">
                <td><c:out value="${people.id}"></c:out></td>
                <td><c:out value="${people.firstname}"></c:out></td>
                <td><c:out value="${people.lastname}"></c:out></td>
                <td><c:out value="${people.email}"></c:out></td>
                <td><c:out value="${people.login}"></c:out></td>
                <td><c:out value="${people.password}"></c:out></td>
                <td>
                    <c:choose>
                        <c:when test="${people.is_blocked}">
                            <label>заблокирован</label>
                        </c:when>
                        <c:otherwise>
                            <label>открыт</label>
                        </c:otherwise>
                    </c:choose>
                <td>
                    <a href="/admin/edit?id=${people.id}">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">На главную</a>
</div>



</body>
</html>

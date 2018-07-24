<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.devsav.model.pojo.Task" %>
<html>
<head>
    <title>Calendar</title>
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
    <h2>Список задач</h2>
    <div class="container">
        <ul class="nav nav-tabs">
            <li class=""><a href="/calendar/all">Все</a></li>
            <li class=""><a href="/calendar/home">Домашние</a></li>
            <li class=""><a href="/calendar/family">Семейные</a></li>
            <li class="active"><a href="/calendar/work">Рабочие</a></li>
            <li class=""><a href="/calendar/other">Остальные</a></li>
        </ul>
        <br>
    </div>
    <table class="table table-hover">
        <tr>
            <td><b>#</b></td>
            <td><b>Задача</b></td>
            <td><b>Дата</b></td>
            <td><b>Исполнено</b></td>
            <td><b>Действие</b></td>
        </tr>

        <c:forEach items="${listOfTask}" var="task">
            <tr class="${task.is_complete == true ? "success" : ""}">
                <td><c:out value="${task.id}"></c:out></td>
                <td><c:out value="${task.event}"></c:out></td>
                <td><c:out value="${task.date}"></c:out></td>
                <td>
                    <c:if test="${task.is_complete}">
                        Исполнено
                    </c:if>
                </td>
                <td>
                    <c:if test="${!task.is_complete}">
                        <form action="/calendar/complete" method="post">
                            <div class="form-group">
                                <input type="hidden" name="id" value="${task.id}">
                                <input type="hidden" name="url" value="/calendar/work">
                                <input type="submit" class="btn btn-default" value="Исполнить" >
                            </div>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">На главную</a>
</div>

</body>
</html>


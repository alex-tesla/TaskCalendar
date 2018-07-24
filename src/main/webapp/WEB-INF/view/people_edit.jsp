<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="com.devsavelpojo.People" %>--%>
<html>
<head>
    <title>Registration</title>
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
    <div class="col-md-4 text-right">
        <h1>Изменение:</h1></br>
        <form:form action="/admin/edit"  method="post" modelAttribute="people">
            <div class="form-group">
                <form:input type="hidden" name="id" path="id" value="${people.id}"  />
            </div>
            <div class="form-group">
                <label for="firstname">Firstname:</label>
                <form:input type="text" name="firstname" path="firstname" value="${people.firstname}" />
            </div>
            <div class="form-group">
                <label for="lastname">Lastname:</label>
                <form:input type="text" name="lastname" path="lastname" value="${people.lastname}" />
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <form:input type="email" name="email" path="email" value="${people.email}" />
            </div>
            <div class="form-group">
                <label for="login">Login:</label>
                <form:input type="text" name="login" path="login" value="${people.login}" />
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <form:input type="password" name="password" path="password" value="${people.email}" />
            </div>
            <div class="form-group">
                <label for="is_blocked">Залочить</label>
                <form:checkbox path="is_blocked" name="is_blocked" />
            </div>
            <input type="submit" class="btn btn-primary" value="Сохранить" formmethod="post">
        </form:form>
    </div>
</div>
</body>
</html>
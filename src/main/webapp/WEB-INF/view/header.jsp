<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!("anonymousUser").equals(auth.getName())) {
        String login = auth.getName();
        request.setAttribute("login", login);
    }
%>

<div class="header" >
    <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand active" href="/">Календарь задач</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="/">Главная</a></li>
                    <li><a href="/calendar/all">Задачи</a></li>
                    <li><a href="/admin/panel">Админка</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href=${login == null ? '/registration' : '/profile'}>
                        <span class="glyphicon glyphicon-user"></span> ${login == null ? "Регистрация" : login}</a></li>
                    <li><a href=${login == null ? "/login" : "/logout"}>
                        <span class="glyphicon glyphicon-log-in"></span> ${login == null ? "Войти" : "Выйти"}</a></li>
                </ul>
            </div>
    </nav>
</div>

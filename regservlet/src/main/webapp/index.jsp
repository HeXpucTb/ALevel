<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 20.04.18
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap-4.1.0/dist/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="css/DemoCss.css">
</head>
<body>
<header>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" href="index.jsp">Main</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/sign_page.jsp">Sign In</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/userpage">User Page</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
        </li>
    </ul>
</header>
<div class="container">
    <div class="row">
        <div class="col">
            <img id="ctImg" src="img/pent.jpg">
            <h1 onclick="func('text1')">Текст №1</h1>
            <p id = "text1">
                Перед вами учебный сайт для демонстрации возможностей HTML и CSS по
                созданию своего ресурса и его публикации в Интернете. Поскольку
                любой сайт должен содержать полезную или интересную информацию,
                мы выбрали тему ловли льва в пустыне, которая будет, без всяких
                сомнений, полезна любому посетителю. Так, на всякий случай.
                Перед вами учебный сайт для демонстрации возможностей HTML и CSS по
                созданию своего ресурса и его публикации в Интернете. Поскольку
                любой сайт должен содержать полезную или интересную информацию,
                мы выбрали тему ловли льва в пустыне, которая будет, без всяких
                сомнений, полезна любому посетителю. Так, на всякий случай.
            </p>
        </div>
        <div class="col">
            <h1 onclick="func('text2')">Текст №2</h1>
            <p id = "text2">
                Для упрощения расчетов некоторые реальные величины заменяются их
                приближенным аналогом, которые хотя и влияют на точность результата,
                находятся в пределах допустимой погрешности вычисления.
                Перед вами учебный сайт для демонстрации возможностей HTML и CSS по
                созданию своего ресурса и его публикации в Интернете. Поскольку
                любой сайт должен содержать полезную или интересную информацию,
                мы выбрали тему ловли льва в пустыне, которая будет, без всяких
                сомнений, полезна любому посетителю. Так, на всякий случай.
                Перед вами учебный сайт для демонстрации возможностей HTML и CSS по
                созданию своего ресурса и его публикации в Интернете. Поскольку
                любой сайт должен содержать полезную или интересную информацию,
                мы выбрали тему ловли льва в пустыне, которая будет, без всяких
                сомнений, полезна любому посетителю. Так, на всякий случай.
            </p>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>

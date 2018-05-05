<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 24.04.18
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<header>
    <div class="header">
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="../index.jsp">Main</a>
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
    </div>
</header>
<div>
    <img class="myfoto" src="#">
    <button type="addfoto" class="btn btn-primary"><a id="addfoto" href="#">Add Foto</a></button>
    <div class="name">User Name</div>
    <p><%out.println("<p>"+request.getAttribute("name")+"</p>");%></p>
    <div class="email">User Email</div>
    <p><%out.println("<p>"+request.getAttribute("email")+"</p>");%></p>
</div>
</body>
</html>

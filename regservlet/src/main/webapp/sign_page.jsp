<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 24.04.18
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Form</title>
</head>
<body>

<header>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/index.jsp">Main</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/sign_page.jsp">Sign In</a>
        </li>
        <li class="nav-item" >
            <a class="nav-link" href="${pageContext.request.contextPath}/userpage">User Page</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
        </li>
    </ul>
    <div class="row">
        <div class="column">

            <form class="signinform" action="${pageContext.request.contextPath}/processuser" method = "post">
                <div class="form-group" id = "nameform">
                    <label for="exampleInputName">Name</label>
                    <span id ="e_name">Wrong name!</span>
                    <input type="text" name = "name" class="form-control" id="exampleInputName" aria-describedby="nameHelp" placeholder="Enter name" onkeyup = "checkName(this.value)" value="${name}">
                    <small id="namesmall" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <span id ="e_email">Wrong email!</span>
                    <input type="email" name = "email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" onkeyup = "checkEmail(this.value)" value="${email}">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name = "password" class="form-control" id="exampleInputPassword1" placeholder="Password" value="${password}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Repeat password</label>
                    <input type="password" name = "password2" class="form-control" id="exampleInputPassword2" placeholder="Repeat password" value="${password2}">
                </div>
                <button type="submit" name = "submit" class="btn btn-primary" id="signinbtn" onClick="butEvent()" value="Submit">Submit</button>
            </form>
        </div>
        <div class="column"></div>
    </div>
</header>
</body>
</html>

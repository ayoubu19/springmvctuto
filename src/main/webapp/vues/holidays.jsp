<%--
  Created by IntelliJ IDEA.
  User: Ayoub
  Date: 3/17/2020
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>holidays</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>
<c:import url="header.jsp"/>
<h1>Congés de : <c:out value="${sessionScope.user.username}"/></h1>
<p class="card-text">votre compteur de congés est :
    <c:choose>
        <c:when test="${sessionScope.user.holidayCounter < 0}">
            <span class="text-danger"><c:out value="${sessionScope.user.holidayCounter}"/></span>
        </c:when>
        <c:when test="${sessionScope.user.holidayCounter < 5}">
            <span class="text-warning"><c:out value="${sessionScope.user.holidayCounter}"/></span>
        </c:when>
        <c:otherwise>
            <span class="text-success"><c:out value="${sessionScope.user.holidayCounter}"/></span>
        </c:otherwise>
    </c:choose>
</p>
<button class="btn btn-primary">Demander un congé</button>


<script>
    document.getElementById("holidays-tab").className = "nav-link active";
    document.getElementById("login-tab").className = "nav-link disabled";
</script>
</body>
</html>

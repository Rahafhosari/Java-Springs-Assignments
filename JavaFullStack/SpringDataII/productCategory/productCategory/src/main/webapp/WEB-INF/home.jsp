<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/15/2021
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>HOMEPAGE</title>
    <style>
        main{
            display: flex;
            justify-content: space-evenly;
        }
    </style>
</head>
<body>
<center>
    <header>
    <h1> Products & Categories </h1>
    </header>
    <main>
        <div>
            <a href="/products"><p class="fw-bold">Add Products</p></a>

        </div>
        <div>
            <a href="/categories"><p class="fw-bold">Add Categories</p></a>
        </div>
    </main>
</center>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/12/2021
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>All Products/New Product</title>
</head>
<body>
<center>
    <h1> Products </h1>
<div class ="container">
    <div class="display">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Product Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="p">
            <tr>
                <td><a href="/product/${p.id}">${p.name}</a></td>
                <td>${p.price}</td>
                <td>${p.description}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="add">
        <h4>Add a new product</h4>
        <form:form action="/products/new" method="post" modelAttribute="product">
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input class="form-control" path="name"/>
            </div>
            <div class="form-group">
                <form:label path="description">Description</form:label>
                <form:errors path="description"/>
                <form:input class="form-control" path="description"/>
            </div>
            <div class="form-group">
                <form:label path="price">Price</form:label>
                <form:errors path="price"/>
                <form:input type="number" class="form-control" path="price"/>
            </div>
            <input class="btn btn-primary" type="submit" value="Create"/>
        </form:form>
    </div>
</div>
    <h5><a href="/categories">View Categories</a></h5>
    <h5><a href="/products">Add Category</a></h5>
</center>
</body>
</html>

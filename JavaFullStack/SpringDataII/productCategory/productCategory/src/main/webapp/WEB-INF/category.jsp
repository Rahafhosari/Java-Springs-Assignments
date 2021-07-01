<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/13/2021
  Time: 5:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>All Categories/New Category</title>
</head>
<body>
<center>
    <h1> Categories </h1>
    <div class ="container">
        <div class="display">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="cat"> <!-- categories is model.addAttribute("---" , categories <list>) in function -->
                    <tr>
                        <td>${cat.id}</td>
                        <td><a href="/category/${cat.id}">${cat.name}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="add">
            <h4>Add a new category</h4>
            <form:form action="/category/new" method="post" modelAttribute="category">
                <div class="form-group">
                    <form:label path="name">Name</form:label>
                    <form:errors path="name"/>
                    <form:input class="form-control" path="name"/>
                </div>
                <input type="submit" value="Create" class="btn btn-primary"/>
            </form:form>
        </div>
    </div>
    <h5><a href="/products">View Products</a></h5>
    <h5><a href="/products">Add Products</a></h5>
</center>
</body>
</html>

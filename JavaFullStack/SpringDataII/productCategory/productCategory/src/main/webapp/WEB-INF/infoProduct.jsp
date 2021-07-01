<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/13/2021
  Time: 6:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Product Page</title>
    <style>
        .form-control{
            width: 300px;
        }
        ul li{
            list-style: circle;
            list-style-position: inside;
        }
    </style>
</head>
<body>
<center>
    <header><h2><c:out value="${product.name}"/></h2></header>
    <h6><c:out value="${product.id}"/></h6>
    <main>
        <div>
            <h4>Categories:</h4>
            <ul>
                <c:forEach items="${categories}" var="category">
                    <li>${category.name}</li> <%-- <li>"${product.categories_products.name}</li> --%>
                </c:forEach>
            </ul>
        </div>
    <div>
        <form action="/catTopro/${product.id}" method="post">
            <div class="form-group">
                <label>Categories:</label>
                <select class="form-control" name="select_category">
                    <c:forEach items="${ notInCategories }" var="notInCategory"> <!-- "notInCategories" model.addAttribute name -->
                        <option value="${ notInCategory.id }">${ notInCategory.name }</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Add" class="btn btn-primary"/>
        </form>
    </div>
    </main>
    <h5><a href="/">Home</a></h5>
</center>
</body>
</html>

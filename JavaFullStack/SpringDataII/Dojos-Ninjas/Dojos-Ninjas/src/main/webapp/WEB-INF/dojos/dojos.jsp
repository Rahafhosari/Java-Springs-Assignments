<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/11/2021
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>New Dojo</title>
</head>
<body>
<center>
    <header>
    <h1>New Dojo</h1>
    </header>
    <main>
    <div class="container">
        <div>
        <form:form action="/dojos/new" method="post" modelAttribute="dojo">
            <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="enter name"/>
            </div>
            <input class="btn btn-primary" type="submit" value="Create"/>
        </form:form>
            <p><h5><a href="/ninjas/new">Add Ninja</a></h5></p>
        </div>
        <div>
            <h2>Dojos</h2>
            <table class="table table-hover">
                <thead  class="thead-dark">
                <tr>
                    <th scope="col">Dojo Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${dojos}" var="dojo">
                    <tr scope="row">
                        <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </main>
</center>
</body>
</html>

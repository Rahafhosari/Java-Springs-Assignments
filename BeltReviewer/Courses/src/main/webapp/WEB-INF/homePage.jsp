<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/14/2021
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <c:out value="${loggedUser.email}" /></h1>
    	<h3>Hello Section 3</h3>
    	<table class="table">
		  <thead style="background-color:#f14444;" >
		    <tr>
		      <th scope="col">Course</th>
		      <th scope="col">Instructor</th>
		      <th scope="col">Capacity</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
    	 <c:forEach var="course" items="${courses}">
    	 	 <tr>
			      <th><a href="/courses/${course.id}"><c:out value="${course.name}"/></a></th>
			      <td>${course.instructor}</td>
			      <td>${course.capacity}</td>
		    </tr>
    	 </c:forEach>
    	 </tbody>
    	 </table>
    <a href="/logout">Logout</a>
</body>
</html>

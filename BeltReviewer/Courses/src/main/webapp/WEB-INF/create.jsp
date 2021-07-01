<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<title>Add Course</title>
</head>
<body>
 <h2><a href="/home">Back</a></h2>
	  <form:form action="/courses" method="post" modelAttribute="course">

        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input class="form-control" path="name"/>
        </div>
        <div class="form-group">
            <form:label path="instructor">Instructor</form:label>
            <form:errors path="instructor"/>
            <form:input class="form-control" path="instructor"/>

        </div>

        <div class="form-group">
            <form:label path="capacity">Capacity</form:label>
            <form:errors path="capacity"/>
            <form:input class="form-control" path="capacity"/>
        </div>

        <input type="submit" style="background: #f14444;border-color: #f14444; color: whitesmoke" value="Create" class="btn btn-primary"/>
    </form:form>
</body>
</html>
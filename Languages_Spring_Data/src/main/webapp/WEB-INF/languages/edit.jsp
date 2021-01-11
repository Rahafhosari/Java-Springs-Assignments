<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Edit Language Information</title>
</head>
<body>
<center>
    <header>
        <form action="/${language.id}" method="post">
            <!-- <input type="hidden" name="_method" value="delete"> -->
            <input class="btn btn-danger" type="submit" value="Delete">
        </form>
        <a class="btn btn-primary" href="/languages">Dashboard</a>
    </header>
    <main>
        <h2> Edit </h2>
        <h1>Edit Book</h1>
        <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
            <input type="hidden" name="_method" value="put">
            <p>
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator"/>
                <form:input path="creator"/>
            </p>
            <p>
                <form:label path="version">Version</form:label>
                <form:errors path="version"/>
                <form:input type="number" path="version"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </main>
</center>
</body>
</html>

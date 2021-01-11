<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Add New Language</title>
</head>
<body>
<center>
    <h2> Add a New Language </h2>
    <form:form action="/languages" method="post" modelAttribute="language">
        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="language name"/>
        </div>
        <div class="form-group">
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:input path="creator" type="text" class="form-control" id="creator" placeholder="creator's name"/>
        </div>
        <div class="form-group">
            <form:label path="version">Version</form:label>
            <form:errors path="version"/>
            <form:input type="number" path="version" class="form-control" id="version" placeholder="version"/>
        </div>
        <input type="submit" value="Submit"/>
    </form:form>

    <%--    <form:form action="/languages" method="post" modelAttribute="language">--%>
    <%--        <p>--%>
    <%--            <form:label path="name">Name</form:label>--%>
    <%--            <form:errors path="name"/>--%>
    <%--            <form:input path="name"/>--%>
    <%--        </p>--%>
    <%--        <p>--%>
    <%--            <form:label path="creator">Creator</form:label>--%>
    <%--            <form:errors path="creator"/>--%>
    <%--            <form:input path="creator"/>--%>
    <%--        </p>--%>
    <%--        <p>--%>
    <%--            <form:label path="version">Version</form:label>--%>
    <%--            <form:errors path="version"/>--%>
    <%--            <form:input type="number" path="version"/>--%>
    <%--        </p>--%>
    <%--        <input type="submit" value="Submit"/>--%>
    <%--    </form:form>--%>

</center>
</body>
</html>


<%--<form:form action="/books" method="post" modelAttribute="book">--%>
<%--    <p>--%>
<%--        <form:label path="title">Title</form:label>--%>
<%--        <form:errors path="title"/>--%>
<%--        <form:input path="title"/>--%>
<%--    </p>--%>
<%--    <p>--%>
<%--        <form:label path="description">Description</form:label>--%>
<%--        <form:errors path="description"/>--%>
<%--        <form:textarea path="description"/>--%>
<%--    </p>--%>
<%--    <p>--%>
<%--        <form:label path="language">Language</form:label>--%>
<%--        <form:errors path="language"/>--%>
<%--        <form:input path="language"/>--%>
<%--    </p>--%>
<%--    <p>--%>
<%--        <form:label path="numberOfPages">Pages</form:label>--%>
<%--        <form:errors path="numberOfPages"/>--%>
<%--        <form:input type="number" path="numberOfPages"/>--%>
<%--    </p>--%>
<%--    <input type="submit" value="Submit"/>--%>
<%--</form:form>--%>

<%--<form action="/languages" method="post" modelAttribute="language">--%>
<%--    <div class="form-group">--%>
<%--        <label for="name">Name</label>--%>
<%--        <input type="text" class="form-control" id="name"  placeholder="enter name">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="creator">Creator</label>--%>
<%--        <input type="text" class="form-control" id="creator" placeholder="creator">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="version">Version</label>--%>
<%--        <input type="number" class="form-control" id="version" placeholder="version">--%>
<%--    </div>--%>
<%--    <input class="btn btn-primary type="submit" value="Submit"/>--%>
<%--</form>--%>
<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/8/2021
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Ninja Gold</title>
</head>
<body>
<center>
    <header>
        <h2><span>Your Gold</span>: <!-- display gold number--> </h2>
    </header>
    <main>
        <div class="randGold">
            <h2> FARM </h2>
            <h4>(earns 10-20 gold)</h4>
            <form action="/gold" method="post">
                <input type="hidden" name="which_form" value="farm">
                <input class="submit" type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="randGold">
            <h2> CAVE </h2>
            <h4>(earns 5-10 gold)</h4>
            <form action="/gold" method="post">
                <input type="hidden" name="whichForm" value="cave">
                <input class="submit" type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="randGold">
            <h2> HOUSE </h2>
            <h4>(earns 2-5 gold)</h4>
            <form action="/gold" method="post">
                <input type="hidden" name="whichForm" value="house">
                <input class="submit" type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="randGold">
            <h2> CASINO </h2>
            <h4>(earn/takes 0-50 gold)</h4>
            <form action="/gold" method="post">
                <input type="hidden" name="whichForm" value="casino">
                <input class="submit" type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="activity">
            <h3>Activities:</h3>
            <!-- show activities -->
            <p> <%=session.getAttribute("activity")%> (${displayDate}) </p>
        </div>
    </main>
</center>
</body>
</html>

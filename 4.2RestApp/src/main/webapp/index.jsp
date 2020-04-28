<%--
  Created by IntelliJ IDEA.
  User: imiclaus
  Date: 4/27/2020
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="web/resource/createUsingForm" method="post" >
    FirstName:
    <label>
        <input type="text" name="first"/>
    </label>
    <br/>
    LastName:
    <label>
        <input type="text" name="last"/>
    </label>
    <br/>
    <input type="submit" value="Create"/>
</form>
</body>
</html>

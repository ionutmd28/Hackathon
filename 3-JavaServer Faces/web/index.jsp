
<%--
  Created by IntelliJ IDEA.
  User: imiclaus
  Date: 4/14/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <h:head>
    <title>This is the page title</title>
  </h:head>
  <h:body>
    Hello Facelets, my name is ${name.value}!

    <h:dataTable value="${titleList.nameList}" var="c">
      <h:column>${c.value}</h:column>
    </h:dataTable>
  </h:body>
</html>

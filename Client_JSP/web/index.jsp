<%--
  Created by IntelliJ IDEA.
  User: djanin
  Date: 18/02/2020
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form action="/Client_JSP_war_exploded/servletCoord" method="post">
        LatA:<input type="text" name="latA"/><br/>
        LonA:<input type="text" name="lonA"/><br/>
        LatB:<input type="text" name="latB"/><br/>
        LonB:<input type="text" name="lonB"/><br/>
        <input type="submit" value="Calculer"/>
      </form>
  </body>
</html>

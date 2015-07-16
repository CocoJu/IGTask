<%@ page import="java.util.List" %>
<%@ page import="ru.cj.db.*" %>
<%@ page import="static ru.cj.util.ParamChecker.showValueIfExist" %>
<%@ page import="static ru.cj.util.ParamChecker.setRequest" %>
<%@ page import="ru.cj.db.map.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 14.05.2015
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<script src="resources/js/bootstrap.min.js"></script>
<head>
    <title></title>
</head>
<body>
<div clases="container">
    <form role="form" class="navbar-form pull-left" action="/testtask/" accept-charset="UTF-8">
        <% setRequest(request);%>
        <input name="category" type="text"
               <%= showValueIfExist("category")%>
                    class="form-control span2" placeholder="категория">
        <input name="name" type="text"
               <%= showValueIfExist("name")%>
                    class="form-control span2" placeholder="наименование">
        <input name="priceFrom" type="text"
               <%= showValueIfExist("priceFrom")%>
                    class="form-control span2" placeholder="цена от">
        <input name="priceOf" type="text"
               <%= showValueIfExist("priceOf")%>
                    class="form-control span2" placeholder="цена до">
        <button type="submit" class="btn btn-default">Найти</button>
    </form>
    <table class="table">
        <caption>Результаты поиска:</caption>
        <thead>
        <tr>
            <th>категория</th>
            <th>наименование</th>
            <th>цена</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
</body>
</html>

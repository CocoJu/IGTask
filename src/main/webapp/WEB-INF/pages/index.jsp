<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 14.05.2015
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<script src="resources/js/bootstrap.min.js"></script>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <form role="form" class="navbar-form pull-left">
        <input type="text" class="form-control span2" placeholder="категория">
        <input type="text" class="form-control span2" placeholder="наименование">
        <input type="text" class="form-control span2" placeholder="цена от">
        <input type="text" class="form-control span2" placeholder="цена до">
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
        <tr>
            <td>Tanmay</td>
            <td>Bangalore</td>
            <td>Bangalore</td>
        </tr>
        <tr>
            <td>Sachin</td>
            <td>Mumbai</td>
            <td>Bangalore</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>

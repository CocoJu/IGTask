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
        <input name="category" type="text"
                    class="form-control span2" placeholder="категория">
        <input name="name" type="text"
                    class="form-control span2" placeholder="наименование">
        <input name="priceFrom" type="text"
                    class="form-control span2" placeholder="цена от">
        <input name="priceOf" type="text"
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

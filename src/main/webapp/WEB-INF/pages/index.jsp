<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<script src="resources/js/bootstrap.min.js"></script>
<head>
    <title></title>
</head>
<body>
<div clases="container">
    <form role="form" class="navbar-form pull-left" action="
            <c:out value="${context_path}"/>/productlist"
                accept-charset="UTF-8">
        <input name="category" type="text"
               value="<c:out value="${category}"/>"
                        class="form-control span2" placeholder="категория">
        <input name="name" type="text"
               value="<c:out value="${name}"/>"
                    class="form-control span2" placeholder="наименование">
        <input name="priceFrom" type="text"
               value="<c:out value="${priceFrom}"/>"
                    class="form-control span2" placeholder="цена от">
        <input name="priceOf" type="text"
               value="<c:out value="${priceOf}"/>"
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
            <c:forEach items="${product_list}" var="product">
                <tr>
                    <th><c:out value="${product.getCat().getName()}"/></th>
                    <th><c:out value="${product.getName()}"/></th>
                    <th><c:out value="${product.getPrice()}"/></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

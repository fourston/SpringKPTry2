<%--
  Created by IntelliJ IDEA.
  User: fours
  Date: 08.04.2016
  Time: 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>SpringMVC</title>


    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1><a href="/">SpringMVC</a></h1>
    <h1>FORUM </h1>
    <hr/>
    <h3><a href="/addThread" type="button" class="btn btn-default btn-sm">Add Thread</a></h3>
    <c:if test="${!empty threadsList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Category</th>
                <th>Tittle</th>

            </tr>

            <c:forEach items="${threadsList}" var="threads">
                <tr>
                    <td>${threads.category}</td>
                    <td>${threads.tittle}</td>
                    <td>
                        <a href="/showThread/${threads.id}" type="button" class="btn btn-sm btn-success">Show</a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>


<script src="/js/jquery.min.js"></script>


<script src="/js/bootstrap.min.js"></script>
</body>
</html>
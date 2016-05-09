<%--
  Created by IntelliJ IDEA.
  User: fours
  Date: 08.04.2016
  Time: 2:07
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


    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>Comments</h1>
    <hr/>

    <c:if test="${!empty commentsByFile}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Комментарий</th>
                <th>От кого</th>
                <th></th>
                <th>Рейтинг</th>
                <th></th>
            </tr>

            <c:forEach items="${commentsByFile}" var="comments">
                <tr>
                    <td>${comments.post}</td>
                    <td>${comments.userName}</td>
                    <td>
                        <form:form action="/upRating" method="post" commandName="comment" role="form">

                            <div class="form-group">
                                <button type="submit" class="btn btn-sm btn-success">+</button>
                            </div>
                        </form:form>
                    </td>
                    <td>${comments.rating}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

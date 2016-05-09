<%--
  Created by IntelliJ IDEA.
  User: fours
  Date: 08.04.2016
  Time: 5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <![endif]-->
</head>
<body>
<div class="container">
    <h1>SpringMVC</h1>
    <hr/>
    <form:form action="/addThreadPost" method="post" commandName="user" role="form">
        <div class="form-group">
            <label for="tittle">Tittle</label>
            <input type="text" class="form-control" id="tittle" name="tittle" placeholder="Enter Tittle:"/>
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <input type="text" class="form-control" id="category" name="category" placeholder="Enter Category:"/>
        </div>
        <div class="form-group">
            <label for="post">Post</label>
            <input type="text" class="form-control" id="post" name="post" placeholder="Enter Post:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Add</button>
        </div>
    </form:form>
</div>



<script src="/js/jquery.min.js"></script>


<script src="/js/bootstrap.min.js"></script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: fours
  Date: 08.04.2016
  Time: 1:36
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


    <<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

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

    <hr/>

    <table class="table tavble-bordered table-striped">
        <tr>
            <th>Name of file</th>
            <td>${file.name}</td>
        </tr>
        <tr>
            <th>extension</th>
            <td>${file.ext}</td>
        </tr>
        <tr>
            <th>size of file</th>
            <td>${file.sizeOfFile}</td>
        </tr>
        <tr>
            <th>path to file</th>
            <td>${file.pathToFile}</td>
        </tr>
    </table>
    <form:form action="/addCommentPost/" method="post" commandName="comment" role="form">
        <div class="form-group">
            <label for="post">post</label>
            <input type="text" class="form-control" id="post" name="post" placeholder="Enter post:"/>
            <input type="text" class="form-control" id="name" name="userName" size="15" placeholder="Your Name:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Post this</button>
        </div>
    </form:form>
    <jsp:include page="/commentsByFile/${file.id}" />

</div>



<script src="/js/jquery.min.js"></script>


<script src="/js/bootstrap.min.js"></script>
</body>
</html>

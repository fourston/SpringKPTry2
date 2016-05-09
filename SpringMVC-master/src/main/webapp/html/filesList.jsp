<%--
  Created by IntelliJ IDEA.
  User: fours
  Date: 07.04.2016
  Time: 23:59
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
    <h1>List of Files </h1>
    <hr/>
    <form method="POST" action="uploadFile" enctype="multipart/form-data">
        Name: <input type="text" name="name"><br /> <br />
        File to upload: <input type="file" name="file"><br />
        <input type="submit" value="Upload"> Press here to upload the file!
    </form>
    <c:if test="${!empty filesList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Name</th>
                <th>size</th>
                <th>extension</th>
                <th>path</th>
                <th>download</th>
                <th>show</th>
            </tr>

            <c:forEach items="${filesList}" var="file">
                <tr>
                    <td>${file.name}</td>
                    <td>${file.sizeOfFile}</td>
                    <td>${file.ext}</td>
                    <td>${file.pathToFile}</td>
                    <td>
                        <a href="/download.do/${file.pathToFile}">Click here to download file</a>
                    </td>
                     <td>
                        <a href="/fileShow/${file.id}" type="button" class="btn btn-sm btn-success">Show</a>

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

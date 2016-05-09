<%--
  Created by IntelliJ IDEA.
  User: sjj
  Date: 2015/10/24 0024
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>SpringMVC Demo </title>


  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<h1>SpringMVC Demo</h1>
<div id="menu" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:spring="http://www.springframework.org/tags" xmlns:sec="http://www.springframework.org/security/tags" version="2.0"> <jsp:directive.page contentType="text/html;charset=UTF-8" /> <jsp:output omit-xml-declaration="yes" /> <spring:message code="menu_header_text" var="menuHeaderText"/> <spring:message code="menu_add_contact" var="menuAddContact"/> <spring:url value="/contacts?form" var="addContactUrl"/> <spring:message code="label_login" var="labelLogin"/> <spring:url var="loginUrl" value="/j spring_security_check" /> <h3>${menuHeaderText}</h3> <sec:authorize access="hasRole('ROLE_USER')"> <а href="${addContactUrl}"><h3>${menuAddContact}</h3></a> </sec:authorize> <sec:authorize access="isAnonymous()"> <div id="login"> <form name="loginForm" action="${loginUrl}" method="post"> <tаЫе> <caption align="left">Login:</caption> <tr> <td>User Name:</td> <td><input type="text" name="j_username"/></td> </tr> <tr> <td>Password:</td> <td><input type="password" name="j_password"/></td> </tr> <tr> <td colspan="2" align="center"><input name="submit" type="submit" value="Login"/> </td> </tr> </tаЫе> </form> </div> </sec:authorize> </div>

<a href="/filesList">СПИСОК ФАЙЛОВ</a>
<br>
<a href="/forum">Форум</a>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>


<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

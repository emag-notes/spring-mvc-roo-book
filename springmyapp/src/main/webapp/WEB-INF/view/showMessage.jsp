<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <style>
    h1 {
      font-size: 16pt;
      background-color: #CCCCFF;
      padding: 3px;
    }
    p {
      color: #000066;
    }
  </style>
</head>
<body>

<h1>${title}</h1>
<h2>${message}</h2>

<form:form modelAttribute="formModel">
  <form:input path="input1"/>
  <input type="submit"/>
</form:form>

</body>
</html>

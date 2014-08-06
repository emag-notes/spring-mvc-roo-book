<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
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

<p>${message}</p>

<form:form>
  <table>
    <tr>
      <td>FIND:</td>
      <td><input type="text" name="fstr" size="20"/></td>
      <td><input type="submit"/></td>
    </tr>
  </table>
</form:form>

<hr/>

<c:if test="${dataList != null}">
  <table border="1">
    <tr>
      <th>ID</th>
      <th>名前</th>
    </tr>
    <c:forEach var="obj" items="${dataList}" varStatus="status">
      <tr>
        <td> <c:out value="${obj.id}"/></td>
        <td><c:out value="${obj.name}"/></td>
      </tr>
    </c:forEach>
  </table>
</c:if>

</body>
</html>

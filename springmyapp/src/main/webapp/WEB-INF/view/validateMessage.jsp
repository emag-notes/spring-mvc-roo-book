<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form:form modelAttribute="validationFormModel">
  <table>
    <tr>
      <td><form:label path="item">商品名</form:label></td>
      <td>
        <form:input path="item" size="20"/>
        <form:errors path="item" cssStyle="color:red"/>
      </td>
    </tr>
    <tr>
      <td><form:label path="price">金額</form:label></td>
      <td>
        <form:input path="price" size="20"/>
        <form:errors path="price" cssStyle="color:red"/>
      </td>
    </tr>
    <tr>
      <td><form:label path="memo">メモ</form:label></td>
      <td>
        <form:textarea path="memo" cols="20" rows="5"/>
        <form:errors path="memo" cssStyle="color:red"/>
      </td>
    </tr>
    <tr>
      <td><input type="submit"/></td>
    </tr>
  </table>
</form:form>

<hr/>

<c:if test="${dataList != null}">
  <table border="1">
    <tr>
      <th>商品名</th>
      <th>価格</th>
    </tr>
    <c:forEach var="obj" items="${dataList}" varStatus="status">
      <tr>
        <td><c:out value="${obj.item}"/></td>
        <td><c:out value="${obj.price}"/></td>
      </tr>
    </c:forEach>
  </table>
</c:if>

</body>
</html>

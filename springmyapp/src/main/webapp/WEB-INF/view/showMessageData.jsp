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

<form:form modelAttribute="messageData">
  <table>
    <tr>
      <td></td>
      <td><form:errors path="*"/></td>
    </tr>
    <form:hidden path="id"/>
    <tr>
      <td><form:label path="title">タイトル</form:label></td>
      <td><form:input path="title" size="20"/></td>
    </tr>
    <tr>
      <td><form:label path="message">メッセージ</form:label></td>
      <td><form:textarea path="message" cols="20" rows="5"/></td>
    </tr>
    <tr>
      <td><form:label path="myData">MYDATA_ID</form:label></td>
      <td><form:input path="myData" size="20"/></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit"/></td>
    </tr>
  </table>
  <hr/>
  <c:if test="${datalist != null}">
    <table border="1">
      <tr>
        <th>ID</th>
        <th>投稿者</th>
        <th>タイトル</th>
        <th>メッセージ</th>
      </tr>
      <c:forEach var="obj" items="${datalist}" varStatus="status">
        <tr>
          <td><c:out value="${obj.id}"/></td>
          <td><c:out value="${obj.myData.name}"/></td>
          <td><c:out value="${obj.title}"/></td>
          <td><c:out value="${obj.message}"/></td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</form:form>

</body>
</html>

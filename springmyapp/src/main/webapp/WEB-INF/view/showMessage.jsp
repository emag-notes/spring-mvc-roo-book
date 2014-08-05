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
  <table>
    <tr>
      <td><form:input path="input1"/></td>
    </tr>
    <tr>
      <td><form:password path="pass1" showPassword="true"/></td>
    </tr>
    <tr>
      <td><form:textarea path="area1" cols="40" rows="3"/></td>
    </tr>
    <tr>
      <td><form:checkbox path="check1" label="checkbox 1"/></td>
    </tr>
    <tr>
      <td><form:checkboxes path="checkOSs" items="${checkOSItems}" delimiter=" "/></td>
    </tr>
    <tr>
      <td><form:checkboxes path="checkNums" items="${checkNumItems}" itemLabel="label" itemValue="data" delimiter=" "/></td>
    </tr>
    <tr>
      <td>
        <form:radiobutton path="radio1" name="radio1" label="男性" value="male"/>
        <form:radiobutton path="radio1" name="radio1" label="女性" value="female"/>
      </td>
    </tr>
    <tr>
      <td><form:radiobuttons path="radioOS" name="radioOS" items="${radioOSItems}" itemLabel="label" itemValue="data" delimiter=" "/></td>
    </tr>
    <tr>
      <td><form:select path="select1" name="select1" items="${optionList}" itemLabel="label" itemValue="data" size="5" multiple="false"/></td>
    </tr>
    <tr>
      <td>
        <form:select path="selectList" name="selectList" size="5" multiple="true">
          <form:option label="None" value="nothing..."/>
          <form:options items="${multiOptionList}" itemLabel="label" itemValue="data"/>
          <form:option label="HAL9000" value="HAL"/>
        </form:select>
      </td>
    </tr>
    <tr>
      <td><input type="submit"/></td>
    </tr>
  </table>
</form:form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> <%--relacionado com spring:form--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <%--relacionado com spring:form--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Jogo da Forca</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h1>Play</h1>
  
    <p> Choose a category and the difficulty </p>

    <a href="<c:url value='/index' />"> Back to Welcome Page</a>
    <br>
    <br>
    <br>
    <br>
    <br>

    <img src="<c:url value='/views/images/1.png'/>"/>
    <img src="<c:url value='views/images/1.png'/>"/>
    <img src="<c:url value='views/1.png'/>"/>
    <img src="<c:url value='/views/1.png'/>"/>
    <img src="<c:url value='images/1.png'/>"/>
    <img src="<c:url value='/images/1.png'/>"/>
    <img src="1.png">
    <br>
    <br>

    <p>Escreve apenas UMA letra.</p>
    <form action="<c:url value='play'/>" method="get" >
        <input name="attempt" type="text" >
        <input type="submit" value="try this letter">
    </form>
    
    <p>Palavra de Jogo: ${encodedWord}</p>

    <br>
    <br>

    <p>Categoria escolhida: ${category}</p>
    <p>Dificuldade escolhida: ${difficulty}</p>

    <br>
    <br>

    <select name="word">
        <%--<option>----</option> just to prevent sending this to database TO_DO--%> 
        <c:forEach items="${listWords}" var="word">
            <option>${word.description}</option> 
        </c:forEach>
    </select>

</body>
</html>
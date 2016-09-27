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
    <h1>Lets Play</h1>
  
    <p> Choose a category and the difficulty </p>

    <a href="<c:url value='/index' />"> Back to Welcome Page</a>
    <br>
    <br>



    <form action="<c:url value='submitPair' />" method="get" >
        <p>Escolhe uma categoria.</p>
        <select name="category">
            <%--<option>----</option> just to prevent sending this to database TO_DO--%>
            <c:forEach items="${listCategories}" var="category">
                <option>${category.description}</option> 
            </c:forEach>
        </select>
        <br>
        <br>
        <p>Escolhe uma dificuldade.</p>
        <select name="difficulty">
            <%--<option>----</option> just to prevent sending this to database TO_DO--%> 
            <c:forEach items="${listDifficulties}" var="difficulty">
                <option>${difficulty.description}</option> 
            </c:forEach>
        </select>
        <br>
        <br>
        <input type="submit" value="Jogar">
    </form>

    <%--test print word.description --%>
    <select name="word">
        <%--<option>----</option> just to prevent sending this to database TO_DO--%> 
        <c:forEach items="${listWords}" var="word">
            <option>${word.description}</option> 
        </c:forEach>
    </select>


    <br>
    <br>


    <br>
    <br>
    <br>
</body>
</html>
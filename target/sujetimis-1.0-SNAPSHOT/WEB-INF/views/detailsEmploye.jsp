
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employe</title>
</head>

<h1>${details.prenom} ${details.nom}</h1>

<form action="${pageContext.request.contextPath}/employe/${details.id}" method="post">
<div>
    Nom :<input type="text" name="nom" value="${details.nom}">
</div>
<div>
    Prenom : <input type="text" name="prenom" value="${details.prenom}">
</div>
<div>
    Adresse : <input type="text" name="adresse" value="${details.adresse}">
</div>
<div>
    Date recrutement : <input type="date" name="dateRec" value="${details.dateRecrutement}">
</div>
<div>
Service :
<select name="idService">
<option value="-1">-- (Hors service!)</option>
<c:forEach items="${tousservices}" var="service">
    <c:choose>
        <c:when test="${service.id eq details.idService}">
            <option value="${service.id}" selected>${service.nom}</option>
        </c:when>
        <c:otherwise>
            <option value="${service.id}">${service.nom}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>

        </select>
        </div>
        <div>
        Role : <input type="text" name="role">
        </div>
        <button type="submit">Modifier</button>
        </form>
        </div>
        </body>
        </html>

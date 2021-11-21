
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>${details.nom}</title>
</head>

<h1>${details.nom}</h1>
<form action="${pageContext.request.contextPath}/service/${details.id}" method="post">

<div>
Nom : <input type="text" name="nom" value="${details.nom}">
</div>
<div>
Mission : <input type="text" name="mission" value="${details.mission}">
</div>
<div>
    Service parent :
    <select name="idParent">
        <option value="-1">--</option>
        <c:forEach items="${tousservices}" var="service">
            <c:choose>
                <c:when test="${service.id eq details.idParent}">
                    <option value="${service.id}" selected>${service.nom}</option>
                </c:when>
                <c:otherwise>
                    <option value="${service.id}">${service.nom}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
</div>
    <button type="submit">Modifier</button>
</form>
<h2>Sous-services</h2>
<ul>
<c:forEach items="${details.sousservices}" var="service">
    <li>
        <a href="${pageContext.request.contextPath}/service/${service.id}">${service.nom}</a>
    </li>
</c:forEach>
</ul>
<form action="${pageContext.request.contextPath}/ajoutsousservice/${details.id}" method="post">
    <select name="idSous">
        <c:forEach items="${tousservices}" var="service">
            <option value="${service.id}">${service.nom}</option>
        </c:forEach>
    </select>
    <button type="submit">Ajouter un sous-service</button>
</form>
</div>

<h2>Membres</h2>
<ul>
<c:forEach items="${details.employes}" var="employe">
    <li>
        <a href="${pageContext.request.contextPath}/employe/${employe.id}">${employe.nom}</a>
    </li>
</c:forEach>
</ul>
<form action="${pageContext.request.contextPath}/ajoutemployeservice/${details.id}" method="post">
<select name="idEmp">
    <c:forEach items="${tousemployes}" var="employe">
        <option value="${employe.id}">${employe.nom}</option>
    </c:forEach>
</select>
<button type="submit">Ajouter un employé</button>
</form>
<div>
    <form action="${pageContext.request.contextPath}/supprservice/${details.id}" method="post">
        <button type="submit">Supprimer le service</button>
    </form>
</div>
</body>
</html>

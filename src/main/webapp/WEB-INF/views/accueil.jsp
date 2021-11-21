
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Who's who</title>
</head>

<h1>C'est qui le chef ?</h1>

<h2>où ça ?</h2>
<ul>
<c:forEach items="${services}" var="service">
    <li>
        <a href="${pageContext.request.contextPath}/service/${service.id}">${service.nom}</a>
    </li>
</c:forEach>
</ul>
<form action="${pageContext.request.contextPath}/nouveauservice">
    <button type="submit">Ajouter un service</button>
</form>
</div>

<h2>Qui ça ?</h2>
<form action="${pageContext.request.contextPath}">
    <input name="filtre"> <button type="submit">Filtrer</button>
</form>
<ul>
<c:forEach items="${employes}" var="employe">
    <li>
        <a href="${pageContext.request.contextPath}/employe/${employe.id}">${employe.nom}</a>
    </li>
</c:forEach>
</ul>
<div>
    <form action="${pageContext.request.contextPath}/nouvelemploye">
        <button type="submit">Ajouter un employe</button>
    </form>
</div>
</body>
</html>

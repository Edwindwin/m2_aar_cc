
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Service</title>
</head>

<h1>Nouveau Service</h1>

<form action="${pageContext.request.contextPath}/nouveauservice" method="post">
    <div>
        Nom :<input type="text" name="nom">
    </div>
    <div>
        Mission : <input type="text" name="mission">
    </div>
    <div>
        Service parent :
        <select name="idParent">
            <option value="-1" selected>--</option>
            <c:forEach items="${services}" var="service">
                <option value="${service.id}">${service.nom}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Créer</button>
</form>
</div>
</body>
</html>

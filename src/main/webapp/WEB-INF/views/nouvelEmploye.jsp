
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employe</title>
</head>

<h1>Nouvel Employe</h1>

<form action="${pageContext.request.contextPath}/nouvelemploye" method="post">
    <div>
        Nom :<input type="text" name="nom">
    </div>
    <div>
        Prenom : <input type="text" name="prenom">
    </div>
    <div>
        Adresse : <input type="text" name="adresse">
    </div>
    <div>
        Date recrutement : <input type="date" name="dateRec">
    </div>
    <div>
        Service :
        <select name="idService">
            <option value="-1" selected>--</option>
            <c:forEach items="${tousservices}" var="service">
                <option value="${service.id}">${service.nom}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        Role : <input type="text" name="role">
    </div>
    <button type="submit">Créer</button>
</form>
</div>
</body>
</html>

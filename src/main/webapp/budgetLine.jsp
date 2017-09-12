<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Presupost</title>
</head>
<body>
    <tag:logOut></tag:logOut>
    <p>Nom usuari: ${sessionScope['user'].user}</p>
    <p>Telefon usuari: ${sessionScope['user'].phone}</p>
    <p>Numero Presupost:<tag:budgetNum></tag:budgetNum></p>
    <tag:budgetDate></tag:budgetDate>

    <tag:budgetLine></tag:budgetLine>
</body>
</html>

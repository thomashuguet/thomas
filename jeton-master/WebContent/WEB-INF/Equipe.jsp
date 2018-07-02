<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="jeton.beans.Equipe" %>
<%@ page import ="jeton.beans.Projet" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
    <title>Mon Equipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
</body>
<div class="container center_div">
    <h1>Mon Equipe</h1><br><br>
    <div class="form-group">
        <label style="font-size: 18px; padding-bottom: 18px; padding-right: 40%">Nom Equipe : ${equipe.nom}</label>
        <label>Jetons restants : ${equipe.nbJeton}</label><br>
        <label style="font-size: 18px;padding-right: 15%">Nom projet : ${projet.nom}</label>

    </div>

    <table style="margin-top: 10%" class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var ="itemUser">
        <tr>
            <td>${itemUser.id}</td>
            <td>${itemUser.nom}</td>
            <td>${itemUser.prenom}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>		
</div>
</html>

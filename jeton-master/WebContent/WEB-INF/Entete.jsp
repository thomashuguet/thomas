<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li>
	            <form action="/Jeton/Accueil" method="POST">
	  				<button type="submit" class="btn-link">Accueil</button>
				</form>
			</li>
            <li>
	            <form action="/Jeton/ListeProjet" method="GET">
	  				<button type="submit" class="btn-link">Les Projets</button>
				</form>
			</li>
            <li>
	            <form action="/Jeton/Equipe" method="GET">
	  				<button type="submit" class="btn-link">Mon Equipe</button>
				</form>
			</li>
            <li>
	            <form action="/Jeton/Mail" method="GET">
	  				<button type="submit" class="btn-link">Mail</button>
				</form>
			</li>
            <li>
	            <form action="/Jeton/Forum" method="POST">
	  				<button type="submit" class="btn-link">Forum</button>
				</form>
			</li>																				
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a><span class="glyphicon glyphicon-user"></span>
            	<c:choose> 
		    <c:when test="${!empty user.identifiant}"> ${user.identifiant}
		<span style="float:right;"><a href="/Jeton/Login">Déconnection
			<%
				session.invalidate();
			%>
			</c:when>
			<c:otherwise>
		<span style="float:right;"><a href="/Jeton/Login">Connection
			</c:otherwise>
			</c:choose>
            </a></li>
        </ul>
    </div>
</nav>
</body>
</html>
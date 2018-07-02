<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="jeton.beans.Projet" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
  <title>Liste des projets</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   
    .row.content {height: 1500px}   
   
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
      
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }   
   
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="row content">

    <div class="col-sm-9">
		<c:forEach items="${projets}" var="itemProjet">       			
			<div class="container">
				<div class="panel-group">
				   <div class="panel panel-default">
				    <a href="/Jeton/Projet"><div class="panel-heading">${itemProjet.nom}</div></a>
				    <div class="panel-body">
					<div class="col-sm-3">Mots cléfs : ${itemProjet.motclef1} ${itemProjet.motclef2} ${itemProjet.motclef3}</div>
					<div class="col-sm-6">Description : ${itemProjet.descriptionCourte}</div>
			  		</div>
				   </div>
			 	</div>
			</div>
		</c:forEach>     
    </div>

	
	<div class="col-sm-3 sidenav">
		<BR>
		<div class="center-block">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button"><a href="/Jeton/CreationProjet">
				<span class="glyphicon glyphicon-plus"></span> Créer un projet
				</button></a>
			</span>
		</div>
		<BR>
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Rechercher un projet">
			<span class="input-group-btn">
			<button class="btn btn-default" type="button">
			<span class="glyphicon glyphicon-search"></span>
			</button>
			</span>
		</div>
	</div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>

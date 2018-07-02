<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="jeton.beans.Projet" %>
<%@ page import ="jeton.beans.Sujet" %>         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
  <title>Projet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
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


    <div class="col-sm-8">
      <h4><small>Projet : ${projet.nom}</small></h4>
      <hr>
      <h2>${projet.descriptionCourte}</h2>
     
      <p>${projet.description}</p>
      <br><br>
      
     </div>
      
      
	<div class="col-sm-4 sidenav">
	  
	  	<div>
		<BR>
		<div class="center-block">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" ><a href="/Jeton/CreationSujet">
				<span class="glyphicon glyphicon-plus"></span> Créer un sujet
				</button></a>
			</span>
		</div>
		<br>  
		
	<div class="col-sm-9">
		<c:forEach items="${sujets}" var="itemSujet">       			
			<div class="container">
				<div class="panel-group">
				   <div class="panel panel-default">
				    <a href="/Jeton/Sujet"><div class="panel-heading">${itemSujet.nom}</div></a>
				    <div class="panel-body">
					<div class="col-sm-3">Mots cléfs : ${itemSujet.motclef1} ${itemSujet.motclef2} ${itemSujet.motclef3}</div>
					<div class="col-sm-6">Description : ${itemSujet.descriptionCourte}</div>
			  		</div>
				   </div>
			 	</div>
			</div>
		</c:forEach>     
    </div>
		    
    </div>
     
    </div>
  </div>
</div>

    

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Inscription</title>
</head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
<body>
<center>
  <form class="form-horizontal" action="/Jeton/Inscription" method="post">
	  <div class="col-md-6 col-md-offset-3 text-center">
	    <label>Nom</label>
	    <div>
	    <input class="form-control" name="nom">
	    </div>
	  </div>
	  <div class="col-md-6 col-md-offset-3 text-center">
	    <label>Prenom</label>
	    <div> 
	      <input class="form-control" name="prenom">
	    </div>
	  </div>
	  <div class="col-md-6 col-md-offset-3 text-center">
	    <label>Email</label>
	    <div> 
	      <input type="email" class="form-control" name="identifiant">
	    </div>
	  </div>
	  <div class="col-md-6 col-md-offset-3 text-center">
	    <label>Mot de passe</label>
	    <div> 
	      <input type="password" class="form-control" name="mdp">
	    </div>
	  </div>
	  </br>
	  <div class="form-group col-md-6 col-md-offset-3 text-center">
	  	<div class="col-xs-5 selectContainer">
            <select class="form-control" name="typeUser">
            	<option value="0" hidden>Rôle</option>
                <option value="1">Apprenant</option>
                <option value="2">Intervenant</option>
                <option value="3">Pedago</option>
            </select>
      	</div>
	  </div>
	  <div> 
	    <div class="col-md-6 col-md-offset-3 text-center">
	      <button type="submit" class="btn btn-default">Valider</button>
	    </div>
	  </div>
  </form>
  </br>
</center>
</body>
</html>
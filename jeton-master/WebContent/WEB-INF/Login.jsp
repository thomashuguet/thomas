<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<center>Connexion</center>
</br>
<center>
	<form class='form' action="/Jeton/Login" method="post">
		<div class="col-md-6 col-md-offset-3 text-center">
			<label>E-Mail</label>
			<div> 
				<input class="form-control" name="identifiant">
			</div>
		</div>
		<div class="col-md-6 col-md-offset-3 text-center">
			<label>Mot de passe</label>
			<div>
				<input type="password" class="form-control" name="mdp">
			</div>
		</div>
		</br>
		<button type="submit" class="btn btn-default">Connexion</button>
	</form>
</center>
<br/>
<center><a href="/Jeton/Inscription">Inscription</a></center>
</body>
</html>
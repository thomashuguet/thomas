<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
    <title>Créer un sujet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container center_div">
    <h1>Créer un nouveau sujet</h1>
    <form action="/Jeton/CreationSujet" method="POST">
        <div class="form-group">
            <label for="formGroupExampleInput">Nom sujet</label>
            <input type="text" class="form-control" name="nomSujet" placeholder="Saisir un nom de sujet">
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput2">Courte description</label>
            <input type="text" class="form-control" name="descriptionCourte" placeholder="Saisir un courte description">
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Description détaillée</label>
            <textarea class="form-control" name="description" rows="3"></textarea>
        </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text" id="">Mots clés (domaines, environnement, langages...)</span>
            </div>
            <input type="text" class="form-control" placeholder="Mot clef 1" name="motclef1">
            <input type="text" class="form-control" placeholder="Mot clef 2" name="motclef2">
            <input type="text" class="form-control" placeholder="Mot clef 3" name="motclef3">
        </div><br>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-2">Valider</button>
        </div>
    </form>
</div>
</body>
</html>

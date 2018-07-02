<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
    <title>CrÃ©er Ã©quipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container center_div">
    <h1>CrÃ©er mon Ã©quipe</h1>
    <form>
        <div class="form-group">
            <label for="formGroupExampleInput">Nom Ã©quipe</label>
            <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Saisir un nom d'Ã©quipe">
        </div>
        <label for="formGroupExampleInput">Nombre maximum de membre acceptÃ©s</label>
        <select name="nom" size="1">
            <option>1

        </select>
        <label for="formGroupExampleInput">SÃ©lectionner membres interÃ©ssÃ©s par le projet</label>
        <select multiple class=form-control>
            <option value=1>Nom prÃ©nom</option>
            <option value=2>Nom prÃ©nom</option>
            <option value=3>Nom prÃ©nom</option>
            <option value=4>Nom prÃ©nom</option>
            <option value=5>Nom prÃ©nom</option>
            <option value=6>Nom prÃ©nom</option>
            <option value=7>Nom prÃ©nom</option>
            <option value=8>Nom prÃ©nom</option>
            <option value=9>Nom prÃ©nom</option>
            <option value=10>Nom prÃ©nom</option>
        </select>




        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-2">Valider</button>
        </div>
    </form>
</div>
</body>
</html>
    
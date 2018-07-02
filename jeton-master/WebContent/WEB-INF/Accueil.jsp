<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/Entete.jsp"/>
    <title>Accueil</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
        
    /* On small screens, set height to 'auto' for the grid */
    @media screen and (max-width: 767px) {
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2>Annonces récentes</h2>
      <ul class="nav nav-pills nav-stacked">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rhoncus porta commodo. Quisque lacinia eu libero sit amet hendrerit. Fusce sit amet mollis orci. Nullam ut neque diam. Etiam vehicula ipsum non sollicitudin iaculis. Praesent sollicitudin turpis in massa facilisis, ut dictum dolor dapibus. Nullam purus elit, dictum in magna quis, sodales lacinia orci. Sed rhoncus mauris mauris, sit amet gravida urna bibendum eget. Sed volutpat lacus id elit pretium vestibulum. Nulla vel molestie nibh. Integer rhoncus faucibus diam interdum blandit. Nullam sed sodales libero. Nunc in sodales odio.
			<br>
			Fusce in interdum purus, ac ullamcorper eros. Ut nec mattis enim. Fusce ut hendrerit erat. Donec in velit rutrum, vulputate enim ac, sodales tellus. Praesent vel ante venenatis, porta lacus sit amet, sodales libero. Aenean a sagittis justo. Vivamus magna neque, ultricies eget malesuada ut, hendrerit eget quam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
      </ul><br>
    </div>
    <br>

    <div class="col-sm-9">
        <h1 class="container center_div">Accueil</h1>
      <div class="well">
        <h4>Dashboard</h4>
        <p>Some text..</p>
      </div>
	</div>
	
</div>
</body>
</html>

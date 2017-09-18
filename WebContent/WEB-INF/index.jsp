<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<title>Accueil</title>
</head>
<body>
	<div class="container">
	<div class="header clearfix">   
      </div>
      <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>/index">SupTrip</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" method="post" action="<%=request.getContextPath()%>/connexion">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Se connecter</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
    <div align="center">
			<form class="navbar-form navbar-center" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Chercher Voyage par Ville">
				</div>
			</form>
	</div>

      <div class="jumbotron">
      
        <h1>Bienvenue sur Supinfo Trip</h1>
        <p class="lead">En tant que etudiant a Supinfo, vous avez la possibilite de voyager autant que vous voulez entre campus. Reservez vos voyage ici!!!</p>
        
        <p><a class="btn btn-lg btn-success" href=" <%=request.getContextPath()%>/inscription" >S'inscrire</a></p>
      </div>

      <div class="row marketing">
           <c:forEach items="${listeCampus}" var="l" step="1"> 
            <div class="col-lg-6" align = "center">
         	 <h4>${l.nom}</h4>
      	     <p>${l.description}</p>
           </div>
          </c:forEach>              
        </div>
      </div>

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

    </div> <!-- /container -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> 
</body>
</html>
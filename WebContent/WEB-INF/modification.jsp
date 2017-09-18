<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<title>Inscription</title>
</head>
<body>
	<div class="container">
	<div class="header clearfix">      
     
      <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index">SupTrip</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" method="get" action="<%=request.getContextPath()%>/client">
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
     </div>

     <div>
     
     </div>
     <div class="container">
      <fieldset >
      	<legend align="left" >Modification de Compte</legend>
			<form method="post" action="<%=request.getContextPath()%>/user/modification" >			
				<div class="col-md-6" >
					<div class="form-group">
						<label for="idBooster">IdBooster</label> <input
							type="text" name="idBooster" class="form-control" id="idBooster"
							placeholder="idBooster" value="${user.idBooster}" disabled> <p style="color : red" >${erreurs.id}</p>
					</div>
					<div class="form-group">
						<label for="Nom">Nom</label> <input
							type="text" name="nom" class="form-control" id="nom"
							placeholder="Nom" value="${user.nom}"> <p style="color : red" >${erreurs.nom}</p>
					</div>		
					<div class="form-group ">
						<label for="Prenom">Prenom</label> <input
							type="text" name="prenom" class="form-control" id="prenom"
							placeholder="Prenom"  value="${user.prenom}" > <p style="color : red" >${erreurs.prenom}</p>
					</div>	
					
					<div class="form-group">
						<label for="Email">Email address</label> <input
							type="email" name="email" class="form-control" id="email"
							placeholder="Email"  value="${user.email}"><p style="color : red" >${erreurs.email}</p>
					</div>
					<div class="form-group">
						<label for="password">Mot de passe</label> <input
							type="password" name="password" class="form-control" id="passwordConf"
							placeholder="Password"  value="${user.password}"> <p style="color : red" >${erreurs.password}</p>
					</div>	
					<div class="form-group">
						<label for="passwordConf">Confirmation de mot de passe</label> <input
							type="password" name="passwordConf" class="form-control" id="passwordConf"
							placeholder="Password confirmation">
					</div>	
					<div class="form-group">
	                    <label for="idCategorie">Campus</label>
	                 	<select class="form-control" name="idCampus" id="idCampus"  >
						  <c:forEach items="${listeCampus}" var="l"> 
						  	<option value="${l.idCampus}"> <c:out value="${l.nom}" />  </option>
						  </c:forEach>  
						</select>
	                 </div>  			
					<button type="submit" class="btn btn-default" name="bouton" value="modification">Submit</button>
				</div>
				</form>		
				
					
	 </fieldset>			
			 
			     
      </div>
      
      </div>
      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

    
</body>
</html>
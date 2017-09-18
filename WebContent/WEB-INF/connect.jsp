<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/jumbottron-narrow.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/elfinder.min.css">
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
          <a class="navbar-brand" href="<%=request.getContextPath()%>/index">SupTrip</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<form class="navbar-form navbar-right" method="post" action="<%=request.getContextPath()%>/connexion">						
						<a href="#" style="margin-right: 30px"><span
							class="glyphicon glyphicon-user" aria-hidden="true"> Profile</span></a>
							<a href="#" style="margin-right: 30px"><span
							class="glyphicon glyphicon-plane" aria-hidden="true"> Voyages<span class="badge">4</span></span></a>		
						<button type="submit" class="btn btn-warning" name="bouton" value="disconnect">Deconnexion</button>
					</form>

				</div><!--/.navbar-collapse -->
      </div>
    </nav>
     </div>

      <div class="jumbotron">
      
      <fieldset>
      	<legend align="left">Reservez vos voyages</legend>
			<form method="post" action="<%=request.getContextPath()%>/user/trip">				
				<div class="form-group">
                    <label for="idSource">Campus source</label>
                 	<select class="form-control" name="idSource" id="idSource"  >
					  <c:forEach items="${listeCampus}" var="l"> 
					  	<option value="${l.idCampus}"> <c:out value="${l.nom}" />  </option>
					  </c:forEach>  
					</select>
                 </div>  
                 
                 <div class="form-group">
                    <label for="idDest">Campus source</label>
                 	<select class="form-control" name="idDest" id="idDest" >
					  <c:forEach items="${listeCampus}" var="l"> 
					  	<option value="${l.idCampus}"> <c:out value="${l.nom}" />  </option>
					  </c:forEach>  
					</select>
                 </div>  		
				<button type="submit" class="btn btn-default" name="bouton" value="addTrip">Submit</button>
			</form>
	 </fieldset>
			  
			  
			
             
        </div>
      </div>

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

    </div> <!-- /container -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> 
</body>
</html>
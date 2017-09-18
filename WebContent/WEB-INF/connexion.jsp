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
      </div>
    </nav>
     </div> 
     <div class="col-md-6">
      <fieldset>
      	<legend align="left">Connexion</legend>    
			<form method="post" action="<%=request.getContextPath()%>/connexion">				
					
			      <div class="container">
			      
			       <div> <h2 class="form-signin-heading">Please sign in</h2></div>
			        <div>
				        <label for="idBooster" >IdBooster</label>
				        <input type="number" id="idBooster" class="form-control" placeholder="idBooster" name="idBooster" >
			        </div>
			        <div>
				        <label for="password">Password</label>
				        <input type="password" id="password" class="form-control" placeholder="Password" name="password">
			    	</div>     
			        <button class="btn btn-lg btn-primary btn-block" type="submit" name="bouton" value="connexion">Sign in</button>
     		 </div>
     		 </form>
		 </fieldset>


    </div> <!-- /container -->  
      </div>

      <footer class="footer" align = "center">
        <p>&copy; 2015 Okpafaces, Inc.</p>
      </footer>

    </div> <!-- /container -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/css/bootstrap.css" >
	<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/css/bootstrap-theme.css" >
	<script type="text/javascript" src="<%=request.getContextPath()%>/theme/js/bootstrap.min.js"></script>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<title>Expeditor</title>
</head>
<body>
<h2>Bienvenue sur Expeditor</h2>
<div class="row">
    <a href="<%=request.getContextPath()%>/Candidate">
        <div class="col-sm-6 col-sm-push-1 jumbotron bloc_profil">
            <h2>Manager</h2>
        </div>
    </a>
</div>
<div class="row">
    <a href="<%=request.getContextPath()%>/Teacher">
        <div class="col-sm-6 col-sm-push-1 jumbotron bloc_profil">
            <h2>Employe</h2>
        </div>
    </a>
</div>
</body>
</html>
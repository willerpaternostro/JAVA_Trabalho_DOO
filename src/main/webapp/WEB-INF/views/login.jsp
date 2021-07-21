<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Login</title>
</head>
<body class="bg-dark text-white text-center">
<form method="POST" action="controle">
<div class="row justify-content-center">
<c:if test="${erro.equals('erro')}">
<h6 class="text-danger">${msgErro}</h6>
</c:if>
	<h1 class="col-2">Login</h1>

</div>
<div class="row justify-content-center">
	<span class="col-1">E-mail:</span>
	<input class="mb-1 col-2" type="text" name="email">
</div>
<div class="row justify-content-center">
	<span class="col-1">Senha:</span>	
	<input class="col-2 mb-2" type="password" name="senha">
</div>

<div class="row justify-content-center">
	<input class="offset-1 col-2 btn btn-primary "  type="submit" value="Logar">
</div>
<input type="hidden"  value="Logar" name="comando">

</form>


</body>
</html>
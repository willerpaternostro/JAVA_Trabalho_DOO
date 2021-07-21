<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Operador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
	<div class="row justify-content-center">
		<h1 class="col-4 text-center mb-4">Editar Operador</h1>
	</div>

	<form method="POST" action="controle">
		<div class="row justify-content-center">
			<label class="col-1">Nome:</label>
			<input class="col-3 mb-2" type="text" name="nome" value="${nome}" >
		</div>
		<div class="row justify-content-center">
			<label class="col-1">Email:</label>
			<input class="col-3 mb-2" type="text" name="email" value="${email}">
		</div>
		<div class="row justify-content-center">
			<label class="col-1">Senha:</label>
			<input class="col-3 mb-2" type="text" name="senha" value="${senha}">
		</div>
	
		<div class="row justify-content-center">
			<a class="btn btn-secondary col-2" style="margin:10px" href="controle?comando=GerenciarOperadores">Voltar</a>
			<input class="col-2 btn btn-success" style="margin:10px" type="submit" value="Editar" >
			<input type="hidden"  value="EditarOperador" name="comando">
		</div>
	</form>
</body>
</html>
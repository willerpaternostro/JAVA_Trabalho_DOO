<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row justify-content-center">
<h1 class="col-4 text-center mb-4">Editar Cliente</h1>
</div>
<div class="row justify-content-center">
<h6 class="text-danger col-4">${msgErro}</h6>
</div>
<form method="POST" action="controle">
<div class="row justify-content-center">
	<label class="col-1">Nome:</label>
	<input class="col-3 mb-2" type="text" name="nome" value="${nome}">
</div>
<div class="row justify-content-center">
	<label class="col-1">CPF:</label>
	<input class="col-3 mb-2" type="text" name="cpf" value="${cpf}">
</div>
<div class="row justify-content-center">
	<label class="col-1">Endereço:</label>
	<input class="col-3 mb-2" type="text" name="endereco" value="${endereco}">
</div>
<div class="row justify-content-center">
	<label class="col-1">Telefone:</label>
	<input class="col-3 mb-2" type="text" name="telefone" value="${telefone}">
</div>

<div class="row justify-content-center">
	<a style="margin:10px" class="col-2 btn btn-secondary" href="controle?comando=GerenciarCliente">Voltar</a>
	<input style="margin:10px" class="col-2 btn btn-success" type="submit" value="Editar" >
	<input type="hidden"  value="EditarCliente" name="comando">
</div>

</form>
</body>
</html>
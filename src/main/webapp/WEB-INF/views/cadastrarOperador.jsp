<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Operador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row justify-content-center">
<h1 class="col-4 text-center mb-4">Cadastrar Operador</h1>
</div>
<div class="row justify-content-center">
<h6 class="text-danger col-4">${msgErro}</h6>
</div>
<form method="POST" action="controle">
<div class="row justify-content-center">
	<label class="col-1">Nome:</label>
	<input class="col-3 mb-2" type="text" name="nome" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Email:</label>
	<input class="col-3 mb-2" type="text" name="email" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Senha:</label>
	<input class="col-3 mb-2" type="password" name="senha" >
</div>
<div class="row justify-content-center">
<a class="btn btn-secondary col-2" href="controle?comando=GerenciarOperadores">Voltar</a>
	<input class="col-2 btn btn-success" type="submit" value="Cadastrar" >
	<input type="hidden"  value="CadastrarOperador" name="comando">
</div>

</form>
</body>
</html>
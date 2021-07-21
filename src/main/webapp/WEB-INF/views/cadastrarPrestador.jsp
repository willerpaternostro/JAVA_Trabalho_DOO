<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Prestador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row justify-content-center">

<h1 class="col-4 text-center mb-4">Cadastrar Prestador</h1>
</div>

<form method="POST" action="controle">
<div class="row justify-content-center">
<h6 class="text-danger text-center">${msgErro}</h6>
	<label class="col-1">Nome:</label>
	<input class="col-3 mb-2" type="text" name="nome" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Endereço:</label>
	<input class="col-3 mb-2" type="text" name="endereco" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Documento:</label>
	<input class="col-3 mb-2" type="text" name="documento" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Telefone:</label>
	<input class="col-3 mb-2" type="text" name="telefone" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Serviço Oferecido:</label>
	<input class="col-3 mb-2" type="text" name="servicoOferecido" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Valor Diária:</label>
	<input class="col-3 mb-2" type="text" name="valorDiaria" >
</div>
<div class="row justify-content-center">
	<div class="form-check col-3 offset-1 mb-2">
  <input class="form-check-input" type="checkbox" value="true" name="atendeUrgencia" id="atendeUrgencia">
	  <label class="form-check-label" for="atendeUrgencia">
	    Atende Urgência
	  </label>
	</div>
</div>
<div class="row justify-content-center">
	<a style="margin:10px" class="col-2 btn btn-secondary" href="controle?comando=GerenciarPrestadores">Voltar</a>
	<input style="margin:10px" class="col-2 btn btn-success" type="submit" value="Cadastrar" >
	<input type="hidden"  value="CadastrarPrestador" name="comando">
</div>

</form>
</body>
</html>
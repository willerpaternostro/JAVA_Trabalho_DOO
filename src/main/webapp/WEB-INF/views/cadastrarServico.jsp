<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Servico</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row justify-content-center">
<h1 class="col-4 text-center mb-4">Cadastrar Servico</h1>
</div>
<div class="row justify-content-center">
<h6 class="text-danger col-4">${msgErro}</h6>
</div>
<form method="POST" action="controle">
<div class="row justify-content-center">
	<label class="col-1">CPF Cliente:</label>
	<input class="col-3 mb-2" type="text" name="cpfCliente" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Documento Prestador:</label>
	<input class="col-3 mb-2" type="text" name="documentoPrestador" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Tempo gasto:</label>
	<input class="col-3 mb-2" type="text" name="tempoGasto" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Valor final:</label>
	<input class="col-3 mb-2" type="text" name="valorFinal" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Porcentagem ADM:</label>
	<input class="col-3 mb-2" type="text" name="porcentagemADM" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Avaliação:</label>
	<input class="col-3 mb-2" type="text" name="avaliacao" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Data Realização:</label>
	<input class="col-3 mb-2" type="text" name="dataRealizacao" >
</div>
<div class="row justify-content-center">
	<label class="col-1">Tipo serviço:</label>
	<input class="col-3 mb-2" type="text" name="tipoServico" >
</div>
<div class="row justify-content-center">
	<div class="form-check col-3 offset-1 mb-2">
  <input class="form-check-input" type="checkbox" value="true" name="statusServico" id="statusServico">
	  <label class="form-check-label" for="statusServico">
	    Serviço Concluído
	  </label>
	</div>
</div>
<div class="row justify-content-center">
	<a style="margin:10px" class="col-2 btn btn-secondary" href="controle?comando=GerenciarServicos">Voltar</a>
	<input style="margin:10px" class="col-2 btn btn-success" type="submit" value="Cadastrar" >
	<input type="hidden"  value="CadastrarServico" name="comando">
</div>

</form>
</body>
</html>
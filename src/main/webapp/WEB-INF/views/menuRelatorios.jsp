<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Relatorios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row">
	<a class="col-1 btn btn-secondary" href="controle?comando=MenuAdmin" style="max-height:40px;"> Voltar</a>
	<div class="col-11 text-end">
		<span class="h5">Bem-vindo, ${usuario.nome}</span>
		<a href="controle?comando=Deslogar" class="col-1 btn btn-danger" style="max-height:40px">
		 Sair
		</a>
	</div>
</div>
<div class="row ">
<h1 class="col-12 text-center">Relatorios</h1>
</div>

<div class="row justify-content-center">
	<a href="controle?comando=RelatorioFinanceiro" class="btn btn-primary col-3 mb-2"> 
		Relatorio Financeiro
	</a>
</div>
<div class="row justify-content-center">
	<a href="controle?comando=RelatorioClientes" class="btn btn-primary col-3 mb-2"> 
		Relatorio Clientes
	</a>
</div>
<div class="row justify-content-center">
	<a href="controle?comando=RelatorioPrestadores" class="btn btn-primary col-3 mb-2"> 
		Relatorio Prestadores
	</a>
</div>

</body>
</html>
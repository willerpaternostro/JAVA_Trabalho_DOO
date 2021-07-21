<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row">
	<div class="col-11 offset-1 text-end">
		<span class="h5">Bem-vindo, ${usuario.nome}</span>
		<a href="controle?comando=Deslogar" class="col-1 btn btn-danger" style="max-height:40px">
		 Sair
		</a>
	</div>
</div>
<div class="row ">
<h1 class="col-12 text-center">Menu</h1>
</div>
 <c:if test = "${usuario.email.equals('admin@ihomeservices.br')}">
	<div class="row justify-content-center">
		<a href="controle?comando=GerenciarOperadores" class="btn btn-primary col-3 mb-2"> 
			Gerenciar Operadores 
		</a>
	</div>
</c:if>
<div class="row justify-content-center">
	<a href="controle?comando=GerenciarPrestadores" class="btn btn-primary col-3 mb-2"> 
		Gerenciar Prestadores
	</a>
</div>
<div class="row justify-content-center">
	<a href="controle?comando=GerenciarCliente" class="btn btn-primary col-3 mb-2"> 
		Gerenciar Clientes
	</a>
</div>
<div class="row justify-content-center">
	<a href="controle?comando=GerenciarServicos" class="btn btn-primary col-3 mb-2"> 
		Gerenciar Serviços
	</a>
</div>
<div class="row justify-content-center">
	<a href="controle?comando=MenuRelatorios" class="btn btn-primary col-3">Emitir Relatório</a>
</div>


</body>
</html>
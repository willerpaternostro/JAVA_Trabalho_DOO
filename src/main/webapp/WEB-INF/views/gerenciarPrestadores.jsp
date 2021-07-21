<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Prestadores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<div class="row mb-5">
		<a class="col-1 btn btn-secondary" href="controle?comando=MenuAdmin" style="max-height:40px;"> Voltar</a>
		<div class="col-11 text-end">
			<span class="h5">Bem-vindo, ${usuario.nome}</span>
			<a href="controle?comando=Deslogar" class="col-1 btn btn-danger" style="max-height:40px">
			 Sair
			</a>
		</div>
</div>

<div class="row justify-content-center">
	<h1  class="col-9  mb-5 text-center">Gerenciador de Prestadores <a href="controle?comando=TelaCadastroPrestador" class=" btn btn-success" style="max-height:40px;">+ Novo</a></h1>
</div>
<div class="row justify-content-center">
	<table class="col-9">
	<tr>
		<th>Nome</th>
		<th>Endereço</th>
		<th>Documento</th>
		<th>Telefone</th>
		<th>Serviço</th>
		<th>Diária</th>
		<th>Urgência</th>
		<th>Editar</th>
		<th>Excluir</th>
	</tr>
	<c:forEach items="${prestadores}" var="prestador">
		<tr>
			<td>${prestador.nome}</td>
			<td>${prestador.endereco}</td>
			<td>${prestador.documento}</td>
			<td>${prestador.telefone}</td>
			<td>${prestador.servicoOferecido}</td>
			<td>${prestador.valorDiaria}</td>
			<td>${prestador.atendeUrgencia}</td>
			<td>
				<a 
				class="btn btn-warning" 
				href="controle?comando=TelaEditarPrestador&nome=${prestador.nome}&
				endereco=${prestador.endereco}&documento=${prestador.documento}&
				telefone=${prestador.telefone}&servicoOferecido=${prestador.servicoOferecido}&
				valorDiaria=${prestador.valorDiaria}&atendeUrgencia=${prestador.atendeUrgencia}">
				Editar
				</a>
			</td>
			<td><a class="btn btn-danger" href="controle?comando=TelaExcluirPrestador&documento=${prestador.documento}">Excluir</a></td>
		</tr>
	</c:forEach>
	</table>
</div>
</body>
</html>
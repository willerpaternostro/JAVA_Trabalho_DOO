<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Serviços</title>
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
	<h1 class=" col-11 text-center  mb-5">Gerenciador de Serviços <a href="controle?comando=TelaCadastroServico" class="btn btn-success" style="max-height:40px;">+ Novo</a></h1>
</div>

<div class="row justify-content-center">
	<table class="col-11">
	<tr>
		<th>ID</th>
		<th>CPF Cliente</th>
		<th>Documento Prestador</th>
		<th>Tempo Gasto</th>
		<th>Valor final</th>
		<th>%ADM</th>
		<th>Avaliação</th>
		<th>Realizado em</th>
		<th>Status</th>
		<th>Servico</th>
		<th>Editar</th>
		<th>Excluir</th>
	</tr>
	<c:forEach items="${servicos}" var="servico">
		<tr>
			<td>${servico.id}</td>
			<td>${servico.cpfCliente}</td>
			<td>${servico.documentoPrestador}</td>
			<td>${servico.tempoGasto}</td>
			<td>${servico.valorFinal}</td>
			<td>${servico.porcentagemAdm}</td>
			<td>${servico.avaliacao}</td>
			<td>${servico.dataRealizacao }</td>
			<td>${servico.status}</td>
			<td>${servico.tipoServico}</td>
			<td>
				<a 
				class="btn btn-warning" 
				href="controle?comando=TelaEditarServico&id=${servico.id}&cpfCliente=${servico.cpfCliente}&
				documentoPrestador=${servico.documentoPrestador}&tempoGasto=${servico.tempoGasto}&
				valorFinal=${servico.valorFinal}&porcentagemADM=${servico.porcentagemAdm}&
				avaliacao=${servico.avaliacao}&dataRealizacao=${servico.dataRealizacao}&
				status=${servico.status}&tipoServico=${servico.tipoServico}">
				Editar
				</a>
			</td>
			<td><a class="btn btn-danger" href="controle?comando=TelaExcluirServico&id=${servico.id}">Excluir</a></td>
		</tr>
	</c:forEach>
	</table>
	
</div>
</body>
</html>
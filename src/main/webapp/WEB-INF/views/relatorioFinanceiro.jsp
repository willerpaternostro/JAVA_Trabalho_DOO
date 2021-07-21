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
<div class="row">
	<a class="col-1 btn btn-secondary" href="controle?comando=MenuRelatorios" style="max-height:40px;"> Voltar</a>
	<div class="col-11 text-end">
		<span class="h5">Bem-vindo, ${usuario.nome}</span>
		<a href="controle?comando=Deslogar" class="col-1 btn btn-danger" style="max-height:40px">
		 Sair
		</a>
	</div>
</div>
<div class="row">
<h1 class=" col-11 text-center  mb-4">Relatorio Financeiro</h1>
</div>

<div class="row justify-content-center">
	<table class="col-11 ">
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
		<th>Valor ADM (R$)</th>

	</tr>
	<c:forEach items="${servicosRelatorio}" var="servico" varStatus="id">
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
			<td>${faturamentoAdminRelatorio.get(id.count-1)}</td>
		</tr>
	</c:forEach>
	<tr class="bg-success" >
	<td class=" h6 text-center">Total</td>
	<td colspan="9"></td>
	<td class=" h6 "> ${faturamentoTotalRelatorio} reais</td>
	</tr>
	</table>
	
</div>
</body>
</html>
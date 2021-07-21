<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Relatorio Prestadores</title>
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
	<div class="row justify-content-center">
		<h1 class="col-12 text-center mb-4">Relatorio  Prestadores</h1>
	</div>
	<div class="row justify-content-center mb-4">
		<div class="col-10">
		<a  class="btn btn-success">Mais Requisitado</a>
		<a  href="controle?comando=RelatorioPrestadoresBemAvaliados" class="btn btn-outline-secondary">Melhor avaliado</a>
		</div>
	</div>	
	<div class="row justify-content-center">
		<table class="col-10">
			<tr>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Documento</th>
				<th>Telefone</th>
				<th>Serviço</th>
				<th>Diária</th>
				<th>Urgência</th>
				<th>Requisicoes</th>
			</tr>
				<c:forEach items="${prestadoresRelatorio}" var="prestador" varStatus="id">
					<tr>
						<td>${prestador.nome}</td>
						<td>${prestador.endereco}</td>
						<td>${prestador.documento}</td>
						<td>${prestador.telefone}</td>
						<td>${prestador.servicoOferecido}</td>
						<td>${prestador.valorDiaria}</td>
						<td>${prestador.atendeUrgencia}</td>
						<td>${solicitacoesRelatorio.get(id.count-1)}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>
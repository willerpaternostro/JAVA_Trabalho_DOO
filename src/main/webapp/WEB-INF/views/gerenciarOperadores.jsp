<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Operadores</title>
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
	<h1 class="col-9  mb-5 text-center">Gerenciador de Operadores <a href="controle?comando=TelaCadastroOperador" class="btn btn-success" style="max-height:40px;">+ Novo</a></h1>
</div>
<div class="row justify-content-center">
	<table class="col-9">
	<tr>
		<th>Email</th>
		<th>Nome</th>
		<th>Senha</th>
		<th>Editar</th>
		<th>Excluir</th>
	</tr>
	<c:forEach items="${operadores}" var="operador">
		<c:if test="${!operador.email.equals('admin@ihomeservices.br')}">
			<tr>
				<td>${operador.email}</td>
				<td>${operador.nome}</td>
				<td>${operador.senha}</td>
				<td>
					<a class="btn btn-warning" href="controle?comando=TelaEditarOperador&email=${operador.email}&nome=${operador.nome}&senha=${operador.senha}">
						Editar
					</a>
				</td>
				<td><a class="btn btn-danger" href="controle?comando=TelaExcluirOperador&email=${operador.email}">Excluir</a></td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
</div>
</body>
</html>
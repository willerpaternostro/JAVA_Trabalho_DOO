<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Prestador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
	<form method="POST" action="controle">
		<p>Deseja mesmo excluir o prestador com documento ${documento}?</p>
		<a class="btn btn-secondary" href="controle?comando=GerenciarPrestadores">Voltar</a>
		<input class="btn btn-danger" type="submit" value="Excluir">
		<input  type="hidden" value="ExcluirPrestador" name="comando">
		<input  type="hidden" value="${documento}" name="documento">
	</form>
</body>
</html>
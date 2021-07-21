<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Operador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-dark text-white">
<h6>Deseja mesmo excluir ${email} ?</h6>
<form method="POST" action="controle">
<a class="btn btn-secondary" href="controle?comando=GerenciarOperadores">Voltar</a>
<input class="btn btn-danger" type="submit" value="Excluir">
<input  type="hidden" value="ExcluirOperador" name="comando">
<input  type="hidden" value="${email}" name="email">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Menu principal</title>
</head>
<body>
	<h2>Página inicial da Lista de Tarefas</h2>
	<p>Bem vindo, ${usuarioLogado.login}!</p>
	<p><a href="listaTarefas">Clique aqui</a> para acessar a lista de tarefas.</p>	
	<p><a href="logout">Sair do sistema</a></p>
</body>
</html>
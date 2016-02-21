<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulário de cadastro de tarefas</title>
</head>
<body>
	<h2>Formulário de cadastro de tarefas</h2>
	<form:errors path="tarefa.descricao" cssStyle="color:red"/>
	<form action="adicionaTarefa" method="post">
		<div>
			<label for="d">Descrição:</label>
			<br>		
			<textarea name="descricao" id="d" rows="5" cols="50"></textarea>
		</div>
		<br>
		<button>Adicionar</button>
	</form>
</body>
</html>
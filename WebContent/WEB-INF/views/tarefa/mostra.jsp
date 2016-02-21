<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alterar tarefa</title>
</head>
<script type="text/javascript" src="resources/js/mostra.js" charset="UTF-8"></script>
<body>
	<h3>Alterar tarefa - ${tarefa.descricao}</h3>
	<form:errors path="tarefa.descricao" cssStyle="color:red"/>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" />
		Descrição:<br>
		<textarea name="descricao" cols="50" rows="5">${tarefa.descricao}</textarea>
		<br>
		Finalizado: <input onClick="checkFinalizado()" type="checkbox" name="finalizado"
		value="true" ${tarefa.finalizado? 'checked' : '' }>
		<br>
		<label id="lb_data">Data de finalização: </label><br>
		<input type="date" name="dataFinalizacao"
			value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
			pattern="yyyy-MM-dd" />" required>
		<br>
		<button>Alterar</button>
	</form>
</body>
</html>
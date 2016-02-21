<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de tarefas</title>
	<link type="text/css" rel="stylesheet" href="resources/css/lista.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="resources/js/lista.js"></script>
</head>
<body>
	<a id="novaTarefa" href="novaTarefa">Criar nova tarefa</a>
	<br /> <br />
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado</th>
			<th>Data de finalização</th>
			<th>Excluir</th>
			<th></th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr id="tarefa_${tarefa.id}">
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>				
				<c:if test="${tarefa.finalizado eq false}">
					<td>
						<a href="#" onClick="finalizaAgora(${tarefa.id})">
							Finaliza agora!
						</a>
					</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td>
					<fmt:formatDate 
						value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy"/>
				</td>
				<td><button onclick="exclui('${tarefa.id}', '${tarefa.descricao}')">X</button></td>
				<td>
					<a href="mostraTarefa?id=${tarefa.id}">
						Alterar
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>				
	<td>Finalizado</td>
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
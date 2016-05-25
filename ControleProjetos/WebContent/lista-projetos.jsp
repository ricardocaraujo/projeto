<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="css/estilos.css">
	<link rel="stylesheet" href="css/font-awesome-4.5.0/css/font-awesome.min.css">
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<c:import url="header.jsp"></c:import>
	<div class="linha">
		<section>
			<div>
				<table>
					<tr> 
						<th width="200px">Nome</th>
						<th width="400px">Objetivo</th>
						<th width="100px">Data de início</th>
						<th width="100px">Data de término</th>
						<th width="100px">Coordenador</th>
						<th width="100px">Responsável técnico</th>
						<th width="150px">Ação</th>
					</tr>
					<jsp:useBean id="listaProjetos" class="tg.controleprojeto.persistencia.dao.ProjetoDAO">
						<c:forEach var="projeto" items="${listaProjetos.lista}">
							<tr id="projeto${projeto.idProjeto}">
								<td>${projeto.nomeProjeto}</td>
								<td>${projeto.objetivo}</td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.dataInicio.time}"/>
								</td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.dataFim.time}"/>
								</td>
	 							<td><c:forEach var="coordenador" items="${projeto.coordenador}">
	 									<span>${coordenador.nome}<br></span>
	 								</c:forEach>
	 							</td>					
								<td>${projeto.responsavelTecnico.nome}</td>
								<td>
								<a href="#" title="Remover projeto" onclick="removeProjeto(${projeto.idProjeto})">
								<i class="fa fa-trash-o"></i></a>
								<a href="mvc?logica=AlteraProjetoLogic&idProjeto=${projeto.idProjeto}"
								title="Editar projeto">
								<i class="fa fa-pencil-square-o"></i></a>
								</td>
							</tr>
						</c:forEach>
					</jsp:useBean>
				</table>
			</div>
		</section>
	</div>
	<script src="js/jquery-2.1.4.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<!-- <script src="js/javascript.js"></script> -->
	<script>
		function removeProjeto(id) {
			$(document).load("mvc", {"logica": "RemoveProjetoLogic", "projetoId": + id});
			$("#projeto" + id).remove();
		}
		
		$(function() {
		    $(document).tooltip();
		});
	</script>
	
	
</body>
</html>


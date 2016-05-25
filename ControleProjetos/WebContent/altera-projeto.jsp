<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="header.jsp"></c:import>
	<div class="linha">
		<section>
			<div>
				<form action="mvc">
					<label>Nome do projeto</label>
					<input type="text" name="nomeProjeto" value="${projeto.nomeProjeto}">
					<div>
					<label>Coordenador</label>			
					<select name="coordenador">
						<option value="${projeto.coordenador.nome}" selected>${projeto.coordenador.nome}</option>
						<jsp:useBean id="coordenador" class="tg.controleprojeto.persistencia.dao.EmpregadoDAO">
							<c:forEach var="empregado" items="${coordenador.lista}">
								<c:if test="${empregado.nome != projeto.coordenador.nome}">
									<option value="${empregado.nome}">${empregado.nome}</option>
								</c:if>
							</c:forEach>
						</jsp:useBean>
					</select>
					<label>Responsável técnico</label>
					<select name="responsavelTecnico">
						<option value="${projeto.responsavelTecnico.nome}" selected>${projeto.responsavelTecnico.nome}</option>
						<jsp:useBean id="responsavelTecnico" class="tg.controleprojeto.persistencia.dao.EmpregadoDAO">
							<c:forEach var="empregado" items="${responsavelTecnico.lista}">
								<c:if test="${empregado.nome != projeto.responsavelTecnico.nome}">
									<option value="${empregado.nome}">${empregado.nome}</option>
								</c:if>
							</c:forEach>
						</jsp:useBean>
					</select>	
					</div>					
					<div>
					<label>Gerência executante</label>
					<select name="gerenciaExecutante">
						<option value="${projeto.gerenciaExecutora.nome}" selected>${projeto.gerenciaExecutora.nome}</option>
						<jsp:useBean id="gerenciaExecutante" class="tg.controleprojeto.persistencia.dao.GerenciaDAO">
							<c:forEach var="gerencia" items="${gerenciaExecutante.lista}">
								<c:if test="${gerencia.nome != projeto.gerenciaExecutora.nome}">
									<option value="${gerencia.nome}">${gerencia.nome}</option>
								</c:if>
							</c:forEach>
						</jsp:useBean>
					</select>
					<label>Gerência cliente</label>
					<select name="gerenciaCliente" class="combolado">
						<option value="${projeto.gerenciaCliente.nome}" selected>${projeto.gerenciaCliente.nome}</option>
						<jsp:useBean id="gerenciaCliente" class="tg.controleprojeto.persistencia.dao.GerenciaDAO">
							<c:forEach var="gerencia" items="${gerenciaCliente.lista}">
								<c:if test="${gerencia.nome != projeto.gerenciaCliente.nome}">
									<option value="${gerencia.nome}">${gerencia.nome}</option>
								</c:if>
							</c:forEach>
						</jsp:useBean>
					</select>
					</div>
					<div>
					<label>Data de início</label>
					<input type="date" name="dataInicio" value="${projeto.dataInicio.time}"/>
					<label>Data de término</label>
					<input type="date" name="dataTermino" value="${projeto.dataFim.time}"/>
					</div>
					<label>Justificativa</label>
					<textarea name="justificativa"  placeholder="${projeto.justificativa}"></textarea>
					<label>Objetivo</label>
					<textarea name="objetivo" placeholder="${projeto.objetivo}"></textarea>
					<input type="submit" value="Alterar" />
					<input hidden="true" name="logica" value="AdicionaProjetoLogic"/>
				</form>
			</div>
		</section>
	</div>

</body>
</html>
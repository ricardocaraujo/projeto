<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Nada</title>
	<link rel="stylesheet" href="css/estilos.css">	
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="header.jsp"></c:import>
	<div class="linha">
		<section>
				<form action="mvc">
					<label>Nome do projeto</label>
					<input type="text" name="nomeProjeto"/>
					<label>Coordenador</label>
						<div >
							<select name="coordenador" class="adiciona-coordenador elementos-em-linha">
								<jsp:useBean id="coordenador" class="tg.controleprojeto.persistencia.dao.EmpregadoDAO">
									<c:forEach var="empregado" items="${coordenador.lista}">
										<option value="${empregado.nome}">${empregado.nome}</option>
									</c:forEach>
								</jsp:useBean>
							</select>
						</div>
					<input type="button" value="Adicionar" name="adiciona-coordenador">
					<label>Responsável técnico</label>
					<select name="responsavelTecnico" class="adiciona-ResponsavelTecnico elementos-em-linha">
						<jsp:useBean id="responsavelTecnico" class="tg.controleprojeto.persistencia.dao.EmpregadoDAO">
							<c:forEach var="empregado" items="${responsavelTecnico.lista}">
								<option value="${empregado.nome}">${empregado.nome}</option>
							</c:forEach>
						</jsp:useBean>
					</select> 
					<input type="button" value="Adicionar" name="adiciona-ResponsavelTecnico">	
					<label>Gerência executante</label>
					<select name="gerenciaExecutante">
						<jsp:useBean id="gerenciaExecutante" class="tg.controleprojeto.persistencia.dao.GerenciaDAO">
							<c:forEach var="gerencia" items="${gerenciaExecutante.lista}">
								<option value="${gerencia.nome}">${gerencia.nome}</option>
							</c:forEach>
						</jsp:useBean>
					</select>
					<input type="button" value="Adicionar" id="botao-adiciona-gerExecutante">
					<label>Gerência cliente</label>
					<select name="gerenciaCliente">
						<jsp:useBean id="gerenciaCliente" class="tg.controleprojeto.persistencia.dao.GerenciaDAO">
							<c:forEach var="gerencia" items="${gerenciaCliente.lista}">
								<option value="${gerencia.nome}">${gerencia.nome}</option>
							</c:forEach>
						</jsp:useBean>
					</select>
					<input type="button" value="Adicionar" id="botao-adiciona-gerCliente">
					<div class="datas-em-linha">
						<label>Data de início</label>
						<input type="date" name="dataInicio"/>
					</div>
					<div class="datas-em-linha">
						<label>Data de término</label>
						<input type="date" name="dataTermino"/>
					</div>
					<label>Justificativa</label>
					<textarea name="justificativa"></textarea>
					<label>Objetivo</label>
					<textarea name="objetivo"></textarea>
					<input type="submit" value="Gravar" />
					<input hidden="true" name="logica" value="AdicionaProjetoLogic"/>
				</form>
		</section>
	</div>
	<script src="js/jquery-2.1.4.js"></script>
	<script>
	$("input[type=button]").on("click", function () {
		var botao = $(this).attr("name");
		var novoselect = $("." + botao + ":last").clone();
		novoselect.insertAfter("." + botao + ":last");
		});
	$("#botao-remove-coordenador").on("click", function () {	
		$(".coordenador > select:last").remove();
		});
	</script>
</body>
</html>

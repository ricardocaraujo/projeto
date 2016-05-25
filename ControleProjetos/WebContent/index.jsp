<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/estilos.css">
	<script src="js/jquery-2.1.4.js"></script>
	<script src="js/javascript.js"></script>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<div class="header">
		<div class="linha">
			<header>
				<div class="coluna col1">
					<h1>Sistema de Gerenciamento de Projetos</h1>
					<h2>EP-EXP/GEOF/TG | Tecnologia Geofísica</h2>
				</div>
				<div class="coluna col1">
					<nav>
						<ul>
							<li><a href="adiciona-projeto.jsp">PROJETOS</a></li>
							<li><a href="adiciona-empregado.html">EMPREGADOS</a></li>
							<li><a href="">GERÊNCIAS</a></li>
						</ul>
					</nav>
				</div>
			</header>
		</div>
	</div>
	<div class="conteudo">
		<div class="linha">
			<section>
				<div class="coluna col3">
					<nav>
						<ul class="menu">
							<li><a href="">PROJETOS</a>
								<nav>
									<ul class="menu submenu">
										<li><a href="?pagina=adiciona-projeto">ADICIONAR PROJETO</a></li>
										<li><a href="">EDITAR PROJETO</a></li>
										<li><a href="?pagina=lista-projetos">LISTAR PROJETOS</a></li>
										<li><a href="">REMOVER PROJETO</a></li>
									</ul>
								</nav>
							</li>
							<li><a href="">EMPREGADOS</a>
								<nav>
									<ul class="menu submenu">
										<li><a href="">ADICIONAR EMPREGADO</a></li>
										<li><a href="">EDITAR EMPREGADO</a></li>
										<li><a href="">LISTAR EMPREGADOS</a></li>
										<li><a href="">REMOVER EMPREGADO</a></li>
									</ul>
								</nav>
							</li>
							<li><a href="">GERÊNCIA</a>
								<nav>
									<ul class="menu submenu">
										<li><a href="">ADICIONAR GERÊNCIA</a></li>
										<li><a href="">EDITAR GERÊNCIA</a></li>
										<li><a href="">LISTAR GERÊNCIA</a></li>
										<li><a href="">REMOVER GERÊNCIA</a></li>
									</ul>
								</nav>
							</li>
						</ul>
					</nav>
				</div>
				<div class="coluna col4">
					<c:choose>
						<c:when test="${param.pagina == 'adiciona-projeto'}">
							<c:import url="adiciona-projeto.jsp"></c:import>
						</c:when>
						<c:when test="${param.pagina == 'lista-projetos'}">
							<c:import url="lista-projetos.jsp"></c:import>
						</c:when>
					</c:choose>	
				</div>
			</section>
		</div>
	</div>

</body>
</html>
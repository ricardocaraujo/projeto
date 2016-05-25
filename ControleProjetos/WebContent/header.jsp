<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="linha botaomenu">
		<header>
			<div>
				<h1>Sistema de Gerenciamento de Projetos</h1>
				<h2>EP-EXP/GEOF/TG | Tecnologia Geofísica</h2>
			</div>
			<div class="menu">
				<nav>		
					<div class="btn-group">
						<button type="button" class="btn btn-default">Projeto</button>
						<button type="button" class="btn btn-default dropdown-toggle" 
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="caret"></span>
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="adiciona-projeto.jsp">Criar</a></li>
							<li><a href="#">Editar</a></li>
							<li><a href="#">Excluir</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-default">Empregado</button>
						<button type="button" class="btn btn-default dropdown-toggle" 
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="caret"></span>
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Criar</a></li>
							<li><a href="#">Editar</a></li>
							<li><a href="#">Excluir</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-default">Gerência</button>
						<button type="button" class="btn btn-default dropdown-toggle" 
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="caret"></span>
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Criar</a></li>
							<li><a href="#">Editar</a></li>
							<li><a href="#">Excluir</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-default">Relatórios</button>
						<button type="button" class="btn btn-default dropdown-toggle" 
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="caret"></span>
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="lista-projetos.jsp">Listar Projetos</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</header>
	</div>
	<script src="js/jquery-2.1.4.js"></script>
	<script src="css/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</body>
</html>
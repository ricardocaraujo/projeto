<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="linha">
		<form action="mvc">
			Usu�rio: <input type="text" name="nome">
			Senha:   <input type="password" name="senha">
			<input type="submit" value="Logar">
			<input hidden="true" name="logica" value="LoginLogic"/>
		</form>
	</div>

</body>
</html>
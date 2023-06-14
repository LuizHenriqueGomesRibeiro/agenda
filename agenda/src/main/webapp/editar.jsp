<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="estilos/editar.css">
<script type="text/javascript" src="script/jquery-3.7.0.js"></script>
<script type="text/javascript" src="script/jquery.validate.js"></script>
<script type="text/javascript"src="jquery.js"></script>
</head>
<body>
	<header>
		<div class="titulo">
			<h1>Agenda</h1>
		</div>
		<div class="logo">
			<img src="estilos/imagens/icon-ga222ecfd9_1280.png" alt="" width="38px">
		</div>
	</header>
	<main>
		<div>
			<h2>Editar contato</h2>
			<form action="update" name="frmContato" id="formulario">
				<p>Id:</p>
				<input type="text" name="idcon" readonly value="<%out.print(request.getAttribute("idcon"));%>"><br>
				<p>Nome:</p>
				<input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"><br>
				<p>Telefone:</p>
				<input type="text" name="fone" value="<%out.print(request.getAttribute("fone"));%>"><br>
				<p>E-mail:</p>
				<input type="text" name="email" value="<%out.print(request.getAttribute("email"));%>"><br>
				
                <input type="submit" value="Salvar" class="botao" onclick="validar()" id="button">
			</form>
		</div>
	</main>
	<footer>
		<div>
			<p>
				Por Luiz Henrique Gomes Ribeiro. Programa desenvolvido no curso<a
				href="https://www.youtube.com/playlist?list=PLbEOwbQR9lqz9AnwhrrOLz9cz1-TxoiUg">
				Java Web</a>.
			</p>
		</div>
	</footer>
</body>
</html>
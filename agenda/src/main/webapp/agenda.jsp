<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="estilos/agenda.css">
<script type="text/javascript"src="script/jquery.js"></script>
<script type="text/javascript" src="script/jquery-3.7.0.js"></script>
<script type="text/javascript" src="script/jquery.validate.js"></script>
</head>
<body>
	<header>
		<div class="titulo">
			<h1>AGENDA</h1>
		</div>
		<div class="logo">
			<img src="estilos/imagens/icon-ga222ecfd9_1280.png" alt=""
				width="38px">
		</div>
	</header>
	<main>
		<div>
			<a href="novo.html">NOVO CONTATO</a>
		</div>
		<aside>
			<table>
				<thead>
					<tr>
						<th class="idcon">Id</th>
                        <th class="nome">Nome</th>
                        <th class="fone">Fone</th>
                        <th class="email">Email</th>
                        <th class="opcoes">Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getFone()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td>
							<a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="editar">Editar</a>
							<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class="excluir">Excluir</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</aside>
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
package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns= {"/main","/insert","/select","/update","/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao=new DAO();
	JavaBeans contato=new JavaBeans();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getServletPath();
		if(action.equals("/main")) {
			contatos(request,response);
		}
		else if(action.equals("/insert")) {
			novo(request,response);
		}
		else if(action.equals("/select")) {
			listar(request,response);
		}
		else if(action.equals("/update")) {
			editar(request,response);
		}
		else if(action.equals("/delete")) {
			excluir(request,response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> lista=dao.listar();
		
		request.setAttribute("contatos", lista);
		RequestDispatcher rd=request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.inserir(contato);
		response.sendRedirect("main");
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon=request.getParameter("idcon");
		contato.setIdcon(idcon);
		dao.selecionar(contato);

		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		
		RequestDispatcher rd=request.getRequestDispatcher("editar.jsp");
		rd.forward(request,response);
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.alterar(contato);
		
		response.sendRedirect("main");
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon=request.getParameter("idcon");
		contato.setIdcon(idcon);
		dao.deletar(contato);
		response.sendRedirect("main");
	}
}

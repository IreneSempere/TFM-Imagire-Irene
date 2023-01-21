package com.ireneokami.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorServlet
 */
@WebServlet("/ControladorServlet") 
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControladorServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//se obtienen los productos del modelo
		String [] productos={"Diorama1","collar3","mesa2","diorama4"};
		
		//guarda los productos obtenidos en un atributo del request
		request.setAttribute("lista_productos", productos);
		
		//selecciona la vista que pintará los datos recopilados
		RequestDispatcher miDespatcher=request.getRequestDispatcher("/VistaJSP.jsp");
		
		//envia información al archivo jsp indicado arriba
		miDespatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

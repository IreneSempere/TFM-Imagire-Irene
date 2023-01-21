package com.ireneokami.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class servletDB
 */
@WebServlet("/servletDB")
public class servletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Definir o establecer el DataSource
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Crear el objeto PrintWriter
		PrintWriter salida=response.getWriter();
		
		response.setContentType("text/plain");
		
		//Crear conexión con BBDD
		Connection conexionBD=null;
		
		Statement miStatement=null;
		
		ResultSet miResultset=null;
		
		try {
			//Obtener conexión con BBDD
			conexionBD=miPool.getConnection();
			
			//Obtener los datos de la BBDD
			String miSql="SELECT * FROM PRODUCTOS";
			
			//Dar valor al statement
			miStatement=conexionBD.createStatement();
			
			//Ejecutar las sentencias sql
			miResultset=miStatement.executeQuery(miSql);
			
			while(miResultset.next()) {
				
				String nombre_articulo=miResultset.getString(3);
				
				salida.println("nombre articulo: " + nombre_articulo);
			}
			
		}catch(Exception e) {
			//Imprime en consola el error
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

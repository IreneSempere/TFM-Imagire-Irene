package com.ireneokami.productos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorOfertas")
public class ControladorOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/imagirebd")
	private DataSource miPool;
	
	
	//Método para arrancar la página
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			modeloProductos=new ModeloProductos(miPool);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		obtenerProducto(request, response);
	}

	

	private void obtenerProducto(HttpServletRequest request, HttpServletResponse response) {
		
		List<Producto> productos;
				
				try {			
					// Obtener lista de productos desde el modelo
					productos= modeloProductos.getProductosEnOfertaByTipoProducto(request.getParameter("tipo_producto"));//el parametro tipo_producto se usa para filtrar los productos por su tipo					
					
					// Agregar lista de productos al request
					request.setAttribute("LISTA_PRODUCTOS", productos);
					
					// Enviar request a la página JSP
					RequestDispatcher miDispatcher=request.getRequestDispatcher("/ofertas.jsp");
					miDispatcher.forward(request, response);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}

}

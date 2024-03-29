package com.imagire.controladores;

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

import com.imagire.dao.ProductosDao;
import com.imagire.vo.Producto;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorOfertas")
public class ControladorOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductosDao modeloProductos;
	
	@Resource(name="jdbc/imagirebd")
	private DataSource miPool;
	
	
	/**
	 * Arranca la página
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			modeloProductos=new ProductosDao(miPool);
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

	
	/**
	 * Obtiene una lista de producto de la base de datos y los manda a la vista. Permite con el parámetro tipo_producto filtrar los productos por su tipo. Además solo mostrará productos en oferta
	 * @param request objeto donde se recoge la petición del cliente
	 * @param response objeto con el que responderá el servlet al cliente
	 */
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

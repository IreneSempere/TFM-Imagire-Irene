package com.ireneokami.productos;

import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet("/ControladorGestionProductos")
public class ControladorGestionProductos extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// Leer el parámetro del formulario
		String parametroFormInsercion=request.getParameter("instruccion");	//insertarEnBD (crear un producto), (eliminar uno), modificar uno, listar todos
		
		// Si no se envía el parámetro, listar productos
		if(parametroFormInsercion==null) parametroFormInsercion="listar";
		
		// Redirigir el flujo de ejecución al método adecuado
		switch(parametroFormInsercion) {
		
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarEnBD":
			insertarProducto(request, response);
			break;
		case "cargarPorID":
			try {
				cargarProductoPorID(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "actualizarBDyListar":
			try {
				actualizarProducto(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "eliminarPorID":
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			obtenerProductos(request, response);
			
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Leer el parámetro del formulario
		String parametroFormInsercion=request.getParameter("instruccion");	//insertarEnBD (crear un producto), (eliminar uno), modificar uno, listar todos
		
		// Si no se envía el parámetro, listar productos
		if(parametroFormInsercion==null) parametroFormInsercion="listar";
		
		// Redirigir el flujo de ejecución al método adecuado
		switch(parametroFormInsercion) {
		
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarEnBD":
			insertarProducto(request, response);
			break;
		case "cargarPorID":
			try {
				cargarProductoPorID(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "actualizarBDyListar":
			try {
				actualizarProducto(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "eliminarPorID":
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			obtenerProductos(request, response);
			
		}
	}
	
	
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Leer id del producto a eliminar
		int idProducto=Integer.parseInt(request.getParameter("IDproducto"));
		
		// Borrar producto de BD
		modeloProductos.eliminarProducto(idProducto);
		
		// Volver al listado
		obtenerProductos(request, response);
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Leer los datos que le vienen del formulario de modificar
		int idProducto=Integer.parseInt(request.getParameter("IDproducto"));
		String tipoProducto=request.getParameter("tipo_producto");
		String nombreProducto=request.getParameter("nombre_producto");
		String descripcionProducto=request.getParameter("descripcion_producto");
		float precioProducto=Float.parseFloat(request.getParameter("precio_producto"));
		float ofertaProducto=Float.parseFloat(request.getParameter("oferta_producto"));
		int stockProducto=Integer.parseInt(request.getParameter("stock_producto"));
		String pathImgProducto=request.getParameter("img_producto");
		
		// Crear un objeto de tipo producto con la info del formulario
		Producto productoActualizado= new Producto(idProducto, nombreProducto, descripcionProducto, precioProducto, ofertaProducto, stockProducto, tipoProducto, null, pathImgProducto);
		
		// Actualizar la BD con la info actualizada
		modeloProductos.actualizarProducto(productoActualizado);
		
		// Volver al listado actualizado
		obtenerProductos(request, response);

	}
	
	private void cargarProductoPorID(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Leer el ID del artículo mediante el listado
		String IDproducto=request.getParameter("IDproducto");
		
		// Enviar el ID al modelo para obtener el producto de dicho ID
		Producto elProductoPorID=modeloProductos.getProducto(IDproducto);
		
		// Almacenar el producto obtenido en un atributo para enviarlo al jsp
		request.setAttribute("productoModificar", elProductoPorID);
		
		// Enviar el producto al formulario Modificar
		RequestDispatcher dispatcher=request.getRequestDispatcher("/modificar_producto.jsp");
		
		dispatcher.forward(request, response);
	}	
	
	private void insertarProducto(HttpServletRequest request, HttpServletResponse response) {
		
		// Leer la información del producto que viene del formulario
		String tipoProducto=request.getParameter("tipo_producto");
		String nombreProducto=request.getParameter("nombre_producto");
		String descripcionProducto=request.getParameter("descripcion_producto");
		float precioProducto=Float.parseFloat(request.getParameter("precio_producto"));
		float ofertaProducto=Float.parseFloat(request.getParameter("oferta_producto"));
		int stockProducto=Integer.parseInt(request.getParameter("stock_producto"));
		String pathImgProducto=request.getParameter("img_producto");
			
		// Crear un objeto de tipo producto
		Producto nuevoProducto= new Producto(nombreProducto, descripcionProducto, precioProducto, ofertaProducto, stockProducto, tipoProducto, pathImgProducto);
		
		// Enviar el objeto al modelo y después insertarlo en base de datos
		try {
			modeloProductos.insertarNuevoProducto(nuevoProducto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Volver al listado de productos para comprobación
		obtenerProductos(request, response);
	}
	
	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		
		List<Producto> productos;
				
				try {			
					
					if(request.getParameter("instruccion")==null) { // Filtrar por tipo de producto solo si instruccion no tiene parametro
						// Obtener lista de productos desde el modelo
						productos= modeloProductos.getProductosByTipoProducto(request.getParameter("tipo_producto"));//el parametro tipo_producto se usa para filtrar los productos por su tipo
					}else {
						productos= modeloProductos.getProductosByTipoProducto(null);//el parametro tipo_producto se usa para filtrar los productos por su tipo
					}
					// Agregar lista de productos al request
					request.setAttribute("LISTA_PRODUCTOS", productos);
				
					// Enviar request a la página JSP
					RequestDispatcher miDispatcher=request.getRequestDispatcher("/gestion_productos.jsp");
					miDispatcher.forward(request, response);
				
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}

}

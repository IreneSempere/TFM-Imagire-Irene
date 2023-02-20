package com.imagire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.imagire.vo.Producto;

//Esta clase se utiliza para realizar el CRUD de los productos de la BBDD
public class ProductosDao {
	
	//extrae del context.xml los datos para poder acceder a la BBDD
	@Resource(name="jdbc/imagirebd")
	private DataSource miPool;
	
	
	
	public ProductosDao(DataSource miPool) {
		
		this.miPool=miPool;
	}
	
	//Método para obtener los productos de la base de datos
	public List<Producto> getProductosByTipoProducto(String filtroTipoProducto) throws Exception{
		
		List<Producto> productos=new ArrayList<>();
		
		Connection conexionBD=null;
		Statement miStatement=null;
		ResultSet miResultset=null;
		
		//-----------establecer la conexión--------------
		conexionBD=miPool.getConnection();
				
		//-----------crear sentencia sql-----------------
		String instruccionSql="SELECT * FROM PRODUCTOS";
		if(filtroTipoProducto != null) {
			instruccionSql+=" WHERE TIPO_PRODUCTO='" + filtroTipoProducto + "'";
		}
		miStatement=conexionBD.createStatement();
		
		//----------------ejecutar sql-------------------
		miResultset=miStatement.executeQuery(instruccionSql);

		//--------recorrer el resultset obtenido para obtener los datos en java---------
		while(miResultset.next()) {
			
			int id=miResultset.getInt("ID_PRODUCTO");
			String nombre=miResultset.getString("NOMBRE");
			String descripcion=miResultset.getString("DESCRIPCION");
			float precio=miResultset.getFloat("PRECIO");
			float precioOferta=miResultset.getFloat("PRECIO_OFERTA");
			int stock=miResultset.getInt("STOCK");
			String tipoProducto=miResultset.getString("TIPO_PRODUCTO");
			Date fecha=miResultset.getDate("FECHA_LANZAMIENTO");
			String pathImg=miResultset.getString("PATH_IMG");
			
			Producto productoTemporal=new Producto(id,nombre,descripcion,precio,precioOferta,stock,tipoProducto,fecha,pathImg);
			
			productos.add(productoTemporal);
		}
		conexionBD.close();
		return productos;

	}
	
	//Método para obtener los productos en oferta y por tipo de producto de la base de datos
	public List<Producto> getProductosEnOfertaByTipoProducto(String filtroTipoProducto) throws Exception{
		
		List<Producto> productos=new ArrayList<>();
		
		Connection conexionBD=null;
		Statement miStatement=null;
		ResultSet miResultset=null;
		
		//-----------establecer la conexión--------------
		conexionBD=miPool.getConnection();
			
		//-----------crear sentencia sql-----------------
		String instruccionSql="SELECT * FROM PRODUCTOS WHERE PRECIO_OFERTA IS NOT NULL AND PRECIO_OFERTA >0.0";
		if(filtroTipoProducto != null) {
			instruccionSql+=" AND TIPO_PRODUCTO= '" + filtroTipoProducto + "'";
		}
		
		miStatement=conexionBD.createStatement();
		
		//----------------ejecutar sql-------------------
		miResultset=miStatement.executeQuery(instruccionSql);

		//--------recorrer el resultset obtenido para obtener los datos en java---------
		while(miResultset.next()) {
			
			int id=miResultset.getInt("ID_PRODUCTO");
			String nombre=miResultset.getString("NOMBRE");
			String descripcion=miResultset.getString("DESCRIPCION");
			float precio=miResultset.getFloat("PRECIO");
			float precioOferta=miResultset.getFloat("PRECIO_OFERTA");
			int stock=miResultset.getInt("STOCK");
			String tipoProducto=miResultset.getString("TIPO_PRODUCTO");
			Date fecha=miResultset.getDate("FECHA_LANZAMIENTO");
			String pathImg=miResultset.getString("PATH_IMG");
			
			Producto productoTemporal=new Producto(id,nombre,descripcion,precio,precioOferta,stock,tipoProducto,fecha,pathImg);
			
			productos.add(productoTemporal);
		}
		conexionBD.close();
		return productos;

	}
	
	//Añadir producto a la BD
	public void insertarNuevoProductoEnBBDD(Producto nuevoProducto) throws SQLException {
		
		Connection conexionBD=null;
		PreparedStatement preparedStatement = null;
		
		//-----------establecer la conexión--------------
		conexionBD=miPool.getConnection();
				
		//-----------crear sentencia sql-----------------
		//Con PreparedStatement
		String instruccionSql="INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, STOCK, PRECIO, PRECIO_OFERTA, TIPO_PRODUCTO, PATH_IMG) "
				+ "VALUES (?,?,?,?,?,?,?);";
		
		preparedStatement = conexionBD.prepareStatement(instruccionSql);
		
		preparedStatement.setString(1, nuevoProducto.getNombre());
		preparedStatement.setString(2, nuevoProducto.getDescripcion());
		preparedStatement.setInt(3, nuevoProducto.getStock());
		preparedStatement.setFloat(4, nuevoProducto.getPrecio());
		preparedStatement.setFloat(5, nuevoProducto.getPrecioOferta());
		preparedStatement.setString(6, nuevoProducto.getTipoProducto());
		preparedStatement.setString(7, nuevoProducto.getPathImg());

		//----------------ejecutar sql-------------------
		preparedStatement.execute();

		conexionBD.close();

	}

	public Producto getProducto(String IDproducto) throws Exception {
		
		Producto productoObtenidoDeBD=null;
				
		Connection conexionBD=null;
		PreparedStatement miStatement = null;
		ResultSet miResultset=null;
		
		try {
			
			// Establecer conexion con la BD
			conexionBD=miPool.getConnection();
					
			// Crear sql que nos servirá para buscar el producto mediante id en la BD
			String instruccionSql="SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO=?";	
			
			// Asigna la instrucción al statement
			miStatement=conexionBD.prepareStatement(instruccionSql);
			
			// Establecer los parámetros del statement que sustituye la "?" 
			miStatement.setString(1, IDproducto);
			
			// Ejecuta la consulta en la BD con la instrucción y parámetros asignados
			miResultset=miStatement.executeQuery();
			
			// Obtener los datos de respuesta
			if(miResultset.next()) { //next apunta a los datos de la fila correspondiente al producto buscado
				
				int id=miResultset.getInt("ID_PRODUCTO");
				String nombre=miResultset.getString("NOMBRE");
				String descripcion=miResultset.getString("DESCRIPCION");
				float precio=miResultset.getFloat("PRECIO");
				float precioOferta=miResultset.getFloat("PRECIO_OFERTA");
				int stock=miResultset.getInt("STOCK");
				String tipoProducto=miResultset.getString("TIPO_PRODUCTO");
				Date fecha=miResultset.getDate("FECHA_LANZAMIENTO");
				String pathImg=miResultset.getString("PATH_IMG");
				
				productoObtenidoDeBD=new Producto(id,nombre,descripcion,precio,precioOferta,stock,tipoProducto,fecha,pathImg);
			}else {
				throw new Exception("No se ha encontrado ningún producto con id " + IDproducto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		conexionBD.close();

		return productoObtenidoDeBD;
		
	}

	public void actualizarProducto(Producto productoActualizado) throws Exception {
		
		// Establecer conexion con BD
		
		Connection conexionBD=null;
		PreparedStatement miStatement = null;
		
		conexionBD=miPool.getConnection();
		
		// Crear sentencia sql
		String sql="UPDATE PRODUCTOS SET NOMBRE=?, DESCRIPCION=?, PRECIO=?, PRECIO_OFERTA=?, STOCK=?, TIPO_PRODUCTO=? WHERE ID_PRODUCTO=?";
		
		// Crear la consulta preparada
		miStatement=conexionBD.prepareStatement(sql);
		
		// Establecer los parametros
		miStatement.setString(1, productoActualizado.getNombre());
		miStatement.setString(2, productoActualizado.getDescripcion());
		miStatement.setFloat(3, productoActualizado.getPrecio());
		miStatement.setFloat(4, productoActualizado.getPrecioOferta());
		miStatement.setInt(5, productoActualizado.getStock());
		miStatement.setString(6, productoActualizado.getTipoProducto());
		miStatement.setInt(7, productoActualizado.getId());
//		miStatement.setString(7, productoActualizado.getPathImg());
		
		// Ejecutar la instruccion sql
		miStatement.executeUpdate();
		
		conexionBD.close();
	}
	
	public void eliminarProducto(int idProducto) throws SQLException {
		
		Connection conexionBD=null;
		PreparedStatement miStatement = null;
		
		// Establecer conexion con BD
		conexionBD=miPool.getConnection();
		
		// Crear instruccion sql
		String sql="DELETE FROM PRODUCTOS WHERE ID_PRODUCTO=?";
		
		// Preparar la consulta
		miStatement=conexionBD.prepareStatement(sql);
		
		// Establecer parametros
		miStatement.setInt(1, idProducto);

		// Ejecutar secuencia sql
		miStatement.execute();
		
		conexionBD.close();
	}
	


	
}

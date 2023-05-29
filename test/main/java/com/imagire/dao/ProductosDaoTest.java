package com.imagire.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.imagire.vo.Producto;

public class ProductosDaoTest {

    private DataSource mockPool;
    private Connection mockConexion;
    private Statement mockStatement;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultset;
    
    
    @BeforeEach
    void setup() throws Exception {
        mockPool = mock(DataSource.class);
        mockConexion = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockResultset = mock(ResultSet.class);
        mockPreparedStatement = mock(PreparedStatement.class);

        // Simular la conexión y la sentencia SQL
        when(mockPool.getConnection()).thenReturn(mockConexion);
        when(mockConexion.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockConexion.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultset);
        when(mockPreparedStatement.execute()).thenReturn(true);
        when(mockPreparedStatement.executeUpdate()).thenReturn(3);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultset);
        Mockito.doNothing().when(mockConexion).close();
    }

    @Test
    void testGetProductosByTipoProductoConFiltroPorTipo() throws Exception {
        // Simular el resultado obtenido de la base de datos
        when(mockResultset.next()).thenReturn(true).thenReturn(false);
        when(mockResultset.getInt("ID_PRODUCTO")).thenReturn(1);
        when(mockResultset.getString("NOMBRE")).thenReturn("Producto1");
        when(mockResultset.getString("DESCRIPCION")).thenReturn("Descripción del producto 1");
        when(mockResultset.getFloat("PRECIO")).thenReturn(10.0f);
        when(mockResultset.getFloat("PRECIO_OFERTA")).thenReturn(8.0f);
        when(mockResultset.getInt("STOCK")).thenReturn(5);
        when(mockResultset.getString("TIPO_PRODUCTO")).thenReturn("Tipo1");
        when(mockResultset.getDate("FECHA_LANZAMIENTO")).thenReturn(new Date(1684141056000l));
        when(mockResultset.getString("PATH_IMG")).thenReturn("path");

        ProductosDao dao = new ProductosDao(mockPool);

        // Llamar al método "getProductosByTipoProducto" con el filtro deseado
        List<Producto> productos = dao.getProductosByTipoProducto("Tipo1");

        // 5. Verificar que el resultado obtenido es el esperado
        assertEquals(1, productos.size());
        assertEquals("Producto1", productos.get(0).getNombre());
        assertEquals("Descripción del producto 1", productos.get(0).getDescripcion());
        assertEquals(10.0f, productos.get(0).getPrecio(), 0.001f);
        assertEquals(8.0f, productos.get(0).getPrecioOferta(), 0.001f);


	    assertEquals(5, productos.get(0).getStock());
	    assertEquals("Tipo1", productos.get(0).getTipoProducto());
	    assertEquals(new Date(1684141056000l), productos.get(0).getFecha());
	    assertEquals("path", productos.get(0).getPathImg());
    }

	@Test
	void testGetProductosByTipoProductoTipoNuloYDosIteraciones() throws Exception {
	    // Simular el resultado obtenido de la base de datos
	    when(mockResultset.next()).thenReturn(true, true, false);
	    when(mockResultset.getInt("ID_PRODUCTO")).thenReturn(1, 2);
	    when(mockResultset.getString("NOMBRE")).thenReturn("Producto1", "Producto2");
	    when(mockResultset.getString("DESCRIPCION")).thenReturn("Descripción del producto 1", "Descripción del producto 2");
	    when(mockResultset.getFloat("PRECIO")).thenReturn(10.0f, 20.0f);
	    when(mockResultset.getFloat("PRECIO_OFERTA")).thenReturn(8.0f, 15.0f);
	    when(mockResultset.getInt("STOCK")).thenReturn(5, 1);
	    when(mockResultset.getString("TIPO_PRODUCTO")).thenReturn("Tipo1", "Tipo2");
	    when(mockResultset.getDate("FECHA_LANZAMIENTO")).thenReturn(new Date(1684141056000l), new Date(2684141056000l));
	    when(mockResultset.getString("PATH_IMG")).thenReturn("path", "path2");
	
	    ProductosDao dao = new ProductosDao(mockPool);
	
	    // Llamar al método "getProductosByTipoProducto" sin ningún filtro
	    List<Producto> productos = dao.getProductosByTipoProducto(null);
	
	    // Verificar que el resultado obtenido es el esperado
	    assertEquals(2, productos.size());
	
	    assertEquals("Producto1", productos.get(0).getNombre());
	    assertEquals("Descripción del producto 1", productos.get(0).getDescripcion());
	    assertEquals(10.0f, productos.get(0).getPrecio(), 0.001f);
	    assertEquals(8.0f, productos.get(0).getPrecioOferta(), 0.001f);
	    assertEquals(5, productos.get(0).getStock());
	    assertEquals("Tipo1", productos.get(0).getTipoProducto());
	    assertEquals(new Date(1684141056000l), productos.get(0).getFecha());
	    assertEquals("path", productos.get(0).getPathImg());
	
	    // Verificar que el resultado de la iteración obtenido es el esperado
	    assertEquals("Producto2", productos.get(1).getNombre());
	    assertEquals("Descripción del producto 2", productos.get(1).getDescripcion());
	    assertEquals(20.0f, productos.get(1).getPrecio(), 0.001f);
	    assertEquals(15.0f, productos.get(1).getPrecioOferta(), 0.001f);
	    assertEquals(1, productos.get(1).getStock());
	    assertEquals("Tipo2", productos.get(1).getTipoProducto());
	    assertEquals(new Date(2684141056000l), productos.get(1).getFecha());
	    assertEquals("path2", productos.get(1).getPathImg());
	}
    
	@Test
    void testGetProductosByTipoProductoSinDatos() throws Exception {
        // Simular el resultado obtenido de la base de datos
        when(mockResultset.next()).thenReturn(false);
        
        ProductosDao dao = new ProductosDao(mockPool);

        // Llamar al método "getProductosByTipoProducto" con el filtro deseado
        List<Producto> productos = dao.getProductosByTipoProducto("Tipo1");

        // Verificar que el resultado obtenido es el esperado
        assertEquals(0, productos.size());
        
    }
	
	@Test
	public void testInsertarNuevoProductoEnBBDD() throws SQLException {
			
        // Llamar al método "insertarNuevoProductoEnBBDD" con el producto creado
        Producto producto = new Producto();
        producto.setNombre("resina");
        producto.setDescripcion("Esta es la resina");
        producto.setStock(2);
        producto.setPrecio(33);
        producto.setPrecioOferta(22);
        producto.setPathImg("Ruta");
        producto.setTipoProducto("Diorama");
        
        ProductosDao dao = new ProductosDao(mockPool);
        
        boolean ejecutado = dao.insertarNuevoProductoEnBBDD(producto);

        // Verificar que el resultado obtenido es el esperado
        assertEquals(true, ejecutado);			
	}
	
	@Test
	public void testGetProducto() throws SQLException {
		
		String idProducto = "1234";
		
		when(mockResultset.next()).thenReturn(true);
	    when(mockResultset.getInt("ID_PRODUCTO")).thenReturn(1234);
	    when(mockResultset.getString("NOMBRE")).thenReturn("Cuadro marina");
	    when(mockResultset.getString("DESCRIPCION")).thenReturn("Cuadro marina 2x2");
	    when(mockResultset.getFloat("PRECIO")).thenReturn(20.5f);
	    when(mockResultset.getFloat("PRECIO_OFERTA")).thenReturn(15f);
	    when(mockResultset.getInt("STOCK")).thenReturn(3);
	    when(mockResultset.getString("TIPO_PRODUCTO")).thenReturn("Cuadro");
	    when(mockResultset.getDate("FECHA_LANZAMIENTO")).thenReturn(new Date (2684141056000l));
	    when(mockResultset.getString("PATH_IMG")).thenReturn("Path 5");
	    
	    Producto productoEsperado = new Producto (1234,"Cuadro marina","Cuadro marina 2x2",20.5f,15f,3,"Cuadro",new Date (2684141056000l),"Path 5");
	    
	    ProductosDao dao = new ProductosDao(mockPool);
	    
	    Producto productoObtenido =  dao.getProducto(idProducto);
	    
	    // Verificar que el resultado obtenido es el esperado
        assertEquals(productoEsperado, productoObtenido);
	}
	
	@Test
	public void testActualizarProducto() throws SQLException {
		
		// Llamar al método "actualizarProducto" con el producto creado
        Producto productoAActualizar = new Producto();
        productoAActualizar.setNombre("resina");
        productoAActualizar.setDescripcion("Esta es la resina");
        productoAActualizar.setStock(2);
        productoAActualizar.setPrecio(33);
        productoAActualizar.setPrecioOferta(22);
        productoAActualizar.setPathImg("Ruta");
        productoAActualizar.setTipoProducto("Diorama");
        
        ProductosDao dao = new ProductosDao(mockPool);
        
        boolean ejecutado = dao.actualizarProducto(productoAActualizar);

        // Verificar que el resultado obtenido es el esperado
        assertEquals(true, ejecutado);		
	}

	@Test
	public void testEliminarProducto() throws SQLException {
	    
		int idProducto = 1234;
		
		ProductosDao dao = new ProductosDao(mockPool);
        
        boolean ejecutado = dao.eliminarProducto(idProducto);
        
     // Verificar que el resultado obtenido es el esperado
        assertEquals(true, ejecutado);	
	}



    
}

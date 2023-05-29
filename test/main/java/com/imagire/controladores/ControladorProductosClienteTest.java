package com.imagire.controladores;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.imagire.vo.Producto;

public class ControladorProductosClienteTest {
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

        // 1. Simular la conexión y la sentencia SQL
        when(mockPool.getConnection()).thenReturn(mockConexion);
        when(mockConexion.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockConexion.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultset);
        when(mockPreparedStatement.execute()).thenReturn(true);
        Mockito.doNothing().when(mockConexion).close();
    }

    @Test
    public void testObtenerProductos() throws ServletException, IOException {
        // Crear objetos simulados para HttpServletRequest, HttpServletResponse y RequestDispatcher
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
        RequestDispatcher mockDispatcher = mock(RequestDispatcher.class);

        // Simular parámetro "tipo_producto"
        when(mockRequest.getParameter("tipo_producto")).thenReturn("tipo1");

        // Simular lista de productos desde el modelo
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto 1", "Descripción 1", 10.0f, 5, "Tipo 1"));
        productos.add(new Producto(2, "Producto 2", "Descripción 2", 20.0f, 10, "Tipo 1"));
        ModeloProductos mockModeloProductos = mock(ModeloProductos.class);
        when(mockModeloProductos.getProductosByTipoProducto("tipo1")).thenReturn(productos);

        // Configurar el método getRequestDispatcher() del mockRequest para devolver el mockDispatcher
        when(mockRequest.getRequestDispatcher("/productos.jsp")).thenReturn(mockDispatcher);

        // Crear el objeto a probar
        ControladorProductosCliente tuObjeto = new ControladorProductosCliente(mockModeloProductos);

        // Ejecutar el método a probar
        tuObjeto.obtenerProductos(mockRequest, mockResponse);

        // Verificar que se haya llamado al método getProductosByTipoProducto() del mockModeloProductos
        Mockito.verify(mockModeloProductos).getProductosByTipoProducto("tipo1");

        // Verificar que se haya llamado al método setAttribute() del mockRequest con la lista de productos
        Mockito.verify(mockRequest).setAttribute(Mockito.eq("LISTA_PRODUCTOS"), Mockito.eq(productos));

        // Verificar que se haya llamado al método getRequestDispatcher() del mockRequest con la URL adecuada
        Mockito.verify(mockRequest).getRequestDispatcher(Mockito.eq("/productos.jsp"));

        // Verificar que se haya llamado al método forward() del mockDispatcher con el mockRequest y mockResponse
        Mockito.verify(mockDispatcher).forward(Mockito.eq(mockRequest), Mockito.eq(mockResponse));
    }
}


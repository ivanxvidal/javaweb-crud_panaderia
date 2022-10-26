package com.proyectos.javaweb.crud.Modelo;

import com.proyectos.javaweb.crud.Controlador.conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class editar {

    conexion conn;
    protected static Statement statement;
    private static String PETICION_SQL;
    protected boolean salida = false;

    public editar(String codigo, String nombre, String precio) {
        PETICION_SQL = "UPDATE panaderia SET nombre='" + nombre + "',precio='" + precio + "' WHERE codigo=" + codigo;
    }

    public boolean actualizar() {
        try {
            conn = new conexion();
            statement = conn.conectar().createStatement();
            statement.executeUpdate(PETICION_SQL);
            statement.close();
            conn.desconectar();
            salida = true;
        } catch (SQLException ex) {
            salida = false;
            System.out.println(ex);
        }
        return salida;
    }

}

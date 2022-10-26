
package com.proyectos.javaweb.crud.Modelo;

import com.proyectos.javaweb.crud.Controlador.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class insertar {
    conexion conn;
    protected static Statement statement;
    protected static ResultSet resultSets;
    private static String PETICION_SQL;
    protected boolean salida = false;
    
    public insertar(String nombre, String precio){
        PETICION_SQL="INSERT INTO panaderia(codigo, nombre, precio) VALUES (NULL,'"+nombre+"',"+precio+")";
    }
    
    public Boolean agregar(){
        try {
            conn = new conexion();
            statement = conn.conectar().createStatement();
            statement.executeUpdate(PETICION_SQL);
            statement.close();
            conn.desconectar();
            salida=true;
        } catch (SQLException ex) {
            salida = false;
            System.out.println(ex);
        }        
        return salida;
    }
    
}

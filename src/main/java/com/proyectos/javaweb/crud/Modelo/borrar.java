package com.proyectos.javaweb.crud.Modelo;

import com.proyectos.javaweb.crud.Controlador.conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class borrar {
    conexion conn;
    protected static Statement statement;
    private static String PETICION_SQL;
    protected boolean salida = false;

    public borrar(String id) {
        PETICION_SQL = "DELETE FROM panaderia WHERE codigo = "+id;
    }
    private void borrar(){
         try {
             System.out.println("SQL:"+PETICION_SQL);
            conn = new conexion();
            statement = conn.conectar().createStatement();
            statement.executeUpdate(PETICION_SQL);
            
            statement.close();
            conn.desconectar();
            salida=true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            salida=false;
        }
    }
    
    public boolean estado(){
        borrar();
        return salida;
    }
}

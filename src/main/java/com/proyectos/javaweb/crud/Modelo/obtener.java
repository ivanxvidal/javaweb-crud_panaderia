package com.proyectos.javaweb.crud.Modelo;

import com.proyectos.javaweb.crud.Controlador.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class obtener {

    conexion conn;
    protected static Statement statement;
    protected static ResultSet resultSets;
    private final String PETICION_SQL = "SELECT * FROM panaderia";
    protected String info = "";

    public obtener() {
        
        try {
            conn = new conexion();
            statement = conn.conectar().createStatement();
            resultSets = statement.executeQuery(PETICION_SQL);
            while (resultSets.next()) {
                info += "\n                     <tr>\n"
                    + "                         <td>"+resultSets.getRow()+"</td>\n"
            + "                         <td>"+resultSets.getInt("codigo")+"</td>\n"
            + "                         <td>"+resultSets.getString("nombre")+"</td>\n"
            + "                         <td>"+resultSets.getString("precio")+"</td>\n"
            + "                         <td><button type=\"button\" class=\"btn btn-secondary\" onclick=\"editable("+resultSets.getInt("codigo")+",\'"+resultSets.getString("nombre")+"\',\'"+resultSets.getString("precio")+"\')\">Editar</button></td>\n"
            + "                         <td><a class=\"btn btn-danger\" href=\"eliminar?codigo="+resultSets.getInt("codigo")+" \" >Eliminar</a></td>\n"
            + "                     </tr>";
                
            }
            resultSets.close();
            statement.close();
            conn.desconectar();
            
        } catch (SQLException ex) {
            info = "Error en la obtencion de Datos";
            System.out.println(ex);
        }
        if (statement == null) {
            info = "Error en la obtencion de Datos";
        }
    }

    public String datos() {
        return info;
    }

}

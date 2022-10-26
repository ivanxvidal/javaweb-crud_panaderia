package com.proyectos.javaweb.crud.Controlador;

import com.proyectos.javaweb.crud.Modelo.bd;
import java.sql.*;

public class conexion {

    private bd base = new bd();
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection jdbcConnection;
    private String estado="Sin Conexion a BD";

    //Constructor
    public conexion() {

        try {
            if (jdbcConnection != null) {
                return;
            }
            Class.forName(this.driver);
            this.jdbcConnection = DriverManager.getConnection(base.getUrl()
                    + base.getBd(), base.getUsuario(),
                    base.getPassword());
            this.estado="Con Conexion a BD";
        } catch (SQLException | ClassNotFoundException ex) {
            this.estado="Sin Conexion a BD";
            System.out.println(ex);
        }
    }

    public Connection conectar() {
        return jdbcConnection;
    }

    public void desconectar() {
        try {
            if (jdbcConnection != null) {
                jdbcConnection.close();
                this.estado="Sin Conexion a BD";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String estado_conexion() {
        return estado;
    }

}

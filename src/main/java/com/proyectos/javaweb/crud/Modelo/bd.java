package com.proyectos.javaweb.crud.Modelo;

public class bd {

    //usuario
    private final String usuario = "root";
    private final String password = "";
    //Base de datos
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String bd = "javaweb_crud_panaderia";
    private final String tabla = "panaderia";

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getBd() {
        return bd;
    }

    public String getTabla() {
        return tabla;
    }
}

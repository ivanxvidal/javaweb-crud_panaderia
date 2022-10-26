<%-- Document : index Created on : 21 oct 2022, 15:38:51 Author : Ivan --%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.proyectos.javaweb.crud.Controlador.listar"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>CRUD-Panaderia</title>
        <link rel="icon" type="image/png" href="img/bread.png" />
        <!--CSS-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous"
            />
    </head>
    <body>
        <div class="container">
            <img src="img/bread.png" class="rounded mx-auto d-block" alt="La Panaderia" style="height: 5.5rem;">
            <h1 class="h1 text-center">La Panaderia</h1>
            
            <hr class="hr-text"/>
            <form id="formulario" method="GET" class="d-flex justify-content-center" action="agregar">
                <div class="row justify-content-center">
                    <div class="col-md-2 p-1">
                        <input id="codigo" type="hidden" name="accion" value="add"/>
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Code"
                            aria-label="Codigo"
                            name="codigo"
                            disabled
                            />
                    </div>
                    <div class="col-md-3 p-1">
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Nombre"
                            aria-label="Nombre"
                            name="nombre"
                            autocomplete="off"
                            />
                    </div>
                    <div class="col-md-2 p-1">
                        <input
                            type="text"
                            class="form-control"
                            placeholder="Precio $"
                            aria-label="Precio"
                            name="precio"
                             autocomplete="off"
                            />
                    </div>
                    <div class="col-md-4 p-1">
                        <input type="submit" class="btn btn-primary" id="agregar" value="Agregar" />
                        <input type="hidden" class="btn btn-secondary" id="cancelar" value="Cancelar" />
                    </div>
                </div>
            </form>
            <hr class="hr-text"/>
            <table class="table table-striped">
                <thead>
                    <tr class="table-dark">
                        <th scope="col">#</th>
                        <th scope="col">Code</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th class="text-center" scope="col" colspan="2">Acciones</th>
                    </tr>
                    
                </thead>
                <tbody>
                    <%
                    listar list = new listar();
                    out.println(list.listar());
                    %>
                </tbody>
            </table>
                
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"
        ></script>
        <script>
            function editable(id,nom,pre){
                document.getElementsByName("codigo")[0].value=id;
                document.getElementsByName("nombre")[0].value=nom;
                document.getElementsByName("precio")[0].value=pre;
                document.getElementById("codigo").name="codigo";
                document.getElementById("codigo").value=id;
                document.getElementById("agregar").value="Actualizar";
                document.getElementById("formulario").action="actualizar";
                document.getElementById("cancelar").type="button";
            }
            document.getElementById("cancelar").onclick=function(){
                document.getElementsByName("codigo")[0].value="";
                document.getElementsByName("nombre")[0].value="";
                document.getElementsByName("precio")[0].value="";
                document.getElementById("codigo").name="accion";
                document.getElementById("codigo").value="add";
                document.getElementById("agregar").value="Agregar";
                document.getElementById("formulario").action="agregar";
                document.getElementById("cancelar").type="hidden";
            };
        </script>
        
    </body>
</html>

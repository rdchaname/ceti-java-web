package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class Conexion {

    private Connection conexion;

    public Conexion() {
        try {
            // Paso 01: Definir los datos de conexión.
            String usuario = "root";
            String password = "root";
            String puerto = "3306"; // mysql=> 3306, pgsql=>5432
            String base = "java_web";
            String servidor = "localhost";
            // Paso 02: Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Paso 03: Definir la URL de conexión
            String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + base
                    + "?useSSL=false&serverTimezone=America/Lima";
            this.conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println(error.getMessage());
            LogManager.registrarEvento(error, "SEVERE");
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }

}

package org.ceti.sistemas.proyectoceti.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class Conexion {

    private Connection conexion;

    public Conexion() {
        try {
            // usando DOTENV
            Dotenv dotenv = Dotenv.load(); // buscar en la raiz de mi proyecto el archivo .env
            
            // Paso 01: Definir los datos de conexión.
            String usuario = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");
            String puerto = dotenv.get("DB_PORT"); // mysql=> 3306, pgsql=>5432
            String base = dotenv.get("DB_DATABASE");
            String servidor = dotenv.get("DB_HOST");
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

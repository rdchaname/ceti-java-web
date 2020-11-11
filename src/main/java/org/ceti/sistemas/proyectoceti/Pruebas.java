package org.ceti.sistemas.proyectoceti;

import org.ceti.sistemas.proyectoceti.dao.Conexion;

public class Pruebas {

    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            conexion.obtenerConexion();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}

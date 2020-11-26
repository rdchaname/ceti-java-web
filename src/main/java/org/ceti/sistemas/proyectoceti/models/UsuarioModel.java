package org.ceti.sistemas.proyectoceti.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.beans.Usuario;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.InscritoDao;
import org.ceti.sistemas.proyectoceti.dao.UsuarioDao;
import org.ceti.sistemas.proyectoceti.utils.Encriptacion;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class UsuarioModel {

    private final Connection conexion;

    public UsuarioModel() {
        Conexion conn = new Conexion();
        this.conexion = conn.obtenerConexion();
    }
    public Usuario login(String email, String password){
        UsuarioDao usuarioDao = new UsuarioDao(this.conexion);
        Usuario logeado = null;
        try {
            logeado = usuarioDao.login(email);
            if(logeado != null){
                boolean comparacion = Encriptacion.compararPassword(password, logeado.getPassword());
                if(!comparacion){
                    logeado = null;
                }
            }
        } catch (Exception e) {
            LogManager.registrarEvento(e, "SEVERE");
        }
        return logeado;
    }

    public Usuario registrar(Inscrito inscrito, Usuario usuario) {
        InscritoDao inscritoDao = new InscritoDao(this.conexion);
        UsuarioDao usuarioDao = new UsuarioDao(this.conexion);
        Usuario registrado = null;
        try {
            this.conexion.setAutoCommit(false);
            inscrito = inscritoDao.registrar(inscrito);
            usuario.setInscrito(inscrito);
            usuario.setPassword(Encriptacion.encriptarPassword(usuario.getPassword()));
            registrado = usuarioDao.registrar(usuario);
            this.conexion.commit();
        } catch (SQLException e) {
            try {
                this.conexion.rollback();
            } catch (SQLException ex) {
                LogManager.registrarEvento(ex, "SEVERE");
            }
            LogManager.registrarEvento(e, "SEVERE");
        }
        return registrado;
    }
}

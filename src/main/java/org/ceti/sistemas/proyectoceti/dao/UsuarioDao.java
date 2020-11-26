package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.beans.Usuario;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class UsuarioDao {
    
    private final Connection conexion;
    
    public UsuarioDao(Connection conexion) {
        this.conexion = conexion;
    }
    
    public Usuario login(String email) {
        Usuario usuario = null;
        try {
            String sql = "SELECT usu.password, usu.id as 'usuario_id', ins.id as 'inscrito_id', usu.email, "
                    + "ins.apellido_paterno, ins.apellido_materno, ins.nombres "
                    + "FROM usuarios usu INNER JOIN inscritos ins ON usu.inscritos_id = ins.id "
                    + "WHERE usu.email = ?";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setString(1, email);
            ResultSet resultado = prepararConsulta.executeQuery();
            while (resultado.next()) {
                usuario = new Usuario();
                Inscrito inscrito = new Inscrito();
                inscrito.setId(resultado.getInt("inscrito_id"));
                inscrito.setApellido_materno(resultado.getString("apellido_materno"));
                inscrito.setApellido_paterno(resultado.getString("apellido_paterno"));
                inscrito.setNombres(resultado.getString("nombres"));
                usuario.setInscrito(inscrito);
                usuario.setInscrito_id(resultado.getInt("inscrito_id"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setPassword(resultado.getString("password"));
            }
        } catch (SQLException e) {
            LogManager.registrarEvento(e, "SEVERE");
        }
        return usuario;
    }
    
    private Integer ultimoRegistro() {
        Integer id = null;
        try {
            String sql = "SELECT LAST_INSERT_ID()";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (SQLException error) {
            LogManager.registrarEvento(error, "SEVERE");
        }
        return id;
    }
    
    public Usuario registrar(Usuario usuario) {
        Usuario registrado = null;
        try {
            String sql = "INSERT INTO usuarios (email, password, inscritos_id) VALUES (?, ?, ?)";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setString(1, usuario.getEmail());
            prepararConsulta.setString(2, usuario.getPassword());
            prepararConsulta.setInt(3, usuario.getInscrito().getId());
            Integer resultado = prepararConsulta.executeUpdate();
            if (resultado > 0) {
                registrado = usuario;
                registrado.setId(this.ultimoRegistro());
            }
        } catch (SQLException e) {
            LogManager.registrarEvento(e, "SEVERE");
        }
        return registrado;
    }
}

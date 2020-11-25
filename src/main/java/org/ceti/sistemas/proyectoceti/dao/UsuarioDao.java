package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.ceti.sistemas.proyectoceti.beans.Usuario;

public class UsuarioDao {
    
    private final Connection conexion;
    
    public UsuarioDao(){
        Conexion con = new Conexion();
        this.conexion = con.obtenerConexion();
    }
    
    public Usuario registrar(Usuario usuario){
        return usuario;
    }
    
    public Usuario login(String email, String password){
        Usuario usuario = null;
        try {
            String sql = "SELECT usu.id as 'usuario_id', ins.id as 'inscrito?id', usu.email, "
                    + "ins.apellido_paterno, ins.apellido_materno, ins.nombres "
                    + "FROM usuarios usu INNER JOIN inscrito ins ON usu.inscrito_id = ins.id "
                    + "WHERE usu.email = ? AND usu.password = ?";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while(resultado.next()){
                usuario = new Usuario();
                
            }
        } catch (SQLException e) {
        }
        return usuario;
    }
}

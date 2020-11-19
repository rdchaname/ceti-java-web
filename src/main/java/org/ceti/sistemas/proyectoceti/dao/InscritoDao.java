package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class InscritoDao {
    private final Connection conexion;
    
    public InscritoDao(){
        Conexion db = new Conexion();
        this.conexion = db.obtenerConexion();
    }
    
    private Integer ultimoRegistro(){
        Integer id = null;
        try{
            String sql = "SELECT LAST_INSERT_ID()";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while(resultado.next()){
                id = resultado.getInt(1);
            }
        }catch(SQLException error){
            LogManager.registrarEvento(error, "SEVERE");
        }
        return id;
    }
    
    public Inscrito registrar(Inscrito inscrito){
        try{
            String sql = "INSERT INTO inscritos (apellido_paterno, apellido_materno, nombres, celular)"
                    + " VALUES(?, ?, ?, ?)";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setString(1, inscrito.getApellido_paterno());
            prepararConsulta.setString(2, inscrito.getApellido_materno());
            prepararConsulta.setString(3, inscrito.getNombres());
            prepararConsulta.setString(4, inscrito.getCelular());
            Integer resultado = prepararConsulta.executeUpdate();
            if(resultado != 0){
                inscrito.setId(this.ultimoRegistro());
            }
        }catch(SQLException error){
            LogManager.registrarEvento(error, "SEVERE");
        }
        return inscrito;
    }
    
    public Boolean actualizar(Inscrito inscrito){
        Boolean actualizado = false;
        try {
            String sql = "UPDATE inscritos SET apellido_paterno = ?, apellido_materno = ?, nombres = ?, celular = ? WHERE id = ?";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setString(1, inscrito.getApellido_paterno());
            prepararConsulta.setString(2, inscrito.getApellido_materno());
            prepararConsulta.setString(3, inscrito.getNombres());
            prepararConsulta.setString(4, inscrito.getCelular());
            prepararConsulta.setInt(5, inscrito.getId());
            Integer filasAfectadas = prepararConsulta.executeUpdate();
            if(filasAfectadas > 0){
                actualizado = true;
            }
        } catch (SQLException error) {
            LogManager.registrarEvento(error, "SEVERE");
        }
        return actualizado;
    }
    
    public Boolean eliminar(Integer id){
        Boolean eliminado = false;
        try{
            String sql = "DELETE FROM inscritos WHERE id = ?";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setInt(1, id);
            Integer filasEliminadas = prepararConsulta.executeUpdate();
            if(filasEliminadas > 0){
                eliminado = true;
            }
        }catch(SQLException error){
            LogManager.registrarEvento(error, "SEVERE");
        }
        return eliminado;
    }
    
    public ArrayList<Inscrito> todos(){
        ArrayList<Inscrito> listado = new ArrayList<>();
        try{
            String sql = "SELECT id,apellido_materno,apellido_paterno,celular,nombres FROM inscritos";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while(resultado.next()){
                // almacenar los valores la fila, en un bean : Inscrito
                Inscrito inscrito = new Inscrito();
                inscrito.setApellido_paterno(resultado.getString("apellido_paterno"));
                inscrito.setApellido_materno(resultado.getString("apellido_materno"));
                inscrito.setNombres(resultado.getString("nombres"));
                inscrito.setCelular(resultado.getString("celular"));
                inscrito.setId(resultado.getInt("id"));
                System.out.println("");
                listado.add(inscrito);
            }
        }catch(SQLException error){
            LogManager.registrarEvento(error, "SEVERE");
        }
        return listado;
    }
    
    public Inscrito obtenerPorId(Integer id){
        Inscrito inscrito = null;
        try{
            String sql = "SELECT * FROM inscritos WHERE id = ?";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setInt(1, id);
            ResultSet resultado = prepararConsulta.executeQuery();
            while(resultado.next()){
                inscrito = new Inscrito();
                inscrito.setApellido_paterno(resultado.getString("apellido_paterno"));
                inscrito.setApellido_materno(resultado.getString("apellido_materno"));
                inscrito.setNombres(resultado.getString("nombres"));
                inscrito.setCelular(resultado.getString("celular"));
                inscrito.setId(id);
            }
        }catch(SQLException error){
            LogManager.registrarEvento(error, "SEVERE");
        }
        return inscrito;
    }
}

package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class InscritoDao {
    private Connection conexion;
    
    public InscritoDao(){
        Conexion db = new Conexion();
        this.conexion = db.obtenerConexion();
    }
    
    public Integer ultimoRegistro(){
        Integer id = null;
        try{
            String sql = "SELECT LAST_INSERT_ID()";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while(resultado.next()){
                id = resultado.getInt(1);
            }
        }catch(Exception error){
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
        }catch(Exception error){
            LogManager.registrarEvento(error, "SEVERE");
        }
        return inscrito;
    }
}

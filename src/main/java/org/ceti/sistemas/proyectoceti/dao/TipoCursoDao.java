package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.TipoCurso;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class TipoCursoDao {

    private final Connection conexion;

    public TipoCursoDao(Connection conexion) {
        this.conexion = conexion;
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

    public TipoCurso registrar(TipoCurso tipo_curso) {
        try {
            String sql = "INSERT INTO tipo_cursos (nombre) VALUES(?)";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setString(1, tipo_curso.getNombre());
            Integer resultado = prepararConsulta.executeUpdate();
            if (resultado != 0) {
                tipo_curso.setId(this.ultimoRegistro());
            }
        } catch (SQLException error) {
            LogManager.registrarEvento(error, "SEVERE");
        }
        return tipo_curso;
    }

    public ArrayList<TipoCurso> todos() {
        ArrayList<TipoCurso> listado = new ArrayList<>();
        try {
            String sql = "SELECT id,nombre FROM tipo_cursos";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while (resultado.next()) {
                TipoCurso tipo_curso = new TipoCurso();
                tipo_curso.setNombre(resultado.getString("nombre"));
                tipo_curso.setId(resultado.getInt("id"));
                listado.add(tipo_curso);
            }
        } catch (SQLException error) {
            LogManager.registrarEvento(error, "SEVERE");
        }
        return listado;
    }
}

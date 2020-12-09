package org.ceti.sistemas.proyectoceti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.Curso;
import org.ceti.sistemas.proyectoceti.beans.TipoCurso;
import org.ceti.sistemas.proyectoceti.utils.LogManager;

public class CursoDao {

    private final Connection conexion;

    public CursoDao(Connection conexion) {
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

    public Curso registrar(Curso curso) {
        try {
            String sql = "INSERT INTO cursos (nombre, nombre_corto, imagen, costo, tipo_cursos_id) VALUES(?,?,?,?,?)";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            prepararConsulta.setString(1, curso.getNombre());
            prepararConsulta.setString(2, curso.getNombre_corto());
            prepararConsulta.setString(3, curso.getImagen());
            prepararConsulta.setDouble(4, curso.getCosto());
            prepararConsulta.setInt(5, curso.getTipo_curso().getId());
            Integer resultado = prepararConsulta.executeUpdate();
            if (resultado != 0) {
                curso.setId(this.ultimoRegistro());
            }
        } catch (SQLException error) {
            LogManager.registrarEvento(error, "SEVERE");
        }
        return curso;
    }

    public ArrayList<Curso> todos() {
        ArrayList<Curso> listado = new ArrayList<>();
        try {
            String sql = "SELECT id,nombre, nombre_corto, imagen, costo, tipo_cursos_id FROM cursos";
            PreparedStatement prepararConsulta = this.conexion.prepareStatement(sql);
            ResultSet resultado = prepararConsulta.executeQuery();
            while (resultado.next()) {
                // almacenar los valores la fila, en un bean : Inscrito
                Curso curso = new Curso();
                curso.setNombre(resultado.getString("nombre"));
                curso.setNombre_corto(resultado.getString("nombre_corto"));
                curso.setImagen(resultado.getString("imagen"));
                curso.setCosto(resultado.getDouble("costo"));
                TipoCurso tipo_curso = new TipoCurso();
                tipo_curso.setId(resultado.getInt("tipo_cursos_id"));
                curso.setTipo_curso(tipo_curso);
                curso.setId(resultado.getInt("id"));
                listado.add(curso);
            }
        } catch (SQLException error) {
            LogManager.registrarEvento(error, "SEVERE");
        }
        return listado;
    }
}

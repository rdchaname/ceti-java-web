package org.ceti.sistemas.proyectoceti.models;

import java.sql.Connection;
import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.Curso;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.CursoDao;

public class CursoModel {
    private final CursoDao cursoDao;
    private final Connection conexion;

    public CursoModel() {
        Conexion conn = new Conexion();
        this.conexion = conn.obtenerConexion();
        cursoDao = new CursoDao(this.conexion);
    }

    public Curso registrar(Curso curso) {
        return this.cursoDao.registrar(curso);
    }


    public ArrayList<Curso> todos() {
        return this.cursoDao.todos();
    }
}

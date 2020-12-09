package org.ceti.sistemas.proyectoceti.models;

import java.sql.Connection;
import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.TipoCurso;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.TipoCursoDao;

public class TipoCursoModel {
    private final TipoCursoDao tipoCursoDao;
    private final Connection conexion;

    public TipoCursoModel() {
        Conexion conn = new Conexion();
        this.conexion = conn.obtenerConexion();
        tipoCursoDao = new TipoCursoDao(this.conexion);
    }

    public TipoCurso registrar(TipoCurso tipo_curso) {
        return this.tipoCursoDao.registrar(tipo_curso);
    }


    public ArrayList<TipoCurso> todos() {
        return this.tipoCursoDao.todos();
    }
}

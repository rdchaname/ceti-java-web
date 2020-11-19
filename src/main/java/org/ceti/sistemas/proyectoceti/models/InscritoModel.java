package org.ceti.sistemas.proyectoceti.models;

import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.dao.InscritoDao;

public class InscritoModel {

    private final InscritoDao inscritoDao;

    public InscritoModel() {
        inscritoDao = new InscritoDao();
    }

    // 
    public Inscrito registrar(Inscrito inscrito) {
        Inscrito inscritoRegistrado = this.inscritoDao.registrar(inscrito);
//        UsuarioDao usuarioDao = new UsuarioDao();
//        Usuario usuario = new Usuario();
//        usuarioDao.registrar(usuario);
        // email confirmacion
        // email administrador del sistema
        return inscritoRegistrado;
//        return this.inscritoDao.registrar(inscrito);
    }

    public Boolean actualizar(Inscrito inscrito) {
        return this.inscritoDao.actualizar(inscrito);
    }

    public Boolean eliminar(Integer id) {
        return this.inscritoDao.eliminar(id);
    }

    public ArrayList<Inscrito> todos() {
        return this.inscritoDao.todos();
    }

    public Inscrito obtenerPorId(Integer id) {
        return this.inscritoDao.obtenerPorId(id);
    }
}
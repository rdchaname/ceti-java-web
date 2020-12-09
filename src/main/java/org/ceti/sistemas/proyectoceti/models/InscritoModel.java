package org.ceti.sistemas.proyectoceti.models;

import java.sql.Connection;
import java.util.ArrayList;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.beans.Usuario;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.InscritoDao;
import org.ceti.sistemas.proyectoceti.dao.UsuarioDao;

public class InscritoModel {

    private final InscritoDao inscritoDao;
    private final Connection conexion;

    public InscritoModel() {
        Conexion conn = new Conexion();
        this.conexion = conn.obtenerConexion();
        inscritoDao = new InscritoDao(this.conexion);
    }

    public Inscrito registrar(Inscrito inscrito) {
        Inscrito inscritoRegistrado = this.inscritoDao.registrar(inscrito);
        return inscritoRegistrado;
    }

    public Boolean actualizar(Inscrito inscrito) {
        return this.inscritoDao.actualizar(inscrito);
    }

    public Boolean eliminar(Integer id) {
        UsuarioDao usuarioDao = new UsuarioDao(conexion);
        Usuario usuario = usuarioDao.obtenerPorIdInscrito(id);
        usuarioDao.eliminar(usuario.getId());
        return this.inscritoDao.eliminar(id);
    }

    public ArrayList<Inscrito> todos() {
        return this.inscritoDao.todos();
    }

    public Inscrito obtenerPorId(Integer id) {
        return this.inscritoDao.obtenerPorId(id);
    }
}

package org.ceti.sistemas.proyectoceti.beans;

public class UsuarioPermiso {

    private Integer id;
    private Permiso permiso;
    private Usuario usuario;

    public UsuarioPermiso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

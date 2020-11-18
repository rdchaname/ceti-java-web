package org.ceti.sistemas.proyectoceti.beans;

public class TipoUsuarioPermiso {

    private Integer id;
    private TipoUsuario tipo_usuario;
    private Permiso permiso;

    public TipoUsuarioPermiso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

}

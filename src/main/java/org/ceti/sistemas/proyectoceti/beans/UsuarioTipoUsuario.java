package org.ceti.sistemas.proyectoceti.beans;

import java.io.Serializable;

public class UsuarioTipoUsuario implements Serializable {

    private Integer id;
    private TipoUsuario tipo_usuario;
    private Usuario usuario;

    public UsuarioTipoUsuario() {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

package org.ceti.sistemas.proyectoceti.beans;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String email;
    private String password;
    private Integer inscrito_id;
    private Inscrito inscrito;

    public Usuario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getInscrito_id() {
        return inscrito_id;
    }

    public void setInscrito_id(Integer inscrito_id) {
        this.inscrito_id = inscrito_id;
    }

    public Inscrito getInscrito() {
        return inscrito;
    }

    public void setInscrito(Inscrito inscrito) {
        this.inscrito = inscrito;
    }

}

package org.ceti.sistemas.proyectoceti.beans;

import java.io.Serializable;

public class TipoCurso implements Serializable {

    private Integer id;
    private String nombre;

    public TipoCurso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package org.ceti.sistemas.proyectoceti.beans;

import java.io.Serializable;

public class Curso implements Serializable {

    private Integer id;
    private String nombre;
    private String imagen;
    private String nombre_corto;
    private Double costo;
    private TipoCurso tipo_curso;

    public Curso() {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public TipoCurso getTipo_curso() {
        return tipo_curso;
    }

    public void setTipo_curso(TipoCurso tipo_curso) {
        this.tipo_curso = tipo_curso;
    }

}

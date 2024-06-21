package com.test.renato.back.Modelo;




import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(name="tareas")
public class Tareas {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private boolean completada;
    private boolean eliminar;

    public Tareas() {
    }

    public Tareas(String nombre, String descripcion, boolean completada, boolean eliminar) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = completada;
        this.eliminar = eliminar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public boolean isEliminar() {
        return eliminar;
    }
    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    
    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", eliminar=" + eliminar +
                '}';
    }

}

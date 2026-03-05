package es.fplumara.dam1.alumnos.model;

public class Curso {

    private Integer id;

    private boolean estado;
   private String nombre;

    public Curso(Integer id, boolean estado, String nombre) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

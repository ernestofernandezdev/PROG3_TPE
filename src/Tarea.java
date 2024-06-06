package src;

public class Tarea {
    private String idTarea;
    private String nombreTarea;
    private Integer tiempoEjecucion;
    private Boolean esCritica;
    private Integer nivelDePrioridad;

    public Tarea(String idTarea, String nombreTarea, Integer tiempoEjecucion, Boolean esCritica, Integer nivelDePrioridad) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.tiempoEjecucion = tiempoEjecucion;
        this.esCritica = esCritica;
        this.nivelDePrioridad = nivelDePrioridad;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public Boolean getEsCritica() {
        return esCritica;
    }

    public void setEsCritica(Boolean esCritica) {
        this.esCritica = esCritica;
    }

    public Integer getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Integer tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Integer getNivelDePrioridad() {
        return nivelDePrioridad;
    }

    public void setNivelDePrioridad(Integer nivelDePrioridad) {
        this.nivelDePrioridad = nivelDePrioridad;
    }

    @Override
    public String toString() {
        return "Tarea----->{id_tarea='" + idTarea + '\'' +
                ", nombre='" + nombreTarea + '\'' +
                ", tiempo=" + tiempoEjecucion +
                ", es_critica=" + esCritica +
                ", prioridad=" + nivelDePrioridad +
                '}';
    }
}

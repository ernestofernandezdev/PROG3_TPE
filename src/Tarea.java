package src;

public class Tarea {
    private String id_tarea;
    private String nombre_tarea;
    private Integer tiempo_ejecucion;
    private Boolean es_critica;
    private Integer nivel_de_prioridad;

    public Tarea(String id_tarea, String nombre_tarea, Integer tiempo_ejecucion, Boolean es_critica, Integer nivel_de_prioridad) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.tiempo_ejecucion = tiempo_ejecucion;
        this.es_critica = es_critica;
        this.nivel_de_prioridad = nivel_de_prioridad;
    }

    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public Boolean getEs_critica() {
        return es_critica;
    }

    public void setEs_critica(Boolean es_critica) {
        this.es_critica = es_critica;
    }

    public Integer getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }

    public void setTiempo_ejecucion(Integer tiempo_ejecucion) {
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public Integer getNivel_de_prioridad() {
        return nivel_de_prioridad;
    }

    public void setNivel_de_prioridad(Integer nivel_de_prioridad) {
        this.nivel_de_prioridad = nivel_de_prioridad;
    }

    @Override
    public String toString() {
        return "Tarea----->{id_tarea='" + id_tarea + '\'' +
                ", nombre='" + nombre_tarea + '\'' +
                ", tiempo=" + tiempo_ejecucion +
                ", es_critica=" + es_critica +
                ", prioridad=" + nivel_de_prioridad +
                '}';
    }
}

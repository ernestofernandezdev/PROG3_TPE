package src;

public class Tarea {
    private String id_tarea;
    private String nombre;
    private int tiempo_ejecucion;
    private boolean es_critica;
    private int nivel_prioridad;

    public Tarea(String id_tarea, String nombre, int tiempo_ejecucion, int nivel_prioridad, boolean es_critica) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.tiempo_ejecucion = tiempo_ejecucion;
        this.nivel_prioridad = nivel_prioridad;
        this.es_critica = es_critica;
    }

    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }

    public void setTiempo_ejecucion(int tiempo_ejecucion) {
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public boolean is_Es_critica() {
        return es_critica;
    }

    public void set_Es_critica(boolean es_critica) {
        this.es_critica = es_critica;
    }

    public int getNivel_prioridad() {
        return nivel_prioridad;
    }

    public void setNivel_prioridad(int nivel_prioridad) {
        this.nivel_prioridad = nivel_prioridad;
    }
}

package src;

import java.util.ArrayList;

public class Procesador {
    private String id_procesador;
    private String codigo;
    private Boolean estaRefrigerado;
    private Integer anio_funcionamiento;

    public Procesador(String id_procesador, String codigo, Boolean estaRefrigerado, Integer anio_funcionamiento) {
        this.id_procesador = id_procesador;
        this.codigo = codigo;
        this.estaRefrigerado = estaRefrigerado;
        this.anio_funcionamiento = anio_funcionamiento;
    }

    public String getId_procesador() {
        return id_procesador;
    }

    public void setId_procesador(String id_procesador) {
        this.id_procesador = id_procesador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstaRefrigerado() {
        return estaRefrigerado;
    }

    public void setEstaRefrigerado(Boolean estaRefrigerado) {
        this.estaRefrigerado = estaRefrigerado;
    }

    public Integer getAnio_funcionamiento() {
        return anio_funcionamiento;
    }

    public void setAnio_funcionamiento(Integer anio_funcionamiento) {
        this.anio_funcionamiento = anio_funcionamiento;
    }

}

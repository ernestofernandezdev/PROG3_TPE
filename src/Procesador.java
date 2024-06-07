package src;

public class Procesador {
    private String idProcesador;
    private String codigo;
    private Boolean estaRefrigerado;
    private Integer anioFuncionamiento;

    public Procesador(String idProcesador, String codigo, Boolean estaRefrigerado, Integer anioFuncionamiento) {
        this.idProcesador = idProcesador;
        this.codigo = codigo;
        this.estaRefrigerado = estaRefrigerado;
        this.anioFuncionamiento = anioFuncionamiento;
    }

    public String getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(String idProcesador) {
        this.idProcesador = idProcesador;
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

    public Integer getAnioFuncionamiento() {
        return anioFuncionamiento;
    }

    public void setAnioFuncionamiento(Integer anioFuncionamiento) {
        this.anioFuncionamiento = anioFuncionamiento;
    }

    @Override
    public String toString() {
        return "\n" + "Procesador"+ " " + idProcesador + " | " + "Refrigerado:" + estaRefrigerado + " ";
    }
}

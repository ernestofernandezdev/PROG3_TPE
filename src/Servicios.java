package src;

import utils.CSVReader;

import java.util.HashMap;
import java.util.List;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	//estructura para el servicio 1
	private HashMap<String, Tarea> tareas;

	//estructura para el servicio 2
	private HashMap<Boolean, List<Tarea>> listas_criticidad;

	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores);
		this.tareas = new HashMap<>();
		this.listas_criticidad = new HashMap<>();
		reader.readTasks(pathTareas, tareas, listas_criticidad);
		//System.out.println(reader.readService1(true));
	}
	

	// La complejidad temporal del servicio 1 es O(1), ya que en las estructuras
	// HashMap obtener un elemento siempre es O(1).
	public Tarea servicio1(String ID) {
		return this.tareas.get(ID);
	}
    

    // La complejidad temporal del servicio 2 es O(1), por lo mismo que el punto anterior.
	public List<Tarea> servicio2(boolean esCritica) {
		if(esCritica){
			return this.listas_criticidad.get(true);
		}
		return this.listas_criticidad.get(false);
	}

    /*
     * Expresar la complejidad temporal del servicio 3.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		return null;
	}

}

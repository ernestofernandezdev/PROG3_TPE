package src;

import utils.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	//estructura para el servicio 1
	private HashMap<Integer, Tarea> tareas;

	//estructura para el servicio 2
	private HashMap<Boolean, List<Tarea>> listasCriticidad;

	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores);
		this.tareas = new HashMap<>();
		this.listasCriticidad = new HashMap<>();
		reader.readTasks(pathTareas, tareas, listasCriticidad);
		//System.out.println(reader.readService1(true));
	}
	

	// La complejidad temporal del servicio 1 es O(1), ya que en las estructuras
	// HashMap obtener un elemento siempre es O(1).
	public Tarea servicio1(int id) {
		return this.tareas.get(id);
	}
    

    // La complejidad temporal del servicio 2 es O(1), por lo mismo que el punto anterior.
	public List<Tarea> servicio2(boolean esCritica) {
		return this.listasCriticidad.get(esCritica);
	}

    // La complejidad temporal del servicio 3 es 0(n), ya que necesitamos recorrer todas las tareas
	// para verificar si cumplen o no con la condición de estar entre los dos niveles de prioridad.
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		List<Tarea> tareas = new ArrayList<>();
		for (Integer idTarea: this.tareas.keySet()) {
			Tarea tarea = this.tareas.get(idTarea);
			if (tarea.getNivelDePrioridad() < prioridadSuperior && tarea.getNivelDePrioridad() < prioridadInferior) {
				tareas.add(tarea);
			}
		}
		return tareas;
	}

}

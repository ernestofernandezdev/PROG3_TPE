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

	private HashMap<String, Tarea> tareas;

	/*
     * Expresar la complejidad temporal del constructor. O(n)
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores);
		reader.readTasks(pathTareas);
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1. O(1) Hashing
     */
	public Tarea servicio1(String ID) {

		return tareas.get(ID);
	}
    
    /*
     * Expresar la complejidad temporal del servicio 2. O(n) Lista de factoreo
     */
	public List<Tarea> servicio2(boolean esCritica) {
		return null;
	}

    /*
     * Expresar la complejidad temporal del servicio 3. O(n) Estructura de arbol
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		return null;
	}

}

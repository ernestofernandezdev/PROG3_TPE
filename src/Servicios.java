package src;

import utils.CSVReader;

import java.util.*;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	//estructura para el servicio 1
	private HashMap<String, Tarea> tareas;

	//estructura para el servicio 2
	private HashMap<Boolean, List<Tarea>> listasCriticidad;

	private LinkedList<Procesador> procesadores;

	private int maxTiempoNoRefrigerados;
	private HashMap<Procesador, LinkedList<Tarea>> solucion;
	private int tiempoSolucion;
	private int solucionesConsideradas;

	/*
	 * Expresar la complejidad temporal del constructor.
	 */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		this.procesadores = new LinkedList<>();
		reader.readProcessors(pathProcesadores, this.procesadores);
		this.tareas = new HashMap<String, Tarea>();
		this.listasCriticidad = new HashMap<>();
		reader.readTasks(pathTareas, this.tareas, this.listasCriticidad);
		//System.out.println(reader.readService1(true));
	}


	// La complejidad temporal del servicio 1 es O(1), ya que en las estructuras
	// HashMap obtener un elemento siempre es O(1).
	public Tarea servicio1(String id) {
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
		for (String idTarea: this.tareas.keySet()) {
			Tarea tarea = this.tareas.get(idTarea);
			if (tarea.getNivelDePrioridad() < prioridadSuperior && tarea.getNivelDePrioridad() > prioridadInferior) {
				tareas.add(tarea);
			}
		}
		return tareas;
	}

	public HashMap<Procesador, LinkedList<Tarea>> backtracking(int maxTiempoNoRefrigerados) {
		HashMap<Procesador, LinkedList<Tarea>> estado = new HashMap<>();
		for (Procesador p: this.procesadores) {
			estado.put(p, new LinkedList<>());
		}
		this.maxTiempoNoRefrigerados = maxTiempoNoRefrigerados;
		Deque<Tarea> tareasPorRealizar = new LinkedList<>(this.tareas.values());
		this.solucionesConsideradas = 0;
		this.backtracking(estado, tareasPorRealizar);

		System.out.println(this.tiempoSolucion);
		System.out.println(this.solucionesConsideradas);
		return this.solucion;
	}

	private void backtracking(HashMap<Procesador, LinkedList<Tarea>> estado, Deque<Tarea> tareasPorRealizar) {
		if (esPosibleSolucion(estado)) {
			this.solucionesConsideradas++;
			this.analizarSolucion(estado);
			return;
		}

		if (!tareasPorRealizar.isEmpty()) {
			Tarea siguienteTarea = tareasPorRealizar.removeFirst();
			for (Procesador p: this.procesadores) {
				estado.get(p).add(siguienteTarea);
				backtracking(estado, tareasPorRealizar);
				estado.get(p).remove(siguienteTarea);
			}
			tareasPorRealizar.addFirst(siguienteTarea);
		}

	}

	private boolean esPosibleSolucion(HashMap<Procesador, LinkedList<Tarea>> estado) {

		int tareasAsignadas = 0;
		for (Procesador procesador: estado.keySet()) {
			LinkedList<Tarea> tareas = estado.get(procesador);
			if (!procesador.getEstaRefrigerado()) {
				for (Tarea tarea: tareas) {
					if (tarea.getTiempoEjecucion() > this.maxTiempoNoRefrigerados) {
						return false;
					}
				}
			}
			tareasAsignadas += tareas.size();
		}

		if (tareasAsignadas == this.tareas.size()) {
			for (Procesador p: this.procesadores) {
				if (this.getNumTareasCriticas(estado, p) > this.getNumTareasNoCriticas(estado, p) + 1) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private int getTiempoEjecucion(HashMap<Procesador, LinkedList<Tarea>> posibleSolucion) {
		int maxTiempo = 0;
		int tiempoProcesador;
		for (LinkedList<Tarea> tareas: posibleSolucion.values()) {
			tiempoProcesador = 0;
			for (Tarea tarea: tareas) {
				tiempoProcesador += tarea.getTiempoEjecucion();
			}
			if (tiempoProcesador > maxTiempo) {
				maxTiempo = tiempoProcesador;
			}
		}
		return maxTiempo;
	}

	private int getNumTareasCriticas(HashMap<Procesador, LinkedList<Tarea>> estado, Procesador p) {
		int numTareasCriticas = 0;
		for (Tarea tarea: estado.get(p)) {
			if (tarea.getEsCritica()) {
				numTareasCriticas++;
			}
		}
		return numTareasCriticas;
	}

	private int getNumTareasNoCriticas(HashMap<Procesador, LinkedList<Tarea>> estado, Procesador p) {
		int numTareasNoCriticas = 0;
		for (Tarea tarea: estado.get(p)) {
			if (!tarea.getEsCritica()) {
				numTareasNoCriticas++;
			}
		}
		return numTareasNoCriticas;
	}


	private void analizarSolucion(HashMap<Procesador, LinkedList<Tarea>> posibleSolucion) {
		int tiempoPosibleSolucion = this.getTiempoEjecucion(posibleSolucion);
		if (this.solucion == null || tiempoPosibleSolucion < this.tiempoSolucion) {

			this.solucion = new HashMap<>();
			for (Procesador p: posibleSolucion.keySet()) {
				this.solucion.put(p, new LinkedList<>(posibleSolucion.get(p)));
			}
			this.tiempoSolucion = tiempoPosibleSolucion;
		}
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Si conjunto_solucion tiene elementos y ya use todas las Tareas de tareas entonces es una solucion
	private boolean solucion(HashMap<Procesador, LinkedList<Tarea>> conjunto_solucion, PriorityQueue<Tarea> tareas){
        return !conjunto_solucion.isEmpty() && tareas.isEmpty();
    }

	private boolean esFactible(HashMap<Procesador, LinkedList<Tarea>> conjunto_solucion, Procesador procesador){
		//PROCESADOR REFRIGERADO
		if(procesador.getEstaRefrigerado()){
			return procesador.getContadorTareasCriticas() < 2;
		}
		//PROCESADOR NO REFRIGERADO
		else{
			int tamanio_tiempo_ejecucion = 0;
			if(conjunto_solucion.containsKey(procesador)){
				for (Tarea t : conjunto_solucion.get(procesador)){
					tamanio_tiempo_ejecucion += t.getTiempoEjecucion();
				}
			}
			return (procesador.getContadorTareasCriticas() < 2) && (tamanio_tiempo_ejecucion < maxTiempoNoRefrigerados);
		}
	}

	public HashMap<Procesador, LinkedList<Tarea>> greedy(int maxTiempoNoRefrigerados) throws Exception {

		//Se crea una cola de prioridad (PriorityQueue) que almacenará objetos de tipo Tarea. La prioridad de las tareas en esta
		//cola se determina por su tiempo de ejecución. Las tareas con menor tiempo de ejecución tienen mayor prioridad.
		//Esto se logra pasando un comparador al constructor de la PriorityQueue que compara las tareas por su tiempo de ejecución.
		PriorityQueue<Tarea> tareas_disponibles = new PriorityQueue<>(Comparator.comparing(Tarea::getTiempoEjecucion));
		tareas_disponibles.addAll(this.tareas.values());

		HashMap<Procesador, LinkedList<Tarea>> conjunto_solucion = new HashMap<>();

		this.maxTiempoNoRefrigerados = maxTiempoNoRefrigerados;

		for (Procesador proc: this.procesadores) {
			conjunto_solucion.put(proc, new LinkedList<>());
		}

		while(!tareas_disponibles.isEmpty() && !solucion(conjunto_solucion, tareas_disponibles)){
			for (Procesador proc: this.procesadores) {
				while (!tareas_disponibles.isEmpty() && esFactible(conjunto_solucion, proc)) {
					Tarea t = tareas_disponibles.poll();
					LinkedList<Tarea> tareas_validas = conjunto_solucion.get(proc);
					tareas_validas.add(t);
					conjunto_solucion.put(proc, tareas_validas);
					if (t.getEsCritica()) {
						proc.incrementarContadorTareasCriticas();
					}
				}
			}
		}

		max_tiempo_de_ejecucion(conjunto_solucion);

		if (solucion(conjunto_solucion, tareas_disponibles)){
			return conjunto_solucion;
		}
		else {
			throw new Exception("Error, no hay solucion posible");
		}
	}

	private void max_tiempo_de_ejecucion(HashMap<Procesador, LinkedList<Tarea>> conjunto_solucion){
		int max = 0;
		for (Procesador proc: this.procesadores) {
			int suma = 0;
			LinkedList<Tarea> tareas = conjunto_solucion.get(proc);
			for (Tarea t : tareas){
				suma += t.getTiempoEjecucion();
			}
			if (suma > max){
				max = suma;
			}
		}
		System.out.println("El tiempo maximo de ejecucion es " + max);
	}
}
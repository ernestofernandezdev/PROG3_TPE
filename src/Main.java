package src;

import utils.CSVReader;

public class Main {

	public static void main(String[] args) throws Exception {
		Servicios servicios = new Servicios("./datasets/Procesadores.csv", "./datasets/Tareas.csv");

		System.out.println(servicios.backtracking(1000));
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		//Si pongo mas de 20 tareas en Tareas.csv se crashea
		//System.out.println(servicios.greedy(1000));
	}
}

package src;

import utils.CSVReader;

public class Main {

	public static void main(String[] args) {
		Servicios servicios = new Servicios("./datasets/Procesadores.csv", "./datasets/Tareas.csv");

		System.out.println(servicios.backtracking(1000));
	}
}

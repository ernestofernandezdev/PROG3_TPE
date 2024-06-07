package src;

import utils.CSVReader;

public class Main {

	public static void main(String[] args) {
		Servicios servicios = new Servicios("./datasets/Procesadores.csv", "./datasets/Tareas.csv");

		try {
			System.out.println(servicios.backtracking(1000));
			System.out.println("=============================================Separador=============================================");
			System.out.println(servicios.greedy(1000));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

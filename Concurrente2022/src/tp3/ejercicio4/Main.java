package tp3.ejercicio4;

import java.util.Scanner;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	private static int cantHamsters;
	private static Hamster[] hamsters;
	private static Thread[] th;
	private static Rueda r = new Rueda();
	private static Hamaca h = new Hamaca();
	private static Comida c = new Comida();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos hamsters?");
		cantHamsters = sc.nextInt();
		crearHamsters();
		crearHilos();
		empezarHilos();

		/*
		 * Jaula jaula = new Jaula();
		 * 
		 * Thread hamsters[] = new Thread[3];
		 * 
		 * for (int i = 0; i < hamsters.length; i++) { hamsters[i] = new Thread(new
		 * Hamster(jaula), "#" + i); }
		 * 
		 * for (int i = 0; i < hamsters.length; i++) { hamsters[i].start(); }
		 */

	}

	private static void crearHamsters() {
		hamsters = new Hamster[cantHamsters];
		for (int i = 0; i < cantHamsters; i++) {
			hamsters[i] = new Hamster(r, h, c);
		}
	}

	private static void crearHilos() {
		th = new Thread[cantHamsters];
		for (int i = 0; i < cantHamsters; i++) {
			th[i] = new Thread(hamsters[i], "Hamster " + i);

		}
	}

	private static void empezarHilos() {
		for (int i = 0; i < th.length; i++) {
			th[i].start();
		}
	}

}

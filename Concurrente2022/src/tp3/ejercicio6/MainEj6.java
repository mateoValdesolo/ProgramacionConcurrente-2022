package tp3.ejercicio6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mateo Valdesolo
 */
public class MainEj6 {

	private static int[] arr = new int[50000];
	private static Suma sumaCompartida = new Suma();

	/*--------------- Main ---------------*/
	public static void main(String[] args) {

		iniciarArreglo();
		Thread[] hilos = crearHilos();
		sumarArreglo(hilos, hilos.length);
		for (int i = 0; i < arr.length; i++) {
			try {
				hilos[i].join();
			} catch (Exception e) {
			}

		}
		System.out.println("Suma por hilos --> " + sumaCompartida.getSuma());

	}

	/*--------------- Inicializo Arreglo con Numeros Random ---------------*/
	public static void iniciarArreglo() {

		Random r = new Random();

		for (int i = 0; i < 50000; i++) {
			arr[i] = r.nextInt(10) + 1;

		}
	}

	/*--------------- Creo los Hilos y los guardo en un Arreglo ---------------*/
	public static Thread[] crearHilos() {
		System.out.println("Ingrese la cantidad de hilos");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while (k > 50000 || k == 0) {
			System.out.println("Usted ingreso un numero invalido, intente nuevamente");
			k = sc.nextInt();
		}

		Thread[] hilos = new Thread[k];
		int cantPorHilo = Math.floorDiv(50000, k);
		int j = 0;
		for (int i = 0; i < k - 1; i++) {
			hilos[i] = new Thread(new Sumadores(arr, j, j + cantPorHilo, sumaCompartida));
			j += cantPorHilo;

		}

		// SUMA DEL ULITMO HILO
		hilos[k - 1] = new Thread(new Sumadores(arr, j, arr.length, sumaCompartida));
		return hilos;
	}

	/*--------------- Suma Secuencial del Arreglo ---------------*/
	public static void sumarArreglo(Thread hilos[], int k) {
		int suma = 0;
		for (int i = 0; i < k; i++) {
			hilos[i].start();

		}

		for (int i = 0; i < 50000; i++) {
			suma += arr[i];
		}
		System.out.println("SUMA SECUENCIAL --> " + suma);

	}

}

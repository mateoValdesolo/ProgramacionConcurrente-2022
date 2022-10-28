package actividadesObligatorias.actObl20_10.ejercicio1;

import java.util.Scanner;

/**
 *
 * @author GRUPO 7 
 * TORRES, ANTONELLA 
 * VALDESOLO, MATEO 
 * RIVERA, MALENA
 */
public class Main {
	private static Transbordador transbordador = new Transbordador();
	private static Auto[] autos;
	private static ControlTransbordador control = new ControlTransbordador(transbordador);
	private static Thread hiloControl;
	private static Thread[] threadAutos;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cant de autos");
		int cantAutos = sc.nextInt();
		inicializarAutos(cantAutos);
		hiloControl = new Thread(control);
		iniciarHilos();

	}

	private static void inicializarAutos(int cant) {
		autos = new Auto[cant];
		threadAutos = new Thread[cant];

		for (int i = 0; i < autos.length; i++) {
			autos[i] = new Auto(transbordador);
			threadAutos[i] = new Thread(autos[i], "Auto " + i);
		}

	}

	private static void iniciarHilos() {
		for (int i = 0; i < threadAutos.length; i++) {
			threadAutos[i].start();
		}
		hiloControl.start();
	}
}
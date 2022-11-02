package tp5.ejercicio7.hashMap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de babuinos del lado derecho");
		int cantBabuinosD = sc.nextInt();
		System.out.println("Ingrese la cantidad de babuinos del lado izquierdo");
		int cantBabuinosI = sc.nextInt();

		Thread babuinos[] = new Thread[cantBabuinosD + cantBabuinosI];

		Cuerda cuerda = new Cuerda();

		int j = 0;

		for (int i = 0; i < cantBabuinosI + cantBabuinosD; i++) {
			if (i < cantBabuinosI) {
				babuinos[i] = new Thread(new Babuino(cuerda, "Izquierda", "Derecha"), "Babuino Izquierda " + i);
			} else {

				babuinos[i] = new Thread(new Babuino(cuerda, "Derecha", "Izquierda"), "Babuino Derecho " + j);
				j++;
			}
		}
		for (int i = 0; i < cantBabuinosI + cantBabuinosD; i++) {
			babuinos[i].start();
		}
	}

}

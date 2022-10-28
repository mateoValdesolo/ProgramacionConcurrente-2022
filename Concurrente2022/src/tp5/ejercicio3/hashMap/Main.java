package tp5.ejercicio3.hashMap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de perros");
		int cantPerros = sc.nextInt();
		System.out.println("Ingrese la cantidad de gatos");
		int cantGatos = sc.nextInt();

		Thread animales[] = new Thread[cantPerros + cantGatos];

		int limite, cantPlatos;

		System.out.println("Ingrese el limite ");
		limite = sc.nextInt();
		System.out.println("Ingrese la cantidad de platos");
		cantPlatos = sc.nextInt();

		Comedor c = new Comedor(limite, cantPlatos);

		int j = 0;

		for (int i = 0; i < cantGatos + cantPerros; i++) {
			if (i < cantGatos) {
				animales[i] = new Thread(new Animal(c, "Gato", "Perro"), "Gato " + i);
			} else {

				animales[i] = new Thread(new Animal(c, "Perro", "Gato"), "Perro " + j);
				j++;
			}
		}

		for (int i = 0; i < cantGatos + cantPerros; i++) {
			animales[i].start();
		}

	}

}

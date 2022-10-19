package tp5.ejercicio3;

public class Main {

	public static void main(String[] args) {

		Comedor comedor = new Comedor(5);

		Thread hiloPerros[] = new Thread[20];
		Thread hiloGatos[] = new Thread[20];

		for (int i = 0; i < hiloPerros.length; i++) {
			hiloPerros[i] = new Thread(new Perro(comedor), "Perro " + (i + 1));
		}

		for (int i = 0; i < hiloGatos.length; i++) {
			hiloGatos[i] = new Thread(new Gato(comedor), "Gato " + (i + 1));
		}

		for (int i = 0; i < hiloPerros.length; i++) {
			hiloPerros[i].start();
		}

		for (int i = 0; i < hiloGatos.length; i++) {
			hiloGatos[i].start();
		}

	}

}

package tp4.ejercicio3;

public class Main {

	public static void main(String[] args) {

		Recurso recurso = new Recurso();
		Thread[] hilos = new Thread[3];

		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new Thread(new Proceso(recurso), "Hilo " + (i+1));
		}
		
		for (int i = 0; i < hilos.length; i++) {
			hilos[i].start();
		}

	}

}
	
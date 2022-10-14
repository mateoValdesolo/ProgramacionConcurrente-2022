package tp5.ejercicio1;

public class Main {

	public static void main(String[] args) {

		Comedor comedor = new Comedor();

		Thread mozo = new Thread(new Mozo(comedor), "Mozo");
		Thread cocinero = new Thread(new Cocinero(comedor), "Cocinero");
		Thread empleados[] = new Thread[2];

		for (int i = 0; i < empleados.length; i++) {
			empleados[i] = new Thread(new Empleado(comedor), "Empleado " + (i + 1));
		}

		mozo.start();
		cocinero.start();

		for (int i = 0; i < empleados.length; i++) {
			empleados[i].start();
		}

	}

}

package tp4.ejercicio6;

public class Main {

	public static void main(String[] args) {

		Comedor comedor = new Comedor();
		Thread hiloMozo = new Thread(new Mozo(comedor));
		Thread empleados[] = new Thread[10];

		for (int i = 0; i < empleados.length; i++) {
			empleados[i] = new Thread(new Empleado(comedor), "Empleado " + (i + 1));
		}
		
		hiloMozo.start();

		for (int i = 0; i < empleados.length; i++) {
			empleados[i].start();
		}
	}

}

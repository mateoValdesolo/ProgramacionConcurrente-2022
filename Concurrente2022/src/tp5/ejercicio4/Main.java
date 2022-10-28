package tp5.ejercicio4;

public class Main {
	
	// Arreglar prints

	public static void main(String[] args) {

		Tren tren = new Tren(5);

		Thread pasajeros[] = new Thread[10];
		Thread vendedor = new Thread(new VendedorTickets(tren), "VendedorTickets ");
		Thread control = new Thread(new ControlTren(tren));

		for (int i = 0; i < pasajeros.length; i++) {
			pasajeros[i] = new Thread(new Pasajero(tren), "Pasajero " + (i + 1));
		}

		control.start();
		vendedor.start();

		for (int i = 0; i < pasajeros.length; i++) {
			pasajeros[i].start();
		}

	}

}

package tp5.ejercicio4;

public class Pasajero implements Runnable {

	private Tren tren;

	public Pasajero(Tren tren) {
		this.tren = tren;
	}

	@Override
	public void run() {
		comprarTicket // release semComprar
		subirTren // Acquire semSubir
		bajarTren // Release semSubir

	}

}

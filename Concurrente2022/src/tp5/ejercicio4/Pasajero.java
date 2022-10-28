package tp5.ejercicio4;

public class Pasajero implements Runnable {

	private Tren tren;

	public Pasajero(Tren tren) {
		this.tren = tren;
	}

	@Override
	public void run() {
		tren.ingresarComprar();
		System.out.println(Thread.currentThread().getName() + " Va a comprar un Ticket");
		tren.pedirTicket();
		tren.pagarTicket();
		System.out.println(Thread.currentThread().getName() + " Pago un Ticket");
		tren.recibirTicket();
		tren.subirTren();
		tren.sentarse();
		System.out.println(Thread.currentThread().getName() + " Se sento en el tren");
		tren.dejarAsiento();
		System.out.println(Thread.currentThread().getName() + " Ya dejo su asiento");
		tren.bajarTren();
		System.out.println(Thread.currentThread().getName() + " Se bajo del tren");
	}

}

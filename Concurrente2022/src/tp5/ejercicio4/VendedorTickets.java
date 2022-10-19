package tp5.ejercicio4;

public class VendedorTickets implements Runnable {
	
	private Tren tren;

	public VendedorTickets(Tren tren) {
		this.tren = tren;
	}

	@Override
	public void run() {
		atender //acquire a su semComprar
		vender // deja que se suba el pasajero, semSubir release

	}

}

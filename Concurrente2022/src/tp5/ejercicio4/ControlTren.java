package tp5.ejercicio4;

public class ControlTren implements Runnable {

	private Tren tren;


	public ControlTren(Tren tren) {
		this.tren = tren;
	}

	@Override
	public void run() {
		// si la cantidad para viajar es, hago acquire de semBajar(cant pasajeros)
		// al terminar

	}

}

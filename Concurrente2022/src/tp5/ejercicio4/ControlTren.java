package tp5.ejercicio4;

public class ControlTren implements Runnable {

	private Tren tren;

	public ControlTren(Tren tren) {
		this.tren = tren;
	}

	@Override
	public void run() {
		while (true) {
			tren.viajar();
			System.out.println("******** Tren comienza viaje ********");
			viaje();
			tren.finalizarViaje();
			System.out.println("******** Tren finaliza viaje ********");
		}
	}

	private void viaje() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

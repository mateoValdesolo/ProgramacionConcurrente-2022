package tp4.ejercicio5;

public class Taxista implements Runnable {

	private Taxi taxi;

	public Taxista(Taxi taxi) {
		this.taxi = taxi;
	}

	@Override
	public void run() {
		while (true) {
			taxi.conducir();
			viajar();
			taxi.terminarViaje();
		}
	}

	private void viajar() {
		System.out.println("Viajando.....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package tp4.ejercicio6;

public class Mozo implements Runnable {

	private Comedor comedor;

	public Mozo(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		while (true) {
			comedor.cocinar();
			cocina();
			comedor.entregarPlato();
		}
	}

	private void cocina() {
		System.out.println("Cocinando.....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

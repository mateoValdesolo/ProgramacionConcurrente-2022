package tp5.ejercicio1;

public class Mozo implements Runnable {

	private Comedor comedor;

	public Mozo(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		while (true) {
			comedor.mozoAtiende();
			servir();
			comedor.servirBebida();
		}
	}

	private void servir() {
		System.out.println(Thread.currentThread().getName() + " Sirviendo Bebida");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

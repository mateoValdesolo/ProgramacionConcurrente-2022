package tp5.ejercicio1;

public class Cocinero implements Runnable {

	private Comedor comedor;

	public Cocinero(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		while (true) {
			comedor.cocineroAtiende();
			servir();
			comedor.servirComida();
		}
	}

	private void servir() {
		System.out.println(Thread.currentThread().getName() + " Sirviendo Comida");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

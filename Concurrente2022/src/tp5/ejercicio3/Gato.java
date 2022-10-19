package tp5.ejercicio3;

public class Gato implements Runnable {

	private Comedor comedor;

	public Gato(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		comedor.esperaComerGato();
		comedor.comeGato();
		comer();
		comedor.saleGato();
		System.out.println(Thread.currentThread().getName() + " Dejo de comer");
	}

	private void comer() {
		System.out.println(Thread.currentThread().getName() + " Comiendo...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

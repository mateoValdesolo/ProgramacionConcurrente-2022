package tp5.ejercicio2;

public class Perro implements Runnable {

	private Comedor comedor;

	public Perro(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		comedor.esperaComerPerro();
		comedor.comePerro();
		comer();
		comedor.salePerro();
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

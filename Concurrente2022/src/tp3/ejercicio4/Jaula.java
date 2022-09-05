package tp3.ejercicio4;

/**
 *
 * @author Mateo Valdesolo
 */
public class Jaula {

	private Object rueda = new Object();
	private Object plato = new Object();
	private Object hamaca = new Object();

	public void usarHamaca() {
		synchronized (hamaca) {
			System.out.println("Hamster " + Thread.currentThread().getName() + " quiere usar la Hamaca");
			usar();
			System.out.println("Hamster " + Thread.currentThread().getName() + " dejo de usar la Hamaca");
		}
	}

	public void usarPlato() {
		synchronized (plato) {
			System.out.println("Hamster " + Thread.currentThread().getName() + " quiere usar el Plato");
			usar();
			System.out.println("Hamster " + Thread.currentThread().getName() + " dejo de usar el Plato");

		}
	}

	public void usarRueda() {
		synchronized (rueda) {
			System.out.println("Hamster " + Thread.currentThread().getName() + " quiere usar la Rueda");
			usar();
			System.out.println("Hamster " + Thread.currentThread().getName() + " dejo de usar la Rueda");
		}
	}

	private void usar() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}

}

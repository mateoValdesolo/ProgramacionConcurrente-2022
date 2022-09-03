package tp3.ejercicio4;

/**
 *
 * @author Mateo Valdesolo
 */
public class Hamster implements Runnable {

	private String nombre;
	private Jaula jaula;

	public Hamster(String nombre, Jaula jaula) {
		this.nombre = nombre;
		this.jaula = jaula;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Hamster " + nombre + " quiere usar la Hamaca");
			jaula.usarHamaca();
			System.out.println("Hamster " + nombre + " dejo de usar la Hamaca");
			usar();
			System.out.println("Hamster " + nombre + " quiere usar la Rueda");
			jaula.usarRueda();
			System.out.println("Hamster " + nombre + " dejo de usar la Rueda");
			usar();
			System.out.println("Hamster " + nombre + " quiere usar el Plato");
			jaula.usarPlato();
			usar();
			System.out.println("Hamster " + nombre + " dejo de usar el Plato");
		}

	}

	public void usar() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}

}

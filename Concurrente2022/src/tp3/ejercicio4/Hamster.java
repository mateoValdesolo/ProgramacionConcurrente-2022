package tp3.ejercicio4;

import java.util.Random;

/**
 *
 * @author Mateo Valdesolo
 */
public class Hamster implements Runnable {

	private Jaula jaula;

	public Hamster(Jaula jaula) {
		this.jaula = jaula;
	}

	@Override
	public void run() {
		while (true) {
			switch (opcRandom()) {
			case 1:
				jaula.usarHamaca();
				break;
			case 2:
				jaula.usarRueda();
				break;
			case 3:
				jaula.usarPlato();
				break;
			default:
				break;
			}

		}

	}

	private int opcRandom() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}

}

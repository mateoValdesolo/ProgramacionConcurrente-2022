package tp3.ejercicio4;

/**
 *
 * @author Mateo Valdesolo
 */
public class Hamster implements Runnable {

	Rueda r = new Rueda();
	Comida c = new Comida();
	Hamaca h = new Hamaca();

	public Hamster(Rueda r, Hamaca h, Comida c) {
		this.r = r;
		this.h = h;
		this.c = c;

	}

	@Override
	public void run() {
		r.realizarActividad();
		h.realizarActividad();
		c.realizarActividad();

	}

	/*
	 * private Jaula jaula;
	 * 
	 * public Hamster(Jaula jaula) { this.jaula = jaula; }
	 * 
	 * @Override public void run() { while (true) { switch (opcRandom()) { case 1:
	 * jaula.usarHamaca(); break; case 2: jaula.usarRueda(); break; case 3:
	 * jaula.usarPlato(); break; default: break; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private int opcRandom() { Random r = new Random(); return r.nextInt(3) + 1; }
	 */

}

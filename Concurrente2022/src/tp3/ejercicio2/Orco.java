package tp3.ejercicio2;

/**
 *
 * @author Mateo Valdesolo
 */
public class Orco implements Runnable {
	Personaje pj;

	public Orco(Personaje pj) {
		this.pj = pj;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " Hace daño al personaje que tiene " + pj.getVida()
				+ " puntos de vida");
		pj.modificarVida(-3);
		System.out.println(
				" Vida del personaje luego del ataque de " + Thread.currentThread().getName() + " " + pj.getVida());

	}
}
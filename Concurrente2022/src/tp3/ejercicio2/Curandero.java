package tp3.ejercicio2;

/**
 *
 * @author Mateo Valdesolo
 */
public class Curandero implements Runnable {
	Personaje pj;

	public Curandero(Personaje pj) {
		this.pj = pj;
	}

	public void run() {

		System.out.println(
				Thread.currentThread().getName() + " Cura al personaje que tiene " + pj.getVida() + " puntos de vida");
		pj.modificarVida(3);
		System.out.println(
				" Vida del personaje luego de la curacion de " + Thread.currentThread().getName() + " " + pj.getVida());

	}
}

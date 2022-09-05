package tp3.ejercicio2;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {
		Personaje pj = new Personaje();
		Orco or = new Orco(pj);
		Curandero cur = new Curandero(pj);

		Thread orcoThread = new Thread(or, "Orco");
		Thread curanderoThread = new Thread(cur, "Curandero");

		orcoThread.start();
		curanderoThread.start();

		try {
			orcoThread.join();
			curanderoThread.join();
		} catch (InterruptedException e) {
		}

		System.out.println("La vida final es de " + pj.getVida());

	}

}

package tp3.ejercicio2;

public class Orco implements Runnable {
	Personaje pj;

	public Orco(Personaje pj) {
		this.pj = pj;
	}

	public void run() {

		pj.modificarVida(-3);
		System.out.println("En Orco la vida es de " + pj.getVida());

	}
}
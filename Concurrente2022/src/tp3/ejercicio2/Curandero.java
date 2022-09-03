package tp3.ejercicio2;

public class Curandero implements Runnable {
	Personaje pj;

	public Curandero(Personaje pj) {
		this.pj = pj;
	}

	public void run() {

		pj.modificarVida(3);
		System.out.println("En Curandero la vida es de " + pj.getVida());

	}
}

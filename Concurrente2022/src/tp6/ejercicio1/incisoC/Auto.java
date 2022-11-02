package tp6.ejercicio1.incisoC;

import tp6.ejercicio1.incisoB.Puente;

public class Auto implements Runnable {

	private Puente puente;

	public Auto(Puente puente) {
		this.puente = puente;
	}

	@Override
	public void run() {
		if (lado()) {
			puente.entrarDesdeSur();
			cruzar();
			puente.salirDesdeSur();
		} else {
			puente.entrarDesdeNorte();
			cruzar();
			puente.salirDesdeNorte();
		}
	}

	private void cruzar() {
		System.out.println("------------ " + Thread.currentThread().getName() + " CRUZANDO ------------");
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean lado() {
		return ((int) (Math.random() * 2) + 1) == 1;
	}

}

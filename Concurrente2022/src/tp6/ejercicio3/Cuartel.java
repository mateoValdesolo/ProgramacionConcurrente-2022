package tp6.ejercicio3;

import java.util.concurrent.Semaphore;

public class Cuartel {

	private int cantMaxima;
	private Semaphore semMostradorAlmuerzo;
	private Semaphore semAbridor;
	private Semaphore semMostradorPostre;

	public Cuartel(int cantMaxima, int cantMostradorAlmuerzo, int cantAbridor, int cantMostradorPostre) {
		this.cantMaxima = cantMaxima;
		this.semMostradorAlmuerzo = new Semaphore(cantMostradorAlmuerzo);
		this.semAbridor = new Semaphore(cantAbridor);
		this.semMostradorPostre = new Semaphore(cantMostradorPostre);
	}

	public void pedirAlmuerzo() {
		try {
			semMostradorAlmuerzo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void terminaAlmuerzo() {
		semMostradorAlmuerzo.release();
	}

	public void pedirAbridor() {
		try {
			semAbridor.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dejarAbridor() {
		semAbridor.release();
	}

	public void pedirPostre() {
		try {
			semMostradorPostre.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void terminarPostre() {
		semMostradorPostre.release();
	}

}

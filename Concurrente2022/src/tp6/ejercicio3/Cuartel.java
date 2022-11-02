package tp6.ejercicio3;

import java.util.concurrent.Semaphore;

public class Cuartel {

	private int cantMaxima;
	private Semaphore semMostradorAlmuerzo;
	private Semaphore semAbridor;
	private Semaphore semMostradorPostre;
	private Semaphore semCuartel;

	public Cuartel(int cantMaxima, int cantMostradorAlmuerzo, int cantAbridor, int cantMostradorPostre) {
		this.cantMaxima = cantMaxima;
		this.semCuartel = new Semaphore(cantMaxima);
		this.semMostradorAlmuerzo = new Semaphore(cantMostradorAlmuerzo);
		this.semAbridor = new Semaphore(cantAbridor);
		this.semMostradorPostre = new Semaphore(cantMostradorPostre);
	}

	public void entrarCuartel(){
		try {
			semCuartel.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void salirCuartel(){
		semCuartel.release();
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

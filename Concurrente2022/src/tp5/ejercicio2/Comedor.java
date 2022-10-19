package tp5.ejercicio2;

import java.util.concurrent.Semaphore;

public class Comedor {

	private Semaphore semGatos;
	private Semaphore semPerros;
	private Semaphore mutex = new Semaphore(1);

	private int cantComieron; // Cantidad de veces que comieron
	private int maxCant; // Cantidad maxima de animales que pueden haber al mismo tiempo

	public Comedor(int maxCant) {
		this.maxCant = maxCant;
		this.semGatos = new Semaphore(maxCant, true);
		this.semPerros = new Semaphore(0, true);
	}

	// --------------- Gatos ---------------

	public void esperaComerGato() {
		try {
			semGatos.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void comeGato() {
		try {
			mutex.acquire();
			if (cantComieron < maxCant) {
				cantComieron++;
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void saleGato() {
		try {
			mutex.acquire();
			cantComieron--;
			if (cantComieron == 0) {
				pasanPerros();
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pasanGatos() {
		semPerros.release(maxCant);
	}

	// --------------- Perros ---------------

	public void esperaComerPerro() {
		try {
			semPerros.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void comePerro() {
		try {
			mutex.acquire();
			if (cantComieron < maxCant) {
				cantComieron++;
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void salePerro() {
		try {
			mutex.acquire();
			cantComieron--;
			if (cantComieron == 0) {
				pasanGatos();
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pasanPerros() {
		semPerros.release(maxCant);
	}

}

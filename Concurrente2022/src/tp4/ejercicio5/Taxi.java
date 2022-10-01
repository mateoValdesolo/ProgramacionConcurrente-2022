package tp4.ejercicio5;

import java.util.concurrent.Semaphore;

public class Taxi {

	private Semaphore semAsiento = new Semaphore(1);
	private Semaphore semConducir = new Semaphore(0);
	private Semaphore semBajarse = new Semaphore(0);

	/**
	 * semConducir.acquire()
	 */
	public void conducir() {
		try {
			semConducir.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * semBajarse.release()
	 */
	public void terminarViaje() {
		semBajarse.release();
	}

	/**
	 * semAsiento.acquire()
	 */
	public void subirseTaxi() {
		try {
			semAsiento.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * semConducir.release()
	 */
	public void empezarViaje() {
		semConducir.release();
	}

	/**
	 * semBajarse.acquire()
	 */
	public void bajarseTaxi() {
		try {
			semBajarse.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * semAsiento.release()
	 */
	public void liberarAsiento() {
		semAsiento.release();
	}

}

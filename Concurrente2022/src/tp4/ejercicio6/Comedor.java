package tp4.ejercicio6;

import java.util.concurrent.Semaphore;

public class Comedor {

	private Semaphore semSilla = new Semaphore(1);
	private Semaphore semServir = new Semaphore(0);
	private Semaphore semComer = new Semaphore(0);

	public void sentarse() {
		try {
			semSilla.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void elegirComida() {
		semServir.release();
	}

	public void cocinar() {
		try {
			semServir.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void empezarComer() {
		try {
			semComer.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void entregarPlato() {
		semComer.release();
	}
	
	public void volverATrabajar() {
		semSilla.release();
	}

}

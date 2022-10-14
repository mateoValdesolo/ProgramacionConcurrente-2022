package tp5.ejercicio1;

import java.util.concurrent.Semaphore;

public class Comedor {

	private Semaphore semLlamarMozo;
	private Semaphore semLlamarCocinero;
	private Semaphore semPuedeComer;
	private Semaphore semPuedeTomar;
	private Semaphore semSentarse;

	public Comedor() {
		this.semPuedeComer = new Semaphore(0);
		this.semPuedeTomar = new Semaphore(0);
		this.semLlamarMozo = new Semaphore(0);
		this.semLlamarCocinero = new Semaphore(0);
		this.semSentarse = new Semaphore(2, true);
	}

	// ---------------- semSentarse ----------------

	public boolean puedeSentarse() {
		return semSentarse.tryAcquire();
	}

	public void levantarse() {
		semSentarse.release();
	}

	// ---------------- semLlamarMozo ----------------

	public void pedirBebida() {
		semLlamarMozo.release();
	}

	public void mozoAtiende() {
		try {
			semLlamarMozo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ---------------- semLlamarCocinero ----------------

	public void pedirComida() {
		semLlamarCocinero.release();
	}

	public void cocineroAtiende() {
		try {
			semLlamarCocinero.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ---------------- semPuedeTomar ----------------

	public void servirBebida() {
		semPuedeTomar.release();
	}

	public void tomarBebida() {
		try {
			semPuedeTomar.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ---------------- semPuedeComer ----------------

	public void servirComida() {
		semPuedeComer.release();
	}

	public void comerComida() {
		try {
			semPuedeComer.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

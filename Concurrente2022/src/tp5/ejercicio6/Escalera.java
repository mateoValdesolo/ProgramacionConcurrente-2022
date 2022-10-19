package tp5.ejercicio6;

import java.util.concurrent.Semaphore;

public class Escalera {

	private int cantEscalones;

	private Semaphore semEscalones;
	private Semaphore semEncargado;
	private Semaphore semTobogan1;
	private Semaphore semTobogan2;

	public Escalera(int cantEscalones) {
		this.cantEscalones = cantEscalones;
		semEscalones = new Semaphore(cantEscalones, true);
		semTobogan1 = new Semaphore(0);
		semTobogan2 = new Semaphore(0);
		semEncargado = new Semaphore(permits);
	}
	
	public void subirEscalera() {
		try {
			semEscalones.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void habilitarVisitante() {
		semEscalones.release();
	}
	
	

}

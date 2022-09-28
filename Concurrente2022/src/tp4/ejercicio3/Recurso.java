package tp4.ejercicio3;

import java.util.concurrent.Semaphore;

public class Recurso {

	private Semaphore p1 = new Semaphore(1, true);
	private Semaphore p2 = new Semaphore(1, true);
	private Semaphore p3 = new Semaphore(1, true);

	/**
	 * Toma el permiso de p1
	 */
	public void paso1() {
		try {
			p1.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Deja el permiso de p1 Toma el permiso de p2
	 */
	public void paso2() {
		p1.release();
		try {
			p2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Deja el permiso de p2 Toma el permiso de p3
	 */
	public void paso3() {
		p2.release();
		try {
			p3.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Deja el permiso de p3
	 */
	public void paso4() {
		p3.release();
	}

	/*
	 * public void tomarP1() { try { p1.acquire(); } catch (InterruptedException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public void dejarP1() { p1.release(); }
	 * 
	 * public void tomarP2() { try { p2.acquire(); } catch (InterruptedException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public void dejarP2() { p2.release(); }
	 * 
	 * public void tomarP3() { try { p3.acquire(); } catch (InterruptedException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public void dejarP3() { p3.release(); }
	 */

}

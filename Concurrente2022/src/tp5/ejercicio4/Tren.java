package tp5.ejercicio4;

import java.util.concurrent.Semaphore;

public class Tren {

	private final int cantMaxima;
	private int ocupados;
	
	private Semaphore semComprarTicket;
	private Semaphore semSubir;
	private Semaphore semBajar;

	public Tren(int cantMaxima) {
		this.cantMaxima = cantMaxima;
	}

}

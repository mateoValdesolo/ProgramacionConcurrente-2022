package tp5.ejercicio7.hashMap;

import java.util.concurrent.Semaphore;

public class Contador {

	private int cantPasando, cantTotal, cantEsperando;
	private Semaphore semEntrar;

	public Contador() {
		this.cantEsperando = 0;
		this.cantTotal = 0;
		this.cantPasando = 0;
		semEntrar = new Semaphore(0);
	}

	// ------------- cantPasando -------------

	public int getCantPasando() {
		return cantPasando;
	}

	public void setCantPasando(int cantPasando) {
		this.cantPasando = cantPasando;
	}

	public void incrementarCantPasando() {
		this.cantPasando++;
	}

	public void decrementarCantPasando() {
		this.cantPasando--;
	}

	// ------------- cantTotal -------------

	public int getCantTotal() {
		return cantTotal;
	}

	public void setCantTotal(int cantTotal) {
		this.cantTotal = cantTotal;
	}

	public void incrementarCantTotal() {
		this.cantTotal++;
	}

	// ------------- cantEsperando -------------

	public int getCantEsperando() {
		return cantEsperando;
	}

	public void setCantEsperando(int cantEsperando) {
		this.cantEsperando = cantEsperando;
	}

	public void incrementarCantEsperando() {
		this.cantEsperando++;
	}

	public void decrementarCantEsperando() {
		this.cantEsperando--;
	}

	// ------------- semEntrar -------------

	public void tomarEntrar() {
		try {
			semEntrar.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dejaEntrar(int cantPermisos) {
		semEntrar.release(cantPermisos);
	}

	public void reiniciarEntrar() {
		semEntrar = new Semaphore(0);
	}

}

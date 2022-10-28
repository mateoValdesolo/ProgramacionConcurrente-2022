package tp5.ejercicio2.hashMap;

import java.util.concurrent.Semaphore;

public class Contador {

	private int cantEsperando; // Cantidad esperando para comer
	private int cantComiendo; // Cantidad comiendo actualmente
	private int cantTotal; // Cantidad total de la especie
	private Semaphore entrar; // Simula la espera para poder usar un plato y comer

	public Contador() {
		cantEsperando = 0;
		cantComiendo = 0;
		entrar = new Semaphore(0);
	}
	
	// ---------- cantEsperando ----------

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
	
	// ---------- cantComiendo ----------

	public int getCantComiendo() {
		return cantComiendo;
	}

	public void setCantComiendo(int cantComiendo) {
		this.cantComiendo = cantComiendo;
	}
	
	public void incrementarCantComiendo() {
		this.cantComiendo++;
	}
	
	public void decrementarCantComiendo() {
		this.cantComiendo--;
	}
	
	// ---------- cantTotal ----------

	public int getCantTotal() {
		return cantTotal;
	}

	public void setCantTotal(int cantTotal) {
		this.cantTotal = cantTotal;
	}
	
	public void incrementarCantTotal() {
		this.cantTotal++;
	}
	
	// ---------- Semaforo entrar ----------

	public void tomarEntrar() {
		try {
			entrar.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void dejaEntrar(int cantPermisos) {
		entrar.release(cantPermisos);
	}
	
	public void reiniciarEntrar() {
		entrar = new Semaphore(0);
	}

}

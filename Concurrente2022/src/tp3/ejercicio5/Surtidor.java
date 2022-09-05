package tp3.ejercicio5;

/**
 *
 * @author Mateo Valdesolo
 */
public class Surtidor {

	private int maximo;

	public Surtidor() {
		this.maximo = 15000;
	}

	public void cargarCombustible(int lts) {
		synchronized (this) {
			if ((maximo - lts) >= 0) {
				System.out.println(Thread.currentThread().getName() + " Va a cargar combustible");
				this.maximo -= lts;
				espera();
				System.out.println(Thread.currentThread().getName()
						+ " Termino de cargar combustible, combustible en surtidor: " + maximo);
			}
		
		}
	}

	public synchronized int getMaximo() {
		synchronized (this) {
			return maximo;
		}
	}
	
	private void espera() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

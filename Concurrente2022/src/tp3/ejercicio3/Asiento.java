package tp3.ejercicio3;

/**
 *
 * @author Mateo Valdesolo
 */
public class Asiento {

	private boolean ocupado;
	private int nroAsiento;

	public Asiento(int nroAsiento) {
		this.nroAsiento = nroAsiento;
		this.ocupado = false;
	}

	public synchronized boolean getOcupado() {
		return ocupado;
	}

	public synchronized void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}

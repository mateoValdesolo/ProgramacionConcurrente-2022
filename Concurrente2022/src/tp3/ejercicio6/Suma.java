package tp3.ejercicio6;

/**
 *
 * @author Mateo Valdesolo
 */
public class Suma {

	private int valor;

	public Suma() {
		valor = 0;
	}

	public synchronized void sumar(int cant) {
		valor += cant;
	}

	public synchronized int getSuma() {
		return valor;
	}
}

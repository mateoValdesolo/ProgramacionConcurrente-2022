package tp3.ejercicio1;

/**
 *
 * @author Mateo Valdesolo
 */
public class CuentaBanco {

	private int balance = 50;

	public CuentaBanco() {
	}

	public int getBalance() {
		return balance;
	}

	public void retiroBancario(int retiro) {
		balance = balance - retiro;
	}
}

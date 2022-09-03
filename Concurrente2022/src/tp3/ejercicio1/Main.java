package tp3.ejercicio1;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {

		VerificarCuenta vc = new VerificarCuenta();
		Thread Luis = new Thread(vc, "Luis");
		Thread Manuel = new Thread(vc, "Manuel");
		Luis.start();
		Manuel.start();
	}

}

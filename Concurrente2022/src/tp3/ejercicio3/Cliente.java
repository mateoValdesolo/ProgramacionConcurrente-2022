package tp3.ejercicio3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mateo Valdesolo	
 */
public class Cliente implements Runnable {

	private Encargado encargado;

	public Cliente(Encargado encargado) {
		this.encargado = encargado;
	}

	@Override
	public void run() {
		boolean compro = false;
		int asientoAComprar;
		do {
			asientoAComprar = asientoRandom();
			compro = encargado.comprarAsiento(asientoAComprar);
			espera();
			if (!compro) {
				System.out.println(Thread.currentThread().getName() + " no pudo comprar el asiento " + asientoAComprar);
			}
			// Desocupar asiento??
		} while (!compro);
	}

	private int asientoRandom() {
		Random r = new Random();
		ArrayList<?> asientosLibres = encargado.obtenerAsientosLibres();
		return r.nextInt(asientosLibres.size());
	}
	
	private void espera() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

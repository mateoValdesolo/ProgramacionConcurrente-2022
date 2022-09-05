package tp3.ejercicio3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mateo Valdesolo
 */
public class Sala {

	private Asiento[] asientos;
	private int cantAsientos;

	public Sala() {
		Random r = new Random();
		cantAsientos = 20;
		asientos = new Asiento[cantAsientos];

		for (int i = 0; i < asientos.length; i++) {
			asientos[i] = new Asiento(i + 1);
		}
	}

	public boolean compraAsiento(int nroAsiento) {
		boolean ret = false;
		if (!asientos[nroAsiento].getOcupado()) {
			asientos[nroAsiento].setOcupado(true);
			System.out.println("El cliente " + Thread.currentThread().getName() + " compro el asiento " + nroAsiento);
			ret = true;
		}
		return ret;
	}

	public ArrayList<Asiento> asientosVacios() {
		ArrayList<Asiento> asientosVacios = new ArrayList<Asiento>();
		for (int i = 0; i < asientos.length; i++) {
			if (!asientos[i].getOcupado()) {
				asientosVacios.add(asientos[i]);
			}
		}
		return asientosVacios;
	}

}

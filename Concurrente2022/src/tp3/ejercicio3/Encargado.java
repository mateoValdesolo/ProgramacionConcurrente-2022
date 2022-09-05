package tp3.ejercicio3;

import java.util.ArrayList;

/**
 *
 * @author Mateo Valdesolo
 */
public class Encargado {

	private Sala sala;

	public Encargado(Sala sala) {
		this.sala = sala;
	}

	public boolean comprarAsiento(int nroAsiento) {
		return sala.compraAsiento(nroAsiento);
	}

	public ArrayList<?> obtenerAsientosLibres() {
		return sala.asientosVacios();
	}

}

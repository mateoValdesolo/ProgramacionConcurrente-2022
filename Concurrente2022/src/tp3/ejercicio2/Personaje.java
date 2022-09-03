package tp3.ejercicio2;

/**
 *
 * @author Mateo Valdesolo
 */
public class Personaje {

	private int vida;

	public Personaje() {
		this.vida = 10;
	}

	public int getVida() {
		return vida;
	}

	public synchronized void modificarVida(int puntos) {
		this.vida = vida + puntos;
		System.out.println("La vida es de " + vida);
	}

}

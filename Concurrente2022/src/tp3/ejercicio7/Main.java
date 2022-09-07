package tp3.ejercicio7;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {
		
		Letra letra = new Letra();
		Thread hiloA = new Thread(new Impresora('A', letra));
		Thread hiloB = new Thread(new Impresora('B', letra));
		Thread hiloC = new Thread(new Impresora('C', letra));
		
		hiloA.start();
		hiloB.start();
		hiloC.start();
	}

}

package tp3.ejercicio7;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {
		
		Letra letra = new Letra();
        	Impresora.setRonda(4);
        	Thread hiloA = new Thread(new Impresora('A', letra, 1));
        	Thread hiloB = new Thread(new Impresora('B', letra, 2));
        	Thread hiloC = new Thread(new Impresora('C', letra, 3));

        	hiloA.start();
        	hiloB.start();
        	hiloC.start();
	}

}

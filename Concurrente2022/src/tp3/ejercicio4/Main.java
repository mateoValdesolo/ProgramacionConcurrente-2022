package tp3.ejercicio4;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {
		Jaula jaula = new Jaula();

		Thread hamsters[] = new Thread[10];
		
		for (int i = 0; i < hamsters.length; i++) {
			hamsters[i] = new Thread(new Hamster("#" + i, jaula));
		}
		
		for (int i = 0; i < hamsters.length; i++) {
			hamsters[i].start();
		}

	}

}

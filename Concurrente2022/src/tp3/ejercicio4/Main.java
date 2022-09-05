package tp3.ejercicio4;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {
		Jaula jaula = new Jaula();

		Thread hamsters[] = new Thread[3];
		
		for (int i = 0; i < hamsters.length; i++) {
			hamsters[i] = new Thread(new Hamster(jaula), "#" + i);
		}
		
		for (int i = 0; i < hamsters.length; i++) {
			hamsters[i].start();
		}

	}

}

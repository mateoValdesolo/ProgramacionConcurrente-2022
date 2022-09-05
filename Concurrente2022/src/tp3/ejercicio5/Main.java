package tp3.ejercicio5;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {

		Surtidor surtidor = new Surtidor();
		Thread autos[] = new Thread[10];

		for (int i = 0; i < autos.length; i++) {
			autos[i] = new Thread(new Auto("AC897GT", "Subaru", "Impreza", 500, surtidor), "Auto #" + i);
		}

		for (int i = 0; i < autos.length; i++) {
			autos[i].start();
		}

	}

}

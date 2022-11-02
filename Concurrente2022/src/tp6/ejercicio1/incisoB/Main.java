package tp6.ejercicio1.incisoB;

public class Main {

	public static void main(String[] args) {

		Puente puente = new Puente();

		Thread[] autos = new Thread[20];

		for (int i = 0; i < autos.length; i++) {
			autos[i] = new Thread(new Auto(puente), "Auto " + (i + 1));
		}

		for (int i = 0; i < autos.length; i++) {
			autos[i].start();
		}
	}

}

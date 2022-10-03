package repaso1erParcial.tema3_2021;

public class Main {

	public static void main(String[] args) {

		Parque parque = new Parque(10, 10);
		Thread visitantes[] = new Thread[20];

		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i] = new Thread(new Visitante(parque), "Visitante " + (1 + i));
		}

		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i].start();
		}

	}

}

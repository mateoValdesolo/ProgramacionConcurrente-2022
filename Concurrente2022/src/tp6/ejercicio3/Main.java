package tp6.ejercicio3;

public class Main {

	public static void main(String[] args) {

		Cuartel cuartel = new Cuartel(10,5,10,3);

		Thread soldados[] = new Thread[25];

		for (int i = 0; i < soldados.length; i++) {
			soldados[i] = new Thread(new Soldado(cuartel), "Soldado "+(i+1));
		}


		for (int i = 0; i < soldados.length; i++) {
			soldados[i].start();
		}
	}

}

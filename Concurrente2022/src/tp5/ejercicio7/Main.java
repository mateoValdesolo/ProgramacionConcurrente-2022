package tp5.ejercicio7;

public class Main {
	
	public static void main(String[] args) {
		Thread babuinos[] = new Thread[10];
		Cuerda p = new Cuerda(5);
		for (int i = 0; i < babuinos.length; i++) {
			babuinos[i] = new Thread(new Babuino(p), "Babuino " + (i + 1));
		}
		for (int i = 0; i < babuinos.length; i++) {
			babuinos[i].start();
		}

	}

}
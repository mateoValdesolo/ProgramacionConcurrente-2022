package tp2.ejercicio5;

public class UsoHilosT {

	public static void main(String[] args) {

		System.out.println("Hilo principal iniciando");

		MiHiloT mht = new MiHiloT("#1");
		mht.start();

		for (int i = 0; i < 50; i++) {
			System.out.println(" .");
		}

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("Hilo principal interrumpido");
		}

		System.out.println("Hilo principal finalizado");

	}

}

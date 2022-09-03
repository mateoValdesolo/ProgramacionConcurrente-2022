package tp2.ejercicio5;

public class MiHiloT extends Thread {

	public MiHiloT(String nombre) {
		super(nombre);
	}

	@Override
	public void run() {
		System.out.println("Comenzando " + Thread.currentThread().getName());
		try {
			for (int contar = 0; contar < 10; contar++) {
				Thread.sleep(400);
				System.out.println("En " + Thread.currentThread().getName() + ", el recuento " + contar);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " Interrumpido");
		}

		System.out.println("Terminando " + Thread.currentThread().getName());
	}
}

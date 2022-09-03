package tp2.ejercicio4;

public class ThreadEjemploR implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
			System.out.println("Termina thread   " + Thread.currentThread().getName());
		}
	}
}
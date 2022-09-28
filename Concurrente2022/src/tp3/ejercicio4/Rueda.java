package tp3.ejercicio4;

public class Rueda {

	public synchronized void realizarActividad() {
		System.out.println(Thread.currentThread().getName() + " esta jugando con la RUEDA");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " termino de jugar con la RUEDA ");
		} catch (InterruptedException e) {

		}
	}

}

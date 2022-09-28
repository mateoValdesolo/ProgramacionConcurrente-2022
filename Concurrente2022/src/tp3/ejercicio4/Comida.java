package tp3.ejercicio4;

public class Comida {

	public synchronized void realizarActividad() {
		System.out.println(Thread.currentThread().getName() + " esta usando el plato de COMIDA");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " termino de usar el plato de COMIDA");
		} catch (InterruptedException e) {

		}
	}

}

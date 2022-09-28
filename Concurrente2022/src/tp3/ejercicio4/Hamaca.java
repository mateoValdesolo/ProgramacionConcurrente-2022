package tp3.ejercicio4;

public class Hamaca {
	
	public synchronized void realizarActividad() {
		System.out.println(Thread.currentThread().getName() + " esta descansando en la HAMACA");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " termino de descansar en la HAMACA");
		} catch (InterruptedException e) {

		}
	}
	
}

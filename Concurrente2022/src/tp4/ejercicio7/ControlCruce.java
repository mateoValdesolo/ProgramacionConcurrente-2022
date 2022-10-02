package tp4.ejercicio7;

public class ControlCruce implements Runnable {

	private GestorCruce gestor;

	public ControlCruce(GestorCruce gestor) {
		this.gestor = gestor;
	}

	public void run() {
		while (true) {
			try {
				gestor.cambiarSemaforos();
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
		}
	}
}

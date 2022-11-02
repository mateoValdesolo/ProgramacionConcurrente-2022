package tp6.ejercicio2;

public class MedidorTemperatura implements Runnable {

	private Sala sala;

	public MedidorTemperatura(Sala sala) {
		this.sala = sala;
	}

	@Override
	public void run() {
		while(true) {
			espera();
			sala.notificarTemperatura(tempRandom());
		}
	}
	
	// Random entre 27 y 36
	private int tempRandom() {
		return ((int) (Math.random() * 10) + 27);
	}
	
	private void espera() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

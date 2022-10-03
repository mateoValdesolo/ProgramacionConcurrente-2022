package repaso1erParcial.tema3_2021;

public class Visitante implements Runnable {
	private Parque parque;

	public Visitante(Parque parque) {
		this.parque = parque;
	}

	@Override
	public void run() {
		int numSnorkel = -1, numAntiparra = -1;
		System.out.println(Thread.currentThread().getName() + " Va a pedir antiparras");
		// Si no pudo obtener antiparras intenta de vuelta
		while (numAntiparra < 0) {
			numAntiparra = parque.pedirAntiparra();
			if(numAntiparra < 0) {
				espera();
			}
		}
		System.out.println(
				Thread.currentThread().getName() + " Ya tiene antiparra nro." + numAntiparra + ", va a pedir snorkel");
		// Si no pudo obtener snorkel intenta de vuelta
		while (numSnorkel < 0) {
			numSnorkel = parque.pedirSnorkel();
			if(numSnorkel < 0) {
				espera();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Ya tiene snorkel nro." + numSnorkel + ", va a nadar");
		nadar();
		System.out.println(Thread.currentThread().getName() + " Termino de nadar");
		parque.devolver(numAntiparra, numSnorkel);
		System.out.println(Thread.currentThread().getName() + " Ya devolvio antiparras nro." + numAntiparra
				+ " y snorkel nro." + numSnorkel);
	}

	private void nadar() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void espera() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

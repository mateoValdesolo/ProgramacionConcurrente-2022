package tp3.ejercicio5;

import java.util.Random;

/**
 *
 * @author Mateo Valdesolo
 */
public class Auto extends Vehiculo implements Runnable {

	private int ltsCombustible;
	private int ltsReserva;
	private Surtidor surtidor;

	public Auto(String patente, String modelo, String marca, int km, Surtidor surtidor) {
		super(patente, modelo, marca, km);
		this.ltsCombustible = 60;
		this.ltsReserva = 6;
		this.surtidor = surtidor;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (ltsCombustible <= ltsReserva) {
				surtidor.cargarCombustible(60 - ltsCombustible);
				this.ltsCombustible = 60;
			} else {
				andarKm(i);
				System.out.println(
						Thread.currentThread().getName() + " le faltan " + (ltsCombustible - 6) + " para la reserva");
			}

		}

	}

	private void espera() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void andarKm(int i) {
		Random r = new Random();
		this.ltsCombustible -= i * (r.nextInt(10) + 1);
		espera();
	}

}

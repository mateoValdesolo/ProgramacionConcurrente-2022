package actividadesObligatorias.actObl20_10.ejercicio1;

/**
 *
 * @author GRUPO 7 
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Auto implements Runnable {
	private Transbordador transordador;

	public Auto(Transbordador transordador) {
		this.transordador = transordador;
	}

	public void run() {
		this.simularViaje();
		transordador.agarroPermiso();
		System.out.println(Thread.currentThread().getName() + ": Me subi al transbordador");
		transordador.avisoLlegada();
		transordador.bajarse();
		System.out.println(Thread.currentThread().getName() + ": Me baje del transbordador");
		transordador.avisoSalida();

	}

	private void simularViaje() {
		try {
			System.out.println(Thread.currentThread().getName() + ": Comienzo viaje al lado oeste");
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
}
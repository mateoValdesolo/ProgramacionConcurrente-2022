package actividadesObligatorias.actObl20_10.ejercicio3;

/**
 *
 * @author GRUPO 7 TORRES, ANTONELLA VALDESOLO, MATEO RIVERA, MALENA
 */
public class ControlReloj implements Runnable {
	private Reloj r;

	public ControlReloj(Reloj r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			this.simularTiempoSue�o();
			System.out.println("Termino la hora de dormir");
			System.out.println("Despierto al primer trabajador");
			System.out.println("-----------------------------------------");
			r.despertarPrimerHilo();
			r.esperarZZZ();
		}

	}

	private void simularTiempoSue�o() {
		try {
			System.out.println("-----------------------------------------");
			System.out.println("TRABAJADORES DURMIENDO, SHHHH");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
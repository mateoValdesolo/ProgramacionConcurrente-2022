package actividadesObligatorias.actObl20_10.ejercicio1;

/**
 *
 * @author GRUPO 7 
 * TORRES, ANTONELLA 
 * VALDESOLO, MATEO 
 * RIVERA, MALENA
 */
public class ControlTransbordador implements Runnable {
	private Transbordador transbordador;

	public ControlTransbordador(Transbordador transbordador) {
		this.transbordador = transbordador;
	}

	public void run() {
		while (true) {
			transbordador.iniciarViaje();
			System.out.println("Transbordador: Comenzando viaje");
			this.simulaViaje();
			System.out.println("Transbordador: LLegue a destino, pueden bajar los autos");
			transbordador.llegaADestino();
			transbordador.iniciarViaje();
			System.out.println("Transbordador: ya no hay mas autos, vuelvo vacio");
			this.simulaViaje();
			System.out.println("Transbordador: ya pueden subir");
			transbordador.terminoVuelta();
		}
	}

	private void simulaViaje() {
		try {
			System.out.println("Viajando");
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

}
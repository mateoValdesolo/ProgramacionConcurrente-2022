package actividadesObligatorias.actObl20_10.ejercicio2;

public class Recipiente implements Runnable {
	private Espacio e;

	public Recipiente(Espacio e) {
		this.e = e;
	}

	public void run() {
		while (true) {
			e.avisarRecipienteVacio();
			e.chequearRecipienteLleno();
			System.out.println(" VACIA RECIPIENTE ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}
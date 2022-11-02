package tp5.ejercicio7.hashMap;

public class Babuino implements Runnable {

	private Cuerda cuerda;
	private String tipo;
	private String opuesto;

	public Babuino(Cuerda cuerda, String tipo, String opuesto) {
		this.cuerda = cuerda;
		this.tipo = tipo;
		this.opuesto = opuesto;
	}

	@Override
	public void run() {
		cuerda.setearPrioridadBabuino(tipo);
		cuerda.entrar(tipo);
		pasar();
		cuerda.irse(tipo, opuesto);
	}

	private void pasar() {
		try {
			System.out.println("----- "+Thread.currentThread().getName() + " PASANDOO -----");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

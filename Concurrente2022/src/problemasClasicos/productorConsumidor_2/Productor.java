package problemasClasicos.productorConsumidor_2;

public class Productor implements Runnable {
	RecursoCompartido r;

	public Productor(RecursoCompartido r) {
		this.r = r;
	}

	public void run() {
		r.agarraPuedeProducir();
		r.agarrarMutex();
		this.simula();
		r.liberaMutex();
		r.liberaPuedeConsumir();
	}

	private void simula() {
		try {
			System.out.println(Thread.currentThread().getName() + ": Produciendo");
			Thread.sleep(1000);
			int pos = r.buscarPosLibreProductor();
			r.pone(pos);
		} catch (Exception e) {
		}
	}

}
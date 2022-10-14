package problemasClasicos.productorConsumidor_2;

public class Consumidor implements Runnable {
	RecursoCompartido r;

	public Consumidor(RecursoCompartido r) {
		this.r = r;
	}

	public void run() {
		r.agarraPuedeConsumir();
		r.agarrarMutex();
		this.simula();
		r.liberaMutex();
		r.liberaPuedeProducir();
	}

	private void simula() {
		try {
			System.out.println(Thread.currentThread().getName() + " Consumiendo");
			Thread.sleep(1000);
			int pos = r.buscarPosLibreConsumidor();
			r.saca(pos);
		} catch (Exception e) {
		}
	}
}
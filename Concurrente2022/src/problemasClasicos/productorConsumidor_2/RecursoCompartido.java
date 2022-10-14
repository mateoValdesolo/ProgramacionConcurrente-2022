package problemasClasicos.productorConsumidor_2;

import java.util.concurrent.Semaphore;

public class RecursoCompartido {
	Semaphore puedeConsumir;
	Semaphore puedeProducir;
	Semaphore mutex; /* ????? */
	boolean[] buffer = { false, false, false, false };
	int punteroProductor;
	int punteroConsumidor;

	public RecursoCompartido() {
		puedeConsumir = new Semaphore(0);
		puedeProducir = new Semaphore(buffer.length);
		mutex = new Semaphore(1);
		punteroProductor = 0;
		punteroConsumidor = 0;
	}

	public void agarraPuedeConsumir() {
		try {
			puedeConsumir.acquire();
		} catch (Exception e) {
		}
	}

	public void liberaPuedeConsumir() {
		puedeConsumir.release();
	}

	public void agarraPuedeProducir() {
		try {
			puedeProducir.acquire();
		} catch (Exception e) {
		}
	}

	public void liberaPuedeProducir() {
		puedeProducir.release();
	}

	public void agarrarMutex() {
		try {
			mutex.acquire();
		} catch (Exception e) {
		}
	}

	public void liberaMutex() {
		mutex.release();
	}

	public int buscarPosLibreProductor() {
		return punteroProductor;

	}

	public void pone(int i) {
		buffer[i] = true;
		if (punteroProductor == buffer.length - 1)
			punteroProductor = 0;
		else
			punteroProductor++;
	}

	public int buscarPosLibreConsumidor() {
		return punteroConsumidor;
	}

	public void saca(int i) {
		buffer[i] = false;
		if (punteroConsumidor == buffer.length - 1)
			punteroConsumidor = 0;
		else
			punteroConsumidor++;
	}

}
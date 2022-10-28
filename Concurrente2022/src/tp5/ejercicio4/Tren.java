package tp5.ejercicio4;

import java.util.concurrent.Semaphore;

public class Tren {

	private final int cantAsientos;

	private Semaphore mutexCompra; // Exclusion mutua compra de Tickets
	private Semaphore semComprarTicket; // Rendevous Pasajero - Vendedor
	private Semaphore semEntregaTicket; // Rendevous Vendedor - Pasajero
	private Semaphore semAsientos; // Asientos del Tren
	private Semaphore semViajar; // Tren viaja cuando ya se lleno
	private Semaphore semBajar; // Finaliza el viaje

	public Tren(int cantAsientos) {
		this.cantAsientos = cantAsientos;
		this.mutexCompra = new Semaphore(1);
		this.semComprarTicket = new Semaphore(0);
		this.semAsientos = new Semaphore(cantAsientos);
		this.semEntregaTicket = new Semaphore(0);
		this.semViajar = new Semaphore(0);
		this.semBajar = new Semaphore(0);
	}

	// ------------- Pasajero -------------

	/**
	 * Mutex para la compra de Tickets.
	 */
	public void ingresarComprar() {
		try {
			mutexCompra.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Rendevous que libera al Vendedor, para que le venda un ticket.
	 */
	public void pedirTicket() {
		semComprarTicket.release();
	}

	/**
	 * Rendevous que espera al Vendedor, para que le entregue el ticket.
	 */
	public void pagarTicket() {
		try {
			semEntregaTicket.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Libera el mutex de la compra de Tickets.
	 */
	public void recibirTicket() {
		mutexCompra.release();
	}

	/**
	 * Se sube al Tren y ocupa un espacio dentro de el.
	 */
	public void subirTren() {
		try {
			semAsientos.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ocupa su asiento en el Tren, cuando este lleno, este comienza el viaje.
	 */
	public void sentarse() {
		semViajar.release();
	}

	/**
	 * Espera para poder bajarse del Tren.
	 */
	public void dejarAsiento() {
		try {
			semBajar.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se baja y libera su asiento en el Tren.
	 */
	public void bajarTren() {
		semAsientos.release();
	}

	// ------------- VendedorTickets -------------

	/**
	 * Rendevous que espera a que llegue un Pasajero, asi le vende un Ticket.
	 */
	public void venderTicket() {
		try {
			semComprarTicket.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Rendevous que libera al Pasajero asi recibe su Ticket.
	 */
	public void entregarTicket() {
		semEntregaTicket.release();
	}

	// ------------- ControlTren -------------

	/**
	 * Comienza el viaje cuando ya se lleno el Tren de Pasajeros.
	 */
	public void viajar() {
		try {
			semViajar.acquire(cantAsientos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finaliza el viaje cuando ya se bajaron todos los Pasajeros.
	 */
	public void finalizarViaje() {
		semBajar.release(cantAsientos);
	}

}

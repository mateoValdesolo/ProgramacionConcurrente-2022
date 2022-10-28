package actividadesObligatorias.actObl20_10.ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author GRUPO 7 TORRES, ANTONELLA VALDESOLO, MATEO RIVERA, MALENA
 */
public class Reloj {
	private Semaphore[] semTrabajadores; // cada trabajador va a tener un semaforo asociado
	private int cantTrabajadores; // para no pasarse de largo en el arreglo
	private Semaphore semDormir; // para avisarle a control reloj cuando se levantaron todos

	public Reloj(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
		semTrabajadores = new Semaphore[cantTrabajadores];
		for (int i = 0; i < semTrabajadores.length; i++) {
			semTrabajadores[i] = new Semaphore(0);
		}
		semDormir = new Semaphore(0);
	}

	public void despertarPrimerHilo() {
		// levanta al primer trabajador
		semTrabajadores[0].release();

	}

	public void despertarPana(int nroTrabajador) {
		// le avisa a su hermano q se tiene q levantar
		// esto lo hace liberando el permiso
		if (nroTrabajador < (cantTrabajadores - 1))
			semTrabajadores[nroTrabajador + 1].release();

	}

	public void despertarme(int nroTrabajador) {
		// cada trabajador se queda esperando en su semaforo correspondiente
		try {
			semTrabajadores[nroTrabajador].acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void esperarZZZ() {
		// se queda esperando hasta q todos se levanten
		try {
			semDormir.acquire(cantTrabajadores);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aMimir() {
		// le avisa a controlReloj q se levanto
		semDormir.release();
	}
}
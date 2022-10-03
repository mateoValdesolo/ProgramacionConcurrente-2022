package repaso1erParcial.tema3_2021;

import java.util.concurrent.Semaphore;

public class Objeto {

	private Semaphore enUso;
	private boolean estado;

	public Objeto() {
		this.enUso = new Semaphore(1);
		this.estado = true;
	}

	public void marcarRoto() {
		this.estado = false;
	}

	public boolean usar() {
		return enUso.tryAcquire();
	}

	public void dejarDeUsar() {
		enUso.release();
	}

	public boolean getEstado() {
		return estado;
	}

}

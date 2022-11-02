package tp6.ejercicio1.incisoC;

public class Puente {

	private int cantEsperandoSur;
	private int cantPasandoSur;
	private int cantCruzaronSur;

	private int cantEsperandoNorte;
	private int cantPasandoNorte;
	private int cantCruzaronNorte;

	public Puente() {
		this.cantEsperandoSur = 0;
		this.cantPasandoSur = 0;
		this.cantCruzaronSur = 0;
		this.cantEsperandoNorte = 0;
		this.cantPasandoNorte = 0;
		this.cantCruzaronNorte = 0;
	}

	public synchronized void entrarDesdeSur() {
		while (cantPasandoNorte > 0 || (cantCruzaronSur >= 10 && cantEsperandoNorte > 0)) {
			System.out.println(Thread.currentThread().getName() + " espera desde el SUR");
			cantEsperandoSur++;
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cantEsperandoSur--;
		cantPasandoSur++;
	}

	public synchronized void salirDesdeSur() {
		System.out.println(Thread.currentThread().getName() + " paso desde el SUR");
		cantPasandoSur--;
		cantCruzaronSur++;
		this.notify();
	}

	public synchronized void entrarDesdeNorte() {
		while (cantPasandoSur > 0 || (cantCruzaronNorte >= 10 && cantEsperandoSur > 0)) {
			System.out.println(Thread.currentThread().getName() + " espera desde el NORTE");
			cantEsperandoNorte++;
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cantEsperandoNorte--;
		cantPasandoNorte++;
	}

	public synchronized void salirDesdeNorte() {
		System.out.println(Thread.currentThread().getName() + " paso desde el NORTE");
		cantPasandoNorte--;
		cantCruzaronNorte++;
		this.notify();
	}

}

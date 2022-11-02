package tp6.ejercicio1.incisoB;

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
		while (cantPasandoNorte > 0) {
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
		// System.out.println(Thread.currentThread().getName() + "salio del SUR
		// "+"cantPasandoSur: "+cantPasandoSur+" cantPasandoNorte: "+cantPasandoNorte);
		this.notify();
	}

	public synchronized void entrarDesdeNorte() {
		while (cantPasandoSur > 0) {
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
		// System.out.println(Thread.currentThread().getName() + "salio del NORTE
		// "+"cantPasandoSur: "+cantPasandoSur+" cantPasandoNorte: "+cantPasandoNorte);
		this.notify();
	}

}

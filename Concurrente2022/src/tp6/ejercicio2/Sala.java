package tp6.ejercicio2;

public class Sala {

	private static final int tempUmbral = 30;
	private int tempActual;
	private int cantMaximaPersonas;
	private int cantPersonasActual;
	private int cantJubiladosEsperando;

	public Sala() {
		this.tempActual = 25;
		this.cantJubiladosEsperando = 0;
		this.cantPersonasActual = 0;
		this.cantMaximaPersonas = 50;
	}

	public synchronized void entrarSala() {
		System.out.println(Thread.currentThread().getName() + " va a ENTRAR a la sala");
		while ((cantPersonasActual >= cantMaximaPersonas) || cantJubiladosEsperando > 0) {
			System.out.println(Thread.currentThread().getName() + " esperando...");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cantPersonasActual++;
	}

	public synchronized void entrarSalaJubilado() {
		System.out.println(Thread.currentThread().getName() + " va a ENTRAR a la sala JUBILADO");
		cantJubiladosEsperando++;
		while ((cantPersonasActual >= cantMaximaPersonas)) {
			System.out.println(Thread.currentThread().getName() + " JUBILADO esperando...");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cantPersonasActual++;
		cantJubiladosEsperando--;
		this.notifyAll();
	}

	public synchronized void salirSala() {
		System.out.println(Thread.currentThread().getName() + " SALE de la sala");
		cantPersonasActual--;
		this.notifyAll();
	}

	public void notificarTemperatura(int temperatura) {
		System.out.println("------ CAMBIO DE TEMPERATURA A " + temperatura + " ------");
		this.tempActual = temperatura;
		if (temperatura >= tempUmbral) {
			cantMaximaPersonas = 35;
		} else {
			cantMaximaPersonas = 50;
		}
	}

}

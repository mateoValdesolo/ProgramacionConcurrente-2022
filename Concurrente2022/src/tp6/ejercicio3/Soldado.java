package tp6.ejercicio3;

public class Soldado implements Runnable {

	private Cuartel cuartel;

	public Soldado(Cuartel cuartel) {
		this.cuartel = cuartel;
	}

	@Override
	public void run() {
		cuartel.entrarCuartel();
		System.out.println(Thread.currentThread().getName() + " Entro a la sala");
		cuartel.pedirAlmuerzo();
		System.out.println(Thread.currentThread().getName() + " Pidio ALMUERZO");
		simulaTiempo();
		cuartel.terminaAlmuerzo();
		System.out.println(Thread.currentThread().getName() + " Termino ALMUERZO");
		if (random()) {
			System.out.println(Thread.currentThread().getName() + " Quiere gaseosa, pide ABRIDOR");
			cuartel.pedirAbridor();
			System.out.println(Thread.currentThread().getName() + " Tiene el ABRIDOR");
			simulaTiempo();
			cuartel.dejarAbridor();
			System.out.println(Thread.currentThread().getName() + " Dejo ABRIDOR");
		} else {
			System.out.println(Thread.currentThread().getName() + " Pide AGUA");
		}
		if (random()) {
			System.out.println(Thread.currentThread().getName() + " Quiere POSTRE");
			cuartel.pedirPostre();
			System.out.println(Thread.currentThread().getName() + " Tiene el POSTRE");
			simulaTiempo();
			cuartel.terminarPostre();
			System.out.println(Thread.currentThread().getName() + " Termino el POSTRE");
		} else {
			System.out.println(Thread.currentThread().getName() + " Pide AGUA");
		}
		cuartel.salirCuartel();
		System.out.println(Thread.currentThread().getName() + " Salio del cuartel");
	}

	private void simulaTiempo() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean random() {
		return (int) ((Math.random() * 3) + 1) == 1;
	}

}

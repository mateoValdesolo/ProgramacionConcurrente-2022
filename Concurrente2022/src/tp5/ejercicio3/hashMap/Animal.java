package tp5.ejercicio3.hashMap;

public class Animal implements Runnable {

	private Comedor comedor;
	private String tipo;
	private String opuesto;

	public Animal(Comedor comedor, String tipo, String opuesto) {
		this.comedor = comedor;
		this.tipo = tipo;
		this.opuesto = opuesto;
	}

	@Override
	public void run() {
		comedor.setearPrioridadAnimal(tipo);
		comedor.entrar(tipo);
		comer();
		comedor.irse(tipo, opuesto);
	}

	public void comer() {
		try {
			System.out.println("----- "+Thread.currentThread().getName() + " COMIENDOOOO -----");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

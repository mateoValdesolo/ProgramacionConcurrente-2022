package tp5.ejercicio2;

public class Animal implements Runnable {
	
	private char tipo;
	private Comedor c;

	public Animal(char tipo, Comedor c) {
		this.tipo = tipo;
		this.c = c;
	}

	@Override
	public void run() {
		c.setearPrioridadAnimal(tipo);
		c.entrar(tipo);
		this.comer();
		c.irse(tipo);

	}

	public void comer() {
		try {
			System.out.println(Thread.currentThread().getName() + " COMIENDOOOO");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

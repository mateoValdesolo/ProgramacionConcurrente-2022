
package tp5.ejercicio7;

public class Babuino implements Runnable {

	private char lado;
	private Cuerda c;

	public Babuino(char lado, Cuerda c) {
		this.lado = lado;
		this.c = c;
	}

	public void run() {
		c.setearPrioridadBabuino(lado);
		c.entrar(lado);
		this.pasando();
		c.irse(lado);

	}

	public void pasando() {
		try {
			System.out.println(Thread.currentThread().getName() + " PASANDOOOO");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package tp6.ejercicio2;

public class Persona implements Runnable {

	private Sala sala;

	public Persona(Sala sala) {
		this.sala = sala;
	}

	@Override
	public void run() {
		if (esJubilado()) {
			sala.entrarSalaJubilado();
		} else {
			sala.entrarSala();
		}
		recorreMuseo();
		sala.salirSala();
	}

	private void recorreMuseo() {
		System.out.println(Thread.currentThread().getName()+" Recorre el museo");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean esJubilado() {
		return (int) ((Math.random() * 3) + 1) == 1;
	}

}

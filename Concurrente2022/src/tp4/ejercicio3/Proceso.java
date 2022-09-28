package tp4.ejercicio3;

public class Proceso implements Runnable {

	private Recurso recurso;

	public Proceso(Recurso recurso) {
		this.recurso = recurso;
	}

	@Override
	public void run() {
		while (true) {
			recurso.paso1();
			System.out.println(Thread.currentThread().getName() + " Esta en el proceso 1");
			dormir();
			System.out.println(Thread.currentThread().getName() + " Deja el proceso 1");
			recurso.paso2();
			System.out.println(Thread.currentThread().getName() + " Esta en el proceso 2");
			dormir();
			System.out.println(Thread.currentThread().getName() + " Deja el proceso 2");
			recurso.paso3();
			System.out.println(Thread.currentThread().getName() + " Esta en el proceso 3");
			dormir();
			System.out.println(Thread.currentThread().getName() + " Deja el proceso 3");
			recurso.paso4();
		}
	}

	private void dormir() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

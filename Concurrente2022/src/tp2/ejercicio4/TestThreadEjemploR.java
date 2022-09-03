package tp2.ejercicio4;

public class TestThreadEjemploR {
	
	public static void main(String[] args) {
		
		ThreadEjemploR thr = new ThreadEjemploR();

		Thread mj = new Thread(thr, "Maria Jose");
		Thread jm = new Thread(thr, "Jose Maria");

		mj.start();
		jm.start();
		System.out.println("Termina Thread main");

	}

}
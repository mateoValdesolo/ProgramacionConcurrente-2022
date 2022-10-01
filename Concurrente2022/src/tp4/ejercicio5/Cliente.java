package tp4.ejercicio5;

public class Cliente implements Runnable {
	
	private Taxi taxi;
	
	public Cliente(Taxi taxi) {
		this.taxi = taxi;
	}

	@Override
	public void run() {
		taxi.subirseTaxi();
		System.out.println(Thread.currentThread().getName() + " se subio al taxi");
		taxi.empezarViaje();
		taxi.bajarseTaxi();
		System.out.println(Thread.currentThread().getName() + " se bajo del taxi");
		taxi.liberarAsiento();
	}
	
}
